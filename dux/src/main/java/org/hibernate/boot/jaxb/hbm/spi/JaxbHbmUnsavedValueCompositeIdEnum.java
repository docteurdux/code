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
 * <p>Java class for UnsavedValueCompositeIdEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UnsavedValueCompositeIdEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="any"/&gt;
 *     &lt;enumeration value="none"/&gt;
 *     &lt;enumeration value="undefined"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "UnsavedValueCompositeIdEnum")
@XmlEnum
public enum JaxbHbmUnsavedValueCompositeIdEnum {

    @XmlEnumValue("any")
    ANY("any"),
    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("undefined")
    UNDEFINED("undefined");
    private final String value;

    JaxbHbmUnsavedValueCompositeIdEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JaxbHbmUnsavedValueCompositeIdEnum fromValue(String v) {
        for (JaxbHbmUnsavedValueCompositeIdEnum c: JaxbHbmUnsavedValueCompositeIdEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
