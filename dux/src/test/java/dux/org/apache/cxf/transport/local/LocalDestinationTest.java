package dux.org.apache.cxf.transport.local;

import java.io.OutputStream;
import java.util.concurrent.Executor;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.transport.Conduit;
import org.apache.cxf.transport.MessageObserver;
import org.apache.cxf.transport.local.LocalConduit;
import org.apache.cxf.transport.local.LocalDestination;
import org.apache.cxf.transport.local.LocalTransportFactory;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.java.util.concurrent.DummyExecutor;
import dum.org.apache.cxf.message.DummyExchange;
import dum.org.apache.cxf.message.DummyMessage;
import dum.org.apache.cxf.transport.DummyMessageObserver;

public class LocalDestinationTest extends AbstractTest {

	private Bus bus;
	private MessageObserver observer;
	private DummyExecutor executor;
	private LocalTransportFactory localTransportFactory;
	private ServiceInfo si;
	private EndpointInfo ei;
	private String eiNS;
	private EndpointReferenceType epr;
	private Exchange exchange;

	@Before
	public void before() {
		bus = BusFactory.getDefaultBus();
		localTransportFactory = new LocalTransportFactory();
		executor = new DummyExecutor();
		observer = new DummyMessageObserver();
		exchange = new DummyExchange();
		exchange.put(Executor.class, executor);

		si = new ServiceInfo();
		eiNS = "eiNS";
		ei = new EndpointInfo(si, eiNS);
		ei.setAddress("address");
		epr = ei.getTarget();
	}

	@After
	public void after() {
		BusFactory.setDefaultBus(null);
	}

	@Test
	public void test() throws Exception {

		LocalDestination destination = new LocalDestination(localTransportFactory, epr, ei, bus);
		DummyMessage message = new DummyMessage();
		LocalConduit localConduit = new LocalConduit(localTransportFactory, destination);
		localConduit.setMessageObserver(observer);
		message.put(LocalConduit.IN_CONDUIT, localConduit);

		Conduit conduit = destination.getBackChannel(message);

		message.setExchange(exchange);

		conduit.prepare(message);

		OutputStream os = message.getContent(OutputStream.class);

		conduit.close(message);

	}
}
