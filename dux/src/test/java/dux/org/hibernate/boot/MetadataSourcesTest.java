package dux.org.hibernate.boot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceInitiator;
import org.hibernate.boot.registry.internal.BootstrapServiceRegistryImpl;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cache.internal.RegionFactoryInitiator;
import org.hibernate.engine.config.internal.ConfigurationServiceInitiator;
import org.hibernate.service.internal.ProvidedService;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dus.hibernate.core.HibernateCoreSummaryTest;

public class MetadataSourcesTest extends AbstractTest {

	public static class A {

	}

	@Before
	public void before() {
		requireSources(HibernateCoreSummaryTest.MVNNAME, MetadataSources.class);
	}

	@Test
	public void test() {

		BootstrapServiceRegistryImpl bootstrapServiceRegistry = new BootstrapServiceRegistryImpl();
		@SuppressWarnings("rawtypes")
		List<StandardServiceInitiator> serviceInitiators = new ArrayList<>();

		serviceInitiators.add(ConfigurationServiceInitiator.INSTANCE);
		serviceInitiators.add(RegionFactoryInitiator.INSTANCE);
		@SuppressWarnings("rawtypes")
		List<ProvidedService> providedServices = new ArrayList<>();
		Map<?, ?> configurationValues = new HashMap<>();
		StandardServiceRegistryImpl s = new StandardServiceRegistryImpl(bootstrapServiceRegistry, serviceInitiators,
				providedServices, configurationValues);

		MetadataSources md = new MetadataSources(s);

		md.addAnnotatedClass(A.class);
		md.buildMetadata();
	}
}
