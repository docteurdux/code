//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.19 at 04:55:22 PM BST 
//


package org.hibernate.boot.jaxb.hbm.spi;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.hibernate.EntityMode;

public class Adapter4
    extends XmlAdapter<String, EntityMode>
{


    public EntityMode unmarshal(String value) {
        return (org.hibernate.boot.jaxb.hbm.internal.EntityModeConverter.fromXml(value));
    }

    public String marshal(EntityMode value) {
        return (org.hibernate.boot.jaxb.hbm.internal.EntityModeConverter.toXml(value));
    }

}
