package lu.berscheid.knx;

import static lu.berscheid.knx.utils.KnxTypeUtils.isBoolean;
import static lu.berscheid.knx.utils.KnxTypeUtils.isDouble;
import static lu.berscheid.knx.utils.KnxTypeUtils.isFloat;
import static lu.berscheid.knx.utils.KnxTypeUtils.isInteger;
import static lu.berscheid.knx.utils.KnxTypeUtils.isLong;
import static lu.berscheid.knx.utils.KnxTypeUtils.isShort;
import static lu.berscheid.knx.utils.KnxTypeUtils.isString;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import lu.berscheid.knx.model.KnxDeviceConfig;
import lu.berscheid.knx.model.KnxGroupObjectConfig;
import lu.berscheid.knx.model.KnxParameterConfig;
import tuwien.auto.calimero.GroupAddress;
import tuwien.auto.calimero.KNXException;
import tuwien.auto.calimero.KNXFormatException;
import tuwien.auto.calimero.datapoint.Datapoint;
import tuwien.auto.calimero.datapoint.StateDP;
import tuwien.auto.calimero.device.PatchedKnxDeviceServiceLogic;
import tuwien.auto.calimero.device.ServiceResult;
import tuwien.auto.calimero.dptxlator.DPT;
import tuwien.auto.calimero.dptxlator.DPTXlator;
import tuwien.auto.calimero.dptxlator.DPTXlator4ByteFloat;
import tuwien.auto.calimero.dptxlator.DPTXlator4ByteSigned;
import tuwien.auto.calimero.dptxlator.DPTXlator64BitSigned;
import tuwien.auto.calimero.dptxlator.DPTXlatorBoolean;
import tuwien.auto.calimero.dptxlator.DPTXlatorDateTime;
import tuwien.auto.calimero.dptxlator.DPTXlatorString;

@Slf4j
public class KnxDeviceLogic extends PatchedKnxDeviceServiceLogic {

	private KnxDeviceConfig deviceConfig;

	private Map<String, List<KnxGroupObjectConfig>> map = new HashMap<String, List<KnxGroupObjectConfig>>();

	public KnxDeviceLogic(KnxDeviceConfig deviceConfig) {
		this.deviceConfig = deviceConfig;
	}

	@Override
	public void updateDatapointValue(Datapoint ofDp, DPTXlator update) {
		List<KnxGroupObjectConfig> groupObjects = map.get(ofDp.getMainAddress().toString());
		if (groupObjects == null || groupObjects.isEmpty()) {
			log.error("updateDatapointValue triggered for group address" + ofDp.getMainAddress()
					+ " but we don't have a matching group object.");
			return;
		}

		for (KnxGroupObjectConfig groupObjectConfig : groupObjects) {
			// Check whether the group object is actually writable
			if (!groupObjectConfig.isWriteFlag()) {
				log.warn("Group object" + groupObjectConfig.getName()
						+ " is associated with group address " + ofDp.getMainAddress().toString()
						+ " but it doesn't have the W flag so we're ignoring it.");
				continue;
			}

			Object value = null;
			try {
				if (isBoolean(groupObjectConfig.getType())) {
					value = ((DPTXlatorBoolean) update).getValueBoolean();
				} else if (isShort(groupObjectConfig.getType())) {
					value = (short) ((DPTXlator4ByteSigned) update).getValueSigned();
				} else if (isInteger(groupObjectConfig.getType())) {
					value = ((DPTXlator64BitSigned) update).getValueSigned();
				} else if (isFloat(groupObjectConfig.getType())) {
					value = ((DPTXlator4ByteFloat) update).getValueFloat();
				} else if (isString(groupObjectConfig.getType())) {
					value = ((DPTXlatorString) update).getValue();
				} else {
					log.error("Unsupported type: " + groupObjectConfig.getType());
				}

				// Update the injected GroupObjectImpl first
				groupObjectConfig.getGroupObjectImpl().setValue(value);
				// Then invoke the update datapoint method if it exists
				if (groupObjectConfig.getUpdateDatapointMethod() != null) {
					groupObjectConfig.getUpdateDatapointMethod().invoke(deviceConfig.getDeviceInstance(),
							value);
				}
			} catch (Exception e) {
				log.error("Unable to invoke " + groupObjectConfig.getUpdateDatapointMethod() + " of "
						+ deviceConfig.getDeviceInstance().getClass(), e);
			}
		}
	}

