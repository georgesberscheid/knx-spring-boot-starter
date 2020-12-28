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
 * <p>Java class for ChannelChoose_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChannelChoose_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="when" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://knx.org/xml/project/20}When_t">
 *                 &lt;choice maxOccurs="unbounded" minOccurs="0">
 *                   &lt;element name="ParameterBlock" type="{http://knx.org/xml/project/20}ComObjectParameterBlock_t"/>
 *                   &lt;element name="ComObjectRefRef" type="{http://knx.org/xml/project/20}ComObjectRefRef_t"/>
 *                   &lt;element name="BinaryDataRef" type="{http://knx.org/xml/project/20}BinaryDataRef_t"/>
 *                   &lt;element name="Module" type="{http://knx.org/xml/project/20}Module_t"/>
 *                   &lt;element name="Repeat" type="{http://knx.org/xml/project/20}Repeat_t"/>
 *                   &lt;element name="choose" type="{http://knx.org/xml/project/20}ChannelChoose_t"/>
 *                   &lt;element name="Rename" type="{http://knx.org/xml/project/20}Rename_t"/>
 *                 &lt;/choice>
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
@XmlType(name = "ChannelChoose_t", propOrder = {
    "when"
})
public class ChannelChooseT {

    @XmlElement(required = true)
    protected List<ChannelChooseT.When> when;
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
     * {@link ChannelChooseT.When }
     * 
     * 
     */
    public List<ChannelChooseT.When> getWhen() {
        if (when == null) {
            when = new ArrayList<ChannelChooseT.When>();
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
     *       &lt;choice maxOccurs="unbounded" minOccurs="0">
     *         &lt;element name="ParameterBlock" type="{http://knx.org/xml/project/20}ComObjectParameterBlock_t"/>
     *         &lt;element name="ComObjectRefRef" type="{http://knx.org/xml/project/20}ComObjectRefRef_t"/>
     *         &lt;element name="BinaryDataRef" type="{http://knx.org/xml/project/20}BinaryDataRef_t"/>
     *         &lt;element name="Module" type="{http://knx.org/xml/project/20}Module_t"/>
     *         &lt;element name="Repeat" type="{http://knx.org/xml/project/20}Repeat_t"/>
     *         &lt;element name="choose" type="{http://knx.org/xml/project/20}ChannelChoose_t"/>
     *         &lt;element name="Rename" type="{http://knx.org/xml/project/20}Rename_t"/>
     *       &lt;/choice>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "parameterBlockOrComObjectRefRefOrBinaryDataRef"
    })
    public static class When
        extends WhenT
    {

        @XmlElements({
            @XmlElement(name = "ParameterBlock", type = ComObjectParameterBlockT.class),
            @XmlElement(name = "ComObjectRefRef", type = ComObjectRefRefT.class),
            @XmlElement(name = "BinaryDataRef", type = BinaryDataRefT.class),
            @XmlElement(name = "Module", type = ModuleT.class),
            @XmlElement(name = "Repeat", type = RepeatT.class),
            @XmlElement(name = "choose", type = ChannelChooseT.class),
            @XmlElement(name = "Rename", type = RenameT.class)
        })
        protected List<Object> parameterBlockOrComObjectRefRefOrBinaryDataRef;

        /**
         * Gets the value of the parameterBlockOrComObjectRefRefOrBinaryDataRef property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the parameterBlockOrComObjectRefRefOrBinaryDataRef property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getParameterBlockOrComObjectRefRefOrBinaryDataRef().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ComObjectParameterBlockT }
         * {@link ComObjectRefRefT }
         * {@link BinaryDataRefT }
         * {@link ModuleT }
         * {@link RepeatT }
         * {@link ChannelChooseT }
         * {@link RenameT }
         * 
         * 
         */
        public List<Object> getParameterBlockOrComObjectRefRefOrBinaryDataRef() {
            if (parameterBlockOrComObjectRefRefOrBinaryDataRef == null) {
                parameterBlockOrComObjectRefRefOrBinaryDataRef = new ArrayList<Object>();
            }
            return this.parameterBlockOrComObjectRefRefOrBinaryDataRef;
        }

    }

}