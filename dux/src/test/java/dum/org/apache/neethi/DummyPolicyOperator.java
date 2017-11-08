package dum.org.apache.neethi;

import java.util.List;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.neethi.PolicyComponent;
import org.apache.neethi.PolicyOperator;

public class DummyPolicyOperator implements PolicyOperator {

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

	@Override
	public void addPolicyComponent(PolicyComponent component) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PolicyComponent> getPolicyComponents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
