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
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApplicationProgramStatic_t",
		propOrder = { "code", "parameterTypes", "parameters", "parameterRefs", "parameterCalculations",
				"parameterValidations", "comObjectTable", "comObjectRefs", "addressTable", "associationTable", "fixupList",
				"loadProcedures", "extension", "binaryData", "deviceCompare", "messages", "script", "securityRoles",
				"busInterfaces", "allocators", "options" })
@Data
public class ApplicationProgramStaticT {

	@XmlElement(name = "Code")
	protected ApplicationProgramStaticT.Code code;

	@XmlElement(name = "ParameterTypes")
	protected ApplicationProgramStaticT.ParameterTypes parameterTypes;

	@XmlElement(name = "Parameters")
	protected ApplicationProgramStaticT.Parameters parameters;

	@XmlElement(name = "ParameterRefs")
	protected ApplicationProgramStaticT.ParameterRefs parameterRefs;

	@XmlElement(name = "ParameterCalculations")
	protected ApplicationProgramStaticT.ParameterCalculations parameterCalculations;

	@XmlElement(name = "ParameterValidations")
	protected ApplicationProgramStaticT.ParameterValidations parameterValidations;

	@XmlElement(name = "ComObjectTable")
	protected ApplicationProgramStaticT.ComObjectTable comObjectTable;

	@XmlElement(name = "ComObjectRefs")
	protected ApplicationProgramStaticT.ComObjectRefs comObjectRefs;

	@XmlElement(name = "AddressTable")
	protected ApplicationProgramStaticT.AddressTable addressTable;

	@XmlElement(name = "AssociationTable")
	protected ApplicationProgramStaticT.AssociationTable associationTable;

	@XmlElement(name = "FixupList")
	protected ApplicationProgramStaticT.FixupList fixupList;

	@XmlElement(name = "LoadProcedures")
	protected LoadProceduresT loadProcedures = new LoadProceduresT();

	@XmlElement(name = "Extension")
	protected ApplicationProgramStaticT.Extension extension;

	@XmlElement(name = "BinaryData")
	protected ApplicationProgramStaticT.BinaryData binaryData;

	@XmlElement(name = "DeviceCompare")
	protected ApplicationProgramStaticT.DeviceCompare deviceCompare;

	@XmlElement(name = "Messages")
	protected ApplicationProgramStaticT.Messages messages;

	@XmlElement(name = "Script")
	protected ApplicationProgramStaticT.Script script;

	@XmlElement(name = "SecurityRoles")
	protected ApplicationProgramStaticT.SecurityRoles securityRoles;

	@XmlElement(name = "BusInterfaces")
	protected ApplicationProgramStaticT.BusInterfaces busInterfaces;

	@XmlElement(name = "Allocators")
	protected ApplicationProgramStaticT.Allocators allocators;

	@XmlElement(name = "Options")
	protected ApplicationProgramStaticT.Options options;

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	@Data
	public static class AddressTable {

		@XmlAttribute(name = "CodeSegment")
		@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
		protected String codeSegment;

		@XmlAttribute(name = "Offset")
		protected Long offset;

