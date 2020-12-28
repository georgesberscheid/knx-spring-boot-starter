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


/**
 * <p>Java class for PropertyParameter_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PropertyParameter_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="ObjectIndex" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" />
 *       &lt;attribute name="ObjectType" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" />
 *       &lt;attribute name="Occurrence" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" default="0" />
 *       &lt;attribute name="PropertyId" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" />
 *       &lt;attribute name="Offset" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *       &lt;attribute name="BitOffset" use="required" type="{http://knx.org/xml/project/20}BitOffset_t" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyParameter_t")
@XmlSeeAlso({
    lu.berscheid.knx.generator.model.ModuleDefStaticT.Parameters.Parameter.Property.class
})
public class PropertyParameterT {

    @XmlAttribute(name = "ObjectIndex")
    @XmlSchemaType(name = "unsignedByte")
    protected Short objectIndex;
    @XmlAttribute(name = "ObjectType")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer objectType;
    @XmlAttribute(name = "Occurrence")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer occurrence;
    @XmlAttribute(name = "PropertyId", required = true)
    @XmlSchemaType(name = "unsignedShort")
    protected int propertyId;
    @XmlAttribute(name = "Offset", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long offset;
    @XmlAttribute(name = "BitOffset", required = true)
    protected short bitOffset;

    /**
     * Gets the value of the objectIndex property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getObjectIndex() {
        return objectIndex;
    }

    /**
     * Sets the value of the objectIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setObjectIndex(Short value) {
        this.objectIndex = value;
    }

    /**
     * Gets the value of the objectType property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getObjectType() {
        return objectType;
    }

    /**
     * Sets the value of the objectType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setObjectType(Integer value) {
        this.objectType = value;
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
     * Gets the value of the propertyId property.
     * 
     */
    public int getPropertyId() {
        return propertyId;
    }

    /**
     * Sets the value of the propertyId property.
     * 
     */
    public void setPropertyId(int value) {
        this.propertyId = value;
    }

    /**
     * Gets the value of the offset property.
     * 
     */
    public long getOffset() {
        return offset;
    }

    /**
     * Sets the value of the offset property.
     * 
     */
    public void setOffset(long value) {
        this.offset = value;
    }

    /**
     * Gets the value of the bitOffset property.
     * 
     */
    public short getBitOffset() {
        return bitOffset;
    }

    /**
     * Sets the value of the bitOffset property.
     * 
     */
    public void setBitOffset(short value) {
        this.bitOffset = value;
    }

}