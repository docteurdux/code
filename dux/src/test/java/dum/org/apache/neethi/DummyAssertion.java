package dum.org.apache.neethi;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.neethi.Assertion;
import org.apache.neethi.PolicyComponent;

public class DummyAssertion implements Assertion {

	@Override
	public short getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equal(PolicyComponent policyComponent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public QName getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isOptional() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isIgnorable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void serialize(XMLStreamWriter writer) throws XMLStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public PolicyComponent normalize() {
		// TODO Auto-generated method stub
		return null;
	}

}
