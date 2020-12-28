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
@XmlType(name = "ApplicationProgram_t", propOrder = { "appStatic", "moduleDefs", "dynamic" })
@Data
public class ApplicationProgramT {

	@XmlElement(name = "Static", required = true)
	protected ApplicationProgramStaticT appStatic = new ApplicationProgramStaticT();

	@XmlElement(name = "ModuleDefs")
	protected ApplicationProgramT.ModuleDefs moduleDefs;

	@XmlElement(name = "Dynamic")
	protected ApplicationProgramDynamicT dynamic = new ApplicationProgramDynamicT();

	@XmlAttribute(name = "Id", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;

	@XmlAttribute(name = "ApplicationNumber", required = true)
	@XmlSchemaType(name = "unsignedShort")
	protected int applicationNumber;

	@XmlAttribute(name = "ApplicationVersion", required = true)
	@XmlSchemaType(name = "unsignedByte")
	protected short applicationVersion;

	@XmlAttribute(name = "ProgramType", required = true)
	protected ApplicationProgramTypeT programType = ApplicationProgramTypeT.APPLICATION_PROGRAM;

	@XmlAttribute(name = "MaskVersion", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String maskVersion;

	@XmlAttribute(name = "VisibleDescription")
	protected String visibleDescription;

	@XmlAttribute(name = "Name", required = true)
	protected String name;

	@XmlAttribute(name = "LoadProcedureStyle", required = true)
	protected LoadProcedureStyleT loadProcedureStyle = LoadProcedureStyleT.DEFAULT_PROCEDURE;

	@XmlAttribute(name = "PeiType", required = true)
	@XmlSchemaType(name = "unsignedByte")
	protected short peiType;

	@XmlAttribute(name = "HelpTopic")
	@XmlSchemaType(name = "unsignedInt")
	protected Long helpTopic;

	@XmlAttribute(name = "HelpFile")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String helpFile;

	@XmlAttribute(name = "ContextHelpFile")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String contextHelpFile;

	@XmlAttribute(name = "IconFile")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String iconFile;

	@XmlAttribute(name = "DefaultLanguage", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlSchemaType(name = "language")
	protected String defaultLanguage;

	@XmlAttribute(name = "DynamicTableManagement", required = true)
	protected boolean dynamicTableManagement;

	@XmlAttribute(name = "Linkable", required = true)
	protected boolean linkable;

	@XmlAttribute(name = "IsSecureEnabled")
	protected Boolean isSecureEnabled;

	@XmlAttribute(name = "MinEtsVersion")
	protected String minEtsVersion;

	@XmlAttribute(name = "OriginalManufacturer")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String originalManufacturer;

	@XmlAttribute(name = "PreEts4Style")
	protected Boolean preEts4Style;

	@XmlAttribute(name = "ConvertedFromPreEts4Data")
	protected Boolean convertedFromPreEts4Data;

	@XmlAttribute(name = "CreatedFromLegacySchemaVersion")
	protected Boolean createdFromLegacySchemaVersion;

	@XmlAttribute(name = "IPConfig")
	protected ApplicationProgramIPConfigT ipConfig;

	@XmlAttribute(name = "AdditionalAddressesCount")
	protected Integer additionalAddressesCount;

	@XmlAttribute(name = "MaxUserEntries")
	@XmlSchemaType(name = "unsignedShort")
	protected Integer maxUserEntries;

	@XmlAttribute(name = "MaxTunnelingUserEntries")
	@XmlSchemaType(name = "unsignedShort")
	protected Integer maxTunnelingUserEntries;

	@XmlAttribute(name = "MaxSecurityIndividualAddressEntries")
	@XmlSchemaType(name = "unsignedShort")
	protected Integer maxSecurityIndividualAddressEntries;

	@XmlAttribute(name = "MaxSecurityGroupKeyTableEntries")
	@XmlSchemaType(name = "unsignedShort")
	protected Integer maxSecurityGroupKeyTableEntries;

	@XmlAttribute(name = "MaxSecurityP2PKeyTableEntries")
	@XmlSchemaType(name = "unsignedShort")
	protected Integer maxSecurityP2PKeyTableEntries;

	@XmlAttribute(name = "MaxSecurityProxyGroupKeyTableEntries")
	@XmlSchemaType(name = "unsignedShort")
	protected Integer maxSecurityProxyGroupKeyTableEntries;

	@XmlAttribute(name = "MaxSecurityProxyIndividualAddressTableEntries")
	@XmlSchemaType(name = "unsignedShort")
	protected Integer maxSecurityProxyIndividualAddressTableEntries;

	@XmlAttribute(name = "NonRegRelevantDataVersion")
	@XmlSchemaType(name = "unsignedShort")
	protected Integer nonRegRelevantDataVersion;

	@XmlAttribute(name = "Broken")
	protected Boolean broken;

	@XmlAttribute(name = "DownloadInfoIncomplete")
	protected Boolean downloadInfoIncomplete;

	@XmlAttribute(name = "ReplacesVersions")
	protected List<Short> replacesVersions;

	@XmlAttribute(name = "Hash")
	protected byte[] hash;

	@XmlAttribute(name = "InternalDescription")
	protected String internalDescription;

	@XmlAttribute(name = "Semantics")
	protected String semantics;

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "moduleDef" })
	@Data
	public static class ModuleDefs {

		@XmlElement(name = "ModuleDef", required = true)
		protected List<ModuleDefT> moduleDef = new ArrayList<ModuleDefT>();
	}
}
