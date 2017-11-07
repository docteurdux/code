package dux.org.apache.cxf.interceptor;

import org.apache.cxf.interceptor.InterceptorChain;
import org.apache.cxf.interceptor.MessageSenderInterceptor;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.Conduit;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.org.apache.cxf.interceptor.DummyInterceptorChain;
import dum.org.apache.cxf.message.DummyExchange;
import dum.org.apache.cxf.message.DummyMessage;
import dum.org.apache.cxf.transport.DummyConduit;

public class MessageSenderInterceptorTest extends AbstractTest {
	@Test
	public void test() {
		MessageSenderInterceptor interceptor = new MessageSenderInterceptor();

		aeq(Phase.PREPARE_SEND, interceptor.getPhase());

		DummyMessage message = new DummyMessage();
		Exchange exchange = new DummyExchange();
		Conduit conduit = new DummyConduit();
		exchange.setConduit(conduit);
		message.setExchange(exchange);
		InterceptorChain chain = new DummyInterceptorChain();
		message.setInterceptorChain(chain );
		interceptor.handleMessage(message);
	}
}
