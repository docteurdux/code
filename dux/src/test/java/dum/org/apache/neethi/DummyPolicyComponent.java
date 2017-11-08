package dum.org.apache.neethi;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.neethi.PolicyComponent;

public class DummyPolicyComponent implements PolicyComponent {

	@Override
	public void serialize(XMLStreamWriter writer) throws XMLStreamException {
		// TODO Auto-generated method stub

	}

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

}
