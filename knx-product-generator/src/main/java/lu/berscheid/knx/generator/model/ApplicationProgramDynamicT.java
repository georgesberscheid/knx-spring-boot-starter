package lu.berscheid.knx.generator.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApplicationProgramDynamic_t",
		propOrder = { "channelIndependentBlocks", "applicationProgramChannels",
				"dependentChannelChooses", "modules", "repeats", })
@Data
public class ApplicationProgramDynamicT {

	@XmlElement(name = "ChannelIndependentBlock")
	protected List<ChannelIndependentBlockT> channelIndependentBlocks;

	@XmlElement(name = "Channel")
	protected List<ApplicationProgramChannelT> applicationProgramChannels = new ArrayList<ApplicationProgramChannelT>();

	@XmlElement(name = "choose", type = DependentChannelChooseT.class)
	protected List<DependentChannelChooseT> dependentChannelChooses;

	@XmlElement(name = "Module", type = ModuleT.class)
	protected List<ModuleT> modules;

	@XmlElement(name = "Repeat", type = RepeatT.class)
	protected List<RepeatT> repeats;
}
