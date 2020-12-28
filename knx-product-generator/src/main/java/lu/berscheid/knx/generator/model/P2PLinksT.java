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
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for P2PLinks_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="P2PLinks_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="P2PLink" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="2">
 *                   &lt;choice>
 *                     &lt;element name="DeviceEndpoint" type="{http://knx.org/xml/project/20}P2PLinkDeviceEndpoint_t"/>
 *                     &lt;element name="BusInterfaceEndpoint" type="{http://knx.org/xml/project/20}P2PLinkBusInterfaceEndpoint_t"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *                 &lt;attribute name="Name" type="{http://knx.org/xml/project/20}String255_t" />
 *                 &lt;attribute name="Description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Puid" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="Key" type="{http://knx.org/xml/project/20}Aes128Key_t" />
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
@XmlType(name = "P2PLinks_t", propOrder = {
    "p2PLink"
})
public class P2PLinksT {

    @XmlElement(name = "P2PLink", required = true)
    protected List<P2PLinksT.P2PLink> p2PLink;

    /**
     * Gets the value of the p2PLink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the p2PLink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getP2PLink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link P2PLinksT.P2PLink }
     * 
     * 
     */
    public List<P2PLinksT.P2PLink> getP2PLink() {
        if (p2PLink == null) {
            p2PLink = new ArrayList<P2PLinksT.P2PLink>();
        }
        return this.p2PLink;
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
     *       &lt;sequence maxOccurs="2">
     *         &lt;choice>
     *           &lt;element name="DeviceEndpoint" type="{http://knx.org/xml/project/20}P2PLinkDeviceEndpoint_t"/>
     *           &lt;element name="BusInterfaceEndpoint" type="{http://knx.org/xml/project/20}P2PLinkBusInterfaceEndpoint_t"/>
     *         &lt;/choice>
     *       &lt;/sequence>
     *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
     *       &lt;attribute name="Name" type="{http://knx.org/xml/project/20}String255_t" />
     *       &lt;attribute name="Description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Puid" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="Key" type="{http://knx.org/xml/project/20}Aes128Key_t" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "deviceEndpointOrBusInterfaceEndpoint"
    })
    public static class P2PLink {

        @XmlElements({
            @XmlElement(name = "DeviceEndpoint", type = P2PLinkDeviceEndpointT.class),
            @XmlElement(name = "BusInterfaceEndpoint", type = P2PLinkBusInterfaceEndpointT.class)
        })
        protected List<P2PLinkEndpointT> deviceEndpointOrBusInterfaceEndpoint;
        @XmlAttribute(name = "Id", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlID
        @XmlSchemaType(name = "ID")
        protected String id;
        @XmlAttribute(name = "Name")
        protected String name;
        @XmlAttribute(name = "Description")
        protected String description;
        @XmlAttribute(name = "Comment")
        protected String comment;
        @XmlAttribute(name = "Puid", required = true)
        protected int puid;
        @XmlAttribute(name = "Key")
        protected String key;

        /**
         * Gets the value of the deviceEndpointOrBusInterfaceEndpoint property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the deviceEndpointOrBusInterfaceEndpoint property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDeviceEndpointOrBusInterfaceEndpoint().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link P2PLinkDeviceEndpointT }
         * {@link P2PLinkBusInterfaceEndpointT }
         * 
         * 
         */
        public List<P2PLinkEndpointT> getDeviceEndpointOrBusInterfaceEndpoint() {
            if (deviceEndpointOrBusInterfaceEndpoint == null) {
                deviceEndpointOrBusInterfaceEndpoint = new ArrayList<P2PLinkEndpointT>();
            }
            return this.deviceEndpointOrBusInterfaceEndpoint;
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

    }

}