		@XmlAttribute(name = "MaxEntries", required = true)
		@XmlSchemaType(name = "unsignedInt")
		protected long maxEntries;

	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "allocator" })
	@Data
	public static class Allocators {

		@XmlElement(name = "Allocator", required = true)
		protected List<AllocatorT> allocator;

	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	@Data
	public static class AssociationTable {

		@XmlAttribute(name = "CodeSegment")
		@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
		protected String codeSegment;

		@XmlAttribute(name = "Offset")
		protected Long offset;

		@XmlAttribute(name = "MaxEntries", required = true)
		@XmlSchemaType(name = "unsignedInt")
		protected long maxEntries;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "binaryData" })
	@Data
	public static class BinaryData {

		@XmlElement(name = "BinaryData", required = true)
		protected List<BinaryDataT> binaryData;

	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "busInterface" })
	@Data
	public static class BusInterfaces {

		@XmlElement(name = "BusInterface", required = true)
		protected List<ApplicationProgramStaticT.BusInterfaces.BusInterface> busInterface;

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "")
		@Data
		public static class BusInterface {

			@XmlAttribute(name = "Id", required = true)
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			@XmlID
			@XmlSchemaType(name = "ID")
			protected String id;

			@XmlAttribute(name = "AddressIndex", required = true)
			@XmlSchemaType(name = "unsignedByte")
			protected short addressIndex;

			@XmlAttribute(name = "AccessType", required = true)
			protected String accessType;

			@XmlAttribute(name = "Text")
			protected String text;
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "absoluteSegment", "relativeSegment" })
	@Data
	public static class Code {

		@XmlElement(name = "AbsoluteSegment")
		protected List<ApplicationProgramStaticT.Code.AbsoluteSegment> absoluteSegment = new ArrayList<ApplicationProgramStaticT.Code.AbsoluteSegment>();

		@XmlElement(name = "RelativeSegment")
		protected List<ApplicationProgramStaticT.Code.RelativeSegment> relativeSegment = new ArrayList<ApplicationProgramStaticT.Code.RelativeSegment>();

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "")
		@Data
		@EqualsAndHashCode(callSuper = true)
		public static class AbsoluteSegment extends SegmentBaseT {

			@XmlAttribute(name = "MemoryType")
			protected MemoryTypeT memoryType;

			@XmlAttribute(name = "Address", required = true)
			protected long address;

			@XmlAttribute(name = "UserMemory")
			protected Boolean userMemory;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "")
		@Data
		@EqualsAndHashCode(callSuper = true)
		public static class RelativeSegment extends SegmentBaseT {

			@XmlAttribute(name = "LoadStateMachine", required = true)
			@XmlSchemaType(name = "unsignedByte")
			protected short loadStateMachine;

			@XmlAttribute(name = "Offset", required = true)
			protected long offset;
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "comObjectRef" })
	@Data
	public static class ComObjectRefs {

		@XmlElement(name = "ComObjectRef", required = true)
		protected List<ComObjectRefT> comObjectRef = new ArrayList<ComObjectRefT>();
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "comObject" })
	@Data
	public static class ComObjectTable {

		@XmlElement(name = "ComObject")
		protected List<ComObjectT> comObject = new ArrayList<ComObjectT>();

		@XmlAttribute(name = "CodeSegment")
		@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
		protected String codeSegment;

		@XmlAttribute(name = "Offset")
		protected Long offset;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "excludeMemory", "excludeProperty" })
	@Data
	public static class DeviceCompare {

		@XmlElement(name = "ExcludeMemory")
		protected List<ApplicationProgramStaticT.DeviceCompare.ExcludeMemory> excludeMemory;

		@XmlElement(name = "ExcludeProperty")
		protected List<ApplicationProgramStaticT.DeviceCompare.ExcludeProperty> excludeProperty;

		@XmlAttribute(name = "StandardComTablesExpectable")
		protected ComTableExpectationT standardComTablesExpectable;

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "")
		@Data
		public static class ExcludeMemory {

			@XmlAttribute(name = "CodeSegment", required = true)
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			protected String codeSegment;

			@XmlAttribute(name = "Offset", required = true)
			protected long offset;

			@XmlAttribute(name = "Size", required = true)
			protected long size;

			@XmlAttribute(name = "InternalDescription")
			protected String internalDescription;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "")
		@Data
		public static class ExcludeProperty {

			@XmlAttribute(name = "ObjectIndex")
			@XmlSchemaType(name = "unsignedByte")
			protected Short objectIndex;

			@XmlAttribute(name = "ObjectType")
			@XmlSchemaType(name = "unsignedShort")
			protected Integer objectType;

			@XmlAttribute(name = "Occurrence")
			@XmlSchemaType(name = "unsignedShort")
			protected Integer occurrence;

			@XmlAttribute(name = "PropertyId", required = true)
			@XmlSchemaType(name = "unsignedShort")
			protected int propertyId;

			@XmlAttribute(name = "Offset", required = true)
			@XmlSchemaType(name = "unsignedInt")
			protected long offset;

			@XmlAttribute(name = "Size", required = true)
			protected long size;

			@XmlAttribute(name = "InternalDescription")
			protected String internalDescription;
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "baggage" })
	@Data
	public static class Extension {

		@XmlElement(name = "Baggage")
		protected List<ApplicationProgramStaticT.Extension.Baggage> baggage;

		@XmlAttribute(name = "EtsDownloadPlugin")
		protected String etsDownloadPlugin;

		@XmlAttribute(name = "EtsUiPlugin")
		protected String etsUiPlugin;

		@XmlAttribute(name = "EtsDataHandler")
		protected String etsDataHandler;

		@XmlAttribute(name = "EtsDataHandlerCapabilities")
		protected List<CapabilityT> etsDataHandlerCapabilities;

		@XmlAttribute(name = "RequiresExternalSoftware")
		protected Boolean requiresExternalSoftware;

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "")
		@Data
		public static class Baggage {

			@XmlAttribute(name = "RefId", required = true)
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			protected String refId;
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "fixup" })
	@Data
	public static class FixupList {

		@XmlElement(name = "Fixup", required = true)
		protected List<FixupT> fixup;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "message" })
	@Data
	public static class Messages {

		@XmlElement(name = "Message", required = true)
		protected List<ApplicationProgramStaticT.Messages.Message> message;

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "")
		@Data
		public static class Message {

			@XmlAttribute(name = "Id", required = true)
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			@XmlID
			@XmlSchemaType(name = "ID")
			protected String id;

			@XmlAttribute(name = "Name", required = true)
			protected String name;

			@XmlAttribute(name = "InternalDescription")
			protected String internalDescription;

			@XmlAttribute(name = "Text", required = true)
			protected String text;
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	@Data
	public static class Options {

		@XmlAttribute(name = "PreferPartialDownloadIfApplicationLoaded")
		protected Boolean preferPartialDownloadIfApplicationLoaded;

		@XmlAttribute(name = "EasyCtrlModeModeStyleEmptyGroupComTables")
		protected Boolean easyCtrlModeModeStyleEmptyGroupComTables;

		@XmlAttribute(name = "SetObjectTableLengthAlwaysToOne")
		protected Boolean setObjectTableLengthAlwaysToOne;

		@XmlAttribute(name = "TextParameterEncoding")
		protected TextEncodingT textParameterEncoding;

		@XmlAttribute(name = "TextParameterEncodingSelector")
		protected String textParameterEncodingSelector;

		@XmlAttribute(name = "TextParameterZeroTerminate")
		protected Boolean textParameterZeroTerminate;

		@XmlAttribute(name = "ParameterByteOrder")
		protected String parameterByteOrder;

		@XmlAttribute(name = "PartialDownloadOnlyVisibleParameters")
		protected Boolean partialDownloadOnlyVisibleParameters;

		@XmlAttribute(name = "LegacyNoPartialDownload")
		protected Boolean legacyNoPartialDownload;

		@XmlAttribute(name = "LegacyNoMemoryVerifyMode")
		protected Boolean legacyNoMemoryVerifyMode;

		@XmlAttribute(name = "LegacyNoOptimisticWrite")
		protected Boolean legacyNoOptimisticWrite;

		@XmlAttribute(name = "LegacyDoNotReportPropertyWriteErrors")
		protected Boolean legacyDoNotReportPropertyWriteErrors;

		@XmlAttribute(name = "LegacyNoBackgroundDownload")
		protected Boolean legacyNoBackgroundDownload;

		@XmlAttribute(name = "LegacyDoNotCheckManufacturerId")
		protected Boolean legacyDoNotCheckManufacturerId;

		@XmlAttribute(name = "LegacyAlwaysReloadAppIfCoVisibilityChanged")
		protected Boolean legacyAlwaysReloadAppIfCoVisibilityChanged;

		@XmlAttribute(name = "LegacyNeverReloadAppIfCoVisibilityChanged")
		protected Boolean legacyNeverReloadAppIfCoVisibilityChanged;

		@XmlAttribute(name = "LegacyDoNotSupportUndoDelete")
		protected Boolean legacyDoNotSupportUndoDelete;

		@XmlAttribute(name = "LegacyAllowPartialDownloadIfAp2Mismatch")
		protected Boolean legacyAllowPartialDownloadIfAp2Mismatch;

		@XmlAttribute(name = "LegacyKeepObjectTableGaps")
		protected Boolean legacyKeepObjectTableGaps;

		@XmlAttribute(name = "LegacyProxyCommunicationObjects")
		protected Boolean legacyProxyCommunicationObjects;

		@XmlAttribute(name = "DeviceInfoIgnoreRunState")
		protected Boolean deviceInfoIgnoreRunState;

		@XmlAttribute(name = "DeviceInfoIgnoreLoadedState")
		protected Boolean deviceInfoIgnoreLoadedState;

		@XmlAttribute(name = "DeviceCompareAllowCompatibleManufacturerId")
		protected Boolean deviceCompareAllowCompatibleManufacturerId;

		@XmlAttribute(name = "LineCoupler0912NewProgrammingStyle")
		protected Boolean lineCoupler0912NewProgrammingStyle;

		@XmlAttribute(name = "MaxRoutingApduLength")
		@XmlSchemaType(name = "unsignedInt")
		protected Long maxRoutingApduLength;

		@XmlAttribute(name = "Comparable")
		protected Boolean comparable;

		@XmlAttribute(name = "Reconstructable")
		protected Boolean reconstructable;

		@XmlAttribute(name = "DownloadInvisibleParameters")
		protected DownloadBehaviorT downloadInvisibleParameters;

		@XmlAttribute(name = "SupportsExtendedMemoryServices")
		protected Boolean supportsExtendedMemoryServices;

		@XmlAttribute(name = "SupportsExtendedPropertyServices")
		protected Boolean supportsExtendedPropertyServices;

		@XmlAttribute(name = "SupportsIpSystemBroadcast")
		protected Boolean supportsIpSystemBroadcast;

		@XmlAttribute(name = "NotLoadable")
		protected String notLoadable;

		@XmlAttribute(name = "NotLoadableMessageRef")
		@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
		protected String notLoadableMessageRef;

		@XmlAttribute(name = "CustomerAdjustableParameters")
		protected String customerAdjustableParameters;

		@XmlAttribute(name = "MasterResetOnCRCMismatch")
		protected Boolean masterResetOnCRCMismatch;

		@XmlAttribute(name = "PromptBeforeFullDownload")
		protected Boolean promptBeforeFullDownload;

		@XmlAttribute(name = "LegacyPatchManufacturerIdInTaskSegment")
		protected Boolean legacyPatchManufacturerIdInTaskSegment;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "parameterCalculation" })
	@Data
	public static class ParameterCalculations {

		@XmlElement(name = "ParameterCalculation", required = true)
		protected List<ParameterCalculationT> parameterCalculation;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "parameterRef" })
	@Data
	public static class ParameterRefs {

		@XmlElement(name = "ParameterRef", required = true)
		protected List<ParameterRefT> parameterRef = new ArrayList<ParameterRefT>();
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "parameter", "union" })
	@Data
	public static class Parameters {

		@XmlElement(name = "Parameter")
		protected List<ParameterT> parameter = new ArrayList<ParameterT>();

		@XmlElement(name = "Union")
		protected List<Union> union = new ArrayList<Union>();

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "memory", "property" })
		@Data
		@EqualsAndHashCode(callSuper = true)
		public static class ParameterT extends ParameterBaseT {

			@XmlElement(name = "Memory")
			protected MemoryParameterT memory = new MemoryParameterT();

			@XmlElement(name = "Property")
			protected PropertyParameterT property;

			@XmlAttribute(name = "LegacyPatchAlways")
			protected Boolean legacyPatchAlways;

		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "memory", "property", "parameter" })
		@Data
		public static class Union {

			@XmlElement(name = "Memory")
			protected MemoryUnionT memory;

			@XmlElement(name = "Property")
			protected PropertyUnionT property;

			@XmlElement(name = "Parameter", required = true)
			protected List<UnionParameterT> parameter;

			@XmlAttribute(name = "SizeInBit", required = true)
			protected long sizeInBit;

			@XmlAttribute(name = "InternalDescription")
			protected String internalDescription;
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "parameterType" })
	@Data
	public static class ParameterTypes {

		@XmlElement(name = "ParameterType", required = true)
		protected List<ParameterTypeT> parameterType = new ArrayList<ParameterTypeT>();

	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "parameterValidation" })
	@Data
	public static class ParameterValidations {

		@XmlElement(name = "ParameterValidation", required = true)
		protected List<ParameterValidationT> parameterValidation;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "value" })
	@Data
	public static class Script {

		@XmlValue
		protected String value;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "securityRole" })
	@Data
	public static class SecurityRoles {

		@XmlElement(name = "SecurityRole", required = true)
		protected List<ApplicationProgramStaticT.SecurityRoles.SecurityRole> securityRole;

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "")
		@Data
		public static class SecurityRole {

			@XmlAttribute(name = "Id", required = true)
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			@XmlID
			@XmlSchemaType(name = "ID")
			protected String id;

			@XmlAttribute(name = "Text", required = true)
			protected String text;

			@XmlAttribute(name = "Mask", required = true)
			@XmlSchemaType(name = "unsignedShort")
			protected int mask;

			@XmlAttribute(name = "RoleID")
			@XmlSchemaType(name = "unsignedInt")
			protected Long roleID;
		}
	}
}
