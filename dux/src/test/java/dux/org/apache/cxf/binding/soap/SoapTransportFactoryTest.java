package dux.org.apache.cxf.binding.soap;

import java.io.IOException;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.binding.soap.SoapTransportFactory;
import org.apache.cxf.binding.soap.jms.interceptor.SoapJMSConstants;
import org.apache.cxf.binding.soap.model.SoapBindingInfo;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.transport.Destination;
import org.apache.cxf.transport.DestinationFactoryManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class SoapTransportFactoryTest extends AbstractTest {

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
	public void test1() throws IOException {

		SoapTransportFactory factory = new SoapTransportFactory();
		aeq(1, factory.getUriPrefixes().size());
		aeq("soap.udp", factory.getUriPrefixes().iterator().next());

	}

	@Test
	public void test2() throws IOException {

		SoapTransportFactory factory = new SoapTransportFactory();

		aeq("http://cxf.apache.org/transports/jms",
				factory.mapTransportURI("http://www.w3.org/2010/soapjms/", "anything"));

		aeq("http://cxf.apache.org/transports/jms", factory.mapTransportURI("anything", "jmsanything"));

		aeq("http://cxf.apache.org/transports/udp", factory.mapTransportURI("anything", "soap.udpanything"));

		aeq("http://cxf.apache.org/transports/http",
				factory.mapTransportURI("http://schemas.xmlsoap.org/soap/http", "anything"));

		aeq("http://cxf.apache.org/transports/http",
				factory.mapTransportURI("http://www.w3.org/2003/05/soap/bindings/HTTP/", "anything"));

		aeq("http://cxf.apache.org/transports/http",
				factory.mapTransportURI("http://schemas.xmlsoap.org/wsdl/soap/", "anything"));

		aeq("http://cxf.apache.org/transports/http",
				factory.mapTransportURI("http://schemas.xmlsoap.org/wsdl/http", "anything"));

		aeq("http://cxf.apache.org/transports/http",
				factory.mapTransportURI("http://schemas.xmlsoap.org/wsdl/soap/http", "anything"));

		aeq("http://cxf.apache.org/transports/http",
				factory.mapTransportURI("http://schemas.xmlsoap.org/wsdl/soap/http/", "anything"));

		aeq("http://cxf.apache.org/transports/http",
				factory.mapTransportURI("http://schemas.xmlsoap.org/wsdl/http/", "anything"));

		aeq("anything1", factory.mapTransportURI("anything1", "anything2"));

	}

	@Test
	public void test3() throws Exception {

		DestinationFactoryManager dfm = bus.getExtension(DestinationFactoryManager.class);
		System.out.println(dfm.getClass().getName());

		SoapTransportFactory factory = new SoapTransportFactory();

		ServiceInfo si = new ServiceInfo();
		EndpointInfo ei = new EndpointInfo(si, "http://schemas.xmlsoap.org/soap/");
		ei.setAddress("http://anything");

		Destination destination = factory.getDestination(ei, bus);
		ann(destination);
	}
}
