package dux.org.hibernate.boot.registry;

import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.classloading.internal.TcclLookupPrecedence;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.boot.registry.selector.StrategyRegistrationProvider;
import org.hibernate.integrator.spi.Integrator;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.java.lang.DummyClassLoader;
import dum.org.hibernate.boot.registry.classloading.spi.DummyClassLoaderService;
import dum.org.hibernate.boot.registry.selector.DummyStrategyRegistrationProvider;
import dum.org.hibernate.integrator.spi.DummyIntegrator;

public class BootstrapServiceRegistryBuilderTest extends AbstractTest {
	@Test
	public void test1() {
		Integrator integrator = new DummyIntegrator();
		ClassLoaderService classLoaderService = new DummyClassLoaderService();
		ClassLoader classLoader = new DummyClassLoader();
		StrategyRegistrationProvider strategyRegistrationProvider = new DummyStrategyRegistrationProvider();

		BootstrapServiceRegistryBuilder builder = new BootstrapServiceRegistryBuilder();
		builder.applyClassLoaderService(classLoaderService);
		builder.applyIntegrator(integrator);
		builder.applyTcclLookupPrecedence(TcclLookupPrecedence.NEVER);
		builder.enableAutoClose();
		builder.disableAutoClose();
		builder.applyClassLoader(classLoader);
		builder.applyStrategySelectors(strategyRegistrationProvider);
//		Class<? extends Object> implementation = null;
//		builder.applyStrategySelector(Object.class, "name", implementation );
		builder.build();

		//
		// Class<Object> strategy;
		// String name;
		// Class<? extends Object> implementation;
		// builder.applyStrategySelector(strategy, name, implementation);
		//
		// builder.build();
	}
}
