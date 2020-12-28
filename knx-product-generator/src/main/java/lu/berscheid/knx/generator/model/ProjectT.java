package lu.berscheid.knx.generator.model;

import java.math.BigInteger;
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
import javax.xml.datatype.XMLGregorianCalendar;

import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Project_t", propOrder = { "projectInformation", "installations", "userFiles", "addinData" })
@Data
public class ProjectT {

	@XmlElement(name = "ProjectInformation")
	protected ProjectT.ProjectInformation projectInformation;
	@XmlElement(name = "Installations")
	protected ProjectT.Installations installations;
	@XmlElement(name = "UserFiles")
	protected ProjectT.UserFiles userFiles;
	@XmlElement(name = "AddinData")
	protected ProjectT.AddinData addinData;
	@XmlAttribute(name = "Id", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "addinData" })
	@Data
	public static class AddinData {

		@XmlElement(name = "AddinData")
		protected List<AddinDataT> addinData;

	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "installation" })
	@Data
	public static class Installations {

		@XmlElement(name = "Installation", required = true)
		protected List<ProjectT.Installations.Installation> installation;

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "topology", "locations", "groupAddresses", "p2PLinks", "trades", "splitInfos" })
		@Data
		public static class Installation {

			@XmlElement(name = "Topology", required = true)
			protected TopologyT topology;
			@XmlElement(name = "Locations", required = true)
			protected LocationsT locations;
			@XmlElement(name = "GroupAddresses", required = true)
			protected GroupAddressesT groupAddresses;
			@XmlElement(name = "P2PLinks")
			protected P2PLinksT p2PLinks;
			@XmlElement(name = "Trades")
			protected TradesT trades;
			@XmlElement(name = "SplitInfos")
			protected SplitInfosT splitInfos;
			@XmlAttribute(name = "Name", required = true)
			protected String name;
			@XmlAttribute(name = "InstallationId")
			protected Integer installationId;
			@XmlAttribute(name = "BCUKey")
			@XmlSchemaType(name = "unsignedLong")
			protected BigInteger bcuKey;
			@XmlAttribute(name = "IPRoutingMulticastAddress")
			protected String ipRoutingMulticastAddress;
			@XmlAttribute(name = "MulticastTTL")
			@XmlSchemaType(name = "unsignedByte")
			protected Short multicastTTL;
			@XmlAttribute(name = "IPRoutingBackboneKey")
			protected String ipRoutingBackboneKey;
			@XmlAttribute(name = "IPRoutingLatencyTolerance")
			@XmlSchemaType(name = "unsignedShort")
			protected Integer ipRoutingLatencyTolerance;
			@XmlAttribute(name = "IPSyncLatencyFraction")
			protected Float ipSyncLatencyFraction;
			@XmlAttribute(name = "DefaultLine")
			protected String defaultLine;
			@XmlAttribute(name = "CompletionStatus")
			protected CompletionStatusT completionStatus;
			@XmlAttribute(name = "IPRoutingBackboneSecurity")
			protected SecurityModeT ipRoutingBackboneSecurity;
			@XmlAttribute(name = "SplitType")
			protected String splitType;

		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "historyEntries", "toDoItems", "projectTraces", "deviceCertificates" })
	@Data
	public static class ProjectInformation {

		@XmlElement(name = "HistoryEntries")
		protected ProjectT.ProjectInformation.HistoryEntries historyEntries;
		@XmlElement(name = "ToDoItems")
		protected ProjectT.ProjectInformation.ToDoItems toDoItems;
		@XmlElement(name = "ProjectTraces")
		protected ProjectT.ProjectInformation.ProjectTraces projectTraces;
		@XmlElement(name = "DeviceCertificates")
		protected ProjectT.ProjectInformation.DeviceCertificates deviceCertificates;
		@XmlAttribute(name = "Name", required = true)
		protected String name;
		@XmlAttribute(name = "GroupAddressStyle", required = true)
		protected GroupAddressStyleT groupAddressStyle;
		@XmlAttribute(name = "ProjectNumber")
		protected String projectNumber;
		@XmlAttribute(name = "ContractNumber")
		protected String contractNumber;
		@XmlAttribute(name = "LastModified")
		@XmlSchemaType(name = "dateTime")
		protected XMLGregorianCalendar lastModified;
		@XmlAttribute(name = "ProjectStart")
		@XmlSchemaType(name = "dateTime")
		protected XMLGregorianCalendar projectStart;
		@XmlAttribute(name = "ProjectEnd")
		@XmlSchemaType(name = "dateTime")
		protected XMLGregorianCalendar projectEnd;
		@XmlAttribute(name = "ProjectId")
		protected Integer projectId;
		@XmlAttribute(name = "ProjectPassword")
		protected String projectPassword;
		@XmlAttribute(name = "Comment")
		protected String comment;
		@XmlAttribute(name = "CompletionStatus")
		protected CompletionStatusT completionStatus;
		@XmlAttribute(name = "ProjectTracingLevel")
		protected ProjectTracingLevelT projectTracingLevel;
		@XmlAttribute(name = "ProjectTracingPassword")
		protected String projectTracingPassword;
		@XmlAttribute(name = "Hide16BitGroupsFromLegacyPlugins")
		protected Boolean hide16BitGroupsFromLegacyPlugins;
		@XmlAttribute(name = "CodePage")
		protected TextEncodingT codePage;
		@XmlAttribute(name = "BusAccessLegacyMode")
		protected Boolean busAccessLegacyMode;
		@XmlAttribute(name = "Guid", required = true)
		protected String guid;
		@XmlAttribute(name = "LastUsedPuid", required = true)
		protected int lastUsedPuid;
		@XmlAttribute(name = "Security")
		protected SecurityModeT security;

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "deviceCertificate" })
		@Data
		public static class DeviceCertificates {

			@XmlElement(name = "DeviceCertificate", required = true)
			protected List<DeviceCertificateT> deviceCertificate;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "historyEntry" })
		@Data
		public static class HistoryEntries {

			@XmlElement(name = "HistoryEntry", required = true)
			protected List<ProjectT.ProjectInformation.HistoryEntries.HistoryEntry> historyEntry;

			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "")
			@Data
			public static class HistoryEntry {

				@XmlAttribute(name = "Date", required = true)
				@XmlSchemaType(name = "dateTime")
				protected XMLGregorianCalendar date;
				@XmlAttribute(name = "User")
				protected String user;
				@XmlAttribute(name = "Text", required = true)
				protected String text;
				@XmlAttribute(name = "Detail")
				protected String detail;

			}
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "projectTrace" })
		@Data
		public static class ProjectTraces {

			@XmlElement(name = "ProjectTrace", required = true)
			protected List<ProjectTraceT> projectTrace;

		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "toDoItem" })
		@Data
		public static class ToDoItems {

			@XmlElement(name = "ToDoItem", required = true)
			protected List<ToDoItemT> toDoItem;

		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "userFile" })
	@Data
	public static class UserFiles {

		@XmlElement(name = "UserFile")
		protected List<UserFileT> userFile;

	}
}
