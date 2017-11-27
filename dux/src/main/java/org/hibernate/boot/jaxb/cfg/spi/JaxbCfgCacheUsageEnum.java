//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.19 at 04:55:21 PM BST 
//


package org.hibernate.boot.jaxb.cfg.spi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CacheUsageEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CacheUsageEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="nonstrict-read-write"/&gt;
 *     &lt;enumeration value="read-only"/&gt;
 *     &lt;enumeration value="read-write"/&gt;
 *     &lt;enumeration value="transactional"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CacheUsageEnum")
@XmlEnum
public enum JaxbCfgCacheUsageEnum {

    @XmlEnumValue("nonstrict-read-write")
    NONSTRICT_READ_WRITE("nonstrict-read-write"),
    @XmlEnumValue("read-only")
    READ_ONLY("read-only"),
    @XmlEnumValue("read-write")
    READ_WRITE("read-write"),
    @XmlEnumValue("transactional")
    TRANSACTIONAL("transactional");
    private final String value;

    JaxbCfgCacheUsageEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JaxbCfgCacheUsageEnum fromValue(String v) {
        for (JaxbCfgCacheUsageEnum c: JaxbCfgCacheUsageEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
