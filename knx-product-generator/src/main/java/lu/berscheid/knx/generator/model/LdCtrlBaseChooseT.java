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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for LdCtrlBaseChoose_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LdCtrlBaseChoose_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="when" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://knx.org/xml/project/20}When_t">
 *                 &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *                   &lt;choice>
 *                     &lt;element name="LdCtrlUnload" type="{http://knx.org/xml/project/20}LdCtrlUnload_t"/>
 *                     &lt;element name="LdCtrlLoad" type="{http://knx.org/xml/project/20}LdCtrlLoad_t"/>
 *                     &lt;element name="LdCtrlMaxLength" type="{http://knx.org/xml/project/20}LdCtrlMaxLength_t"/>
 *                     &lt;element name="LdCtrlClearCachedObjectTypes" type="{http://knx.org/xml/project/20}LdCtrlClearCachedObjectTypes_t"/>
 *                     &lt;element name="LdCtrlLoadCompleted" type="{http://knx.org/xml/project/20}LdCtrlLoadCompleted_t"/>
 *                     &lt;element name="LdCtrlAbsSegment" type="{http://knx.org/xml/project/20}LdCtrlAbsSegment_t"/>
 *                     &lt;element name="LdCtrlRelSegment" type="{http://knx.org/xml/project/20}LdCtrlRelSegment_t"/>
 *                     &lt;element name="LdCtrlTaskSegment" type="{http://knx.org/xml/project/20}LdCtrlTaskSegment_t"/>
 *                     &lt;element name="LdCtrlTaskPtr" type="{http://knx.org/xml/project/20}LdCtrlTaskPtr_t"/>
 *                     &lt;element name="LdCtrlTaskCtrl1" type="{http://knx.org/xml/project/20}LdCtrlTaskCtrl1_t"/>
 *                     &lt;element name="LdCtrlTaskCtrl2" type="{http://knx.org/xml/project/20}LdCtrlTaskCtrl2_t"/>
 *                     &lt;element name="LdCtrlWriteProp" type="{http://knx.org/xml/project/20}LdCtrlWriteProp_t"/>
 *                     &lt;element name="LdCtrlCompareProp" type="{http://knx.org/xml/project/20}LdCtrlCompareProp_t"/>
 *                     &lt;element name="LdCtrlLoadImageProp" type="{http://knx.org/xml/project/20}LdCtrlLoadImageProp_t"/>
 *                     &lt;element name="LdCtrlInvokeFunctionProp" type="{http://knx.org/xml/project/20}LdCtrlInvokeFunctionProp_t"/>
 *                     &lt;element name="LdCtrlReadFunctionProp" type="{http://knx.org/xml/project/20}LdCtrlReadFunctionProp_t"/>
 *                     &lt;element name="LdCtrlWriteMem" type="{http://knx.org/xml/project/20}LdCtrlWriteMem_t"/>
 *                     &lt;element name="LdCtrlCompareMem" type="{http://knx.org/xml/project/20}LdCtrlCompareMem_t"/>
 *                     &lt;element name="LdCtrlLoadImageMem" type="{http://knx.org/xml/project/20}LdCtrlLoadImageMem_t"/>
 *                     &lt;element name="LdCtrlWriteRelMem" type="{http://knx.org/xml/project/20}LdCtrlWriteRelMem_t"/>
 *                     &lt;element name="LdCtrlCompareRelMem" type="{http://knx.org/xml/project/20}LdCtrlCompareRelMem_t"/>
 *                     &lt;element name="LdCtrlLoadImageRelMem" type="{http://knx.org/xml/project/20}LdCtrlLoadImageRelMem_t"/>
 *                     &lt;element name="LdCtrlConnect" type="{http://knx.org/xml/project/20}LdCtrlConnect_t"/>
 *                     &lt;element name="LdCtrlDisconnect" type="{http://knx.org/xml/project/20}LdCtrlDisconnect_t"/>
 *                     &lt;element name="LdCtrlRestart" type="{http://knx.org/xml/project/20}LdCtrlRestart_t"/>
 *                     &lt;element name="LdCtrlMasterReset" type="{http://knx.org/xml/project/20}LdCtrlMasterReset_t"/>
 *                     &lt;element name="LdCtrlDelay" type="{http://knx.org/xml/project/20}LdCtrlDelay_t"/>
 *                     &lt;element name="LdCtrlSetControlVariable" type="{http://knx.org/xml/project/20}LdCtrlSetControlVariable_t"/>
 *                     &lt;element name="LdCtrlMapError" type="{http://knx.org/xml/project/20}LdCtrlMapError_t"/>
 *                     &lt;element name="LdCtrlProgressText" type="{http://knx.org/xml/project/20}LdCtrlProgressText_t"/>
 *                     &lt;element name="LdCtrlDeclarePropDesc" type="{http://knx.org/xml/project/20}LdCtrlDeclarePropDesc_t"/>
 *                     &lt;element name="LdCtrlClearLCFilterTable" type="{http://knx.org/xml/project/20}LdCtrlClearLCFilterTable_t"/>
 *                     &lt;element name="LdCtrlMerge" type="{http://knx.org/xml/project/20}LdCtrlMerge_t"/>
 *                     &lt;element name="choose" type="{http://knx.org/xml/project/20}LdCtrlBaseChoose_t"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="ParamRefId" use="required" type="{http://knx.org/xml/project/20}IDREF" />
 *       &lt;attribute name="InternalDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LdCtrlBaseChoose_t", propOrder = {
    "when"
})
public class LdCtrlBaseChooseT {

