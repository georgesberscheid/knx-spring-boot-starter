package lu.berscheid.knx.device.automower;

import static lu.berscheid.knx.annotations.KnxGroupObject.Flag.C;
import static lu.berscheid.knx.annotations.KnxGroupObject.Flag.R;
import static lu.berscheid.knx.annotations.KnxGroupObject.Flag.T;
import static lu.berscheid.knx.annotations.KnxGroupObject.Flag.W;

import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import lu.berscheid.knx.annotations.KnxDevice;
import lu.berscheid.knx.annotations.KnxDeviceParameter;
import lu.berscheid.knx.annotations.KnxGroupObject;
import lu.berscheid.knx.annotations.KnxPostRestart;
import lu.berscheid.knx.annotations.KnxPostStart;
import lu.berscheid.knx.annotations.KnxPreShutdown;
import lu.berscheid.knx.annotations.KnxUpdateDatapoint;
import lu.berscheid.knx.device.automower.model.MowerStatus;
import lu.berscheid.knx.device.automower.service.AutomowerService;
import lu.berscheid.knx.model.GroupObject;

@Slf4j
@SpringBootApplication
@EnableFeignClients
@KnxDevice(productName = "Husqvarna Automower",
		hardwareName = "Husqvarna Automower virtual device",
		applicationName = "Automower Connect",
		applicationVersion = 21,
		applicationNumber = 22,
		hardwareSerialNumber = "HW0001",
		productOrderNumber = "PO0001")
/*
 * The Automower device acts as an actuator.
 */
public class AutomowerDevice {

	public static void main(String[] args) {
		SpringApplication.run(AutomowerDevice.class, args);
	}

	@Autowired
	private ResourceOwnerPasswordResourceDetails automowerCredentials;

	@KnxDeviceParameter(sizeInBit = 288, text = "Automower Client ID")
	@Value("${automower.clientId}")
	private String clientId;

	@KnxDeviceParameter(sizeInBit = 400, text = "Automower User name")
	@Value("${automower.username}")
	private String username;

	@KnxDeviceParameter(sizeInBit = 400, text = "Automower Password")
	@Value("${automower.password}")
	private String password;

	@KnxDeviceParameter(sizeInBit = 400, text = "Default mower duration (minutes)")
	@Value("${automower.defaultDuration}")
	private Integer defaultDuration = 360;

	private ThreadPoolTaskScheduler scheduler;

	/*
	 * Group object can receive boolean (switch) type GroupValueWrite to start the Automower (true)
	 * or park Automower until next schedule (false).
	 */
	@KnxGroupObject(flags = { C, W },
			text = "Start / Park",
			functionText = "Toggle",
			datapointType = "1.001", // Switch
			groupAddresses = "${automower.startStopCommandAddress}")
	private GroupObject<Boolean> startStopSwitch;

	/*
	 * Group object that allows reading the current state of the Automower: started = true, parked =
	 * false.
	 */
	@KnxGroupObject(flags = { C, R, T },
			text = "Start / Park",
			functionText = "Value for toggle",
			datapointType = "1.001", // Switch
			groupAddresses = "${automower.startStopStateAddress}")
	private GroupObject<Boolean> startStopState;

	/*
	 * Group object receive boolean (switch) type GroupValueWrite to park the Automower until further
	 * notice (switch value = false). If switch value = true is received, it's ignored.
	 */
	@KnxGroupObject(flags = { C, W },
			text = "Stop",
			functionText = "Switch",
			datapointType = "1.001", // Switch
			groupAddresses = "${automower.parkCommandAddress}")
	private GroupObject<Boolean> parkSwitch;

	/*
	 * Group object that allows reading the current state of the Automower: false = parked until
	 * further notice, true = undefined.
	 */
	@KnxGroupObject(flags = { C, R, T },
			text = "Stop",
			functionText = "Value for Switch",
			datapointType = "1.001", // Switch
			groupAddresses = "${automower.parkStateAddress}")
	private GroupObject<Boolean> parkState;

	/*
	 * Group object that allows reading a text representation of the current Automower status.
	 */
	@KnxGroupObject(flags = { C, R, T },
			text = "State text",
			functionText = "Value for State",
			datapointType = "16.000", // ASCII String
			groupAddresses = "${automower.stateTextAddress}")
	private GroupObject<String> stateText;

	@Autowired
	private AutomowerService automower;

