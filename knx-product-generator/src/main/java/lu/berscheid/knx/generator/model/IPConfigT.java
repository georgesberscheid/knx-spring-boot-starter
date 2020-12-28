//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.10.05 at 10:56:00 PM CEST 
//


package lu.berscheid.knx.generator.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IPConfig_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IPConfig_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Assign" type="{http://knx.org/xml/project/20}IPConfigAssign_t" default="Auto" />
 *       &lt;attribute name="IPAddress" type="{http://knx.org/xml/project/20}Ipv4Address_t" />
 *       &lt;attribute name="SubnetMask" type="{http://knx.org/xml/project/20}Ipv4Address_t" />
 *       &lt;attribute name="DefaultGateway" type="{http://knx.org/xml/project/20}Ipv4Address_t" />
 *       &lt;attribute name="MACAddress" type="{http://knx.org/xml/project/20}String50_t" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IPConfig_t")
public class IPConfigT {

    @XmlAttribute(name = "Assign")
    protected IPConfigAssignT assign;
    @XmlAttribute(name = "IPAddress")
    protected String ipAddress;
    @XmlAttribute(name = "SubnetMask")
    protected String subnetMask;
    @XmlAttribute(name = "DefaultGateway")
    protected String defaultGateway;
    @XmlAttribute(name = "MACAddress")
    protected String macAddress;

    /**
     * Gets the value of the assign property.
     * 
     * @return
     *     possible object is
     *     {@link IPConfigAssignT }
     *     
     */
    public IPConfigAssignT getAssign() {
        if (assign == null) {
            return IPConfigAssignT.AUTO;
        } else {
            return assign;
        }
    }

    /**
     * Sets the value of the assign property.
     * 
     * @param value
     *     allowed object is
     *     {@link IPConfigAssignT }
     *     
     */
    public void setAssign(IPConfigAssignT value) {
        this.assign = value;
    }

    /**
     * Gets the value of the ipAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIPAddress() {
        return ipAddress;
    }

    /**
     * Sets the value of the ipAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIPAddress(String value) {
        this.ipAddress = value;
    }

    /**
     * Gets the value of the subnetMask property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubnetMask() {
        return subnetMask;
    }

    /**
     * Sets the value of the subnetMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubnetMask(String value) {
        this.subnetMask = value;
    }

    /**
     * Gets the value of the defaultGateway property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultGateway() {
        return defaultGateway;
    }

    /**
     * Sets the value of the defaultGateway property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultGateway(String value) {
        this.defaultGateway = value;
    }

    /**
     * Gets the value of the macAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMACAddress() {
        return macAddress;
    }

    /**
     * Sets the value of the macAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMACAddress(String value) {
        this.macAddress = value;
    }

}