package lu.berscheid.knx.model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private Map<String, KnxGroupObjectConfig> groupObjectMap = new HashMap<String, KnxGroupObjectConfig>();

	private Method postStartMethod;
	Object deviceInstance;

	public void addParameter(KnxParameterConfig parameter) {
		this.parameters.add(parameter);
	}

	public void addGroupObject(KnxGroupObjectConfig groupObject) {
		this.groupObjectMap.put(groupObject.getName(), groupObject);
	}

	public Collection<KnxGroupObjectConfig> getGroupObjects() {
		return this.groupObjectMap.values();
	}

	public KnxGroupObjectConfig getGroupObject(String name) {
		return this.groupObjectMap.get(name);
	}
}
