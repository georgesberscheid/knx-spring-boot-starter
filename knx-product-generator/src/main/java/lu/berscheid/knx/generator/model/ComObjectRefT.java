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
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for ComObjectRef_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComObjectRef_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="RefId" use="required" type="{http://knx.org/xml/project/20}IDREF" />
 *       &lt;attribute name="Name" type="{http://knx.org/xml/project/20}String255_t" />
 *       &lt;attribute name="Text" type="{http://knx.org/xml/project/20}LanguageDependentString255_t" />
 *       &lt;attribute name="Tag" type="{http://knx.org/xml/project/20}String50_t" />
 *       &lt;attribute name="FunctionText" type="{http://knx.org/xml/project/20}LanguageDependentString255_t" />
 *       &lt;attribute name="Priority" type="{http://knx.org/xml/project/20}ComObjectPriority_t" />
 *       &lt;attribute name="ObjectSize" type="{http://knx.org/xml/project/20}ComObjectSize_t" />
 *       &lt;attribute name="ReadFlag" type="{http://knx.org/xml/project/20}Enable_t" />
 *       &lt;attribute name="WriteFlag" type="{http://knx.org/xml/project/20}Enable_t" />
 *       &lt;attribute name="CommunicationFlag" type="{http://knx.org/xml/project/20}Enable_t" />
 *       &lt;attribute name="TransmitFlag" type="{http://knx.org/xml/project/20}Enable_t" />
 *       &lt;attribute name="UpdateFlag" type="{http://knx.org/xml/project/20}Enable_t" />
 *       &lt;attribute name="ReadOnInitFlag" type="{http://knx.org/xml/project/20}Enable_t" />
 *       &lt;attribute name="DatapointType" type="{http://knx.org/xml/project/20}IDREFS" />
 *       &lt;attribute name="TextParameterRefId" type="{http://knx.org/xml/project/20}IDREF" />
 *       &lt;attribute name="InternalDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Roles">
 *         &lt;simpleType>
 *           &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="SecurityRequired" type="{http://knx.org/xml/project/20}ComObjectSecurityRequirements_t" />
 *       &lt;attribute name="MayRead" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ReadFlagLocked" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="WriteFlagLocked" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="TransmitFlagLocked" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="UpdateFlagLocked" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ReadOnInitFlagLocked" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Semantics" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComObjectRef_t")
public class ComObjectRefT {

