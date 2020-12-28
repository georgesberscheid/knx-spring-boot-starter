package lu.berscheid.knx.generator.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LdCtrlRelSegment_t")
@Data
@EqualsAndHashCode(callSuper = true)
public class LdCtrlRelSegmentT extends LdCtrlBaseT {

	@XmlAttribute(name = "LsmIdx")
	@XmlSchemaType(name = "unsignedByte")
	protected Short lsmIdx;
	@XmlAttribute(name = "ObjType")
	@XmlSchemaType(name = "unsignedShort")
	protected Integer objType;
	@XmlAttribute(name = "Occurrence")
	@XmlSchemaType(name = "unsignedShort")
	protected Integer occurrence;
	@XmlAttribute(name = "Size", required = true)
	@XmlSchemaType(name = "unsignedInt")
	protected long size;
	@XmlAttribute(name = "Mode", required = true)
	@XmlSchemaType(name = "unsignedByte")
	protected short mode;
	@XmlAttribute(name = "Fill", required = true)
	@XmlSchemaType(name = "unsignedByte")
	protected short fill;

}
