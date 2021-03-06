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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ModuleDefDynamic_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModuleDefDynamic_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="ChannelIndependentBlock" type="{http://knx.org/xml/project/20}ChannelIndependentBlock_t"/>
 *         &lt;element name="Channel" type="{http://knx.org/xml/project/20}ApplicationProgramChannel_t"/>
 *         &lt;element name="choose" type="{http://knx.org/xml/project/20}DependentChannelChoose_t"/>
 *         &lt;element name="Module" type="{http://knx.org/xml/project/20}Module_t"/>
 *         &lt;element name="Repeat" type="{http://knx.org/xml/project/20}Repeat_t"/>
 *         &lt;element name="ParameterBlock" type="{http://knx.org/xml/project/20}ComObjectParameterBlock_t"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModuleDefDynamic_t", propOrder = {
    "channelIndependentBlockOrChannelOrChoose"
})
public class ModuleDefDynamicT {

    @XmlElements({
        @XmlElement(name = "ChannelIndependentBlock", type = ChannelIndependentBlockT.class),
        @XmlElement(name = "Channel", type = ApplicationProgramChannelT.class),
        @XmlElement(name = "choose", type = DependentChannelChooseT.class),
        @XmlElement(name = "Module", type = ModuleT.class),
        @XmlElement(name = "Repeat", type = RepeatT.class),
        @XmlElement(name = "ParameterBlock", type = ComObjectParameterBlockT.class)
    })
    protected List<Object> channelIndependentBlockOrChannelOrChoose;

    /**
     * Gets the value of the channelIndependentBlockOrChannelOrChoose property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the channelIndependentBlockOrChannelOrChoose property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChannelIndependentBlockOrChannelOrChoose().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChannelIndependentBlockT }
     * {@link ApplicationProgramChannelT }
     * {@link DependentChannelChooseT }
     * {@link ModuleT }
     * {@link RepeatT }
     * {@link ComObjectParameterBlockT }
     * 
     * 
     */
    public List<Object> getChannelIndependentBlockOrChannelOrChoose() {
        if (channelIndependentBlockOrChannelOrChoose == null) {
            channelIndependentBlockOrChannelOrChoose = new ArrayList<Object>();
        }
        return this.channelIndependentBlockOrChannelOrChoose;
    }

}
