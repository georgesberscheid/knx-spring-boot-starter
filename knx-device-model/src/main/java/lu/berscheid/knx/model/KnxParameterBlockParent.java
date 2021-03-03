package lu.berscheid.knx.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/*
 * Marks all classes that can contain a list of parameter blocks. Implementing classes are
 * KnxDeviceConfig (because a device has a list of first-level parameter blocks) and
 * KnxParameterBlockConfig (because parameter blocks can contain nested blocks).
 */
@Data
public abstract class KnxParameterBlockParent {

	private List<KnxParameterBlockConfig> parameterBlocks = new ArrayList<KnxParameterBlockConfig>();

	public void addParameterBlock(KnxParameterBlockConfig parameterBlock) {
		this.parameterBlocks.add(parameterBlock);
	}
}
