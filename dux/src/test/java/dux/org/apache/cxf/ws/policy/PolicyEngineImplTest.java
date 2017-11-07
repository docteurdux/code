package dux.org.apache.cxf.ws.policy;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.ws.policy.PolicyEngineImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class PolicyEngineImplTest extends AbstractTest {
	private Bus bus;

	@Before
	public void before() {
		bus = BusFactory.getDefaultBus();
	}

	@After
	public void after() {
		BusFactory.setDefaultBus(null);
	}

	@Test
	public void test() {
		PolicyEngineImpl engine = new PolicyEngineImpl(bus);

		aeq(0, engine.getPolicyProviders().size());
	}
}
