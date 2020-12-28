package lu.berscheid.knx.model;

import lombok.Data;

@Data
public class KnxParameterTypeConfig {
	private int sizeInBit;
	private Class<?> type;
	private long minInclusive;
	private long maxInclusive;

	public String getName() {
		return type.getSimpleName() + "_" + sizeInBit + "_" + minInclusive + "_" + maxInclusive;
	}
}
