package lu.berscheid.knx.generator.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApplicationProgramChannel_t", propOrder = { "entries" })
@Data
public class ApplicationProgramChannelT implements ComObjectParameterBlockContainer {

	@XmlElements({ @XmlElement(name = "ParameterBlock", type = ComObjectParameterBlockT.class),
			@XmlElement(name = "ComObjectRefRef", type = ComObjectRefRefT.class),
			@XmlElement(name = "BinaryDataRef", type = BinaryDataRefT.class),
			@XmlElement(name = "Module", type = ModuleT.class),
			@XmlElement(name = "Repeat", type = RepeatT.class),
			@XmlElement(name = "choose", type = ChannelChooseT.class) })
	protected List<Object> entries = new ArrayList<Object>();

	@XmlAttribute(name = "Id", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;

	@XmlAttribute(name = "Name", required = true)
	protected String name;

	@XmlAttribute(name = "Text")
	protected String text;

	@XmlAttribute(name = "Number", required = true)
	protected String number;

	@XmlAttribute(name = "TextParameterRefId")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String textParameterRefId;

	@XmlAttribute(name = "InternalDescription")
	protected String internalDescription;

	@XmlAttribute(name = "Icon")
	protected String icon;

	@XmlAttribute(name = "HelpContext")
	protected String helpContext;

	@XmlAttribute(name = "Semantics")
	protected String semantics;

	@Override
	public void addParameterBlock(ComObjectParameterBlockT parameterBlock) {
		entries.add(parameterBlock);
	}
}
