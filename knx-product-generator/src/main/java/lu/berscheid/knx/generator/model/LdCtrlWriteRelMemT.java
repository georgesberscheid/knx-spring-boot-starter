package lu.berscheid.knx.generator.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LdCtrlWriteRelMem_t")
@Data
@EqualsAndHashCode(callSuper = false)
public class LdCtrlWriteRelMemT extends LdCtrlBaseT {

	@XmlAttribute(name = "ObjIdx")
	@XmlSchemaType(name = "unsignedByte")
	protected Short objIdx;
	@XmlAttribute(name = "ObjType")
	@XmlSchemaType(name = "unsignedShort")
	protected Integer objType;
	@XmlAttribute(name = "Occurrence")
	@XmlSchemaType(name = "unsignedShort")
	protected Integer occurrence;
	@XmlAttribute(name = "Offset", required = true)
	@XmlSchemaType(name = "unsignedInt")
	protected long offset;
	@XmlAttribute(name = "Size", required = true)
	@XmlSchemaType(name = "unsignedInt")
	protected long size;
	@XmlAttribute(name = "Verify", required = true)
	protected boolean verify;
	@XmlAttribute(name = "InlineData")
	@XmlJavaTypeAdapter(HexBinaryAdapter.class)
	@XmlSchemaType(name = "hexBinary")
	protected byte[] inlineData;

}
