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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for LanguageData_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LanguageData_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TranslationUnit" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TranslationElement" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Translation" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="AttributeName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="Text" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="RefId" use="required" type="{http://knx.org/xml/project/20}IDREF" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="RefId" use="required" type="{http://knx.org/xml/project/20}IDREF" />
 *                 &lt;attribute name="Version" type="{http://www.w3.org/2001/XMLSchema}int" default="0" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Identifier" use="required" type="{http://www.w3.org/2001/XMLSchema}language" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LanguageData_t", propOrder = {
    "translationUnit"
})
public class LanguageDataT {

    @XmlElement(name = "TranslationUnit", required = true)
    protected List<LanguageDataT.TranslationUnit> translationUnit;
    @XmlAttribute(name = "Identifier", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String identifier;

    /**
     * Gets the value of the translationUnit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the translationUnit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTranslationUnit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LanguageDataT.TranslationUnit }
     * 
     * 
     */
    public List<LanguageDataT.TranslationUnit> getTranslationUnit() {
        if (translationUnit == null) {
            translationUnit = new ArrayList<LanguageDataT.TranslationUnit>();
        }
        return this.translationUnit;
    }

    /**
     * Gets the value of the identifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the value of the identifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifier(String value) {
        this.identifier = value;
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
     *         &lt;element name="TranslationElement" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Translation" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="AttributeName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="Text" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="RefId" use="required" type="{http://knx.org/xml/project/20}IDREF" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="RefId" use="required" type="{http://knx.org/xml/project/20}IDREF" />
     *       &lt;attribute name="Version" type="{http://www.w3.org/2001/XMLSchema}int" default="0" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "translationElement"
    })
    public static class TranslationUnit {

        @XmlElement(name = "TranslationElement", required = true)
        protected List<LanguageDataT.TranslationUnit.TranslationElement> translationElement;
        @XmlAttribute(name = "RefId", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String refId;
        @XmlAttribute(name = "Version")
        protected Integer version;

        /**
         * Gets the value of the translationElement property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the translationElement property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTranslationElement().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link LanguageDataT.TranslationUnit.TranslationElement }
         * 
         * 
         */
        public List<LanguageDataT.TranslationUnit.TranslationElement> getTranslationElement() {
            if (translationElement == null) {
                translationElement = new ArrayList<LanguageDataT.TranslationUnit.TranslationElement>();
            }
            return this.translationElement;
        }

        /**
         * Gets the value of the refId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRefId() {
            return refId;
        }

        /**
         * Sets the value of the refId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRefId(String value) {
            this.refId = value;
        }

        /**
         * Gets the value of the version property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public int getVersion() {
            if (version == null) {
                return  0;
            } else {
                return version;
            }
        }

        /**
         * Sets the value of the version property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setVersion(Integer value) {
            this.version = value;
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
         *         &lt;element name="Translation" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="AttributeName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="Text" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="RefId" use="required" type="{http://knx.org/xml/project/20}IDREF" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "translation"
        })
        public static class TranslationElement {

            @XmlElement(name = "Translation", required = true)
            protected List<LanguageDataT.TranslationUnit.TranslationElement.Translation> translation;
            @XmlAttribute(name = "RefId", required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String refId;

            /**
             * Gets the value of the translation property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the translation property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTranslation().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link LanguageDataT.TranslationUnit.TranslationElement.Translation }
             * 
             * 
             */
            public List<LanguageDataT.TranslationUnit.TranslationElement.Translation> getTranslation() {
                if (translation == null) {
                    translation = new ArrayList<LanguageDataT.TranslationUnit.TranslationElement.Translation>();
                }
                return this.translation;
            }

            /**
             * Gets the value of the refId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRefId() {
                return refId;
            }

            /**
             * Sets the value of the refId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRefId(String value) {
                this.refId = value;
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
             *       &lt;attribute name="AttributeName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="Text" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Translation {

                @XmlAttribute(name = "AttributeName", required = true)
                protected String attributeName;
                @XmlAttribute(name = "Text", required = true)
                protected String text;

                /**
                 * Gets the value of the attributeName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAttributeName() {
                    return attributeName;
                }

                /**
                 * Sets the value of the attributeName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAttributeName(String value) {
                    this.attributeName = value;
                }

                /**
                 * Gets the value of the text property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getText() {
                    return text;
                }

                /**
                 * Sets the value of the text property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setText(String value) {
                    this.text = value;
                }

            }

        }

    }

}
