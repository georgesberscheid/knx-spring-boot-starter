package lu.berscheid.knx.model;

import java.lang.reflect.Field;

import lombok.Data;

@Data
public class KnxParameterConfig {

	private String name;
	private String text;
	private Object value;
	private KnxParameterTypeConfig typeConfig;
	private Field field;
	protected Class<?> type;

	public void setTypeConfig(KnxParameterTypeConfig typeConfig) {
		this.typeConfig = typeConfig;
		this.type = typeConfig.getType();
	}
}