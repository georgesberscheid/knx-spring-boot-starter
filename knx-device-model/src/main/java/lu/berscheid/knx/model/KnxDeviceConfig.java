package lu.berscheid.knx.model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class KnxDeviceConfig {

	private String individualAddress;
	private String manufacturerRefId = "M-00FA"; // KNX Association
	private String applicationName;
	private int applicationNumber = 0;
	private int applicationVersion = 0;
	private String hardwareName;
	private String hardwareSerialNumber = "A12345";
	private int hardwareVersionNumber = 1;
	private String productName;
	private String productOrderNumber = "O12345";

	private List<KnxParameterConfig> parameters = new ArrayList<KnxParameterConfig>();
	private List<KnxGroupObjectConfig> groupObjects = new ArrayList<KnxGroupObjectConfig>();

	private Method postStartMethod;
	private Method postRestartMethod;
	private Method preShutdownMethod;
	Object deviceInstance;

	public void addParameter(KnxParameterConfig parameter) {
		this.parameters.add(parameter);
	}

	public void addGroupObject(KnxGroupObjectConfig groupObject) {
		this.groupObjects.add(groupObject);
	}

	public KnxGroupObjectConfig getGroupObject(String name) {
		for (KnxGroupObjectConfig config : this.groupObjects) {
			if (config.getName().equals(name)) return config;
		}
		return null;
	}
}