	@Override
	public DPTXlator requestDatapointValue(Datapoint ofDp) throws KNXException {
		List<KnxGroupObjectConfig> groupObjectConfigs = map.get(ofDp.getMainAddress().toString());
		if (groupObjectConfigs == null || groupObjectConfigs.isEmpty()) {
			log.error("requestDatapointValue triggered for group address " + ofDp.getMainAddress()
					+ " but we don't have a matching group object.");
			return null;
		}

		if (groupObjectConfigs.size() != 1) {
			log.warn("Received requestDatapointValue for group address " + ofDp.getMainAddress()
					+ " but multiple datapoints are assigned to it. Using the first one: "
					+ groupObjectConfigs.get(0).getName());
		}

		// We're only supposed to have one readable group object mapped to this, so we're returning
		// the value of the first readable group object that matches this group address
		for (KnxGroupObjectConfig groupObjectConfig : groupObjectConfigs) {
			// Check if it's readable
			if (!groupObjectConfig.isReadFlag()) {
				log.warn("Group object" + groupObjectConfig.getName()
						+ " is associated with group address " + ofDp.getMainAddress().toString()
						+ " but it doesn't have the R flag so we're ignoring it.");
				continue;
			}

			Object returnValue;
			if (groupObjectConfig.getRequestDatapointMethod() != null) {
				// Call the request datapoint method if available for this group object
				try {
					returnValue = groupObjectConfig.getRequestDatapointMethod()
							.invoke(deviceConfig.getDeviceInstance());
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					log.error("Unable to invoke " + groupObjectConfig.getRequestDatapointMethod()
							+ " of " + deviceConfig.getDeviceInstance().getClass(), e);
					continue;
				}
			} else {
				// If we don't have a request datapoint method, just return the current value of the
				// group object
				returnValue = groupObjectConfig.getGroupObjectImpl().getValue();
			}

			try {
				if (groupObjectConfig.getType().equals(Boolean.class)) {
					DPTXlatorBoolean xlator = new DPTXlatorBoolean(ofDp.getDPT());
					xlator.setValue((boolean) returnValue);
					return xlator;
				} else if (groupObjectConfig.getType().equals(Short.class)) {
					DPTXlator4ByteSigned xlator = new DPTXlator4ByteSigned(ofDp.getDPT());
					xlator.setValue((short) returnValue);
					return xlator;
				} else if (groupObjectConfig.getType().equals(Integer.class)) {
					DPTXlator4ByteSigned xlator = new DPTXlator4ByteSigned(ofDp.getDPT());
					xlator.setValue((int) returnValue);
					return xlator;
				} else if (groupObjectConfig.getType().equals(Float.class)) {
					DPTXlator4ByteFloat xlator = new DPTXlator4ByteFloat(ofDp.getDPT());
					xlator.setValue((float) returnValue);
					return xlator;
				} else if (groupObjectConfig.getType().equals(String.class)) {
					DPTXlatorString xlator = new DPTXlatorString(ofDp.getDPT());
					xlator.setValue((String) returnValue);
					return xlator;
				} else {
					log.error("Unsupported type: " + groupObjectConfig.getType());
				}
			} catch (ClassCastException | IllegalArgumentException e) {
				log.error("Unable to invoke " + groupObjectConfig.getRequestDatapointMethod() + " of "
						+ deviceConfig.getDeviceInstance().getClass(), e);
			}
		}
		return null;
	}

	/*
	 * When we receive a restart signal from ETS, reset the group objects and application program.
	 */
	@Override
	public ServiceResult restart(final boolean masterReset, final EraseCode eraseCode,
			final int channel) {
		super.restart(masterReset, eraseCode, channel);

		// Restart happens after programming from ETS is complete. Sync the new memory
		// state with the datapoints used at runtime.
		syncRuntimeFromMemory();

		// Run post restart method
		if (deviceConfig.getPostStartMethod() != null) {
			try {
				deviceConfig.getPostRestartMethod().setAccessible(true);
				deviceConfig.getPostRestartMethod().invoke(deviceConfig.getDeviceInstance());
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				log.error("Unable to call init method " + deviceConfig.getPostStartMethod().getName()
						+ ". Group Object is being ignored.", e);
			}
		}
		return null;
	}

	/*
	 * Read the device memory copy values to the device runtime. This means updating the datapoints
	 * that this device is listening to and re-inject device parameters.
	 */
	protected void syncRuntimeFromMemory() {
		// First 2 bytes of each regions in the device memory indicate the length
		ByteBuffer deviceMemory = ByteBuffer.wrap(getMemory());
		short addressTableLength = deviceMemory.getShort(0x0116);
		short associationTableLength = deviceMemory.getShort(0x1000);

		updateGroupAddressesFromMemory(
				Arrays.copyOfRange(getMemory(), 0x0116, 0x0116 + (addressTableLength * 2) + 2),
				Arrays.copyOfRange(getMemory(), 0x1000, 0x1000 + (associationTableLength * 4) + 2));

		// Read 4k bytes - TODO: find out what the size of the application program is
		updateApplicationProgramFromMemory(Arrays.copyOfRange(getMemory(), 0x4000, 0x5000));
	}

