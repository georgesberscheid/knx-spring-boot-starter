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
 * <p>Java class for ComObjectPriority_t.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ComObjectPriority_t">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Low"/>
 *     &lt;enumeration value="High"/>
 *     &lt;enumeration value="Alert"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ComObjectPriority_t")
@XmlEnum
public enum ComObjectPriorityT {

    @XmlEnumValue("Low")
    LOW("Low"),
    @XmlEnumValue("High")
    HIGH("High"),
    @XmlEnumValue("Alert")
    ALERT("Alert");
    private final String value;

    ComObjectPriorityT(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ComObjectPriorityT fromValue(String v) {
        for (ComObjectPriorityT c: ComObjectPriorityT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}