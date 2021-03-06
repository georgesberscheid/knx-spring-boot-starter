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
 * <p>Java class for ResourceAddrSpace_t.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ResourceAddrSpace_t">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="StandardMemory"/>
 *     &lt;enumeration value="UserMemory"/>
 *     &lt;enumeration value="SystemProperty"/>
 *     &lt;enumeration value="AppProperty"/>
 *     &lt;enumeration value="LcSlaveMemory"/>
 *     &lt;enumeration value="LcFilterMemory"/>
 *     &lt;enumeration value="ADC"/>
 *     &lt;enumeration value="Constant"/>
 *     &lt;enumeration value="Pointer"/>
 *     &lt;enumeration value="Property"/>
 *     &lt;enumeration value="RelativeMemory"/>
 *     &lt;enumeration value="RelativeMemoryByObjectType"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ResourceAddrSpace_t")
@XmlEnum
public enum ResourceAddrSpaceT {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("StandardMemory")
    STANDARD_MEMORY("StandardMemory"),
    @XmlEnumValue("UserMemory")
    USER_MEMORY("UserMemory"),
    @XmlEnumValue("SystemProperty")
    SYSTEM_PROPERTY("SystemProperty"),
    @XmlEnumValue("AppProperty")
    APP_PROPERTY("AppProperty"),
    @XmlEnumValue("LcSlaveMemory")
    LC_SLAVE_MEMORY("LcSlaveMemory"),
    @XmlEnumValue("LcFilterMemory")
    LC_FILTER_MEMORY("LcFilterMemory"),
    ADC("ADC"),
    @XmlEnumValue("Constant")
    CONSTANT("Constant"),
    @XmlEnumValue("Pointer")
    POINTER("Pointer"),
    @XmlEnumValue("Property")
    PROPERTY("Property"),
    @XmlEnumValue("RelativeMemory")
    RELATIVE_MEMORY("RelativeMemory"),
    @XmlEnumValue("RelativeMemoryByObjectType")
    RELATIVE_MEMORY_BY_OBJECT_TYPE("RelativeMemoryByObjectType");
    private final String value;

    ResourceAddrSpaceT(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResourceAddrSpaceT fromValue(String v) {
        for (ResourceAddrSpaceT c: ResourceAddrSpaceT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
