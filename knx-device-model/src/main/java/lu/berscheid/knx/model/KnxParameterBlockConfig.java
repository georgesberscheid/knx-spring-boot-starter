package lu.berscheid.knx.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class KnxParameterBlockConfig extends KnxParameterBlockParent {

	private String blockName;
	private String blockText;

	private List<KnxParameterConfig> parameters = new ArrayList<KnxParameterConfig>();
	private List<KnxGroupObjectConfig> groupObjects = new ArrayList<KnxGroupObjectConfig>();

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