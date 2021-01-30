package lu.berscheid.knx;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import lombok.extern.slf4j.Slf4j;
import lu.berscheid.knx.model.KnxDeviceConfig;
import lu.berscheid.knx.model.KnxException;
import lu.berscheid.knx.model.KnxGroupObjectConfig;
import tuwien.auto.calimero.DataUnitBuilder;
import tuwien.auto.calimero.DeviceDescriptor;
import tuwien.auto.calimero.DeviceDescriptor.DD0;
import tuwien.auto.calimero.KNXException;
import tuwien.auto.calimero.device.BaseKnxDevice;

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
				GroupObjectImpl groupObjectImpl = new GroupObjectImpl(knxLink,
						groupObject.getGroupAddresses(), groupObject);
				groupObject.getField().setAccessible(true);
				groupObject.getField().set(deviceConfig.getDeviceInstance(), groupObjectImpl);
				groupObject.setGroupObjectImpl(groupObjectImpl);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				log.error("Unable to assign group object instance to "
						+ groupObject.getField().getName() + ". Group Object is being ignored.", e);
			}
		}

		// Create a BaseKnxDevice and start the runtime
		BaseKnxDevice device;
		try {
			device = startDeviceRuntime(deviceConfig);
		} catch (KNXException e) {
			log.error("Unable to start KNX device runtime: " + e.getMessage(), e);
			throw new KnxException("Unable to start KNX device runtime: " + e.getMessage(), e);
		}

		// Run post start method
		if (deviceConfig.getPostStartMethod() != null) {
			try {
				deviceConfig.getPostStartMethod().setAccessible(true);
				deviceConfig.getPostStartMethod().invoke(deviceConfig.getDeviceInstance());
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				log.error("Unable to call post start method "
						+ deviceConfig.getPostStartMethod().getName() + ".", e);
			}
		}

		// Leave the main thread alive while the listeners process messages
		while (true) {
			try {
				if (System.in.read() != 0) break;
			} catch (IOException e) {
				log.info("Unable to read from System.in, exiting.");
			}
		}

		// Run pre shutdown method
		if (deviceConfig.getPreShutdownMethod() != null) {
			try {
				deviceConfig.getPreShutdownMethod().setAccessible(true);
				deviceConfig.getPreShutdownMethod().invoke(deviceConfig.getDeviceInstance());
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				log.error("Unable to call pre shutdown method "
						+ deviceConfig.getPreShutdownMethod().getName() + ".", e);
			}
		}

		// Close the device and save the interface objects and memory
		device.close();
	}

	private BaseKnxDevice startDeviceRuntime(KnxDeviceConfig deviceConfig) throws KNXException {
		KnxDeviceLogic logic = new KnxDeviceLogic(deviceConfig);

		// Load the previously stored device memory dump. If it exists, sync the runtime from the
		// loaded memory once the device is started.
		String iosFilename = deviceConfig.getHardwareName().replaceAll(" ", "_");
		String iosFilePath = System.getProperty("user.home") + "\\.knx\\"
				+ deviceConfig.getHardwareName() + "\\";
		File deviceOutputFile = new File(iosFilePath + iosFilename + ".xml");
		boolean syncRuntime = deviceOutputFile.exists();
		if (!syncRuntime) {
			// Create directories if they don't exist yet
			new File(iosFilePath).mkdirs();
		}

		BaseKnxDevice device = new BaseKnxDevice(deviceConfig.getApplicationName(), logic,
				deviceOutputFile.toURI(), new char[] { 0 });
		DeviceDescriptor deviceDescriptor = DD0.TYPE_07B0;
		int manufacturerId = Integer.parseInt(deviceConfig.getManufacturerRefId().substring(2), 16);
		// TODO: get serialNumber, hardwareType, programVersion from deviceConfig
		final byte[] serialNumber = DataUnitBuilder.fromHex("000a1c112913"); // 6 bytes
		final byte[] hardwareType = DataUnitBuilder.fromHex("000000000223"); // 6 bytes
		final byte[] programVersion = new byte[] { 0, 4, 0, 0, 0 }; // 5 bytes
		// a valid FDSK is only required for secure device download
		final byte[] fdsk = DataUnitBuilder.fromHex("35cb5a25771daf18d52d9ef7e39a2799"); // 16 bytes
		device.identification(deviceDescriptor, manufacturerId, serialNumber, hardwareType,
				programVersion, fdsk);

		logic.setDevice(device);
		logic.setProgrammingMode(true);
		logic.registerGroupObjects();
		if (syncRuntime) {
			logic.syncRuntimeFromMemory();
		}
		device.setDeviceLink(knxLink.getLink());
		return device;
	}
}