    @XmlElement(required = true)
    protected List<LdCtrlBaseChooseT.When> when;
    @XmlAttribute(name = "ParamRefId", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String paramRefId;
    @XmlAttribute(name = "InternalDescription")
    protected String internalDescription;

    /**
     * Gets the value of the when property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the when property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWhen().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LdCtrlBaseChooseT.When }
     * 
     * 
     */
    public List<LdCtrlBaseChooseT.When> getWhen() {
        if (when == null) {
            when = new ArrayList<LdCtrlBaseChooseT.When>();
        }
        return this.when;
    }

    /**
     * Gets the value of the paramRefId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParamRefId() {
        return paramRefId;
    }

    /**
     * Sets the value of the paramRefId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParamRefId(String value) {
        this.paramRefId = value;
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
     *     &lt;extension base="{http://knx.org/xml/project/20}When_t">
     *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
     *         &lt;choice>
     *           &lt;element name="LdCtrlUnload" type="{http://knx.org/xml/project/20}LdCtrlUnload_t"/>
     *           &lt;element name="LdCtrlLoad" type="{http://knx.org/xml/project/20}LdCtrlLoad_t"/>
     *           &lt;element name="LdCtrlMaxLength" type="{http://knx.org/xml/project/20}LdCtrlMaxLength_t"/>
     *           &lt;element name="LdCtrlClearCachedObjectTypes" type="{http://knx.org/xml/project/20}LdCtrlClearCachedObjectTypes_t"/>
     *           &lt;element name="LdCtrlLoadCompleted" type="{http://knx.org/xml/project/20}LdCtrlLoadCompleted_t"/>
     *           &lt;element name="LdCtrlAbsSegment" type="{http://knx.org/xml/project/20}LdCtrlAbsSegment_t"/>
     *           &lt;element name="LdCtrlRelSegment" type="{http://knx.org/xml/project/20}LdCtrlRelSegment_t"/>
     *           &lt;element name="LdCtrlTaskSegment" type="{http://knx.org/xml/project/20}LdCtrlTaskSegment_t"/>
     *           &lt;element name="LdCtrlTaskPtr" type="{http://knx.org/xml/project/20}LdCtrlTaskPtr_t"/>
     *           &lt;element name="LdCtrlTaskCtrl1" type="{http://knx.org/xml/project/20}LdCtrlTaskCtrl1_t"/>
     *           &lt;element name="LdCtrlTaskCtrl2" type="{http://knx.org/xml/project/20}LdCtrlTaskCtrl2_t"/>
     *           &lt;element name="LdCtrlWriteProp" type="{http://knx.org/xml/project/20}LdCtrlWriteProp_t"/>
     *           &lt;element name="LdCtrlCompareProp" type="{http://knx.org/xml/project/20}LdCtrlCompareProp_t"/>
     *           &lt;element name="LdCtrlLoadImageProp" type="{http://knx.org/xml/project/20}LdCtrlLoadImageProp_t"/>
     *           &lt;element name="LdCtrlInvokeFunctionProp" type="{http://knx.org/xml/project/20}LdCtrlInvokeFunctionProp_t"/>
     *           &lt;element name="LdCtrlReadFunctionProp" type="{http://knx.org/xml/project/20}LdCtrlReadFunctionProp_t"/>
     *           &lt;element name="LdCtrlWriteMem" type="{http://knx.org/xml/project/20}LdCtrlWriteMem_t"/>
     *           &lt;element name="LdCtrlCompareMem" type="{http://knx.org/xml/project/20}LdCtrlCompareMem_t"/>
     *           &lt;element name="LdCtrlLoadImageMem" type="{http://knx.org/xml/project/20}LdCtrlLoadImageMem_t"/>
     *           &lt;element name="LdCtrlWriteRelMem" type="{http://knx.org/xml/project/20}LdCtrlWriteRelMem_t"/>
     *           &lt;element name="LdCtrlCompareRelMem" type="{http://knx.org/xml/project/20}LdCtrlCompareRelMem_t"/>
     *           &lt;element name="LdCtrlLoadImageRelMem" type="{http://knx.org/xml/project/20}LdCtrlLoadImageRelMem_t"/>
     *           &lt;element name="LdCtrlConnect" type="{http://knx.org/xml/project/20}LdCtrlConnect_t"/>
     *           &lt;element name="LdCtrlDisconnect" type="{http://knx.org/xml/project/20}LdCtrlDisconnect_t"/>
     *           &lt;element name="LdCtrlRestart" type="{http://knx.org/xml/project/20}LdCtrlRestart_t"/>
     *           &lt;element name="LdCtrlMasterReset" type="{http://knx.org/xml/project/20}LdCtrlMasterReset_t"/>
     *           &lt;element name="LdCtrlDelay" type="{http://knx.org/xml/project/20}LdCtrlDelay_t"/>
     *           &lt;element name="LdCtrlSetControlVariable" type="{http://knx.org/xml/project/20}LdCtrlSetControlVariable_t"/>
     *           &lt;element name="LdCtrlMapError" type="{http://knx.org/xml/project/20}LdCtrlMapError_t"/>
     *           &lt;element name="LdCtrlProgressText" type="{http://knx.org/xml/project/20}LdCtrlProgressText_t"/>
     *           &lt;element name="LdCtrlDeclarePropDesc" type="{http://knx.org/xml/project/20}LdCtrlDeclarePropDesc_t"/>
     *           &lt;element name="LdCtrlClearLCFilterTable" type="{http://knx.org/xml/project/20}LdCtrlClearLCFilterTable_t"/>
     *           &lt;element name="LdCtrlMerge" type="{http://knx.org/xml/project/20}LdCtrlMerge_t"/>
     *           &lt;element name="choose" type="{http://knx.org/xml/project/20}LdCtrlBaseChoose_t"/>
     *         &lt;/choice>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ldCtrlUnloadOrLdCtrlLoadOrLdCtrlMaxLength"
    })
    public static class When
        extends WhenT
    {

        @XmlElements({
            @XmlElement(name = "LdCtrlUnload", type = LdCtrlUnloadT.class),
            @XmlElement(name = "LdCtrlLoad", type = LdCtrlLoadT.class),
            @XmlElement(name = "LdCtrlMaxLength", type = LdCtrlMaxLengthT.class),
            @XmlElement(name = "LdCtrlClearCachedObjectTypes", type = LdCtrlClearCachedObjectTypesT.class),
            @XmlElement(name = "LdCtrlLoadCompleted", type = LdCtrlLoadCompletedT.class),
            @XmlElement(name = "LdCtrlAbsSegment", type = LdCtrlAbsSegmentT.class),
            @XmlElement(name = "LdCtrlRelSegment", type = LdCtrlRelSegmentT.class),
            @XmlElement(name = "LdCtrlTaskSegment", type = LdCtrlTaskSegmentT.class),
            @XmlElement(name = "LdCtrlTaskPtr", type = LdCtrlTaskPtrT.class),
            @XmlElement(name = "LdCtrlTaskCtrl1", type = LdCtrlTaskCtrl1T.class),
            @XmlElement(name = "LdCtrlTaskCtrl2", type = LdCtrlTaskCtrl2T.class),
            @XmlElement(name = "LdCtrlWriteProp", type = LdCtrlWritePropT.class),
            @XmlElement(name = "LdCtrlCompareProp", type = LdCtrlComparePropT.class),
            @XmlElement(name = "LdCtrlLoadImageProp", type = LdCtrlLoadImagePropT.class),
            @XmlElement(name = "LdCtrlInvokeFunctionProp", type = LdCtrlInvokeFunctionPropT.class),
            @XmlElement(name = "LdCtrlReadFunctionProp", type = LdCtrlReadFunctionPropT.class),
            @XmlElement(name = "LdCtrlWriteMem", type = LdCtrlWriteMemT.class),
            @XmlElement(name = "LdCtrlCompareMem", type = LdCtrlCompareMemT.class),
            @XmlElement(name = "LdCtrlLoadImageMem", type = LdCtrlLoadImageMemT.class),
            @XmlElement(name = "LdCtrlWriteRelMem", type = LdCtrlWriteRelMemT.class),
            @XmlElement(name = "LdCtrlCompareRelMem", type = LdCtrlCompareRelMemT.class),
            @XmlElement(name = "LdCtrlLoadImageRelMem", type = LdCtrlLoadImageRelMemT.class),
            @XmlElement(name = "LdCtrlConnect", type = LdCtrlConnectT.class),
            @XmlElement(name = "LdCtrlDisconnect", type = LdCtrlDisconnectT.class),
            @XmlElement(name = "LdCtrlRestart", type = LdCtrlRestartT.class),
            @XmlElement(name = "LdCtrlMasterReset", type = LdCtrlMasterResetT.class),
            @XmlElement(name = "LdCtrlDelay", type = LdCtrlDelayT.class),
            @XmlElement(name = "LdCtrlSetControlVariable", type = LdCtrlSetControlVariableT.class),
            @XmlElement(name = "LdCtrlMapError", type = LdCtrlMapErrorT.class),
            @XmlElement(name = "LdCtrlProgressText", type = LdCtrlProgressTextT.class),
            @XmlElement(name = "LdCtrlDeclarePropDesc", type = LdCtrlDeclarePropDescT.class),
            @XmlElement(name = "LdCtrlClearLCFilterTable", type = LdCtrlClearLCFilterTableT.class),
            @XmlElement(name = "LdCtrlMerge", type = LdCtrlMergeT.class),
            @XmlElement(name = "choose", type = LdCtrlBaseChooseT.class)
        })
        protected List<Object> ldCtrlUnloadOrLdCtrlLoadOrLdCtrlMaxLength;

        /**
         * Gets the value of the ldCtrlUnloadOrLdCtrlLoadOrLdCtrlMaxLength property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ldCtrlUnloadOrLdCtrlLoadOrLdCtrlMaxLength property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLdCtrlUnloadOrLdCtrlLoadOrLdCtrlMaxLength().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link LdCtrlUnloadT }
         * {@link LdCtrlLoadT }
         * {@link LdCtrlMaxLengthT }
         * {@link LdCtrlClearCachedObjectTypesT }
         * {@link LdCtrlLoadCompletedT }
         * {@link LdCtrlAbsSegmentT }
         * {@link LdCtrlRelSegmentT }
         * {@link LdCtrlTaskSegmentT }
         * {@link LdCtrlTaskPtrT }
         * {@link LdCtrlTaskCtrl1T }
         * {@link LdCtrlTaskCtrl2T }
         * {@link LdCtrlWritePropT }
         * {@link LdCtrlComparePropT }
         * {@link LdCtrlLoadImagePropT }
         * {@link LdCtrlInvokeFunctionPropT }
         * {@link LdCtrlReadFunctionPropT }
         * {@link LdCtrlWriteMemT }
         * {@link LdCtrlCompareMemT }
         * {@link LdCtrlLoadImageMemT }
         * {@link LdCtrlWriteRelMemT }
         * {@link LdCtrlCompareRelMemT }
         * {@link LdCtrlLoadImageRelMemT }
         * {@link LdCtrlConnectT }
         * {@link LdCtrlDisconnectT }
         * {@link LdCtrlRestartT }
         * {@link LdCtrlMasterResetT }
         * {@link LdCtrlDelayT }
         * {@link LdCtrlSetControlVariableT }
         * {@link LdCtrlMapErrorT }
         * {@link LdCtrlProgressTextT }
         * {@link LdCtrlDeclarePropDescT }
         * {@link LdCtrlClearLCFilterTableT }
         * {@link LdCtrlMergeT }
         * {@link LdCtrlBaseChooseT }
         * 
         * 
         */
        public List<Object> getLdCtrlUnloadOrLdCtrlLoadOrLdCtrlMaxLength() {
            if (ldCtrlUnloadOrLdCtrlLoadOrLdCtrlMaxLength == null) {
                ldCtrlUnloadOrLdCtrlLoadOrLdCtrlMaxLength = new ArrayList<Object>();
            }
            return this.ldCtrlUnloadOrLdCtrlLoadOrLdCtrlMaxLength;
        }

    }

}
