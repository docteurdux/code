//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.19 at 04:55:22 PM BST 
//


package org.hibernate.boot.jaxb.hbm.spi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LazyEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LazyEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="false"/&gt;
 *     &lt;enumeration value="proxy"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "LazyEnum")
@XmlEnum
public enum JaxbHbmLazyEnum {

    @XmlEnumValue("false")
    FALSE("false"),
    @XmlEnumValue("proxy")
    PROXY("proxy");
    private final String value;

    JaxbHbmLazyEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JaxbHbmLazyEnum fromValue(String v) {
        for (JaxbHbmLazyEnum c: JaxbHbmLazyEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
