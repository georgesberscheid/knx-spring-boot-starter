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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ModuleDefLoadProcedures_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModuleDefLoadProcedures_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LoadProcedure" type="{http://knx.org/xml/project/20}ModuleDefLoadProcedure_t" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModuleDefLoadProcedures_t", propOrder = {
    "loadProcedure"
})
public class ModuleDefLoadProceduresT {

    @XmlElement(name = "LoadProcedure", required = true)
    protected List<ModuleDefLoadProcedureT> loadProcedure;

    /**
     * Gets the value of the loadProcedure property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loadProcedure property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoadProcedure().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModuleDefLoadProcedureT }
     * 
     * 
     */
    public List<ModuleDefLoadProcedureT> getLoadProcedure() {
        if (loadProcedure == null) {
            loadProcedure = new ArrayList<ModuleDefLoadProcedureT>();
        }
        return this.loadProcedure;
    }

}
