package lu.berscheid.knx.generator.model;

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
@XmlType(name = "MasterData_t",
		propOrder = { "datapointTypes", "datapointRoles", "interfaceObjectTypes", "interfaceObjectProperties",
				"propertyDataTypes", "mediumTypes", "maskVersions", "functionalBlocks", "productLanguages", "functionTypes",
				"spaceUsages", "manufacturers", "languages" })
@Data
public class MasterDataT {

	@XmlElement(name = "DatapointTypes")
	protected MasterDataT.DatapointTypes datapointTypes;
	@XmlElement(name = "DatapointRoles")
	protected MasterDataT.DatapointRoles datapointRoles;
	@XmlElement(name = "InterfaceObjectTypes")
	protected MasterDataT.InterfaceObjectTypes interfaceObjectTypes;
	@XmlElement(name = "InterfaceObjectProperties")
	protected MasterDataT.InterfaceObjectProperties interfaceObjectProperties;
	@XmlElement(name = "PropertyDataTypes")
	protected MasterDataT.PropertyDataTypes propertyDataTypes;
	@XmlElement(name = "MediumTypes")
	protected MasterDataT.MediumTypes mediumTypes;
	@XmlElement(name = "MaskVersions")
	protected MasterDataT.MaskVersions maskVersions;
	@XmlElement(name = "FunctionalBlocks")
	protected MasterDataT.FunctionalBlocks functionalBlocks;
	@XmlElement(name = "ProductLanguages")
	protected MasterDataT.ProductLanguages productLanguages;
	@XmlElement(name = "FunctionTypes")
	protected MasterDataT.FunctionTypes functionTypes;
	@XmlElement(name = "SpaceUsages")
	protected MasterDataT.SpaceUsages spaceUsages;
	@XmlElement(name = "Manufacturers")
	protected MasterDataT.Manufacturers manufacturers;
	@XmlElement(name = "Languages")
	protected MasterDataT.Languages languages;
	@XmlAttribute(name = "Version", required = true)
	@XmlSchemaType(name = "unsignedInt")
	protected long version;
	@XmlAttribute(name = "Signature", required = true)
	protected byte[] signature;
	@XmlAttribute(name = "Id", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "datapointRole" })
	@Data
	public static class DatapointRoles {

		@XmlElement(name = "DatapointRole", required = true)
		protected List<DatapointRoleT> datapointRole;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "datapointType" })
	@Data
	public static class DatapointTypes {

		@XmlElement(name = "DatapointType", required = true)
		protected List<DatapointTypeT> datapointType;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "functionalBlock" })
	@Data
	public static class FunctionalBlocks {

		@XmlElement(name = "FunctionalBlock", required = true)
		protected List<MasterDataT.FunctionalBlocks.FunctionalBlock> functionalBlock;

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "parameters" })
		@Data
		public static class FunctionalBlock {

			@XmlElement(name = "Parameters")
			protected List<MasterDataT.FunctionalBlocks.FunctionalBlock.Parameters> parameters;
			@XmlAttribute(name = "Name", required = true)
			protected String name;
			@XmlAttribute(name = "Id", required = true)
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			@XmlID
			@XmlSchemaType(name = "ID")
			protected String id;

			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = { "parameter" })
			@Data
			public static class Parameters {

				@XmlElement(name = "Parameter", required = true)
				protected List<MasterDataT.FunctionalBlocks.FunctionalBlock.Parameters.Parameter> parameter;
				@XmlAttribute(name = "ObjectType", required = true)
				@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
				protected String objectType;

				@XmlAccessorType(XmlAccessType.FIELD)
				@XmlType(name = "")
				@Data
				public static class Parameter {

					@XmlAttribute(name = "Property", required = true)
					@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
					protected String property;
					@XmlAttribute(name = "Description")
					protected String description;
				}
			}
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "functionsGroup", "functionType" })
	@Data
	public static class FunctionTypes {

		@XmlElement(name = "FunctionsGroup")
		protected List<FunctionsGroupT> functionsGroup;
		@XmlElement(name = "FunctionType")
		protected List<FunctionTypeT> functionType;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "interfaceObjectProperty" })
	@Data
	public static class InterfaceObjectProperties {

		@XmlElement(name = "InterfaceObjectProperty", required = true)
		protected List<MasterDataT.InterfaceObjectProperties.InterfaceObjectProperty> interfaceObjectProperty;

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "")
		@Data
		public static class InterfaceObjectProperty {

			@XmlAttribute(name = "Id", required = true)
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			@XmlID
			@XmlSchemaType(name = "ID")
			protected String id;
			@XmlAttribute(name = "Number", required = true)
			@XmlSchemaType(name = "unsignedInt")
			protected long number;
			@XmlAttribute(name = "ObjectType")
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			protected String objectType;
			@XmlAttribute(name = "Name", required = true)
			protected String name;
			@XmlAttribute(name = "Text")
			protected String text;
			@XmlAttribute(name = "PDT")
			protected List<String> pdt;
			@XmlAttribute(name = "DPT")
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			protected String dpt;
			@XmlAttribute(name = "Array")
			protected Boolean array;
			@XmlAttribute(name = "AccessPolicy")
			protected String accessPolicy;
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "interfaceObjectType" })
	@Data
	public static class InterfaceObjectTypes {

		@XmlElement(name = "InterfaceObjectType", required = true)
		protected List<MasterDataT.InterfaceObjectTypes.InterfaceObjectType> interfaceObjectType;

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "")
		@Data
		public static class InterfaceObjectType {

			@XmlAttribute(name = "Id", required = true)
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			@XmlID
			@XmlSchemaType(name = "ID")
			protected String id;
			@XmlAttribute(name = "Number", required = true)
			@XmlSchemaType(name = "unsignedInt")
			protected long number;
			@XmlAttribute(name = "Name", required = true)
			protected String name;
			@XmlAttribute(name = "Text")
			protected String text;

		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "language" })
	@Data
	public static class Languages {

		@XmlElement(name = "Language", required = true)
		protected List<LanguageDataT> language;

	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "manufacturer" })
	@Data
	public static class Manufacturers {

		@XmlElement(name = "Manufacturer", required = true)
		protected List<MasterDataT.Manufacturers.Manufacturer> manufacturer;

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "",
				propOrder = { "orderNumberFormattingScript", "publicKeys", "datapointTypes", "datapointRoles",
						"functionTypes", "spaceUsages" })
		@Data
		public static class Manufacturer {

			@XmlElement(name = "OrderNumberFormattingScript")
			protected String orderNumberFormattingScript;
			@XmlElement(name = "PublicKeys")
			protected MasterDataT.Manufacturers.Manufacturer.PublicKeys publicKeys;
			@XmlElement(name = "DatapointTypes")
			protected MasterDataT.Manufacturers.Manufacturer.DatapointTypes datapointTypes;
			@XmlElement(name = "DatapointRoles")
			protected MasterDataT.Manufacturers.Manufacturer.DatapointRoles datapointRoles;
			@XmlElement(name = "FunctionTypes")
			protected MasterDataT.Manufacturers.Manufacturer.FunctionTypes functionTypes;
			@XmlElement(name = "SpaceUsages")
			protected MasterDataT.Manufacturers.Manufacturer.SpaceUsages spaceUsages;
			@XmlAttribute(name = "Id", required = true)
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			@XmlID
			@XmlSchemaType(name = "ID")
			protected String id;
			@XmlAttribute(name = "Name", required = true)
			protected String name;
			@XmlAttribute(name = "KnxManufacturerId", required = true)
			@XmlSchemaType(name = "unsignedShort")
			protected int knxManufacturerId;
			@XmlAttribute(name = "DefaultLanguage")
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			@XmlSchemaType(name = "language")
			protected String defaultLanguage;
			@XmlAttribute(name = "CompatibilityGroup")
			@XmlSchemaType(name = "unsignedShort")
			protected Integer compatibilityGroup;
			@XmlAttribute(name = "ImportRestriction")
			protected String importRestriction;
			@XmlAttribute(name = "ImportGroup")
			protected List<String> importGroup;
			@XmlAttribute(name = "OrderNumberWildcardCharacter")
			protected String orderNumberWildcardCharacter;
			@XmlAttribute(name = "MemberStatus")
			protected MemberStatusT memberStatus;

			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = { "datapointRole" })
			@Data
			public static class DatapointRoles {

				@XmlElement(name = "DatapointRole", required = true)
				protected List<DatapointRoleT> datapointRole;

			}

			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = { "datapointType" })
			@Data
			public static class DatapointTypes {

				@XmlElement(name = "DatapointType", required = true)
				protected List<DatapointTypeT> datapointType;

			}

			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = { "functionsGroup", "functionType" })
			@Data
			public static class FunctionTypes {

				@XmlElement(name = "FunctionsGroup")
				protected List<FunctionsGroupT> functionsGroup;
				@XmlElement(name = "FunctionType")
				protected List<FunctionTypeT> functionType;
			}

			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = { "publicKey" })
			@Data
			public static class PublicKeys {

				@XmlElement(name = "PublicKey", required = true)
				protected List<MasterDataT.Manufacturers.Manufacturer.PublicKeys.PublicKey> publicKey;

				@XmlAccessorType(XmlAccessType.FIELD)
				@XmlType(name = "", propOrder = { "rsaKeyValue" })
				@Data
				public static class PublicKey {

					@XmlElement(name = "RSAKeyValue", required = true)
					protected MasterDataT.Manufacturers.Manufacturer.PublicKeys.PublicKey.RSAKeyValue rsaKeyValue;
					@XmlAttribute(name = "Id", required = true)
					@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
					@XmlID
					@XmlSchemaType(name = "ID")
					protected String id;
					@XmlAttribute(name = "Number", required = true)
					@XmlSchemaType(name = "unsignedInt")
					protected long number;
					@XmlAttribute(name = "Revoked")
					protected Boolean revoked;
					@XmlAttribute(name = "Purpose", required = true)
					protected List<String> purpose;

					@XmlAccessorType(XmlAccessType.FIELD)
					@XmlType(name = "", propOrder = { "modulus", "exponent" })
					@Data
					public static class RSAKeyValue {

						@XmlElement(name = "Modulus", required = true)
						protected byte[] modulus;
						@XmlElement(name = "Exponent", required = true)
						protected byte[] exponent;
					}
				}
			}

			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = { "spaceUsage" })
			@Data
			public static class SpaceUsages {

				@XmlElement(name = "SpaceUsage", required = true)
				protected List<SpaceUsageT> spaceUsage;
			}
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "maskVersion" })
	@Data
	public static class MaskVersions {

		@XmlElement(name = "MaskVersion", required = true)
		protected List<MaskVersionT> maskVersion;

	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "mediumType" })
	@Data
	public static class MediumTypes {

		@XmlElement(name = "MediumType", required = true)
		protected List<MasterDataT.MediumTypes.MediumType> mediumType;

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "")
		@Data
		public static class MediumType {

			@XmlAttribute(name = "Id", required = true)
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			@XmlID
			@XmlSchemaType(name = "ID")
			protected String id;
			@XmlAttribute(name = "Number", required = true)
			@XmlSchemaType(name = "unsignedInt")
			protected long number;
			@XmlAttribute(name = "Name", required = true)
			protected String name;
			@XmlAttribute(name = "Text")
			protected String text;
			@XmlAttribute(name = "DomainAddressLength", required = true)
			protected short domainAddressLength;

		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "language" })
	@Data
	public static class ProductLanguages {

		@XmlElement(name = "Language")
		protected List<MasterDataT.ProductLanguages.Language> language;

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "")
		@Data
		public static class Language {

			@XmlAttribute(name = "Identifier")
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			@XmlSchemaType(name = "language")
			protected String identifier;

		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "propertyDataType" })
	@Data
	public static class PropertyDataTypes {

		@XmlElement(name = "PropertyDataType", required = true)
		protected List<MasterDataT.PropertyDataTypes.PropertyDataType> propertyDataType;

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "")
		@Data
		public static class PropertyDataType {

			@XmlAttribute(name = "Id", required = true)
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			@XmlID
			@XmlSchemaType(name = "ID")
			protected String id;
			@XmlAttribute(name = "Number", required = true)
			@XmlSchemaType(name = "unsignedInt")
			protected long number;
			@XmlAttribute(name = "Name", required = true)
			protected String name;
			@XmlAttribute(name = "Size")
			@XmlSchemaType(name = "unsignedInt")
			protected Long size;
			@XmlAttribute(name = "ReadSize")
			@XmlSchemaType(name = "unsignedByte")
			protected Short readSize;

		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "spaceUsage" })
	@Data
	public static class SpaceUsages {

		@XmlElement(name = "SpaceUsage", required = true)
		protected List<SpaceUsageT> spaceUsage;

	}
}
