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
 * <p>Java class for ApplicationProgramType_t.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ApplicationProgramType_t">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ApplicationProgram"/>
 *     &lt;enumeration value="PeiProgram"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ApplicationProgramType_t")
@XmlEnum
public enum ApplicationProgramTypeT {

    @XmlEnumValue("ApplicationProgram")
    APPLICATION_PROGRAM("ApplicationProgram"),
    @XmlEnumValue("PeiProgram")
    PEI_PROGRAM("PeiProgram");
    private final String value;

    ApplicationProgramTypeT(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ApplicationProgramTypeT fromValue(String v) {
        for (ApplicationProgramTypeT c: ApplicationProgramTypeT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}