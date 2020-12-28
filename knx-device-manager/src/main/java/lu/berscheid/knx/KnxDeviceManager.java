package lu.berscheid.knx;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import lu.berscheid.knx.model.KnxDeviceConfig;
import lu.berscheid.knx.model.KnxException;
import lu.berscheid.knx.model.KnxGroupObjectConfig;
import tuwien.auto.calimero.DeviceDescriptor;
import tuwien.auto.calimero.GroupAddress;
import tuwien.auto.calimero.KNXException;
import tuwien.auto.calimero.datapoint.Datapoint;
import tuwien.auto.calimero.datapoint.StateDP;
import tuwien.auto.calimero.device.BaseKnxDevice;
import tuwien.auto.calimero.device.KnxDevice;
import tuwien.auto.calimero.dptxlator.DPT;
import tuwien.auto.calimero.dptxlator.DPTXlator4ByteFloat;
import tuwien.auto.calimero.dptxlator.DPTXlator4ByteSigned;
import tuwien.auto.calimero.dptxlator.DPTXlator64BitSigned;
import tuwien.auto.calimero.dptxlator.DPTXlatorBoolean;
import tuwien.auto.calimero.dptxlator.DPTXlatorDateTime;
import tuwien.auto.calimero.dptxlator.DPTXlatorString;

@Slf4j
public class KnxDeviceManager {

	private KnxDeviceConfig deviceConfig;
	private String ipAddress;
	private int port;
	private KnxLink knxLink;

	public KnxDeviceManager(KnxDeviceConfig deviceConfig, String ipAddress, int port) {
		this.deviceConfig = deviceConfig;
		this.ipAddress = ipAddress;
		this.port = port;
	}

	public void start() throws KnxException {
		log.info("Starting KNX device: " + deviceConfig.getApplicationName());

		// Create a connection to the KNX bus
		if (ipAddress == null) {
			// Create a network link of type router
			knxLink = new KnxLink(deviceConfig.getIndividualAddress());
		} else {
			// Create a network link of type interface / tunnel
			knxLink = new KnxLink(deviceConfig.getIndividualAddress(), ipAddress, port);
		}

		// Inject group objects
		for (KnxGroupObjectConfig groupObject : deviceConfig.getGroupObjects()) {
			try {
				GroupObjectImpl groupObjectImpl = new GroupObjectImpl();
				groupObjectImpl.setKnxLink(knxLink);
				groupObjectImpl.setGroupAddresses(groupObject.getGroupAddresses());
				groupObject.getField().setAccessible(true);
				groupObject.getField().set(deviceConfig.getDeviceInstance(), groupObjectImpl);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				log.error("Unable to assign group object instance to " + groupObject.getField().getName()
						+ ". Group Object is being ignored.", e);
			}
		}

		// Create a BaseKnxDevice and start the runtime
		try {
			startDeviceRuntime(deviceConfig);
		} catch (KNXException e) {
			log.error("Unable to start KNX device runtime: " + e.getMessage(), e);
			throw new KnxException("Unable to start KNX device runtime: " + e.getMessage(), e);
		}

		// Run init method
		if (deviceConfig.getPostStartMethod() != null) {
			try {
				deviceConfig.getPostStartMethod().setAccessible(true);
				deviceConfig.getPostStartMethod().invoke(deviceConfig.getDeviceInstance());
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				log.error("Unable to call init method " + deviceConfig.getPostStartMethod().getName()
						+ ". Group Object is being ignored.", e);
			}
		}

		// Leave the main thread alive while the listeners process messages
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				log.info("Main thread got interrupted, exiting.");
			}
		}
	}

	private void startDeviceRuntime(KnxDeviceConfig deviceConfig) throws KNXException {
		KnxDeviceLogic logic = new KnxDeviceLogic(deviceConfig);
		// We're using device descriptor 0x07B0 because it's also the mask version used in the application program of the
		// generated .knxprod file.
		KnxDevice device = new BaseKnxDevice(deviceConfig.getApplicationName(), DeviceDescriptor.DD0.TYPE_07B0, logic,
				logic, null, new char[] { 0 });
		logic.setDevice(device);

		// Register all group object datapoints
		for (KnxGroupObjectConfig groupObjectConfig : deviceConfig.getGroupObjects()) {
			// TODO: fine grained type management
			DPT datapointType = null;
			if (groupObjectConfig.getType().equals(Boolean.class)) {
				datapointType = DPTXlatorBoolean.DPT_SWITCH;
			} else if (groupObjectConfig.getType().equals(Short.class)) {
				datapointType = DPTXlator4ByteSigned.DPT_COUNT;
			} else if (groupObjectConfig.getType().equals(Integer.class)) {
				datapointType = DPTXlator64BitSigned.DPT_ACTIVE_ENERGY;
			} else if (groupObjectConfig.getType().equals(Float.class)) {
				datapointType = DPTXlator4ByteFloat.DPT_ABSOLUTE_TEMPERATURE;
			} else if (groupObjectConfig.getType().equals(String.class)) {
				datapointType = DPTXlatorString.DPT_STRING_8859_1;
			} else if (groupObjectConfig.getType().equals(Date.class)) {
				datapointType = DPTXlatorDateTime.DPT_DATE_TIME;
			} else {
				log.error("Unsupported datapoint type for group object " + groupObjectConfig.getName() + ": "
						+ groupObjectConfig.getType());
				continue;
			}

			for (String groupAddress : groupObjectConfig.getGroupAddresses()) {
				Datapoint datapoint = new StateDP(new GroupAddress(groupAddress),
						groupObjectConfig.getName() + ": " + groupAddress, 0, datapointType.getID());
				log.debug("Registering group address " + groupAddress);
				logic.getDatapointModel().add(datapoint);
			}

			device.setDeviceLink(knxLink.getLink());
		}
	}
}
