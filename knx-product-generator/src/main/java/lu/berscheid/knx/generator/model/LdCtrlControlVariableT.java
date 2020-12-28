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
 * <p>Java class for LdCtrlControlVariable_t.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LdCtrlControlVariable_t">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EnableSegmentWrite"/>
 *     &lt;enumeration value="EnableVerifyOnWriteDirect"/>
 *     &lt;enumeration value="EnableOptimisticWrite"/>
 *     &lt;enumeration value="EnableMemoryAutoVerify"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LdCtrlControlVariable_t")
@XmlEnum
public enum LdCtrlControlVariableT {

    @XmlEnumValue("EnableSegmentWrite")
    ENABLE_SEGMENT_WRITE("EnableSegmentWrite"),
    @XmlEnumValue("EnableVerifyOnWriteDirect")
    ENABLE_VERIFY_ON_WRITE_DIRECT("EnableVerifyOnWriteDirect"),
    @XmlEnumValue("EnableOptimisticWrite")
    ENABLE_OPTIMISTIC_WRITE("EnableOptimisticWrite"),
    @XmlEnumValue("EnableMemoryAutoVerify")
    ENABLE_MEMORY_AUTO_VERIFY("EnableMemoryAutoVerify");
    private final String value;

    LdCtrlControlVariableT(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LdCtrlControlVariableT fromValue(String v) {
        for (LdCtrlControlVariableT c: LdCtrlControlVariableT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
