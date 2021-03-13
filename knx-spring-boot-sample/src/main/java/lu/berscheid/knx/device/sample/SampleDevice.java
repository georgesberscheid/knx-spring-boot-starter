package lu.berscheid.knx.device.sample;

import static lu.berscheid.knx.annotations.KnxGroupObject.Flag.C;
import static lu.berscheid.knx.annotations.KnxGroupObject.Flag.R;
import static lu.berscheid.knx.annotations.KnxGroupObject.Flag.T;
import static lu.berscheid.knx.annotations.KnxGroupObject.Flag.W;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import lu.berscheid.knx.annotations.KnxDevice;
import lu.berscheid.knx.annotations.KnxDeviceParameter;
import lu.berscheid.knx.annotations.KnxGroupObject;
import lu.berscheid.knx.annotations.KnxPostRestart;
import lu.berscheid.knx.annotations.KnxPostStart;
import lu.berscheid.knx.annotations.KnxPreShutdown;
import lu.berscheid.knx.annotations.KnxRequestDatapoint;
import lu.berscheid.knx.annotations.KnxUpdateDatapoint;
import lu.berscheid.knx.model.GroupObject;
import lu.berscheid.knx.model.KnxException;

@SpringBootApplication
@Slf4j
@KnxDevice(productName = "KNX Sample device", // Appears as the name in the catalog in ETS
		applicationName = "Sample application", // Appears as application name in the catalog in ETS
		hardwareName = "Sample virtual device",
		applicationNumber = 13,
		applicationVersion = 10,
		hardwareSerialNumber = "SN000001",
		productOrderNumber = "PO000001")
public class SampleDevice {

	public static void main(String[] args) {
		SpringApplication.run(SampleDevice.class, args);
	}

	/*
	 * Device parameters will appear in the 'Parameters' tab of the ETS configuration pane. Fields
	 * annotated with @KnxDeviceParameter can be programmed through ETS. The initialized parameter
	 * value will appear as default value in ETS.
	 */
	@KnxDeviceParameter(text = "Some String", sizeInBit = 400)
	private String stringParameter = "This is a test";

	@KnxDeviceParameter(text = "Some Integer", minInclusive = 0, maxInclusive = 1000)
	private int intParameter = 20;

	@KnxDeviceParameter(text = "Some Float", minInclusive = 0, maxInclusive = 1000)
	private float floatParameter = 2.5f;

	/*
	 * Boolean device parameters are rendered as checkboxes in ETS
	 */
	@KnxDeviceParameter(text = "Some Checkbox")
	private boolean checkBox = true;

	/*
	 * If the enum has only 2 values, they're rendered as radio buttons
	 */
	@KnxDeviceParameter(text = "Some radio buttons")
	private ActiveEnum active = ActiveEnum.NOT_ACTIVE;

	/*
	 * If the enum has more than 2 values, they're rendered as a drop down box
	 */
	@KnxDeviceParameter(text = "Some drop down box")
	private ItemsEnum item = ItemsEnum.SECOND_ITEM;

	/*
	 * Group objects will appear in the 'Group Objects' tab of the ETS configuration pane. Fields
	 * annotated with @KnxGroupObject can be programmed through ETS. Group addresses assigned during
	 * object initialization will be overwritten by ETS programming.
	 */
	@KnxGroupObject(text = "On / Off",
			functionText = "Switch",
			flags = { C, R, W, T },
			datapointType = "1.001", // Switch
			groupAddresses = { "${knx.booleanGroupAddress}" })
	private GroupObject<Boolean> booleanGroupObject;

	@KnxGroupObject(text = "Brightness",
			functionText = "Value",
			flags = { C, R, W, T },
			datapointType = "7.013", // Brightness
			groupAddresses = { "${knx.integerGroupAddress}" })
	private GroupObject<Integer> integerGroupObject;

	/*
	 * The post start method is called by the device runtime once the device has completely started
	 * up. This method is called after the constructor and after @PostConstruct methods.
	 */
	@KnxPostStart
	public void postStart() throws KnxException {
		log.info("Device started.");
		log.info("booleanGroupObject has group addresses: " + booleanGroupObject.getGroupAddresses());
		log.info("integerGroupObject has group addresses: " + integerGroupObject.getGroupAddresses());
		log.info("stringParameter has value: " + stringParameter);
		log.info("intParameter has value: " + intParameter);
		log.info("floatParameter has value: " + floatParameter);
		log.info("checkBox has value: " + checkBox);
		log.info("active has value: " + active);
		log.info("item has value: " + item);

		booleanGroupObject.write(true);
		integerGroupObject.write(20);
	}

	/*
	 * The post restart method is called after the device is restarted. ETS requests a device restart
	 * when the programming operation is completed, so when this method is called, new values for
	 * device parameters and group objects have been injected.
	 */
	@KnxPostRestart
	public void postRestart() throws KnxException {
		log.info("Device restarted.");
		log.info("booleanGroupObject has group addresses: " + booleanGroupObject.getGroupAddresses());
		log.info("integerGroupObject has group addresses: " + integerGroupObject.getGroupAddresses());
		log.info("stringParameter has value: " + stringParameter);
		log.info("intParameter has value: " + intParameter);
		log.info("floatParameter has value: " + floatParameter);
		log.info("checkBox has value: " + checkBox);
		log.info("active has value: " + active);
		log.info("item has value: " + item);
	}

	/*
	 * The pre shutdown method is called right before the KNX device runtime is shut down. This
	 * allows some clean up to be done so the device shutdown can complete properly.
	 */
	@KnxPreShutdown
	public void preShutdown() throws KnxException {
		log.info("Shutting down device.");
	}

	/*
	 * A GroupValueWrite telegram has been received on a group address associated with this group
	 * object and the value has been updated.
	 */
	@KnxUpdateDatapoint(groupObjectName = "booleanGroupObject")
	public void updateBoolean(Boolean value) {
		log.info("Received update for boolean group object: " + value);
	}

	@KnxUpdateDatapoint(groupObjectName = "integerGroupObject")
	public void updateInteger(Integer value) {
		log.info("Received update for integer group object: " + value);
		integerGroupObject.setValue(value);
	}

	@KnxRequestDatapoint(groupObjectName = "booleanGroupObject")
	public Boolean requestBoolean() {
		log.info("Requesting value for boolean group object: " + booleanGroupObject.getValue());
		return booleanGroupObject.getValue();
	}

	@KnxRequestDatapoint(groupObjectName = "integerGroupObject")
	public Integer requestInteger() {
		log.info("Requesting value for integer group object: " + integerGroupObject.getValue());
		return integerGroupObject.getValue();
	}

	/*
	 * Enums are converted into radio buttons or drop-down boxes in ETS. Override toString() to
	 * generate some custom descriptions in the Parameters panel in ETS.
	 */
	public enum ActiveEnum {

		ACTIVE("active"), // active
		NOT_ACTIVE("not active"); // not active

		private ActiveEnum(String description) {
			this.description = description;
		}

		private String description;

		public String toString() {
			return description;
		}
	}

	public enum ItemsEnum {

		FIRST_ITEM("First item"), SECOND_ITEM("Second item"), THIRD_ITEM("Third item"), FORTH_ITEM(
				"Forth item"), FIFTH_ITEM("Fifth item");

		private ItemsEnum(String description) {
			this.description = description;
		}

		private String description;

		public String toString() {
			return description;
		}
	}
}