	protected void syncMemoryFromRuntime() {
		updateGroupAddressesFromRuntime(ByteBuffer.wrap(getMemory(), 0x0116, 0x0EEA),
				ByteBuffer.wrap(getMemory(), 0x1000, 0x1000));
		updateApplicationProgramFromRuntime(ByteBuffer.wrap(getMemory(), 0x4000, 0x1000));
	}

	/*
	 * Read the group address table and the association table from the device and rebuild the list of
	 * group objects and group addresses assigned to them.
	 */
	protected void updateGroupAddressesFromMemory(byte[] groupAddressTable,
			byte[] associationTable) {
		try {
			// First, clean up the old configuration
			getDatapointModel().removeAll();
			for (KnxGroupObjectConfig groupObjectConfig : deviceConfig.getGroupObjects()) {
				groupObjectConfig.getGroupAddresses().clear();
			}

			// Then, build an array of group addresses
			DataInputStream groupAddressStream = new DataInputStream(
					new ByteArrayInputStream(groupAddressTable));
			int groupAddressLength = groupAddressStream.readUnsignedShort();
			String[] groupAddresses = new String[groupAddressLength];
			for (int i = 0; i < groupAddressLength; i++) {
				groupAddresses[i] = new GroupAddress(groupAddressStream.readUnsignedShort()).toString();
			}

			// Then, assign the group addresses to the group objects by looking at the association
			// table
			DataInputStream associationTableStream = new DataInputStream(
					new ByteArrayInputStream(associationTable));
			int associationTableLength = associationTableStream.readUnsignedShort();
			for (int i = 0; i < associationTableLength; i++) {
				// The association table contains a list of tuples [groupAddressRef, groupObjectRef],
				// 1-based
				int groupAddressIndex = associationTableStream.readUnsignedShort() - 1;
				int groupObjectIndex = associationTableStream.readUnsignedShort() - 1;
				String groupAddress;
				KnxGroupObjectConfig groupObjectConfig;
				try {
					groupAddress = groupAddresses[groupAddressIndex];
				} catch (ArrayIndexOutOfBoundsException e) {
					log.error("Association table references a group address with index "
							+ groupAddressIndex + " that doesn't exist in table " + groupAddresses);
					continue;
				}
				try {
					groupObjectConfig = deviceConfig.getGroupObjects().get(groupObjectIndex);
				} catch (ArrayIndexOutOfBoundsException e) {
					log.error("Association table references a group object with index "
							+ groupObjectIndex + " that doesn't exist in group object list "
							+ deviceConfig.getGroupObjects());
					continue;
				}

				// Add the group address to the group object
				groupObjectConfig.getGroupAddresses().add(groupAddress);
			}

			// Register group objects (datapoints) in the device runtime
			registerGroupObjects();

			for (KnxGroupObjectConfig groupObjectConfig : deviceConfig.getGroupObjects()) {
				// Track all group addresses and map them to the group object configs. We need this map
				// to look up the group object that is mapped to a specific group address.
				for (String groupAddress : groupObjectConfig.getGroupAddresses()) {
					List<KnxGroupObjectConfig> groupObjects = map.get(groupAddress);
					if (groupObjects == null) {
						groupObjects = new ArrayList<KnxGroupObjectConfig>();
						map.put(groupAddress, groupObjects);
					}
					groupObjects.add(groupObjectConfig);
				}

				// Copy the group addresses to the GroupObjectImpl injected in the device instance class
				try {
					groupObjectConfig.getField().setAccessible(true);
					GroupObjectImpl groupObjectImpl = (GroupObjectImpl) groupObjectConfig.getField()
							.get(deviceConfig.getDeviceInstance());
					groupObjectImpl.setGroupAddresses(groupObjectConfig.getGroupAddresses());
				} catch (IllegalArgumentException | IllegalAccessException e) {
					log.error("Unable to update group addresses on  group object instance "
							+ groupObjectConfig.getField().getName()
							+ ". Group addresses will not be updated.", e);
				}
			}
		} catch (IOException e) {
			log.error("An error occurred while reading the group address or association table: "
					+ e.getMessage(), e);
		}
	}

