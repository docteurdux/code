package dux.org.apache.cxf.ws.policy;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.ws.policy.PolicyInInterceptor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.org.apache.cxf.endpoint.DummyEndpoint;
import dum.org.apache.cxf.message.DummyExchange;
import dum.org.apache.cxf.message.DummyMessage;

public class PolicyInInterceptorTest extends AbstractTest {

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
		PolicyInInterceptor interceptor = new PolicyInInterceptor();
		aeq(Phase.RECEIVE, interceptor.getPhase());

		Message message = new DummyMessage();
		DummyExchange exchange = new DummyExchange();
		exchange.setBus(bus);
		Endpoint endpoint = new DummyEndpoint();
		exchange.setEndpoint(endpoint);
		message.setExchange(exchange);
		interceptor.handleMessage(message);
	}
}
