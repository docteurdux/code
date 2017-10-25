package dux.org.apache.cxf.bus.extension;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.cxf.BusFactory;
import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.bus.extension.ExtensionManager;
import org.apache.cxf.bus.extension.ExtensionManagerBus;
import org.apache.cxf.bus.extension.ExtensionManagerImpl;
import org.apache.cxf.bus.managers.BindingFactoryManagerImpl;
import org.apache.cxf.bus.managers.ConduitInitiatorManagerImpl;
import org.apache.cxf.bus.managers.DestinationFactoryManagerImpl;
import org.apache.cxf.configuration.ConfiguredBeanLocator;
import org.apache.cxf.configuration.Configurer;
import org.apache.cxf.configuration.NullConfigurer;
import org.apache.cxf.feature.Feature;
import org.apache.cxf.resource.DefaultResourceManager;
import org.apache.cxf.resource.ResourceManager;
import org.apache.cxf.transport.ConduitInitiatorManager;
import org.apache.cxf.transport.DestinationFactoryManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class ExtensionManagerBusTest extends AbstractTest {

	private ExtensionManagerBus bus;
	private Map<Class<?>, Object> extensions;
	private Collection<Feature> features;
	private Map<String, Object> properties;
	private Set<Class<?>> missingExtensions;

	@SuppressWarnings("unchecked")
	@Before
	public void before() {

		bus = new ExtensionManagerBus();

		extensions = (Map<Class<?>, Object>) getField(bus, "extensions");

		missingExtensions = (Set<Class<?>>) getField(bus, "missingExtensions");

		features = (Collection<Feature>) getField(bus, "features");

		properties = (Map<String, Object>) getField(bus, "properties");
	}

	@After
	public void after() {
		BusFactory.setDefaultBus(null);

	}

	@Test
	public void test() {

		aeq(7, extensions.size());
		aeq(0, missingExtensions.size());
		aeq(0, features.size());
		aeq(3, properties.size());

		has1(extensions, ExtensionManager.class, ExtensionManagerImpl.class);
		has1(extensions, Configurer.class, NullConfigurer.class);
		has1(extensions, ConfiguredBeanLocator.class, ExtensionManagerImpl.class);
		has1(extensions, ConduitInitiatorManager.class, ConduitInitiatorManagerImpl.class);
		has1(extensions, DestinationFactoryManager.class, DestinationFactoryManagerImpl.class);
		has1(extensions, ResourceManager.class, DefaultResourceManager.class);
		has1(extensions, BindingFactoryManager.class, BindingFactoryManagerImpl.class);

		has2(properties, "bus", ExtensionManagerBus.class);
		has3(properties, "org.apache.cxf.bus.id", "bus");
		has2(properties, "cxf", ExtensionManagerBus.class);

	}

	private void has1(Map<Class<?>, Object> map, Class<?> key, Class<?> value) {
		aeq(value.getName(), map.get(key).getClass().getName());
	}

	private void has2(Map<String, Object> map, String key, Class<?> clazz) {
		aeq(clazz, map.get(key).getClass());
	}

	private void has3(Map<String, Object> map, String key, String value) {
		aeq(value, map.get(key));
	}
}
