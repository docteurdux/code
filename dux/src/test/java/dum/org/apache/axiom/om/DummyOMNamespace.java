package dum.org.apache.axiom.om;

import org.apache.axiom.om.OMNamespace;

public class DummyOMNamespace implements OMNamespace {

	private String name;
	private String namespaceURI;
	private String prefix;

	@Override
	public boolean equals(String arg0, String arg1) {
		return false;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getNamespaceURI() {
		return namespaceURI;
	}

	@Override
	public String getPrefix() {
		return prefix;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNamespaceURI(String namespaceURI) {
		this.namespaceURI = namespaceURI;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

}
