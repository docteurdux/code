package dux.org.apache.cxf.bus.extension;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.extension.ExtensionManagerBus;
import org.junit.After;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class ExtensionManagerBusTest extends AbstractTest {

	@After
	public void after() {
		BusFactory.setDefaultBus(null);
	}

	@Test
	public void test() {
		ExtensionManagerBus bus = new ExtensionManagerBus();

		@SuppressWarnings("unchecked")
		Map<Class<?>, Object> extensions = (Map<Class<?>, Object>) getField(bus, "extensions");
		
		aeq(7, extensions.size());
		
		for(Entry<Class<?>, Object> entry : extensions.entrySet()) {
			System.out.println(entry.getKey().getName()+" : "+str(entry.getValue()));
		}
	}

}
