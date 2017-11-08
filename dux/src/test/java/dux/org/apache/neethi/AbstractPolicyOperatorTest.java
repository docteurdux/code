package dux.org.apache.neethi;

import java.util.Arrays;

import org.apache.neethi.Policy;
import org.apache.neethi.PolicyComponent;
import org.apache.neethi.PolicyOperator;
import org.apache.neethi.PolicyRegistry;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.org.apache.neethi.DummyAbstractPolicyOperator;
import dum.org.apache.neethi.DummyPolicyComponent;
import dum.org.apache.neethi.DummyPolicyOperator;
import dum.org.apache.neethi.DummyPolicyRegistry;

public class AbstractPolicyOperatorTest extends AbstractTest {
	@Test
	public void test() {

		DummyAbstractPolicyOperator operator = new DummyAbstractPolicyOperator();

		PolicyOperator parent = new DummyPolicyOperator();
		operator = new DummyAbstractPolicyOperator(parent);

		PolicyComponent component = new DummyPolicyComponent();
		operator.addPolicyComponent(component);

		operator.addPolicyComponents(Arrays.asList(new PolicyComponent[] { component }));

		aeq(2, operator.getPolicyComponents().size());

		aeqr(component, operator.getFirstPolicyComponent());

		af(operator.isEmpty());

		af(operator.equal(new DummyAbstractPolicyOperator()));

		Policy policy = new Policy();
		PolicyRegistry reg = new DummyPolicyRegistry();
		operator.snormalize(policy, reg, true);
	}
}
