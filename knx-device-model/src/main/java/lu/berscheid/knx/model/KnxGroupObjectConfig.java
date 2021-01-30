package lu.berscheid.knx.model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import lombok.Data;

@Data
public class KnxGroupObjectConfig {

	/*
	 * Order in the list of group objects in the device configuration file
	 */
	private int number;

	/*
	 * The name of the group object, derived from the property name. Does not show in the ETS
	 * interface.
	 */
	private String name;

	/*
	 * The description of the group object. Shows in the 'Name' column in ETS.
	 */
	private String text;

	/*
	 * The function text appears in the 'Object Function' column in ETS.
	 */
	private String functionText;

	/*
	 * The size in bits of the telegrams send to or from group addresses for this group object.
	 */
	private int sizeInBits;

	/*
	 * The datapoint type of the group object. See tuwien.auto.calimero.dptxlator classes for
	 * possible values.
	 */
	private String dataPointType;

	/*
	 * A reference to the field in the device representing the group object.
	 */
	private Field field;

	/*
	 * A reference to the updateDatapoint method to be called when a telegram is received on a group
	 * address associated with this group object.
	 */
	private Method updateDatapointMethod;

	/*
	 * A reference to the requestDatapoint method to be called when a device on the KNX bus requests
	 * the current value of this group object.
	 */
	private Method requestDatapointMethod;

	/*
	 * Group addresses associated with this group object. Either defined in the @KnxGroupObject
	 * annotation or assigned through programming by ETS.
	 */
	private List<String> groupAddresses;

	/*
	 * The GroupObjectImpl value that was injected during device start up.
	 */
	private GroupObject<Object> groupObjectImpl;

	protected Class<?> type;

	private boolean communicationFlag;
	private boolean readFlag;
	private boolean writeFlag;
	private boolean transmitFlag;
	private boolean updateFlag;
	private Priority priority = Priority.LOW;

	public enum Priority {
		LOW, HIGH, ALERT
	};

	// TODO: This should be computed using the dataPointType
	public String getObjectSize() {
		if (type == String.class) {
			return "14 Bytes";
		} else if (type == Integer.class || type == int.class) {
			return "4 Bytes";
		} else if (type == Boolean.class || type == boolean.class) {
			return "1 Bit";
		} else if (type == Byte.class || type == byte.class) {
			return "1 Byte";
		} else {
			return "1 Byte";
		}
	}
}
