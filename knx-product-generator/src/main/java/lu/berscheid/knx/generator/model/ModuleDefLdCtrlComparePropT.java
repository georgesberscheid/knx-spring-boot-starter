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
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ModuleDefLdCtrlCompareProp_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModuleDefLdCtrlCompareProp_t">
 *   &lt;complexContent>
 *     &lt;extension base="{http://knx.org/xml/project/20}LdCtrlCompareProp_t">
 *       &lt;attribute name="BaseObjIdx" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="BaseOccurrence" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="BaseStartElement" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModuleDefLdCtrlCompareProp_t")
public class ModuleDefLdCtrlComparePropT
    extends LdCtrlComparePropT
{

    @XmlAttribute(name = "BaseObjIdx")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object baseObjIdx;
    @XmlAttribute(name = "BaseOccurrence")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object baseOccurrence;
    @XmlAttribute(name = "BaseStartElement")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object baseStartElement;

    /**
     * Gets the value of the baseObjIdx property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getBaseObjIdx() {
        return baseObjIdx;
    }

    /**
     * Sets the value of the baseObjIdx property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setBaseObjIdx(Object value) {
        this.baseObjIdx = value;
    }

    /**
     * Gets the value of the baseOccurrence property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getBaseOccurrence() {
        return baseOccurrence;
    }

    /**
     * Sets the value of the baseOccurrence property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setBaseOccurrence(Object value) {
        this.baseOccurrence = value;
    }

    /**
     * Gets the value of the baseStartElement property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getBaseStartElement() {
        return baseStartElement;
    }

    /**
     * Sets the value of the baseStartElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setBaseStartElement(Object value) {
        this.baseStartElement = value;
    }

}
