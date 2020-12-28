package lu.berscheid.knx.model;

import lombok.Data;

@Data
public class KnxParameterConfig {
	private String name;
	private String text;
	private String value;
	private KnxParameterTypeConfig typeConfig;
}
