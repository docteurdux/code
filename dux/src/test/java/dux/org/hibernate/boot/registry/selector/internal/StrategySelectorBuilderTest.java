package dux.org.hibernate.boot.registry.selector.internal;

import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.boot.registry.selector.StrategyRegistration;
import org.hibernate.boot.registry.selector.internal.StrategySelectorBuilder;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.org.hibernate.boot.registry.classloading.spi.DummyClassLoaderService;
import dum.org.hibernate.boot.registry.selector.DummyStrategyRegistration;

public class StrategySelectorBuilderTest extends AbstractTest {
	@Test
	public void test1() {
		
		ClassLoaderService classLoaderService = new DummyClassLoaderService();
//		StrategyRegistration<Object> strategyRegistration = new DummyStrategyRegistration<Object>();

		StrategySelectorBuilder builder = new StrategySelectorBuilder();
//		builder.addExplicitStrategyRegistration(strategyRegistration);
//		builder.addExplicitStrategyRegistration(strategy, implementation, name);
		builder.buildSelector(classLoaderService);
	}
}