    @XmlAttribute(name = "Id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "RefId", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String refId;
    @XmlAttribute(name = "Name")
    protected String name;
    @XmlAttribute(name = "Text")
    protected String text;
    @XmlAttribute(name = "Tag")
    protected String tag;
    @XmlAttribute(name = "FunctionText")
    protected String functionText;
    @XmlAttribute(name = "Priority")
    protected ComObjectPriorityT priority;
    @XmlAttribute(name = "ObjectSize")
    protected String objectSize;
    @XmlAttribute(name = "ReadFlag")
    protected EnableT readFlag;
    @XmlAttribute(name = "WriteFlag")
    protected EnableT writeFlag;
    @XmlAttribute(name = "CommunicationFlag")
    protected EnableT communicationFlag;
    @XmlAttribute(name = "TransmitFlag")
    protected EnableT transmitFlag;
    @XmlAttribute(name = "UpdateFlag")
    protected EnableT updateFlag;
    @XmlAttribute(name = "ReadOnInitFlag")
    protected EnableT readOnInitFlag;
    @XmlAttribute(name = "DatapointType")
    protected List<String> datapointType;
    @XmlAttribute(name = "TextParameterRefId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String textParameterRefId;
    @XmlAttribute(name = "InternalDescription")
    protected String internalDescription;
    @XmlAttribute(name = "Roles")
    protected List<String> roles;
    @XmlAttribute(name = "SecurityRequired")
    protected ComObjectSecurityRequirementsT securityRequired;
    @XmlAttribute(name = "MayRead")
    protected Boolean mayRead;
    @XmlAttribute(name = "ReadFlagLocked")
    protected Boolean readFlagLocked;
    @XmlAttribute(name = "WriteFlagLocked")
    protected Boolean writeFlagLocked;
    @XmlAttribute(name = "TransmitFlagLocked")
    protected Boolean transmitFlagLocked;
    @XmlAttribute(name = "UpdateFlagLocked")
    protected Boolean updateFlagLocked;
    @XmlAttribute(name = "ReadOnInitFlagLocked")
    protected Boolean readOnInitFlagLocked;
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
     * Gets the value of the refId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefId() {
        return refId;
    }

    /**
     * Sets the value of the refId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefId(String value) {
        this.refId = value;
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
     * Gets the value of the tag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTag() {
        return tag;
    }

    /**
     * Sets the value of the tag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTag(String value) {
        this.tag = value;
    }

    /**
     * Gets the value of the functionText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunctionText() {
        return functionText;
    }

    /**
     * Sets the value of the functionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunctionText(String value) {
        this.functionText = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link ComObjectPriorityT }
     *     
     */
    public ComObjectPriorityT getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComObjectPriorityT }
     *     
     */
    public void setPriority(ComObjectPriorityT value) {
        this.priority = value;
    }

    /**
     * Gets the value of the objectSize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectSize() {
        return objectSize;
    }

    /**
     * Sets the value of the objectSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectSize(String value) {
        this.objectSize = value;
    }

    /**
     * Gets the value of the readFlag property.
     * 
     * @return
     *     possible object is
     *     {@link EnableT }
     *     
     */
    public EnableT getReadFlag() {
        return readFlag;
    }

    /**
     * Sets the value of the readFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnableT }
     *     
     */
    public void setReadFlag(EnableT value) {
        this.readFlag = value;
    }

    /**
     * Gets the value of the writeFlag property.
     * 
     * @return
     *     possible object is
     *     {@link EnableT }
     *     
     */
    public EnableT getWriteFlag() {
        return writeFlag;
    }

    /**
     * Sets the value of the writeFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnableT }
     *     
     */
    public void setWriteFlag(EnableT value) {
        this.writeFlag = value;
    }

    /**
     * Gets the value of the communicationFlag property.
     * 
     * @return
     *     possible object is
     *     {@link EnableT }
     *     
     */
    public EnableT getCommunicationFlag() {
        return communicationFlag;
    }

    /**
     * Sets the value of the communicationFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnableT }
     *     
     */
    public void setCommunicationFlag(EnableT value) {
        this.communicationFlag = value;
    }

    /**
     * Gets the value of the transmitFlag property.
     * 
     * @return
     *     possible object is
     *     {@link EnableT }
     *     
     */
    public EnableT getTransmitFlag() {
        return transmitFlag;
    }

    /**
     * Sets the value of the transmitFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnableT }
     *     
     */
    public void setTransmitFlag(EnableT value) {
        this.transmitFlag = value;
    }

    /**
     * Gets the value of the updateFlag property.
     * 
     * @return
     *     possible object is
     *     {@link EnableT }
     *     
     */
    public EnableT getUpdateFlag() {
        return updateFlag;
    }

    /**
     * Sets the value of the updateFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnableT }
     *     
     */
    public void setUpdateFlag(EnableT value) {
        this.updateFlag = value;
    }

    /**
     * Gets the value of the readOnInitFlag property.
     * 
     * @return
     *     possible object is
     *     {@link EnableT }
     *     
     */
    public EnableT getReadOnInitFlag() {
        return readOnInitFlag;
    }

    /**
     * Sets the value of the readOnInitFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnableT }
     *     
     */
    public void setReadOnInitFlag(EnableT value) {
        this.readOnInitFlag = value;
    }

    /**
     * Gets the value of the datapointType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datapointType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatapointType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDatapointType() {
        if (datapointType == null) {
            datapointType = new ArrayList<String>();
        }
        return this.datapointType;
    }

    /**
     * Gets the value of the textParameterRefId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextParameterRefId() {
        return textParameterRefId;
    }

    /**
     * Sets the value of the textParameterRefId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextParameterRefId(String value) {
        this.textParameterRefId = value;
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

    /**
     * Gets the value of the roles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getRoles() {
        if (roles == null) {
            roles = new ArrayList<String>();
        }
        return this.roles;
    }

    /**
     * Gets the value of the securityRequired property.
     * 
     * @return
     *     possible object is
     *     {@link ComObjectSecurityRequirementsT }
     *     
     */
    public ComObjectSecurityRequirementsT getSecurityRequired() {
        return securityRequired;
    }

    /**
     * Sets the value of the securityRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComObjectSecurityRequirementsT }
     *     
     */
    public void setSecurityRequired(ComObjectSecurityRequirementsT value) {
        this.securityRequired = value;
    }

    /**
     * Gets the value of the mayRead property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMayRead() {
        return mayRead;
    }

    /**
     * Sets the value of the mayRead property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMayRead(Boolean value) {
        this.mayRead = value;
    }

    /**
     * Gets the value of the readFlagLocked property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReadFlagLocked() {
        return readFlagLocked;
    }

    /**
     * Sets the value of the readFlagLocked property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReadFlagLocked(Boolean value) {
        this.readFlagLocked = value;
    }

    /**
     * Gets the value of the writeFlagLocked property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWriteFlagLocked() {
        return writeFlagLocked;
    }

    /**
     * Sets the value of the writeFlagLocked property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWriteFlagLocked(Boolean value) {
        this.writeFlagLocked = value;
    }

    /**
     * Gets the value of the transmitFlagLocked property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTransmitFlagLocked() {
        return transmitFlagLocked;
    }

    /**
     * Sets the value of the transmitFlagLocked property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTransmitFlagLocked(Boolean value) {
        this.transmitFlagLocked = value;
    }

    /**
     * Gets the value of the updateFlagLocked property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUpdateFlagLocked() {
        return updateFlagLocked;
    }

    /**
     * Sets the value of the updateFlagLocked property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUpdateFlagLocked(Boolean value) {
        this.updateFlagLocked = value;
    }

    /**
     * Gets the value of the readOnInitFlagLocked property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReadOnInitFlagLocked() {
        return readOnInitFlagLocked;
    }

    /**
     * Sets the value of the readOnInitFlagLocked property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReadOnInitFlagLocked(Boolean value) {
        this.readOnInitFlagLocked = value;
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