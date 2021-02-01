package lu.berscheid.knx.model;

import lombok.Data;

@Data
public class KnxParameterTypeConfig {

	private int sizeInBit;
	private double minInclusive;
	private double maxInclusive;
	protected Class<?> type;

	public String getName() {
		return type.getSimpleName() + "_" + sizeInBit + "_" + minInclusive + "_" + maxInclusive;
	}
}
