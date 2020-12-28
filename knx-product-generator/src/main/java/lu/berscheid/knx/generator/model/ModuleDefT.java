//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.10.05 at 10:56:00 PM CEST 
//


package lu.berscheid.knx.generator.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for ModuleDef_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModuleDef_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Arguments" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Argument" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *                           &lt;attribute name="Name" use="required" type="{http://knx.org/xml/project/20}Identifier50_t" />
 *                           &lt;attribute name="Type" type="{http://knx.org/xml/project/20}ModuleDefArgType_t" default="Numeric" />
 *                           &lt;attribute name="InternalDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="Allocates" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" />
 *                           &lt;attribute name="Alignment" default="1">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
 *                                 &lt;enumeration value="1"/>
 *                                 &lt;enumeration value="2"/>
 *                                 &lt;enumeration value="4"/>
 *                                 &lt;enumeration value="8"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Static" type="{http://knx.org/xml/project/20}ModuleDefStatic_t"/>
 *         &lt;element name="SubModuleDefs" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ModuleDef" type="{http://knx.org/xml/project/20}ModuleDef_t" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Dynamic" type="{http://knx.org/xml/project/20}ModuleDefDynamic_t" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="Name" use="required" type="{http://knx.org/xml/project/20}String255_t" />
 *       &lt;attribute name="InternalDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModuleDef_t", propOrder = {
    "arguments",
    "_static",
    "subModuleDefs",
    "dynamic"
})
public class ModuleDefT {

    @XmlElement(name = "Arguments")
    protected ModuleDefT.Arguments arguments;
    @XmlElement(name = "Static", required = true)
    protected ModuleDefStaticT _static;
    @XmlElement(name = "SubModuleDefs")
    protected ModuleDefT.SubModuleDefs subModuleDefs;
    @XmlElement(name = "Dynamic")
    protected ModuleDefDynamicT dynamic;
    @XmlAttribute(name = "Id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "InternalDescription")
    protected String internalDescription;

    /**
     * Gets the value of the arguments property.
     * 
     * @return
     *     possible object is
     *     {@link ModuleDefT.Arguments }
     *     
     */
    public ModuleDefT.Arguments getArguments() {
        return arguments;
    }

    /**
     * Sets the value of the arguments property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModuleDefT.Arguments }
     *     
     */
    public void setArguments(ModuleDefT.Arguments value) {
        this.arguments = value;
    }

    /**
     * Gets the value of the static property.
     * 
     * @return
     *     possible object is
     *     {@link ModuleDefStaticT }
     *     
     */
    public ModuleDefStaticT getStatic() {
        return _static;
    }

    /**
     * Sets the value of the static property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModuleDefStaticT }
     *     
     */
    public void setStatic(ModuleDefStaticT value) {
        this._static = value;
    }

    /**
     * Gets the value of the subModuleDefs property.
     * 
     * @return
     *     possible object is
     *     {@link ModuleDefT.SubModuleDefs }
     *     
     */
    public ModuleDefT.SubModuleDefs getSubModuleDefs() {
        return subModuleDefs;
    }

    /**
     * Sets the value of the subModuleDefs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModuleDefT.SubModuleDefs }
     *     
     */
    public void setSubModuleDefs(ModuleDefT.SubModuleDefs value) {
        this.subModuleDefs = value;
    }

    /**
     * Gets the value of the dynamic property.
     * 
     * @return
     *     possible object is
     *     {@link ModuleDefDynamicT }
     *     
     */
    public ModuleDefDynamicT getDynamic() {
        return dynamic;
    }

    /**
     * Sets the value of the dynamic property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModuleDefDynamicT }
     *     
     */
    public void setDynamic(ModuleDefDynamicT value) {
        this.dynamic = value;
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
     * Gets the value of the internalDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternalDescription() {
        return internalDescription;
    }

    /**
     * Sets the value of the internalDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternalDescription(String value) {
        this.internalDescription = value;
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
     *         &lt;element name="Argument" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
     *                 &lt;attribute name="Name" use="required" type="{http://knx.org/xml/project/20}Identifier50_t" />
     *                 &lt;attribute name="Type" type="{http://knx.org/xml/project/20}ModuleDefArgType_t" default="Numeric" />
     *                 &lt;attribute name="InternalDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="Allocates" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" />
     *                 &lt;attribute name="Alignment" default="1">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
     *                       &lt;enumeration value="1"/>
     *                       &lt;enumeration value="2"/>
     *                       &lt;enumeration value="4"/>
     *                       &lt;enumeration value="8"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
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
    @XmlType(name = "", propOrder = {
        "argument"
    })
    public static class Arguments {

        @XmlElement(name = "Argument", required = true)
        protected List<ModuleDefT.Arguments.Argument> argument;

        /**
         * Gets the value of the argument property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the argument property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getArgument().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ModuleDefT.Arguments.Argument }
         * 
         * 
         */
        public List<ModuleDefT.Arguments.Argument> getArgument() {
            if (argument == null) {
                argument = new ArrayList<ModuleDefT.Arguments.Argument>();
            }
            return this.argument;
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
         *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
         *       &lt;attribute name="Name" use="required" type="{http://knx.org/xml/project/20}Identifier50_t" />
         *       &lt;attribute name="Type" type="{http://knx.org/xml/project/20}ModuleDefArgType_t" default="Numeric" />
         *       &lt;attribute name="InternalDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="Allocates" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" />
         *       &lt;attribute name="Alignment" default="1">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
         *             &lt;enumeration value="1"/>
         *             &lt;enumeration value="2"/>
         *             &lt;enumeration value="4"/>
         *             &lt;enumeration value="8"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Argument {

            @XmlAttribute(name = "Id", required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlID
            @XmlSchemaType(name = "ID")
            protected String id;
            @XmlAttribute(name = "Name", required = true)
            protected String name;
            @XmlAttribute(name = "Type")
            protected ModuleDefArgTypeT type;
            @XmlAttribute(name = "InternalDescription")
            protected String internalDescription;
            @XmlAttribute(name = "Allocates")
            @XmlSchemaType(name = "unsignedLong")
            protected BigInteger allocates;
            @XmlAttribute(name = "Alignment")
            protected Integer alignment;

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
             * Gets the value of the type property.
             * 
             * @return
             *     possible object is
             *     {@link ModuleDefArgTypeT }
             *     
             */
            public ModuleDefArgTypeT getType() {
                if (type == null) {
                    return ModuleDefArgTypeT.NUMERIC;
                } else {
                    return type;
                }
            }

            /**
             * Sets the value of the type property.
             * 
             * @param value
             *     allowed object is
             *     {@link ModuleDefArgTypeT }
             *     
             */
            public void setType(ModuleDefArgTypeT value) {
                this.type = value;
            }

            /**
             * Gets the value of the internalDescription property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getInternalDescription() {
                return internalDescription;
            }

            /**
             * Sets the value of the internalDescription property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setInternalDescription(String value) {
                this.internalDescription = value;
            }

            /**
             * Gets the value of the allocates property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getAllocates() {
                return allocates;
            }

            /**
             * Sets the value of the allocates property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setAllocates(BigInteger value) {
                this.allocates = value;
            }

            /**
             * Gets the value of the alignment property.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public int getAlignment() {
                if (alignment == null) {
                    return  1;
                } else {
                    return alignment;
                }
            }

            /**
             * Sets the value of the alignment property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setAlignment(Integer value) {
                this.alignment = value;
            }

        }

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
     *         &lt;element name="ModuleDef" type="{http://knx.org/xml/project/20}ModuleDef_t" maxOccurs="unbounded"/>
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
        "moduleDef"
    })
    public static class SubModuleDefs {

        @XmlElement(name = "ModuleDef", required = true)
        protected List<ModuleDefT> moduleDef;

        /**
         * Gets the value of the moduleDef property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the moduleDef property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getModuleDef().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ModuleDefT }
         * 
         * 
         */
        public List<ModuleDefT> getModuleDef() {
            if (moduleDef == null) {
                moduleDef = new ArrayList<ModuleDefT>();
            }
            return this.moduleDef;
        }

    }

}