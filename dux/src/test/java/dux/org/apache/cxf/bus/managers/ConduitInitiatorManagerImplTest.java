package dux.org.apache.cxf.bus.managers;

import org.apache.cxf.Bus;
import org.apache.cxf.BusException;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.managers.ConduitInitiatorManagerImpl;
import org.apache.cxf.transport.ConduitInitiator;
import org.apache.cxf.transport.ConduitInitiatorManager;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class ConduitInitiatorManagerImplTest extends AbstractTest {

	@Test
	public void test1() throws BusException {

		Bus bus = BusFactory.getDefaultBus();

		ConduitInitiatorManager manager = bus.getExtension(ConduitInitiatorManager.class);
		aeq(ConduitInitiatorManagerImpl.class.getName(), manager.getClass().getName());

		String namespace = "namespace";
		try {
			manager.getConduitInitiator(namespace);
			fail();
		} catch (BusException ex) {

		}
		
	}
}
