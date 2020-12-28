package lu.berscheid.knx.device.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lu.berscheid.knx.annotations.KnxDevice;
import lu.berscheid.knx.annotations.KnxDeviceParameter;
import lu.berscheid.knx.annotations.KnxGroupObject;
import lu.berscheid.knx.annotations.KnxPostStart;
import lu.berscheid.knx.annotations.KnxRequestDatapointMethod;
import lu.berscheid.knx.annotations.KnxUpdateDatapointMethod;
import lu.berscheid.knx.model.GroupObject;
import lu.berscheid.knx.model.KnxException;

@SpringBootApplication
@KnxDevice(applicationNumber = 13, applicationVersion = 10, hardwareSerialNumber = "S111", productOrderNumber = "O222")
public class SampleDevice {

	private Logger log = LoggerFactory.getLogger(SampleDevice.class);

	public static void main(String[] args) {
		SpringApplication.run(SampleDevice.class, args);
	}

	@KnxDeviceParameter(minInclusive = 0, maxInclusive = 1000)
	private int testParameter1 = 10;
	@KnxDeviceParameter(minInclusive = 0, maxInclusive = 1000)
	private int testParameter2 = 20;

	@KnxGroupObject(groupAddresses = { "${knx.booleanGroupAddress}" })
	private GroupObject<Boolean> booleanGroupObject;

	@KnxGroupObject(groupAddresses = { "${knx.integerGroupAddress}" })
	private GroupObject<Integer> integerGroupObject;

	@KnxPostStart
	public void postStart() throws KnxException {
		booleanGroupObject.write(true);
		integerGroupObject.write(20);
	}

	@KnxUpdateDatapointMethod(groupObjectName = "booleanGroupObject")
	public void updateBoolean(Boolean value) {
		log.info("Received update for boolean group object: " + value);
		booleanGroupObject.setValue(value);
	}

	@KnxUpdateDatapointMethod(groupObjectName = "integerGroupObject")
	public void updateInteger(Integer value) {
		log.info("Received update for integer group object: " + value);
		integerGroupObject.setValue(value);
	}

	@KnxRequestDatapointMethod(groupObjectName = "booleanGroupObject")
	public Boolean requestBoolean() {
		log.info("Requesting value for boolean group object: " + booleanGroupObject.getValue());
		return booleanGroupObject.getValue();
	}

	@KnxRequestDatapointMethod(groupObjectName = "integerGroupObject")
	public Integer requestInteger() {
		log.info("Requesting value for integer group object: " + integerGroupObject.getValue());
		return integerGroupObject.getValue();
	}
}
