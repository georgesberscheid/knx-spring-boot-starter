package lu.berscheid.knx.model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;

import lombok.Data;

@Data
public class KnxGroupObjectConfig {

	private int number;
	private String name;
	private String text;
	private String functionText;
	private int sizeInBits;
	private String dataPointType;

	private Class<?> type;
	private Field field;

	private Method updateDatapointMethod;
	private Method requestDatapointMethod;

	private Collection<String> groupAddresses;

	private boolean communicationFlag;
	private boolean readFlag;
	private boolean writeFlag;
	private boolean transmitFlag;
	private boolean updateFlag;
	private Priority priority;

	public enum Priority {
		LOW, HIGH, ALERT
	};

	// TODO: This should be computed using the dataPointType
	public String getObjectSize() {
		if (type == String.class) {
			return "48 Bytes";
		} else if (type == Integer.class) {
			return "4 Bytes";
		} else if (type == Boolean.class) {
			return "1 Bit";
		} else if (type == Byte.class) {
			return "1 Byte";
		} else {
			return "1 Byte";
		}
	}
}
