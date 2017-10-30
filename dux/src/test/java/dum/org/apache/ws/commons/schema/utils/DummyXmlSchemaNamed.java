package dum.org.apache.ws.commons.schema.utils;

import javax.xml.namespace.QName;

import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.utils.XmlSchemaNamed;

public class DummyXmlSchemaNamed implements XmlSchemaNamed {

	private String name;
	private boolean anonymous;
	private XmlSchema parent;
	private QName qname;
	private boolean toplevel;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isAnonymous() {
		return anonymous;
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public XmlSchema getParent() {
		return parent;
	}

	@Override
	public QName getQName() {
		return qname;
	}

	@Override
	public boolean isTopLevel() {
		return toplevel;
	}

	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}

	public void setParent(XmlSchema parent) {
		this.parent = parent;
	}

	public void setQName(QName qname) {
		this.qname = qname;
	}

	public void setToplevel(boolean toplevel) {
		this.toplevel = toplevel;
	}

}
