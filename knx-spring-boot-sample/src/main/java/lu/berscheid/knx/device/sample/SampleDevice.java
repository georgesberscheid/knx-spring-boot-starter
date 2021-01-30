package lu.berscheid.knx.device.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

import static lu.berscheid.knx.annotations.KnxGroupObject.Flag.C;
import static lu.berscheid.knx.annotations.KnxGroupObject.Flag.R;
import static lu.berscheid.knx.annotations.KnxGroupObject.Flag.T;
import static lu.berscheid.knx.annotations.KnxGroupObject.Flag.W;

@SpringBootApplication
@KnxDevice(productName = "KNX Sample device", // Appears as the name in the catalog in ETS
		applicationName = "Sample application", // Appears as application name in the catalog in ETS
		hardwareName = "Sample virtual device",
		applicationNumber = 13,
		applicationVersion = 10,
		hardwareSerialNumber = "SN000001",
		productOrderNumber = "PO000001")
public class SampleDevice {

	private Logger log = LoggerFactory.getLogger(SampleDevice.class);

	public static void main(String[] args) {
		SpringApplication.run(SampleDevice.class, args);
	}

	/*
	 * Device parameters will appear in the 'Parameters' tab of the ETS configuration pane. Fields
	 * annotated with @KnxDeviceParameter can be programmed through ETS. The initialized parameter
	 * value will appear as default value in ETS.
	 */
	@KnxDeviceParameter(sizeInBit = 400)
	private String stringParameter = "This is a test";
	@KnxDeviceParameter(minInclusive = 0, maxInclusive = 1000)
	private int intParameter = 20;

	/*
	 * Group objects will appear in the 'Group Objects' tab of the ETS configuration pane. Fields
	 * annotated with @KnxGroupObject can be programmed through ETS. Group addresses assigned during
	 * object initialization will be overwritten by ETS programming.
	 */
	@KnxGroupObject(flags = { C, R, W, T }, groupAddresses = { "${knx.booleanGroupAddress}" })
	private GroupObject<Boolean> booleanGroupObject;

	@KnxGroupObject(flags = { C, R, W, T }, groupAddresses = { "${knx.integerGroupAddress}" })
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
}
