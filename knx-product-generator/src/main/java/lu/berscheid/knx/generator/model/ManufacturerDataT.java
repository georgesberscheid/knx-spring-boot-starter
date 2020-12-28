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
import javax.xml.datatype.XMLGregorianCalendar;

import lombok.Data;
import lombok.NonNull;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManufacturerData_t", propOrder = { "manufacturer" })
@Data
public class ManufacturerDataT {

	@XmlElement(name = "Manufacturer", required = true)
	protected List<ManufacturerDataT.Manufacturer> manufacturer = new ArrayList<ManufacturerDataT.Manufacturer>();

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "catalog", "applicationPrograms", "baggages", "hardware", "languages" })
	@Data
	public static class Manufacturer {

		@XmlElement(name = "Catalog")
		protected ManufacturerDataT.Manufacturer.Catalog catalog = new ManufacturerDataT.Manufacturer.Catalog();

		@XmlElement(name = "ApplicationPrograms")
		protected ManufacturerDataT.Manufacturer.ApplicationPrograms applicationPrograms = new ManufacturerDataT.Manufacturer.ApplicationPrograms();

		@XmlElement(name = "Baggages")
		protected ManufacturerDataT.Manufacturer.Baggages baggages;

		@XmlElement(name = "Hardware")
		protected ManufacturerDataT.Manufacturer.Hardware hardware = new ManufacturerDataT.Manufacturer.Hardware();

		@XmlElement(name = "Languages")
		protected ManufacturerDataT.Manufacturer.Languages languages;

		@XmlAttribute(name = "RefId", required = true)
		@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
		protected String refId;

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "applicationProgram" })
		@Data
		public static class ApplicationPrograms {

			@XmlElement(name = "ApplicationProgram", required = true)
			protected List<ApplicationProgramT> applicationProgram = new ArrayList<ApplicationProgramT>();
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "baggage" })
		@Data
		public static class Baggages {

			@XmlElement(name = "Baggage", required = true)
			protected List<ManufacturerDataT.Manufacturer.Baggages.Baggage> baggage = new ArrayList<ManufacturerDataT.Manufacturer.Baggages.Baggage>();

			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = { "fileInfo" })
			@Data
			public static class Baggage {

				@XmlElement(name = "FileInfo", required = true)
				protected ManufacturerDataT.Manufacturer.Baggages.Baggage.FileInfo fileInfo = new ManufacturerDataT.Manufacturer.Baggages.Baggage.FileInfo();

				@XmlAttribute(name = "TargetPath", required = true)
				protected String targetPath;

				@XmlAttribute(name = "Name", required = true)
				protected String name;

				@XmlAttribute(name = "FileIntegrity")
				@NonNull
				protected String fileIntegrity = "00000000";

				@XmlAttribute(name = "Id", required = true)
				@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
				@XmlID
				@XmlSchemaType(name = "ID")
				protected String id;

				@XmlAccessorType(XmlAccessType.FIELD)
				@XmlType(name = "")
				@Data
				public static class FileInfo {

					@XmlAttribute(name = "Version")
					protected String version;

					@XmlAttribute(name = "TimeInfo")
					@XmlSchemaType(name = "dateTime")
					protected XMLGregorianCalendar timeInfo;

					@XmlAttribute(name = "Hidden")
					protected Boolean hidden = Boolean.FALSE;

					@XmlAttribute(name = "ReadOnly")
					protected Boolean readOnly = Boolean.FALSE;

				}
			}
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "catalogSection" })
		@Data
		public static class Catalog {

			@XmlElement(name = "CatalogSection", required = true)
			protected List<CatalogSectionT> catalogSection = new ArrayList<CatalogSectionT>();
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "hardware" })
		@Data
		public static class Hardware {

			@XmlElement(name = "Hardware", required = true)
			protected List<HardwareT> hardware = new ArrayList<HardwareT>();
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "language" })
		@Data
		public static class Languages {

			@XmlElement(name = "Language", required = true)
			protected List<LanguageDataT> language = new ArrayList<LanguageDataT>();

		}
	}
}
