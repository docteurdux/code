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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConfigParameterContainer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfigParameterContainer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="param" type="{http://www.hibernate.org/xsd/orm/hbm}ConfigParameterType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfigParameterContainer", propOrder = {
    "configParameters"
})
public abstract class JaxbHbmConfigParameterContainer
    implements Serializable, ConfigParameterContainer
{

    @XmlElement(name = "param")
    protected List<JaxbHbmConfigParameterType> configParameters;

    /**
     * Gets the value of the configParameters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the configParameters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConfigParameters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JaxbHbmConfigParameterType }
     * 
     * 
     */
    public List<JaxbHbmConfigParameterType> getConfigParameters() {
        if (configParameters == null) {
            configParameters = new ArrayList<JaxbHbmConfigParameterType>();
        }
        return this.configParameters;
    }

}
