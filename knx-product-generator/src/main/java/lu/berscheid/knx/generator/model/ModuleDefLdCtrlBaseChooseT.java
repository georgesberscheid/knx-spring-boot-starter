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
 * <p>Java class for ModuleDefLdCtrlBaseChoose_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModuleDefLdCtrlBaseChoose_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="when" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://knx.org/xml/project/20}When_t">
 *                 &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *                   &lt;choice>
 *                     &lt;element name="LdCtrlWriteProp" type="{http://knx.org/xml/project/20}ModuleDefLdCtrlWriteProp_t"/>
 *                     &lt;element name="LdCtrlCompareProp" type="{http://knx.org/xml/project/20}ModuleDefLdCtrlCompareProp_t"/>
 *                     &lt;element name="LdCtrlInvokeFunctionProp" type="{http://knx.org/xml/project/20}ModuleDefLdCtrlInvokeFunctionProp_t"/>
 *                     &lt;element name="LdCtrlReadFunctionProp" type="{http://knx.org/xml/project/20}ModuleDefLdCtrlReadFunctionProp_t"/>
 *                     &lt;element name="LdCtrlDelay" type="{http://knx.org/xml/project/20}LdCtrlDelay_t"/>
 *                     &lt;element name="LdCtrlProgressText" type="{http://knx.org/xml/project/20}LdCtrlProgressText_t"/>
 *                     &lt;element name="LdCtrlDeclarePropDesc" type="{http://knx.org/xml/project/20}LdCtrlDeclarePropDesc_t"/>
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
@XmlType(name = "ModuleDefLdCtrlBaseChoose_t", propOrder = {
    "when"
})
public class ModuleDefLdCtrlBaseChooseT {

    @XmlElement(required = true)
    protected List<ModuleDefLdCtrlBaseChooseT.When> when;
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
     * {@link ModuleDefLdCtrlBaseChooseT.When }
     * 
     * 
     */
    public List<ModuleDefLdCtrlBaseChooseT.When> getWhen() {
        if (when == null) {
            when = new ArrayList<ModuleDefLdCtrlBaseChooseT.When>();
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
     *           &lt;element name="LdCtrlWriteProp" type="{http://knx.org/xml/project/20}ModuleDefLdCtrlWriteProp_t"/>
     *           &lt;element name="LdCtrlCompareProp" type="{http://knx.org/xml/project/20}ModuleDefLdCtrlCompareProp_t"/>
     *           &lt;element name="LdCtrlInvokeFunctionProp" type="{http://knx.org/xml/project/20}ModuleDefLdCtrlInvokeFunctionProp_t"/>
     *           &lt;element name="LdCtrlReadFunctionProp" type="{http://knx.org/xml/project/20}ModuleDefLdCtrlReadFunctionProp_t"/>
     *           &lt;element name="LdCtrlDelay" type="{http://knx.org/xml/project/20}LdCtrlDelay_t"/>
     *           &lt;element name="LdCtrlProgressText" type="{http://knx.org/xml/project/20}LdCtrlProgressText_t"/>
     *           &lt;element name="LdCtrlDeclarePropDesc" type="{http://knx.org/xml/project/20}LdCtrlDeclarePropDesc_t"/>
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
        "ldCtrlWritePropOrLdCtrlComparePropOrLdCtrlInvokeFunctionProp"
    })
    public static class When
        extends WhenT
    {

        @XmlElements({
            @XmlElement(name = "LdCtrlWriteProp", type = ModuleDefLdCtrlWritePropT.class),
            @XmlElement(name = "LdCtrlCompareProp", type = ModuleDefLdCtrlComparePropT.class),
            @XmlElement(name = "LdCtrlInvokeFunctionProp", type = ModuleDefLdCtrlInvokeFunctionPropT.class),
            @XmlElement(name = "LdCtrlReadFunctionProp", type = ModuleDefLdCtrlReadFunctionPropT.class),
            @XmlElement(name = "LdCtrlDelay", type = LdCtrlDelayT.class),
            @XmlElement(name = "LdCtrlProgressText", type = LdCtrlProgressTextT.class),
            @XmlElement(name = "LdCtrlDeclarePropDesc", type = LdCtrlDeclarePropDescT.class),
            @XmlElement(name = "LdCtrlMerge", type = LdCtrlMergeT.class),
            @XmlElement(name = "choose", type = LdCtrlBaseChooseT.class)
        })
        protected List<Object> ldCtrlWritePropOrLdCtrlComparePropOrLdCtrlInvokeFunctionProp;

        /**
         * Gets the value of the ldCtrlWritePropOrLdCtrlComparePropOrLdCtrlInvokeFunctionProp property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ldCtrlWritePropOrLdCtrlComparePropOrLdCtrlInvokeFunctionProp property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLdCtrlWritePropOrLdCtrlComparePropOrLdCtrlInvokeFunctionProp().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ModuleDefLdCtrlWritePropT }
         * {@link ModuleDefLdCtrlComparePropT }
         * {@link ModuleDefLdCtrlInvokeFunctionPropT }
         * {@link ModuleDefLdCtrlReadFunctionPropT }
         * {@link LdCtrlDelayT }
         * {@link LdCtrlProgressTextT }
         * {@link LdCtrlDeclarePropDescT }
         * {@link LdCtrlMergeT }
         * {@link LdCtrlBaseChooseT }
         * 
         * 
         */
        public List<Object> getLdCtrlWritePropOrLdCtrlComparePropOrLdCtrlInvokeFunctionProp() {
            if (ldCtrlWritePropOrLdCtrlComparePropOrLdCtrlInvokeFunctionProp == null) {
                ldCtrlWritePropOrLdCtrlComparePropOrLdCtrlInvokeFunctionProp = new ArrayList<Object>();
            }
            return this.ldCtrlWritePropOrLdCtrlComparePropOrLdCtrlInvokeFunctionProp;
        }

    }

}
