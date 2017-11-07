package dux.org.apache.cxf.bus.managers;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.binding.soap.SoapTransportFactory;
import org.apache.cxf.bus.managers.DestinationFactoryManagerImpl;
import org.apache.cxf.transport.DestinationFactoryManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class DestinationFactoryManagerImplTest extends AbstractTest {
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
	public void test1() throws Exception {

		DestinationFactoryManagerImpl dfm = (DestinationFactoryManagerImpl) bus
				.getExtension(DestinationFactoryManager.class);
		SoapTransportFactory stf = (SoapTransportFactory) dfm.getDestinationFactory("http://schemas.xmlsoap.org/soap/");
		ann(stf);

	}

	@Test
	public void test2() throws Exception {

		DestinationFactoryManagerImpl dfm = (DestinationFactoryManagerImpl) bus
				.getExtension(DestinationFactoryManager.class);
		SoapTransportFactory stf = (SoapTransportFactory) dfm.getDestinationFactoryForUri("soap.udp://");
		ann(stf);

	}
}
