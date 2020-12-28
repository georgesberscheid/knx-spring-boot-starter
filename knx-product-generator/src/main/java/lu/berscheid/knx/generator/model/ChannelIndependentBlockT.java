package lu.berscheid.knx.generator.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChannelIndependentBlock_t",
		propOrder = { "parameterBlocks", "chooses", "binaryDataRefs", "comObjectRefRefs", "modules", "repeats" })
@Data
public class ChannelIndependentBlockT {

	@XmlElement(name = "ParameterBlock")
	protected List<ComObjectParameterBlockT> parameterBlocks = new ArrayList<ComObjectParameterBlockT>();

	@XmlElement(name = "choose")
	protected List<ChannelChooseT> chooses = new ArrayList<ChannelChooseT>();

	@XmlElement(name = "BinaryDataRef")
	protected List<BinaryDataRefT> binaryDataRefs = new ArrayList<BinaryDataRefT>();

	@XmlElement(name = "ComObjectRefRef")
	protected List<ComObjectRefRefT> comObjectRefRefs = new ArrayList<ComObjectRefRefT>();

	@XmlElement(name = "Module")
	protected List<ModuleT> modules = new ArrayList<ModuleT>();

	@XmlElement(name = "Repeat")
	protected List<RepeatT> repeats = new ArrayList<RepeatT>();
}
