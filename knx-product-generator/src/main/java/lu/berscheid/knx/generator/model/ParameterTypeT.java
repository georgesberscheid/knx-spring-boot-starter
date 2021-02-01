package lu.berscheid.knx.generator.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParameterType_t",
		propOrder = { "typeNumber", "typeFloat", "typeRestriction", "typeText", "typeTime",
				"typeDate", "typeIPAddress", "typePicture", "typeColor", "typeRawData", "typeNone" })
@Data
public class ParameterTypeT {

	@XmlElement(name = "TypeNumber")
	protected ParameterTypeT.TypeNumber typeNumber;
	@XmlElement(name = "TypeFloat")
	protected ParameterTypeT.TypeFloat typeFloat;
	@XmlElement(name = "TypeRestriction")
	protected ParameterTypeT.TypeRestriction typeRestriction;
	@XmlElement(name = "TypeText")
	protected ParameterTypeT.TypeText typeText;
	@XmlElement(name = "TypeTime")
	protected ParameterTypeT.TypeTime typeTime;
	@XmlElement(name = "TypeDate")
	protected ParameterTypeT.TypeDate typeDate;
	@XmlElement(name = "TypeIPAddress")
	protected ParameterTypeT.TypeIPAddress typeIPAddress;
	@XmlElement(name = "TypePicture")
	protected ParameterTypeT.TypePicture typePicture;
	@XmlElement(name = "TypeColor")
	protected ParameterTypeT.TypeColor typeColor;
	@XmlElement(name = "TypeRawData")
	protected ParameterTypeT.TypeRawData typeRawData;
	@XmlElement(name = "TypeNone")
	protected Object typeNone;
	@XmlAttribute(name = "Id", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;
	@XmlAttribute(name = "Name", required = true)
	protected String name;
	@XmlAttribute(name = "InternalDescription")
	protected String internalDescription;
	@XmlAttribute(name = "Plugin")
	protected String plugin;
	@XmlAttribute(name = "ValidationErrorRef")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String validationErrorRef;

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	@Data
	public static class TypeColor {

		@XmlAttribute(name = "Space", required = true)
		protected String space;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	@Data
	public static class TypeDate {

		@XmlAttribute(name = "Encoding", required = true)
		protected String encoding;
		@XmlAttribute(name = "DisplayTheYear")
		protected Boolean displayTheYear;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	@Data
	public static class TypeFloat {

		@XmlAttribute(name = "Encoding", required = true)
		protected String encoding;
		@XmlAttribute(name = "minInclusive", required = true)
		protected double minInclusive;
		@XmlAttribute(name = "maxInclusive", required = true)
		protected double maxInclusive;
		@XmlAttribute(name = "Increment")
		protected Double increment;
		@XmlAttribute(name = "UIHint")
		protected String uiHint;
		@XmlAttribute(name = "DisplayFormat")
		protected String displayFormat;
		@XmlAttribute(name = "DisplayOffset")
		protected Double displayOffset;
		@XmlAttribute(name = "DisplayFactor")
		protected Double displayFactor;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	@Data
	public static class TypeIPAddress {

		@XmlAttribute(name = "AddressType", required = true)
		protected String addressType;
		@XmlAttribute(name = "Version")
		protected String version;

	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	@Data
	public static class TypeNumber {

		@XmlAttribute(name = "SizeInBit", required = true)
		protected long sizeInBit;
		@XmlAttribute(name = "Type", required = true)
		protected String type;
		@XmlAttribute(name = "minInclusive", required = true)
		protected long minInclusive;
		@XmlAttribute(name = "maxInclusive", required = true)
		protected long maxInclusive;
		@XmlAttribute(name = "Increment")
		protected Long increment;
		@XmlAttribute(name = "UIHint")
		protected String uiHint;
		@XmlAttribute(name = "DisplayOffset")
		protected Double displayOffset;
		@XmlAttribute(name = "DisplayFactor")
		protected Double displayFactor;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	@Data
	public static class TypePicture {

		@XmlAttribute(name = "RefId", required = true)
		@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
		protected String refId;
		@XmlAttribute(name = "HorizontalAlignment")
		protected HorizontalAlignmentT horizontalAlignment;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	@Data
	public static class TypeRawData {

		@XmlAttribute(name = "MaxSize", required = true)
		protected long maxSize;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "enumeration" })
	@Data
	public static class TypeRestriction {

		@XmlElement(name = "Enumeration")
		protected List<ParameterTypeT.TypeRestriction.Enumeration> enumeration = new ArrayList<ParameterTypeT.TypeRestriction.Enumeration>();
		@XmlAttribute(name = "Base", required = true)
		protected String base;
		@XmlAttribute(name = "SizeInBit", required = true)
		protected long sizeInBit;
		@XmlAttribute(name = "UIHint")
		protected String uiHint;

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "")
		@Data
		public static class Enumeration {

			@XmlAttribute(name = "Text")
			protected String text;
			@XmlAttribute(name = "Icon")
			protected String icon;
			@XmlAttribute(name = "PictureAlignment")
			protected HorizontalAlignmentT pictureAlignment;
			@XmlAttribute(name = "Value", required = true)
			@XmlSchemaType(name = "unsignedInt")
			protected long value;
			@XmlAttribute(name = "Id", required = true)
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			@XmlID
			@XmlSchemaType(name = "ID")
			protected String id;
			@XmlAttribute(name = "DisplayOrder")
			protected Integer displayOrder;
			@XmlAttribute(name = "BinaryValue")
			protected byte[] binaryValue;

		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	@Data
	public static class TypeText {

		@XmlAttribute(name = "SizeInBit", required = true)
		protected long sizeInBit;
		@XmlAttribute(name = "Pattern")
		protected String pattern;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	public static class TypeTime {

		@XmlAttribute(name = "SizeInBit", required = true)
		protected long sizeInBit;
		@XmlAttribute(name = "Unit", required = true)
		protected String unit;
		@XmlAttribute(name = "minInclusive", required = true)
		protected long minInclusive;
		@XmlAttribute(name = "maxInclusive", required = true)
		protected long maxInclusive;
		@XmlAttribute(name = "UIHint")
		protected String uiHint;
	}
}
