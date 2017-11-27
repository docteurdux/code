//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.19 at 04:55:22 PM BST 
//


package org.hibernate.boot.jaxb.hbm.spi;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 The loader element allows specification of a named query to be used for fetching
 *                 an entity or collection
 *             
 * 
 * <p>Java class for loader-type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="loader-type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="query-ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loader-type")
public class JaxbHbmLoaderType
    implements Serializable
{

    @XmlAttribute(name = "query-ref", required = true)
    protected String queryRef;

    /**
     * Gets the value of the queryRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryRef() {
        return queryRef;
    }

    /**
     * Sets the value of the queryRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryRef(String value) {
        this.queryRef = value;
    }

}