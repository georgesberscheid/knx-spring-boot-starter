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
 * <p>Java class for Function_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Function_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GroupAddressRef" type="{http://knx.org/xml/project/20}GroupAddressRef_t" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="Name" use="required" type="{http://knx.org/xml/project/20}String255_t" />
 *       &lt;attribute name="Type" type="{http://knx.org/xml/project/20}String255_t" />
 *       &lt;attribute name="Implements" type="{http://knx.org/xml/project/20}IDREFS" />
 *       &lt;attribute name="Number" type="{http://knx.org/xml/project/20}String255_t" />
 *       &lt;attribute name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CompletionStatus" type="{http://knx.org/xml/project/20}CompletionStatus_t" default="Undefined" />
 *       &lt;attribute name="DefaultGroupRange" type="{http://knx.org/xml/project/20}IDREF" />
 *       &lt;attribute name="Puid" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Context" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Function_t", propOrder = {
    "groupAddressRef"
})
public class FunctionT {

    @XmlElement(name = "GroupAddressRef")
    protected List<GroupAddressRefT> groupAddressRef;
    @XmlAttribute(name = "Id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "Type")
    protected String type;
    @XmlAttribute(name = "Implements")
    protected List<String> _implements;
    @XmlAttribute(name = "Number")
    protected String number;
    @XmlAttribute(name = "Comment")
    protected String comment;
    @XmlAttribute(name = "Description")
    protected String description;
    @XmlAttribute(name = "CompletionStatus")
    protected CompletionStatusT completionStatus;
    @XmlAttribute(name = "DefaultGroupRange")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String defaultGroupRange;
    @XmlAttribute(name = "Puid", required = true)
    protected int puid;
    @XmlAttribute(name = "Context")
    protected String context;

    /**
     * Gets the value of the groupAddressRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the groupAddressRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroupAddressRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GroupAddressRefT }
     * 
     * 
     */
    public List<GroupAddressRefT> getGroupAddressRef() {
        if (groupAddressRef == null) {
            groupAddressRef = new ArrayList<GroupAddressRefT>();
        }
        return this.groupAddressRef;
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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the implements property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the implements property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImplements().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getImplements() {
        if (_implements == null) {
            _implements = new ArrayList<String>();
        }
        return this._implements;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
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
     * Gets the value of the completionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link CompletionStatusT }
     *     
     */
    public CompletionStatusT getCompletionStatus() {
        if (completionStatus == null) {
            return CompletionStatusT.UNDEFINED;
        } else {
            return completionStatus;
        }
    }

    /**
     * Sets the value of the completionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompletionStatusT }
     *     
     */
    public void setCompletionStatus(CompletionStatusT value) {
        this.completionStatus = value;
    }

    /**
     * Gets the value of the defaultGroupRange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultGroupRange() {
        return defaultGroupRange;
    }

    /**
     * Sets the value of the defaultGroupRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultGroupRange(String value) {
        this.defaultGroupRange = value;
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