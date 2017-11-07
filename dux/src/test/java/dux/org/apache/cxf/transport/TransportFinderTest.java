package dux.org.apache.cxf.transport;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.binding.soap.SoapTransportFactory;
import org.apache.cxf.configuration.ConfiguredBeanLocator;
import org.apache.cxf.transport.ConduitInitiator;
import org.apache.cxf.transport.TransportFinder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class TransportFinderTest extends AbstractTest {

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
	public void test1() {

		Map<String, ConduitInitiator> m = new HashMap<>();
		Set<String> l = new HashSet<>();
		TransportFinder<ConduitInitiator> finder = new TransportFinder<>(bus, m, l, ConduitInitiator.class);
		finder.findTransportForNamespace("namespace");

		@SuppressWarnings("unchecked")
		Map<String, ConduitInitiator> map = (Map<String, ConduitInitiator>) getField(finder, "map");

		aeq(7, map.size());

		for (Entry<String, ConduitInitiator> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue().getClass().getName());
		}

		has4(map, "http://schemas.xmlsoap.org/wsdl/soap/http", SoapTransportFactory.class);
		has4(map, "http://schemas.xmlsoap.org/soap/http", SoapTransportFactory.class);
		has4(map, "http://schemas.xmlsoap.org/wsdl/soap12/", SoapTransportFactory.class);
		has4(map, "http://www.w3.org/2010/soapjms/", SoapTransportFactory.class);
		has4(map, "http://schemas.xmlsoap.org/wsdl/soap/", SoapTransportFactory.class);
		has4(map, "http://www.w3.org/2003/05/soap/bindings/HTTP/", SoapTransportFactory.class);
		has4(map, "http://schemas.xmlsoap.org/soap/", SoapTransportFactory.class);

	}

	@Test
	public void test2() {
		System.out.println(bus.getExtension(ConfiguredBeanLocator.class).getClass().getName());
	}
}
