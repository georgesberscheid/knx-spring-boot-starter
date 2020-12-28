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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for FunctionType_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FunctionType_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FunctionPoint" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *                 &lt;attribute name="Text" use="required" type="{http://knx.org/xml/project/20}LanguageDependentString255_t" />
 *                 &lt;attribute name="Role" use="required" type="{http://knx.org/xml/project/20}IDREF" />
 *                 &lt;attribute name="DatapointType" use="required" type="{http://knx.org/xml/project/20}IDREF" />
 *                 &lt;attribute name="Characteristics">
 *                   &lt;simpleType>
 *                     &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="Semantics" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="Number" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *       &lt;attribute name="Text" use="required" type="{http://knx.org/xml/project/20}LanguageDependentString255_t" />
 *       &lt;attribute name="Description" type="{http://knx.org/xml/project/20}LanguageDependentString255_t" />
 *       &lt;attribute name="Status" type="{http://knx.org/xml/project/20}DeprecationStatus_t" default="active" />
 *       &lt;attribute name="Semantics" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FunctionType_t", propOrder = {
    "functionPoint"
})
public class FunctionTypeT {

    @XmlElement(name = "FunctionPoint")
    protected List<FunctionTypeT.FunctionPoint> functionPoint;
    @XmlAttribute(name = "Id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "Number", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long number;
    @XmlAttribute(name = "Text", required = true)
    protected String text;
    @XmlAttribute(name = "Description")
    protected String description;
    @XmlAttribute(name = "Status")
    protected DeprecationStatusT status;
    @XmlAttribute(name = "Semantics")
    protected String semantics;

    /**
     * Gets the value of the functionPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the functionPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFunctionPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FunctionTypeT.FunctionPoint }
     * 
     * 
     */
    public List<FunctionTypeT.FunctionPoint> getFunctionPoint() {
        if (functionPoint == null) {
            functionPoint = new ArrayList<FunctionTypeT.FunctionPoint>();
        }
        return this.functionPoint;
    }

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
     * Gets the value of the number property.
     * 
     */
    public long getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     */
    public void setNumber(long value) {
        this.number = value;
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
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link DeprecationStatusT }
     *     
     */
    public DeprecationStatusT getStatus() {
        if (status == null) {
            return DeprecationStatusT.ACTIVE;
        } else {
            return status;
        }
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeprecationStatusT }
     *     
     */
    public void setStatus(DeprecationStatusT value) {
        this.status = value;
    }

    /**
     * Gets the value of the semantics property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSemantics() {
        return semantics;
    }

    /**
     * Sets the value of the semantics property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSemantics(String value) {
        this.semantics = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
     *       &lt;attribute name="Text" use="required" type="{http://knx.org/xml/project/20}LanguageDependentString255_t" />
     *       &lt;attribute name="Role" use="required" type="{http://knx.org/xml/project/20}IDREF" />
     *       &lt;attribute name="DatapointType" use="required" type="{http://knx.org/xml/project/20}IDREF" />
     *       &lt;attribute name="Characteristics">
     *         &lt;simpleType>
     *           &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="Semantics" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class FunctionPoint {

        @XmlAttribute(name = "Id", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlID
        @XmlSchemaType(name = "ID")
        protected String id;
        @XmlAttribute(name = "Text", required = true)
        protected String text;
        @XmlAttribute(name = "Role", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String role;
        @XmlAttribute(name = "DatapointType", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String datapointType;
        @XmlAttribute(name = "Characteristics")
        protected List<String> characteristics;
        @XmlAttribute(name = "Semantics")
        protected String semantics;

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
         * Gets the value of the role property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRole() {
            return role;
        }

        /**
         * Sets the value of the role property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRole(String value) {
            this.role = value;
        }

        /**
         * Gets the value of the datapointType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDatapointType() {
            return datapointType;
        }

        /**
         * Sets the value of the datapointType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDatapointType(String value) {
            this.datapointType = value;
        }

        /**
         * Gets the value of the characteristics property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the characteristics property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCharacteristics().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getCharacteristics() {
            if (characteristics == null) {
                characteristics = new ArrayList<String>();
            }
            return this.characteristics;
        }

        /**
         * Gets the value of the semantics property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSemantics() {
            return semantics;
        }

        /**
         * Sets the value of the semantics property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSemantics(String value) {
            this.semantics = value;
        }

    }

}