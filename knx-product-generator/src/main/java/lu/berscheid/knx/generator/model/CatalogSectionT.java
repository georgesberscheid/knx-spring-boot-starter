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
@XmlType(name = "CatalogSection_t", propOrder = { "catalogSection", "catalogItem" })
@Data
public class CatalogSectionT {

	@XmlElement(name = "CatalogSection")
	protected List<CatalogSectionT> catalogSection;
	@XmlElement(name = "CatalogItem")
	protected List<CatalogSectionT.CatalogItem> catalogItem = new ArrayList<CatalogSectionT.CatalogItem>();
	@XmlAttribute(name = "Id", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;
	@XmlAttribute(name = "Name", required = true)
	protected String name;
	@XmlAttribute(name = "Number", required = true)
	protected String number;
	@XmlAttribute(name = "VisibleDescription")
	protected String visibleDescription;
	@XmlAttribute(name = "DefaultLanguage")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlSchemaType(name = "language")
	protected String defaultLanguage;
	@XmlAttribute(name = "NonRegRelevantDataVersion")
	@XmlSchemaType(name = "unsignedShort")
	protected Integer nonRegRelevantDataVersion;
	@XmlAttribute(name = "InternalDescription")
	protected String internalDescription;

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	@Data
	public static class CatalogItem {

		@XmlAttribute(name = "Id", required = true)
		@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
		@XmlID
		@XmlSchemaType(name = "ID")
		protected String id;
		@XmlAttribute(name = "Name", required = true)
		protected String name;
		@XmlAttribute(name = "Number", required = true)
		protected int number;
		@XmlAttribute(name = "VisibleDescription")
		protected String visibleDescription;
		@XmlAttribute(name = "ProductRefId", required = true)
		@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
		protected String productRefId;
		@XmlAttribute(name = "Hardware2ProgramRefId")
		@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
		protected String hardware2ProgramRefId;
		@XmlAttribute(name = "DefaultLanguage")
		@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
		@XmlSchemaType(name = "language")
		protected String defaultLanguage;
		@XmlAttribute(name = "NonRegRelevantDataVersion")
		@XmlSchemaType(name = "unsignedShort")
		protected Integer nonRegRelevantDataVersion;
		@XmlAttribute(name = "InternalDescription")
		protected String internalDescription;

	}
}
