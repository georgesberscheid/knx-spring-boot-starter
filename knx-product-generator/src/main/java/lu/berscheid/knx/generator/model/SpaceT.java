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
 * <p>Java class for Space_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Space_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Space" type="{http://knx.org/xml/project/20}Space_t" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DeviceInstanceRef" type="{http://knx.org/xml/project/20}DeviceInstanceRef_t" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Function" type="{http://knx.org/xml/project/20}Function_t" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="Name" use="required" type="{http://knx.org/xml/project/20}String255_t" />
 *       &lt;attribute name="Type" use="required" type="{http://knx.org/xml/project/20}SpaceType_t" />
 *       &lt;attribute name="Usage" type="{http://knx.org/xml/project/20}IDREF" />
 *       &lt;attribute name="Number" type="{http://knx.org/xml/project/20}String255_t" />
 *       &lt;attribute name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CompletionStatus" type="{http://knx.org/xml/project/20}CompletionStatus_t" default="Undefined" />
 *       &lt;attribute name="DefaultLine" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "Space_t", propOrder = {
    "space",
    "deviceInstanceRef",
    "function"
})
public class SpaceT {

    @XmlElement(name = "Space")
    protected List<SpaceT> space;
    @XmlElement(name = "DeviceInstanceRef")
    protected List<DeviceInstanceRefT> deviceInstanceRef;
    @XmlElement(name = "Function")
    protected List<FunctionT> function;
    @XmlAttribute(name = "Id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "Type", required = true)
    protected SpaceTypeT type;
    @XmlAttribute(name = "Usage")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String usage;
    @XmlAttribute(name = "Number")
    protected String number;
    @XmlAttribute(name = "Comment")
    protected String comment;
    @XmlAttribute(name = "Description")
    protected String description;
    @XmlAttribute(name = "CompletionStatus")
    protected CompletionStatusT completionStatus;
    @XmlAttribute(name = "DefaultLine")
    protected String defaultLine;
    @XmlAttribute(name = "Puid", required = true)
    protected int puid;
    @XmlAttribute(name = "Context")
    protected String context;

    /**
     * Gets the value of the space property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the space property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpace().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpaceT }
     * 
     * 
     */
    public List<SpaceT> getSpace() {
        if (space == null) {
            space = new ArrayList<SpaceT>();
        }
        return this.space;
    }

    /**
     * Gets the value of the deviceInstanceRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deviceInstanceRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeviceInstanceRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeviceInstanceRefT }
     * 
     * 
     */
    public List<DeviceInstanceRefT> getDeviceInstanceRef() {
        if (deviceInstanceRef == null) {
            deviceInstanceRef = new ArrayList<DeviceInstanceRefT>();
        }
        return this.deviceInstanceRef;
    }

    /**
     * Gets the value of the function property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the function property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFunction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FunctionT }
     * 
     * 
     */
    public List<FunctionT> getFunction() {
        if (function == null) {
            function = new ArrayList<FunctionT>();
        }
        return this.function;
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
     *     {@link SpaceTypeT }
     *     
     */
    public SpaceTypeT getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpaceTypeT }
     *     
     */
    public void setType(SpaceTypeT value) {
        this.type = value;
    }

    /**
     * Gets the value of the usage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsage() {
        return usage;
    }

    /**
     * Sets the value of the usage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsage(String value) {
        this.usage = value;
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
     * Gets the value of the defaultLine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultLine() {
        return defaultLine;
    }

    /**
     * Sets the value of the defaultLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultLine(String value) {
        this.defaultLine = value;
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
