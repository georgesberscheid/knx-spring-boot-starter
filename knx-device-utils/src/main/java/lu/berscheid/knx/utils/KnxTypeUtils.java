package lu.berscheid.knx.utils;

import lombok.extern.slf4j.Slf4j;
import tuwien.auto.calimero.dptxlator.DPTXlator2ByteFloat;
import tuwien.auto.calimero.dptxlator.DPTXlator2ByteUnsigned;
import tuwien.auto.calimero.dptxlator.DPTXlator4ByteFloat;
import tuwien.auto.calimero.dptxlator.DPTXlator4ByteSigned;
import tuwien.auto.calimero.dptxlator.DPTXlator64BitSigned;
import tuwien.auto.calimero.dptxlator.DPTXlatorBoolean;
import tuwien.auto.calimero.dptxlator.DPTXlatorString;

@Slf4j
public class KnxTypeUtils {

	/*
	 * Returns the default datapoint type for the given Java type. They are chosen somewhat
	 * arbitrarily, so it would be best practice to define the actual datapoint type on the group
	 * object.
	 */
	public static String getDefaultDatapointType(Class<?> type) {
		if (isBoolean(type)) {
			return DPTXlatorBoolean.DPT_SWITCH.getID();
		} else if (isDouble(type)) {
			// There is not 8-byte float, so we'll do it this way
			return DPTXlator4ByteFloat.DPT_ABSOLUTE_TEMPERATURE.getID();
		} else if (isFloat(type)) {
			return DPTXlator2ByteFloat.DPT_TEMPERATURE.getID();
		} else if (isInteger(type)) {
			return DPTXlator4ByteSigned.DPT_COUNT.getID();
		} else if (isLong(type)) {
			return DPTXlator64BitSigned.DPT_ACTIVE_ENERGY.getID();
		} else if (isShort(type)) {
			return DPTXlator2ByteUnsigned.DPT_LENGTH.getID();
		} else if (isString(type)) {
			// Default for String is Latin1 encoding
			return DPTXlatorString.DPT_STRING_8859_1.getID();
		} else {
			return null;
		}
	}

	/*
	 * Datapoint types are typically represented in using mainType.subType where the subType is
	 * left-padded with zeros to 3 positions, e.g. 1.001 for 1bit Switch or 19.001 for 8bytes
	 * date-time. For some obscure reason the .knxprod file requires this to be represented as
	 * DPST-mainType-subType with no padding.
	 */
	public static String convertDatapointTypeToKnxProd(String datapointType) {
		String returnValue = datapointType;
		try {
			String[] typeSplit = datapointType.split("\\.");
			returnValue = "DPST-" + Integer.parseInt(typeSplit[0]) + "-"
					+ Integer.parseInt(typeSplit[1]);
		} catch (NumberFormatException e) {
			log.error("Unable to convert datapoint type " + datapointType + " to .knxprod format.");
		}
		return returnValue;
	}

	/*
	 * Checks whether the provider datapoint type matches the given Java type.
	 */
	public static boolean isValidDatapointTypeForJavaType(String datapointType, Class<?> type) {
		// TODO: implement properly
		return true;
	}

	public static boolean isInteger(Class<?> type) {
		if (type == null) return false;
		return type.equals(int.class) || type.equals(Integer.class);
	}

	public static boolean isBoolean(Class<?> type) {
		if (type == null) return false;
		return type.equals(boolean.class) || type.equals(Boolean.class);
	}

	public static boolean isShort(Class<?> type) {
		if (type == null) return false;
		return type.equals(short.class) || type.equals(Short.class);
	}

	public static boolean isLong(Class<?> type) {
		if (type == null) return false;
		return type.equals(long.class) || type.equals(Long.class);
	}

	public static boolean isDouble(Class<?> type) {
		if (type == null) return false;
		return type.equals(double.class) || type.equals(Double.class);
	}

	public static boolean isFloat(Class<?> type) {
		if (type == null) return false;
		return type.equals(float.class) || type.equals(Float.class);
	}

	public static boolean isString(Class<?> type) {
		if (type == null) return false;
		return type.equals(String.class) || type.equals(CharSequence.class)
				|| type.equals(char[].class);
	}
}
