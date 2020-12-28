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
@XmlType(name = "Hardware_t", propOrder = { "products", "hardware2Programs" })
@Data
public class HardwareT {

	@XmlElement(name = "Products")
	protected HardwareT.Products products = new HardwareT.Products();

	@XmlElement(name = "Hardware2Programs")
	protected HardwareT.Hardware2Programs hardware2Programs = new HardwareT.Hardware2Programs();

	@XmlAttribute(name = "Id", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;

	@XmlAttribute(name = "Name", required = true)
	protected String name;

	@XmlAttribute(name = "SerialNumber", required = true)
	protected String serialNumber;

	@XmlAttribute(name = "VersionNumber", required = true)
	protected int versionNumber;

	@XmlAttribute(name = "BusCurrent")
	protected Float busCurrent;

	@XmlAttribute(name = "Tp256")
	protected Boolean tp256;

	@XmlAttribute(name = "IsAccessory")
	protected Boolean isAccessory;

	@XmlAttribute(name = "HasIndividualAddress", required = true)
	protected boolean hasIndividualAddress;

	@XmlAttribute(name = "HasApplicationProgram", required = true)
	protected boolean hasApplicationProgram;

	@XmlAttribute(name = "HasApplicationProgram2")
	protected Boolean hasApplicationProgram2;

	@XmlAttribute(name = "IsPowerSupply")
	protected Boolean isPowerSupplyE;

	@XmlAttribute(name = "IsChoke")
	protected Boolean isChoke;

	@XmlAttribute(name = "IsCoupler")
	protected Boolean isCoupler;

	@XmlAttribute(name = "IsPowerLineRepeater")
	protected Boolean isPowerLineRepeater;

	@XmlAttribute(name = "IsPowerLineSignalFilter")
	protected Boolean isPowerLineSignalFilter;

	@XmlAttribute(name = "IsCable")
	protected Boolean isCable;

	@XmlAttribute(name = "IsIPEnabled")
	protected Boolean isIPEnabled;

	@XmlAttribute(name = "IsRFRetransmitter")
	protected Boolean isRFRetransmitter;

	@XmlAttribute(name = "OriginalManufacturer")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String originalManufacturer;

	@XmlAttribute(name = "RFRxCapabilities")
	protected RFRxCapabilitiesT rfRxCapabilities;

	@XmlAttribute(name = "RFTxCapabilities")
	protected RFTxCapabilitiesT rfTxCapabilities;

	@XmlAttribute(name = "NoDownloadWithoutPlugin")
	protected Boolean noDownloadWithoutPlugin;

	@XmlAttribute(name = "NonRegRelevantDataVersion")
	@XmlSchemaType(name = "unsignedShort")
	protected Integer nonRegRelevantDataVersion;

	@XmlAttribute(name = "InternalDescription")
	protected String internalDescription;

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "hardware2Program" })
	@Data
	public static class Hardware2Programs {

		@XmlElement(name = "Hardware2Program", required = true)
		protected List<Hardware2ProgramT> hardware2Program = new ArrayList<Hardware2ProgramT>();
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "product" })
	@Data
	public static class Products {

		@XmlElement(name = "Product", required = true)
		protected List<HardwareT.Products.Product> product = new ArrayList<HardwareT.Products.Product>();

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "baggages", "attributes", "registrationInfo" })
		@Data
		public static class Product {

			@XmlElement(name = "Baggages")
			protected HardwareT.Products.Product.Baggages baggages;

			@XmlElement(name = "Attributes")
			protected HardwareT.Products.Product.Attributes attributes;

			@XmlElement(name = "RegistrationInfo")
			protected RegistrationInfoT registrationInfo;

			@XmlAttribute(name = "Id", required = true)
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			@XmlID
			@XmlSchemaType(name = "ID")
			protected String id;

			@XmlAttribute(name = "Text", required = true)
			protected String text;

			@XmlAttribute(name = "OrderNumber", required = true)
			protected String orderNumber;

			@XmlAttribute(name = "IsRailMounted", required = true)
			protected boolean isRailMounted;

			@XmlAttribute(name = "WidthInMillimeter")
			protected Float widthInMillimeter;

			@XmlAttribute(name = "VisibleDescription")
			protected String visibleDescription;

			@XmlAttribute(name = "DefaultLanguage")
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			@XmlSchemaType(name = "language")
			protected String defaultLanguage;

			@XmlAttribute(name = "NonRegRelevantDataVersion")
			@XmlSchemaType(name = "unsignedShort")
			protected Integer nonRegRelevantDataVersion;
			@XmlAttribute(name = "Hash")
			protected byte[] hash;

			@XmlAttribute(name = "InternalDescription")
			protected String internalDescription;

			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = { "attribute" })
			@Data
			public static class Attributes {

				@XmlElement(name = "Attribute", required = true)
				protected List<HardwareT.Products.Product.Attributes.Attribute> attribute;

				@XmlAccessorType(XmlAccessType.FIELD)
				@XmlType(name = "")
				@Data
				public static class Attribute {

					@XmlAttribute(name = "Id")
					@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
					@XmlID
					@XmlSchemaType(name = "ID")
					protected String id;

					@XmlAttribute(name = "Name", required = true)
					protected String name;

					@XmlAttribute(name = "Value", required = true)
					protected String value;

				}
			}

			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = { "baggage" })
			@Data
			public static class Baggages {

				@XmlElement(name = "Baggage", required = true)
				protected List<HardwareT.Products.Product.Baggages.Baggage> baggage;

				@XmlAccessorType(XmlAccessType.FIELD)
				@XmlType(name = "")
				@Data
				public static class Baggage {

					@XmlAttribute(name = "RefId", required = true)
					@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
					protected String refId;
				}
			}
		}
	}
}