	// The last known status of the mower
	private MowerStatus lastStatus;

	private LocalDateTime lastStatusTimestamp;

	@KnxPostStart
	private void startDevice() {
		// Make sure credentials are properly configured in the REST client
		automowerCredentials.setClientId(clientId);
		automowerCredentials.setUsername(username);
		automowerCredentials.setPassword(password);

		// Initialize the scheduler to run every minute
		scheduler = new ThreadPoolTaskScheduler();
		scheduler.initialize();
		scheduler.scheduleWithFixedDelay(this::updateMowerStatus, 60000);
	}

	@KnxPostRestart
	private void restartDevice() {
		// Make sure credentials are properly configured in the REST client
		automowerCredentials.setClientId(clientId);
		automowerCredentials.setUsername(username);
		automowerCredentials.setPassword(password);
	}

	@KnxPreShutdown
	private void preShutdown() {
		// Shut down the scheduler so the device can stop properly
		scheduler.shutdown();
	}

	/*
	 * React to the startStop switch.
	 */
	@KnxUpdateDatapoint(groupObjectName = "startStopSwitch")
	public void updateStartStopSwitch(Boolean value) {
		if (value) {
			log.info("Starting automower.");
			automower.start(defaultDuration);
		} else {
			log.info("Parking automower until next schedule.");
			automower.parkUntilNextSchedule();
		}
		updateMowerStatus();
	}

	/*
	 * React to the park switch
	 */
	@KnxUpdateDatapoint(groupObjectName = "parkSwitch")
	public void updateParkSwitch(Boolean value) {
		if (value) {
			log.info("Park switch set to off, ignoring.");
		} else {
			log.info("Parking automower until further notice.");
			automower.parkUntilFurtherNotice();
		}
		updateMowerStatus();
	}

	/*
	 * Retrieve the mower status every 60s and write updates to the bus.
	 */
	public void updateMowerStatus() {
		// Only do this if the device has been initialised with credentials
		if (isInitialized()) {
			AutomowerKnxState knxState = getUpdatedKnxState();

			try {
				startStopState.write(knxState.isToggleState());
				parkState.write(knxState.isSwitchState());
				stateText.write(knxState.getStateText());
			} catch (Exception e) {
				log.error("Unable to update KNX states.", e);
			}
		} else {
			log.info("Device is not initialized, not making any API calls.");
		}
	}

	/*
	 * Only attempt API calls if credentials are already provided, either through the configuration
	 * file or through ETS programming.
	 */
	private boolean isInitialized() {
		return !StringUtils.isEmpty(clientId) && !StringUtils.isEmpty(username)
				&& !StringUtils.isEmpty(password);
	}

	private AutomowerKnxState getUpdatedKnxState() {
		log.info("Updating mower status.");
		lastStatus = automower.getMowerStatus();
		lastStatusTimestamp = LocalDateTime.now();
		log.info("Mower status updated: " + lastStatus.toString());
		return getKnxState(lastStatus);
	}

	/*
	 * Converts the Automower status as received from the API to values that can be sent to the KNX
	 * bus.
	 */
	private AutomowerKnxState getKnxState(MowerStatus status) {
		boolean toggleState = false;
		boolean switchState = false;
		String stateText = "";

		switch (status.getActivity()) {
		case MOWING:
			stateText = "Mowing";
			toggleState = true;
			switchState = true;
			break;
		case CHARGING:
			stateText = "Charging";
			toggleState = true;
			switchState = true;
			break;
		case GOING_HOME:
			stateText = "Going home";
			toggleState = true;
			switchState = true;
			break;
		case LEAVING:
			stateText = "Leaving";
			toggleState = true;
			switchState = true;
			break;
		case NOT_APPLICABLE:
			stateText = "N/A";
			toggleState = false;
			switchState = false;
			break;
		case PARKED_IN_CS:
			stateText = "Parked";
			toggleState = false;
			switchState = false;
			break;
		case STOPPED_IN_GARDEN:
			stateText = "Stopped";
			toggleState = false;
			switchState = false;
			break;
		case UNKNOWN:
			stateText = "Unknown";
			toggleState = false;
			switchState = false;
			break;
		}
		return new AutomowerKnxState(toggleState, switchState, stateText);
	}

	@Data
	@AllArgsConstructor
	class AutomowerKnxState {

		private boolean toggleState;
		private boolean switchState;
		private String stateText;
	}
}
