package dum.org.apache.axiom.om;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMCloneOptions;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMInformationItem;
import org.apache.axiom.om.OMNamespace;

public class DummyOMAttribute implements OMAttribute {

	private String localName;
	private String value;

	@Override
	public String getLocalName() {
		return localName;
	}

	@Override
	public OMNamespace getNamespace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNamespaceURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrefix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QName getQName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasName(QName arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setLocalName(String localName) {
		this.localName = localName;
	}

	@Override
	public void setNamespace(OMNamespace arg0, boolean arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public OMInformationItem clone(OMCloneOptions arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OMFactory getOMFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAttributeType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAttributeValue() {
		return value;
	}

	@Override
	public OMElement getOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttributeType(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAttributeValue(String value) {
		this.value = value;

	}

	@Override
	public void setOMNamespace(OMNamespace arg0) {
		// TODO Auto-generated method stub

	}

}
