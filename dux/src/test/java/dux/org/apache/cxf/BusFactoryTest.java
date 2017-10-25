package dux.org.apache.cxf;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.junit.After;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class BusFactoryTest extends AbstractTest {

	@After
	public void after() {
		BusFactory.setDefaultBus(null);
	}

	@Test
	public void test() {
		Bus bus = BusFactory.getDefaultBus();
		aeq("org.apache.cxf.bus.extension.ExtensionManagerBus", bus.getClass().getName());
	}
}
