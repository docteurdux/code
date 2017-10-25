package dux.org.apache.cxf.bus.extension;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.cxf.BusFactory;
import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.bus.extension.ExtensionManager;
import org.apache.cxf.bus.extension.ExtensionManagerBus;
import org.apache.cxf.configuration.ConfiguredBeanLocator;
import org.apache.cxf.configuration.Configurer;
import org.apache.cxf.resource.ResourceManager;
import org.apache.cxf.transport.ConduitInitiatorManager;
import org.apache.cxf.transport.DestinationFactoryManager;
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

		Map<Class<?>, String> expectedExtensionsClass = new HashMap<>();
		expectedExtensionsClass.put(ExtensionManager.class, "org.apache.cxf.bus.extension.ExtensionManagerImpl");
		expectedExtensionsClass.put(Configurer.class, "org.apache.cxf.configuration.NullConfigurer");
		expectedExtensionsClass.put(ConfiguredBeanLocator.class, "org.apache.cxf.bus.extension.ExtensionManagerImpl");
		expectedExtensionsClass.put(ConduitInitiatorManager.class,
				"org.apache.cxf.bus.managers.ConduitInitiatorManagerImpl");
		expectedExtensionsClass.put(DestinationFactoryManager.class,
				"org.apache.cxf.bus.managers.DestinationFactoryManagerImpl");
		expectedExtensionsClass.put(ResourceManager.class, "org.apache.cxf.resource.DefaultResourceManager");
		expectedExtensionsClass.put(BindingFactoryManager.class,
				"org.apache.cxf.bus.managers.BindingFactoryManagerImpl");

		aeq("org.apache.cxf.bus.extension.ExtensionManagerImpl",
				extensions.get(ExtensionManager.class).getClass().getName());
		for (Entry<Class<?>, Object> entry : extensions.entrySet()) {
			System.out.println(entry.getKey().getName() + " : " + str(entry.getValue()));
		}
	}

}
