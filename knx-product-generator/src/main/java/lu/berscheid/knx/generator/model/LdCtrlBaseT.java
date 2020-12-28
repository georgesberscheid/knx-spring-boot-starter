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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for LdCtrlBase_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LdCtrlBase_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OnError" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Cause" use="required" type="{http://knx.org/xml/project/20}LdCtrlErrorCause_t" />
 *                 &lt;attribute name="Ignore" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *                 &lt;attribute name="MessageRef" type="{http://knx.org/xml/project/20}IDREF" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="AppliesTo" type="{http://knx.org/xml/project/20}LdCtrlProcType_t" default="auto" />
 *       &lt;attribute name="InternalDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LdCtrlBase_t", propOrder = {
    "onError"
})
@XmlSeeAlso({
    LdCtrlLoadCompletedT.class,
    LdCtrlProgressTextT.class,
    LdCtrlClearLCFilterTableT.class,
    LdCtrlMasterResetT.class,
    LdCtrlMergeT.class,
    LdCtrlWriteMemT.class,
    LdCtrlAbsSegmentT.class,
    LdCtrlUnloadT.class,
    LdCtrlDisconnectT.class,
    LdCtrlLoadImageRelMemT.class,
    LdCtrlWritePropT.class,
    LdCtrlDeclarePropDescT.class,
    LdCtrlLoadImagePropT.class,
    LdCtrlLoadT.class,
    LdCtrlTaskCtrl2T.class,
    LdCtrlLoadImageMemT.class,
    LdCtrlMapErrorT.class,
    LdCtrlMaxLengthT.class,
    LdCtrlTaskPtrT.class,
    LdCtrlConnectT.class,
    LdCtrlTaskCtrl1T.class,
    LdCtrlRelSegmentT.class,
    LdCtrlRestartT.class,
    LdCtrlReadFunctionPropT.class,
    LdCtrlClearCachedObjectTypesT.class,
    LdCtrlTaskSegmentT.class,
    LdCtrlDelayT.class,
    LdCtrlInvokeFunctionPropT.class,
    LdCtrlWriteRelMemT.class,
    LdCtrlSetControlVariableT.class,
    LdCtrlCompareBaseT.class
})
public abstract class LdCtrlBaseT {

    @XmlElement(name = "OnError")
    protected List<LdCtrlBaseT.OnError> onError;
    @XmlAttribute(name = "AppliesTo")
    protected LdCtrlProcTypeT appliesTo;
    @XmlAttribute(name = "InternalDescription")
    protected String internalDescription;

    /**
     * Gets the value of the onError property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the onError property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOnError().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LdCtrlBaseT.OnError }
     * 
     * 
     */
    public List<LdCtrlBaseT.OnError> getOnError() {
        if (onError == null) {
            onError = new ArrayList<LdCtrlBaseT.OnError>();
        }
        return this.onError;
    }

    /**
     * Gets the value of the appliesTo property.
     * 
     * @return
     *     possible object is
     *     {@link LdCtrlProcTypeT }
     *     
     */
    public LdCtrlProcTypeT getAppliesTo() {
        if (appliesTo == null) {
            return LdCtrlProcTypeT.AUTO;
        } else {
            return appliesTo;
        }
    }

    /**
     * Sets the value of the appliesTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link LdCtrlProcTypeT }
     *     
     */
    public void setAppliesTo(LdCtrlProcTypeT value) {
        this.appliesTo = value;
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="Cause" use="required" type="{http://knx.org/xml/project/20}LdCtrlErrorCause_t" />
     *       &lt;attribute name="Ignore" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
     *       &lt;attribute name="MessageRef" type="{http://knx.org/xml/project/20}IDREF" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class OnError {

        @XmlAttribute(name = "Cause", required = true)
        protected LdCtrlErrorCauseT cause;
        @XmlAttribute(name = "Ignore")
        protected Boolean ignore;
        @XmlAttribute(name = "MessageRef")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String messageRef;

        /**
         * Gets the value of the cause property.
         * 
         * @return
         *     possible object is
         *     {@link LdCtrlErrorCauseT }
         *     
         */
        public LdCtrlErrorCauseT getCause() {
            return cause;
        }

        /**
         * Sets the value of the cause property.
         * 
         * @param value
         *     allowed object is
         *     {@link LdCtrlErrorCauseT }
         *     
         */
        public void setCause(LdCtrlErrorCauseT value) {
            this.cause = value;
        }

        /**
         * Gets the value of the ignore property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isIgnore() {
            if (ignore == null) {
                return false;
            } else {
                return ignore;
            }
        }

        /**
         * Sets the value of the ignore property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIgnore(Boolean value) {
            this.ignore = value;
        }

        /**
         * Gets the value of the messageRef property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMessageRef() {
            return messageRef;
        }

        /**
         * Sets the value of the messageRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMessageRef(String value) {
            this.messageRef = value;
        }

    }

}
