package dux.org.apache.cxf.transport.local;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.transport.DestinationFactoryManager;
import org.apache.cxf.transport.local.LocalDestination;
import org.apache.cxf.transport.local.LocalTransportFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class LocalTransportFactoryTest extends AbstractTest {

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
	public void test() throws Exception {

		DestinationFactoryManager dfm = bus.getExtension(DestinationFactoryManager.class);

		LocalTransportFactory ltf = (LocalTransportFactory) dfm
				.getDestinationFactory("http://cxf.apache.org/transports/local");

		ServiceInfo si = new ServiceInfo();
		EndpointInfo ei = new EndpointInfo(si, "namespace");
		LocalDestination d = (LocalDestination) ltf.getDestination(ei, bus);

	}
}
