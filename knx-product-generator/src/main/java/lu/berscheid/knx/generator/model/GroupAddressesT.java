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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GroupAddresses_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GroupAddresses_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GroupRanges">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="GroupRange" type="{http://knx.org/xml/project/20}GroupRange_t" maxOccurs="65535" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupAddresses_t", propOrder = {
    "groupRanges"
})
public class GroupAddressesT {

    @XmlElement(name = "GroupRanges", required = true)
    protected GroupAddressesT.GroupRanges groupRanges;

    /**
     * Gets the value of the groupRanges property.
     * 
     * @return
     *     possible object is
     *     {@link GroupAddressesT.GroupRanges }
     *     
     */
    public GroupAddressesT.GroupRanges getGroupRanges() {
        return groupRanges;
    }

    /**
     * Sets the value of the groupRanges property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupAddressesT.GroupRanges }
     *     
     */
    public void setGroupRanges(GroupAddressesT.GroupRanges value) {
        this.groupRanges = value;
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
     *       &lt;sequence>
     *         &lt;element name="GroupRange" type="{http://knx.org/xml/project/20}GroupRange_t" maxOccurs="65535" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "groupRange"
    })
    public static class GroupRanges {

        @XmlElement(name = "GroupRange")
        protected List<GroupRangeT> groupRange;

        /**
         * Gets the value of the groupRange property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the groupRange property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGroupRange().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GroupRangeT }
         * 
         * 
         */
        public List<GroupRangeT> getGroupRange() {
            if (groupRange == null) {
                groupRange = new ArrayList<GroupRangeT>();
            }
            return this.groupRange;
        }

    }

}
