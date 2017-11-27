//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.19 at 04:55:22 PM BST 
//


package org.hibernate.boot.jaxb.hbm.spi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 The resultset element declares a named resultset mapping definition for SQL queries
 *             
 * 
 * <p>Java class for ResultSetMappingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultSetMappingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;group ref="{http://www.hibernate.org/xsd/orm/hbm}NativeQueryReturnGroup"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultSetMappingType", propOrder = {
    "valueMappingSources"
})
public class JaxbHbmResultSetMappingType
    implements Serializable, ResultSetMappingBindingDefinition
{

    @XmlElements({
        @XmlElement(name = "return-scalar", type = JaxbHbmNativeQueryScalarReturnType.class),
        @XmlElement(name = "return", type = JaxbHbmNativeQueryReturnType.class),
        @XmlElement(name = "return-join", type = JaxbHbmNativeQueryJoinReturnType.class),
        @XmlElement(name = "load-collection", type = JaxbHbmNativeQueryCollectionLoadReturnType.class)
    })
    protected List<Serializable> valueMappingSources;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the valueMappingSources property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valueMappingSources property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValueMappingSources().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JaxbHbmNativeQueryScalarReturnType }
     * {@link JaxbHbmNativeQueryReturnType }
     * {@link JaxbHbmNativeQueryJoinReturnType }
     * {@link JaxbHbmNativeQueryCollectionLoadReturnType }
     * 
     * 
     */
    public List<Serializable> getValueMappingSources() {
        if (valueMappingSources == null) {
            valueMappingSources = new ArrayList<Serializable>();
        }
        return this.valueMappingSources;
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

}
