package dum.org.apache.neethi;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.neethi.AbstractPolicyOperator;
import org.apache.neethi.Policy;
import org.apache.neethi.PolicyOperator;
import org.apache.neethi.PolicyRegistry;

public class DummyAbstractPolicyOperator extends AbstractPolicyOperator {

	public DummyAbstractPolicyOperator() {
		super();
	}

	public DummyAbstractPolicyOperator(PolicyOperator parent) {
		super(parent);
	}

	@Override
	public void serialize(XMLStreamWriter writer) throws XMLStreamException {
		// TODO Auto-generated method stub

	}

	@Override
	public short getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Policy snormalize(Policy policy, PolicyRegistry reg, boolean deep) {
		return AbstractPolicyOperator.normalize(policy, reg, deep);
	}

}
