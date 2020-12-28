//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.10.05 at 10:56:00 PM CEST 
//


package lu.berscheid.knx.generator.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for LdCtrlInvokeFunctionProp_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LdCtrlInvokeFunctionProp_t">
 *   &lt;complexContent>
 *     &lt;extension base="{http://knx.org/xml/project/20}LdCtrlBase_t">
 *       &lt;attribute name="ObjIdx" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" />
 *       &lt;attribute name="ObjType" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" />
 *       &lt;attribute name="Occurrence" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" default="0" />
 *       &lt;attribute name="PropId" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" />
 *       &lt;attribute name="InlineData" type="{http://www.w3.org/2001/XMLSchema}hexBinary" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LdCtrlInvokeFunctionProp_t")
@XmlSeeAlso({
    ModuleDefLdCtrlInvokeFunctionPropT.class
})
public class LdCtrlInvokeFunctionPropT
    extends LdCtrlBaseT
{

    @XmlAttribute(name = "ObjIdx")
    @XmlSchemaType(name = "unsignedByte")
    protected Short objIdx;
    @XmlAttribute(name = "ObjType")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer objType;
    @XmlAttribute(name = "Occurrence")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer occurrence;
    @XmlAttribute(name = "PropId", required = true)
    @XmlSchemaType(name = "unsignedShort")
    protected int propId;
    @XmlAttribute(name = "InlineData")
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    @XmlSchemaType(name = "hexBinary")
    protected byte[] inlineData;

    /**
     * Gets the value of the objIdx property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getObjIdx() {
        return objIdx;
    }

    /**
     * Sets the value of the objIdx property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setObjIdx(Short value) {
        this.objIdx = value;
    }

    /**
     * Gets the value of the objType property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getObjType() {
        return objType;
    }

    /**
     * Sets the value of the objType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setObjType(Integer value) {
        this.objType = value;
    }

    /**
     * Gets the value of the occurrence property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getOccurrence() {
        if (occurrence == null) {
            return  0;
        } else {
            return occurrence;
        }
    }

    /**
     * Sets the value of the occurrence property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOccurrence(Integer value) {
        this.occurrence = value;
    }

    /**
     * Gets the value of the propId property.
     * 
     */
    public int getPropId() {
        return propId;
    }

    /**
     * Sets the value of the propId property.
     * 
     */
    public void setPropId(int value) {
        this.propId = value;
    }

    /**
     * Gets the value of the inlineData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getInlineData() {
        return inlineData;
    }

    /**
     * Sets the value of the inlineData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInlineData(byte[] value) {
        this.inlineData = value;
    }

}