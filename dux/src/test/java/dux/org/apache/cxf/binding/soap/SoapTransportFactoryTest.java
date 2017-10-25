package dux.org.apache.cxf.binding.soap;

import java.io.IOException;
import java.util.List;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.binding.soap.SoapTransportFactory;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SoapTransportFactoryTest {

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

		ServiceInfo serviceInfo = new ServiceInfo();
		String bindingId = "bindingId";
		BindingInfo bindingInfo = new BindingInfo(serviceInfo, bindingId);
		List<?> ees = null;

		SoapTransportFactory factory = new SoapTransportFactory();

		EndpointInfo endpointInfo = factory.createEndpointInfo(bus, serviceInfo, bindingInfo, ees);

	}
}
