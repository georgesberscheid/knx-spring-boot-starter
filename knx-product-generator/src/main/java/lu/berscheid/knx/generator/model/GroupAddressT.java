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
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for GroupAddress_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GroupAddress_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="Address" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt">
 *             &lt;minInclusive value="1"/>
 *             &lt;maxInclusive value="65535"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Name" use="required" type="{http://knx.org/xml/project/20}String255_t" />
 *       &lt;attribute name="Unfiltered" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="Central" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="Global" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="DatapointType" type="{http://knx.org/xml/project/20}IDREF" />
 *       &lt;attribute name="Description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Puid" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Key" type="{http://knx.org/xml/project/20}Aes128Key_t" />
 *       &lt;attribute name="Security" type="{http://knx.org/xml/project/20}SecurityMode_t" default="Auto" />
 *       &lt;attribute name="Context" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupAddress_t")
public class GroupAddressT {

    @XmlAttribute(name = "Id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "Address", required = true)
    protected long address;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "Unfiltered")
    protected Boolean unfiltered;
    @XmlAttribute(name = "Central")
    protected Boolean central;
    @XmlAttribute(name = "Global")
    protected Boolean global;
    @XmlAttribute(name = "DatapointType")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String datapointType;
    @XmlAttribute(name = "Description")
    protected String description;
    @XmlAttribute(name = "Comment")
    protected String comment;
    @XmlAttribute(name = "Puid", required = true)
    protected int puid;
    @XmlAttribute(name = "Key")
    protected String key;
    @XmlAttribute(name = "Security")
    protected SecurityModeT security;
    @XmlAttribute(name = "Context")
    protected String context;

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
     * Gets the value of the address property.
     * 
     */
    public long getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     */
    public void setAddress(long value) {
        this.address = value;
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
     * Gets the value of the unfiltered property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isUnfiltered() {
        if (unfiltered == null) {
            return false;
        } else {
            return unfiltered;
        }
    }

    /**
     * Sets the value of the unfiltered property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUnfiltered(Boolean value) {
        this.unfiltered = value;
    }

    /**
     * Gets the value of the central property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCentral() {
        if (central == null) {
            return false;
        } else {
            return central;
        }
    }

    /**
     * Sets the value of the central property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCentral(Boolean value) {
        this.central = value;
    }

    /**
     * Gets the value of the global property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isGlobal() {
        if (global == null) {
            return false;
        } else {
            return global;
        }
    }

    /**
     * Sets the value of the global property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGlobal(Boolean value) {
        this.global = value;
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
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the puid property.
     * 
     */
    public int getPuid() {
        return puid;
    }

    /**
     * Sets the value of the puid property.
     * 
     */
    public void setPuid(int value) {
        this.puid = value;
    }

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the security property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityModeT }
     *     
     */
    public SecurityModeT getSecurity() {
        if (security == null) {
            return SecurityModeT.AUTO;
        } else {
            return security;
        }
    }

    /**
     * Sets the value of the security property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityModeT }
     *     
     */
    public void setSecurity(SecurityModeT value) {
        this.security = value;
    }

    /**
     * Gets the value of the context property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContext() {
        return context;
    }

    /**
     * Sets the value of the context property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContext(String value) {
        this.context = value;
    }

}
