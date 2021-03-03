package lu.berscheid.knx.model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class KnxDeviceConfig extends KnxParameterBlockParent {

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

	private Method postStartMethod;
	private Method postRestartMethod;
	private Method preShutdownMethod;
	Object deviceInstance;

	public List<KnxGroupObjectConfig> getGroupObjects() {
		List<KnxGroupObjectConfig> groupObjects = new ArrayList<KnxGroupObjectConfig>();
		getParameterBlocks().stream().forEach(pb -> groupObjects.addAll(pb.getGroupObjects()));
		return Collections.unmodifiableList(groupObjects);
	}

	public List<KnxParameterConfig> getParameters() {
		List<KnxParameterConfig> parameters = new ArrayList<KnxParameterConfig>();
		getParameterBlocks().stream().forEach(pb -> parameters.addAll(pb.getParameters()));
		return Collections.unmodifiableList(parameters);
	}
}
