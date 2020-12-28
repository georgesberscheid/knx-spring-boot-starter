package lu.berscheid.knx.generator.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApplicationProgramRef_t")
@Data
public class ApplicationProgramRefT {

	@XmlAttribute(name = "RefId", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String refId;
}
