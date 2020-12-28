//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.10.05 at 10:56:00 PM CEST 
//


package lu.berscheid.knx.generator.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RFTxCapabilities_t.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RFTxCapabilities_t">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Ready"/>
 *     &lt;enumeration value="ReadyFast"/>
 *     &lt;enumeration value="ReadyFastSlow"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RFTxCapabilities_t")
@XmlEnum
public enum RFTxCapabilitiesT {

    @XmlEnumValue("Ready")
    READY("Ready"),
    @XmlEnumValue("ReadyFast")
    READY_FAST("ReadyFast"),
    @XmlEnumValue("ReadyFastSlow")
    READY_FAST_SLOW("ReadyFastSlow");
    private final String value;

    RFTxCapabilitiesT(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RFTxCapabilitiesT fromValue(String v) {
        for (RFTxCapabilitiesT c: RFTxCapabilitiesT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
