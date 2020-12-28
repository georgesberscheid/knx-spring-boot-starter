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
@XmlType(name = "ComObjectParameterBlock_t",
		propOrder = { "rows", "columns", "parameterBlocks", "parameterSeparators", "parameterRefRefs", "buttons",
				"chooses", "binaryDataRefs", "comObjectRefRefs", "modules", "repeats", "assigns", "channels" })
@Data
public class ComObjectParameterBlockT {

	@XmlElement(name = "Rows")
	protected ComObjectParameterBlockT.Rows rows;

	@XmlElement(name = "Columns")
	protected ComObjectParameterBlockT.Columns columns;

	@XmlElement(name = "ParameterBlock")
	protected List<ComObjectParameterBlockT> parameterBlocks = new ArrayList<ComObjectParameterBlockT>();

	@XmlElement(name = "ParameterSeparator")
	protected List<ParameterSeparatorT> parameterSeparators = new ArrayList<ParameterSeparatorT>();

	@XmlElement(name = "ParameterRefRef")
	protected List<ParameterRefRefT> parameterRefRefs = new ArrayList<ParameterRefRefT>();

	@XmlElement(name = "Button")
	protected List<ButtonT> buttons = new ArrayList<ButtonT>();

	@XmlElement(name = "choose")
	protected List<ComObjectParameterChooseT> chooses = new ArrayList<ComObjectParameterChooseT>();

	@XmlElement(name = "BinaryDataRef")
	protected List<BinaryDataRefT> binaryDataRefs = new ArrayList<BinaryDataRefT>();

	@XmlElement(name = "ComObjectRefRef")
	protected List<ComObjectRefRefT> comObjectRefRefs = new ArrayList<ComObjectRefRefT>();

	@XmlElement(name = "Module")
	protected List<ModuleT> modules = new ArrayList<ModuleT>();

	@XmlElement(name = "Repeat")
	protected List<RepeatT> repeats = new ArrayList<RepeatT>();

	@XmlElement(name = "Assign")
	protected List<AssignT> assigns = new ArrayList<AssignT>();

	@XmlElement(name = "Channel")
	protected List<ApplicationProgramChannelT> channels = new ArrayList<ApplicationProgramChannelT>();

	@XmlAttribute(name = "Id", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;

	@XmlAttribute(name = "Name")
	protected String name;

	@XmlAttribute(name = "Text")
	protected String text;

	@XmlAttribute(name = "Access")
	protected AccessT access;

	@XmlAttribute(name = "HelpTopic")
	@XmlSchemaType(name = "unsignedInt")
	protected Long helpTopic;

	@XmlAttribute(name = "InternalDescription")
	protected String internalDescription;

	@XmlAttribute(name = "ParamRefId")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String paramRefId;

	@XmlAttribute(name = "TextParameterRefId")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String textParameterRefId;

	@XmlAttribute(name = "Inline")
	protected Boolean inline;

	@XmlAttribute(name = "Layout")
	protected ParameterBlockLayoutT layout;

	@XmlAttribute(name = "Cell")
	protected String cell;

	@XmlAttribute(name = "Icon")
	protected String icon;

	@XmlAttribute(name = "HelpContext")
	protected String helpContext;

	@XmlAttribute(name = "ShowInComObjectTree")
	protected Boolean showInComObjectTree;

	@XmlAttribute(name = "Semantics")
	protected String semantics;

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "column" })
	public static class Columns {

		@XmlElement(name = "Column", required = true)
		protected List<ComObjectParameterBlockT.Columns.Column> column;

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "")
		public static class Column {

			@XmlAttribute(name = "Id", required = true)
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			@XmlID
			@XmlSchemaType(name = "ID")
			protected String id;

			@XmlAttribute(name = "Name")
			protected String name;

			@XmlAttribute(name = "Text")
			protected String text;

			@XmlAttribute(name = "TextParameterRefId")
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			protected String textParameterRefId;

			@XmlAttribute(name = "Width", required = true)
			protected String width;

			@XmlAttribute(name = "InternalDescription")
			protected String internalDescription;
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "row" })
	public static class Rows {

		@XmlElement(name = "Row", required = true)
		protected List<ComObjectParameterBlockT.Rows.Row> row;

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "")
		public static class Row {

			@XmlAttribute(name = "Id", required = true)
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			@XmlID
			@XmlSchemaType(name = "ID")
			protected String id;

			@XmlAttribute(name = "Name")
			protected String name;

			@XmlAttribute(name = "Text")
			protected String text;

			@XmlAttribute(name = "TextParameterRefId")
			@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
			protected String textParameterRefId;

			@XmlAttribute(name = "CollapseIfEmpty")
			protected Boolean collapseIfEmpty;

			@XmlAttribute(name = "InternalDescription")
			protected String internalDescription;
		}
	}
}