	/*
	 * Read all device parameters from the application program memory
	 */
	protected void updateApplicationProgramFromMemory(byte[] applicationProgram) {
		DataInputStream applicationProgramStream = new DataInputStream(
				new ByteArrayInputStream(applicationProgram));
		for (KnxParameterConfig parameterConfig : deviceConfig.getParameters()) {
			Object value;
			try {
				// Read from the stream depending on the type of the parameter
				if (isInteger(parameterConfig.getType())) {
					value = applicationProgramStream.readInt();
				} else if (isLong(parameterConfig.getType())) {
					value = applicationProgramStream.readLong();
				} else if (isDouble(parameterConfig.getType())) {
					value = applicationProgramStream.readDouble();
				} else if (isFloat(parameterConfig.getType())) {
					value = applicationProgramStream.readFloat();
				} else if (isString(parameterConfig.getType())) {
					int sizeInBytes = parameterConfig.getTypeConfig().getSizeInBit() / 8;
					byte[] bytes = new byte[sizeInBytes];
					applicationProgramStream.read(bytes);
					value = new String(bytes).trim();
				} else {
					log.warn("Unknown type: " + parameterConfig.getTypeConfig().getType());
					continue;
				}
			} catch (IOException e) {
				log.error("Unable to read parameter value from application program: "
						+ parameterConfig.getName());
				continue;
			}

			// Inject the parameter value into the parameter field of the device
			try {
				parameterConfig.getField().setAccessible(true);
				parameterConfig.getField().set(deviceConfig.getDeviceInstance(), value);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				log.error("Unable to write parameter value " + value + " to device field "
						+ deviceConfig.getApplicationName() + "." + parameterConfig.getName()
						+ ". Skipping.");
			}
		}
	}

	/*
	 * Read the group addresses and association table from the runtime (as defined in the device
	 * configuration) and write it to the device memory in case it needs to be read by ETS.
	 */
	protected void updateGroupAddressesFromRuntime(ByteBuffer addressTable,
			ByteBuffer associationTable) {
		// Temporarily write item counts, overwrite later
		addressTable.putShort((short) 0);
		associationTable.putShort((short) 0);

		short currentObjectIndex = 1;
		short currentAddressIndex = 1;
		short associationCount = 0;
		Map<String, Short> groupAddresses = new HashMap<String, Short>();

		for (KnxGroupObjectConfig groupObject : deviceConfig.getGroupObjects()) {
			for (String groupAddress : groupObject.getGroupAddresses()) {
				Short addressIndex = groupAddresses.get(groupAddress);
				if (addressIndex == null) {
					// This group address has not yet appeared
					groupAddresses.put(groupAddress, currentAddressIndex);
					try {
						addressTable.put(new GroupAddress(groupAddress).toByteArray());
					} catch (KNXFormatException e) {
						log.error("Unable to parse group address " + groupAddress
								+ " while writing device memory. Skipping this address.");
						continue;
					}
					associationTable.putShort(currentAddressIndex++);
				} else {
					// This group address appeared before
					associationTable.putShort(addressIndex);
				}
				associationTable.putShort(currentObjectIndex);
				associationCount++;
			}
			currentObjectIndex++;
		}

		// Now overwrite the counters with the right values
		addressTable.putShort(0, (short) groupAddresses.size());
		associationTable.putShort(0, associationCount);
	}

	/*
	 * Read the device parameters and write them to the device application program in memory in case
	 * it needs to be read by ETS.
	 */
	protected void updateApplicationProgramFromRuntime(ByteBuffer applicationProgram) {
		for (KnxParameterConfig parameterConfig : deviceConfig.getParameters()) {
			if (isInteger(parameterConfig.getType())) {
				applicationProgram.putInt((Integer) parameterConfig.getValue());
			} else if (isLong(parameterConfig.getType())) {
				applicationProgram.putLong((Long) parameterConfig.getValue());
			} else if (isDouble(parameterConfig.getType())) {
				applicationProgram.putDouble((Double) parameterConfig.getValue());
			} else if (isFloat(parameterConfig.getType())) {
				applicationProgram.putFloat((Float) parameterConfig.getValue());
			} else if (isString(parameterConfig.getType())) {
				applicationProgram.put(((String) parameterConfig.getValue()).getBytes());
			} else {
				log.warn("Unknown type: " + parameterConfig.getTypeConfig().getType());
				continue;
			}
		}
	}

	public void registerGroupObjects() {
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
				log.error("Unsupported datapoint type for group object " + groupObjectConfig.getName()
						+ ": " + groupObjectConfig.getType());
				continue;
			}

			for (String groupAddress : groupObjectConfig.getGroupAddresses()) {
				try {
					Datapoint datapoint = new StateDP(new GroupAddress(groupAddress),
							groupObjectConfig.getName() + ": " + groupAddress, 0, datapointType.getID());
					log.debug("Registering group address " + groupAddress);
					getDatapointModel().add(datapoint);
				} catch (KNXFormatException e) {
					log.error("Unablet to to add datapoint to device. Group address " + groupAddress
							+ " is invalid.");
				}
			}
		}
	}
}
