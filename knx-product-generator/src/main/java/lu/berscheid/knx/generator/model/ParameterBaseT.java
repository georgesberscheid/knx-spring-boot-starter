//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.10.05 at 10:56:00 PM CEST 
//


package lu.berscheid.knx.generator.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for ParameterBase_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParameterBase_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="Name" use="required" type="{http://knx.org/xml/project/20}String255_t" />
 *       &lt;attribute name="ParameterType" use="required" type="{http://knx.org/xml/project/20}IDREF" />
 *       &lt;attribute name="ParameterTypeParams" type="{http://knx.org/xml/project/20}IDREFS" />
 *       &lt;attribute name="Text" use="required" type="{http://knx.org/xml/project/20}LanguageDependentString255_t" />
 *       &lt;attribute name="SuffixText" type="{http://knx.org/xml/project/20}LanguageDependentString20_t" />
 *       &lt;attribute name="Access" type="{http://knx.org/xml/project/20}Access_t" default="ReadWrite" />
 *       &lt;attribute name="Value" use="required" type="{http://knx.org/xml/project/20}Value_t" />
 *       &lt;attribute name="InitialValue" type="{http://knx.org/xml/project/20}LanguageDependentString_t" />
 *       &lt;attribute name="CustomerAdjustable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="InternalDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParameterBase_t")
@XmlSeeAlso({
    lu.berscheid.knx.generator.model.ApplicationProgramStaticT.Parameters.ParameterT.class,
    lu.berscheid.knx.generator.model.ModuleDefStaticT.Parameters.Parameter.class,
    UnionParameterT.class
})
public abstract class ParameterBaseT {

    @XmlAttribute(name = "Id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "ParameterType", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String parameterType;
    @XmlAttribute(name = "ParameterTypeParams")
    protected List<String> parameterTypeParams;
    @XmlAttribute(name = "Text", required = true)
    protected String text;
    @XmlAttribute(name = "SuffixText")
    protected String suffixText;
    @XmlAttribute(name = "Access")
    protected AccessT access;
    @XmlAttribute(name = "Value", required = true)
    protected String value;
    @XmlAttribute(name = "InitialValue")
    protected String initialValue;
    @XmlAttribute(name = "CustomerAdjustable")
    protected Boolean customerAdjustable;
    @XmlAttribute(name = "InternalDescription")
    protected String internalDescription;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the parameterType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParameterType() {
        return parameterType;
    }

    /**
     * Sets the value of the parameterType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParameterType(String value) {
        this.parameterType = value;
    }

    /**
     * Gets the value of the parameterTypeParams property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameterTypeParams property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameterTypeParams().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getParameterTypeParams() {
        if (parameterTypeParams == null) {
            parameterTypeParams = new ArrayList<String>();
        }
        return this.parameterTypeParams;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

    /**
     * Gets the value of the suffixText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuffixText() {
        return suffixText;
    }

    /**
     * Sets the value of the suffixText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuffixText(String value) {
        this.suffixText = value;
    }

    /**
     * Gets the value of the access property.
     * 
     * @return
     *     possible object is
     *     {@link AccessT }
     *     
     */
    public AccessT getAccess() {
        if (access == null) {
            return AccessT.READ_WRITE;
        } else {
            return access;
        }
    }

    /**
     * Sets the value of the access property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccessT }
     *     
     */
    public void setAccess(AccessT value) {
        this.access = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the initialValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitialValue() {
        return initialValue;
    }

    /**
     * Sets the value of the initialValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitialValue(String value) {
        this.initialValue = value;
    }

    /**
     * Gets the value of the customerAdjustable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCustomerAdjustable() {
        if (customerAdjustable == null) {
            return false;
        } else {
            return customerAdjustable;
        }
    }

    /**
     * Sets the value of the customerAdjustable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCustomerAdjustable(Boolean value) {
        this.customerAdjustable = value;
    }

    /**
     * Gets the value of the internalDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternalDescription() {
        return internalDescription;
    }

    /**
     * Sets the value of the internalDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternalDescription(String value) {
        this.internalDescription = value;
    }

}
