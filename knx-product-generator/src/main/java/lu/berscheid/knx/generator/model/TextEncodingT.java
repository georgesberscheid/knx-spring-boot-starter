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
 * <p>Java class for TextEncoding_t.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TextEncoding_t">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="us-ascii"/>
 *     &lt;enumeration value="iso-8859-1"/>
 *     &lt;enumeration value="iso-8859-2"/>
 *     &lt;enumeration value="iso-8859-3"/>
 *     &lt;enumeration value="iso-8859-4"/>
 *     &lt;enumeration value="iso-8859-5"/>
 *     &lt;enumeration value="iso-8859-6"/>
 *     &lt;enumeration value="iso-8859-7"/>
 *     &lt;enumeration value="iso-8859-8"/>
 *     &lt;enumeration value="iso-8859-9"/>
 *     &lt;enumeration value="iso-8859-10"/>
 *     &lt;enumeration value="iso-8859-13"/>
 *     &lt;enumeration value="iso-8859-15"/>
 *     &lt;enumeration value="utf-8"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TextEncoding_t")
@XmlEnum
public enum TextEncodingT {

    @XmlEnumValue("us-ascii")
    US_ASCII("us-ascii"),
    @XmlEnumValue("iso-8859-1")
    ISO_8859_1("iso-8859-1"),
    @XmlEnumValue("iso-8859-2")
    ISO_8859_2("iso-8859-2"),
    @XmlEnumValue("iso-8859-3")
    ISO_8859_3("iso-8859-3"),
    @XmlEnumValue("iso-8859-4")
    ISO_8859_4("iso-8859-4"),
    @XmlEnumValue("iso-8859-5")
    ISO_8859_5("iso-8859-5"),
    @XmlEnumValue("iso-8859-6")
    ISO_8859_6("iso-8859-6"),
    @XmlEnumValue("iso-8859-7")
    ISO_8859_7("iso-8859-7"),
    @XmlEnumValue("iso-8859-8")
    ISO_8859_8("iso-8859-8"),
    @XmlEnumValue("iso-8859-9")
    ISO_8859_9("iso-8859-9"),
    @XmlEnumValue("iso-8859-10")
    ISO_8859_10("iso-8859-10"),
    @XmlEnumValue("iso-8859-13")
    ISO_8859_13("iso-8859-13"),
    @XmlEnumValue("iso-8859-15")
    ISO_8859_15("iso-8859-15"),
    @XmlEnumValue("utf-8")
    UTF_8("utf-8");
    private final String value;

    TextEncodingT(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TextEncodingT fromValue(String v) {
        for (TextEncodingT c: TextEncodingT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
