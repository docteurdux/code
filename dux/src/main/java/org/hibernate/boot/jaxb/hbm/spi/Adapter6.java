//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.19 at 04:55:22 PM BST 
//


package org.hibernate.boot.jaxb.hbm.spi;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.hibernate.tuple.GenerationTiming;

public class Adapter6
    extends XmlAdapter<String, GenerationTiming>
{


    public GenerationTiming unmarshal(String value) {
        return (org.hibernate.boot.jaxb.hbm.internal.GenerationTimingConverter.fromXml(value));
    }

    public String marshal(GenerationTiming value) {
        return (org.hibernate.boot.jaxb.hbm.internal.GenerationTimingConverter.toXml(value));
    }

}
