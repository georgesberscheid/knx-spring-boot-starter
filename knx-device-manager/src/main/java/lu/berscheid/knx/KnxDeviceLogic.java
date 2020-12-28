package lu.berscheid.knx;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import lu.berscheid.knx.model.KnxDeviceConfig;
import lu.berscheid.knx.model.KnxGroupObjectConfig;
import tuwien.auto.calimero.KNXException;
import tuwien.auto.calimero.datapoint.Datapoint;
import tuwien.auto.calimero.device.KnxDeviceServiceLogic;
import tuwien.auto.calimero.dptxlator.DPTXlator;
import tuwien.auto.calimero.dptxlator.DPTXlator4ByteFloat;
import tuwien.auto.calimero.dptxlator.DPTXlator4ByteSigned;
import tuwien.auto.calimero.dptxlator.DPTXlator64BitSigned;
import tuwien.auto.calimero.dptxlator.DPTXlatorBoolean;
import tuwien.auto.calimero.dptxlator.DPTXlatorString;

@Slf4j
public class KnxDeviceLogic extends KnxDeviceServiceLogic {

	private KnxDeviceConfig deviceConfig;

	private Map<String, List<KnxGroupObjectConfig>> map = new HashMap<String, List<KnxGroupObjectConfig>>();

	public KnxDeviceLogic(KnxDeviceConfig deviceConfig) {
		this.deviceConfig = deviceConfig;

		// Track all group addresses and map them to the group object configs
		for (KnxGroupObjectConfig groupObjectConfig : deviceConfig.getGroupObjects()) {
			for (String groupAddress : groupObjectConfig.getGroupAddresses()) {
				List<KnxGroupObjectConfig> groupObjects = map.get(groupAddress);
				if (groupObjects == null) {
					groupObjects = new ArrayList<KnxGroupObjectConfig>();
					map.put(groupAddress, groupObjects);
				}
				groupObjects.add(groupObjectConfig);
			}
		}
	}

	@Override
	public void updateDatapointValue(Datapoint ofDp, DPTXlator update) {
		List<KnxGroupObjectConfig> groupObjects = map.get(ofDp.getMainAddress().toString());
		if (groupObjects == null || groupObjects.isEmpty()) {
			log.error("updateDatapointValue triggered for group address" + ofDp.getMainAddress()
					+ " but we don't have a matching group object.");
			return;
		}

		for (KnxGroupObjectConfig groupObject : groupObjects) {
			if (groupObject.getUpdateDatapointMethod() == null) {
				continue;
			}

			try {
				if (groupObject.getType().equals(Boolean.class)) {
					groupObject.getUpdateDatapointMethod().invoke(deviceConfig.getDeviceInstance(),
							((DPTXlatorBoolean) update).getValueBoolean());
				} else if (groupObject.getType().equals(Short.class)) {
					groupObject.getUpdateDatapointMethod().invoke(deviceConfig.getDeviceInstance(),
							(short) ((DPTXlator4ByteSigned) update).getValueSigned());
				} else if (groupObject.getType().equals(Integer.class)) {
					groupObject.getUpdateDatapointMethod().invoke(deviceConfig.getDeviceInstance(),
							((DPTXlator64BitSigned) update).getValueSigned());
				} else if (groupObject.getType().equals(Float.class)) {
					groupObject.getUpdateDatapointMethod().invoke(deviceConfig.getDeviceInstance(),
							((DPTXlator4ByteFloat) update).getValueFloat());
				} else if (groupObject.getType().equals(String.class)) {
					groupObject.getUpdateDatapointMethod().invoke(deviceConfig.getDeviceInstance(),
							((DPTXlatorString) update).getValue());
				} else {
					log.error("Unsupported type: " + groupObject.getType());
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				log.error("Unable to invoke " + groupObject.getUpdateDatapointMethod() + " of "
						+ deviceConfig.getDeviceInstance().getClass(), e);
			}
		}
	}

	@Override
	public DPTXlator requestDatapointValue(Datapoint ofDp) throws KNXException {
		List<KnxGroupObjectConfig> groupObjects = map.get(ofDp.getMainAddress().toString());
		if (groupObjects == null || groupObjects.isEmpty()) {
			log.error("requestDatapointValue triggered for group address" + ofDp.getMainAddress()
					+ " but we don't have a matching group object.");
			return null;
		}

		if (groupObjects.size() != 1) {
			log.warn("Received requestDatapointValue for group address " + ofDp.getMainAddress()
					+ " but multiple datapoints are assigned to it. Using the first one: " + groupObjects.get(0).getName());
		}

		for (KnxGroupObjectConfig groupObject : groupObjects) {
			if (groupObject.getRequestDatapointMethod() == null) {
				continue;
			}

			try {
				Object returnValue = groupObject.getRequestDatapointMethod().invoke(deviceConfig.getDeviceInstance());
				if (groupObject.getType().equals(Boolean.class)) {
					DPTXlatorBoolean xlator = new DPTXlatorBoolean(ofDp.getDPT());
					xlator.setValue((boolean) returnValue);
					return xlator;
				} else if (groupObject.getType().equals(Short.class)) {
					DPTXlator4ByteSigned xlator = new DPTXlator4ByteSigned(ofDp.getDPT());
					xlator.setValue((short) returnValue);
					return xlator;
				} else if (groupObject.getType().equals(Integer.class)) {
					DPTXlator4ByteSigned xlator = new DPTXlator4ByteSigned(ofDp.getDPT());
					xlator.setValue((int) returnValue);
					return xlator;
				} else if (groupObject.getType().equals(Float.class)) {
					DPTXlator4ByteFloat xlator = new DPTXlator4ByteFloat(ofDp.getDPT());
					xlator.setValue((float) returnValue);
					return xlator;
				} else if (groupObject.getType().equals(String.class)) {
					DPTXlatorString xlator = new DPTXlatorString(ofDp.getDPT());
					xlator.setValue((String) returnValue);
					return xlator;
				} else {
					log.error("Unsupported type: " + groupObject.getType());
				}
			} catch (ClassCastException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				log.error("Unable to invoke " + groupObject.getRequestDatapointMethod() + " of "
						+ deviceConfig.getDeviceInstance().getClass(), e);
			}
		}
		return null;
	}
}
