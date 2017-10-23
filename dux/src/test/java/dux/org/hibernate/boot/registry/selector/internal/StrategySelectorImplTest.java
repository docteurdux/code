package dux.org.hibernate.boot.registry.selector.internal;

import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.boot.registry.selector.internal.StrategySelectorImpl;
import org.hibernate.boot.registry.selector.spi.StrategySelectionException;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.java.util.concurrent.DummyCallable;
import dum.org.hibernate.boot.registry.classloading.spi.DummyClassLoaderService;
import dum.org.hibernate.boot.registry.selector.spi.DummyStrategyCreator;

public class StrategySelectorImplTest extends AbstractTest {

	public static interface A {
		String getName();
	}

	public static class B implements A {

		private String name;

		public B(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	public static class C implements A {
		@Override
		public String getName() {
			return "C";
		}
	}

	public static class D implements A {
		private D() {
		}

		@Override
		public String getName() {
			return "D";
		}
	}

	public static class MainLogic extends AbstractTest {

		private DummyClassLoaderService classLoaderService;
		private StrategySelectorImpl strategySelector;
		private Class<A> interfaceClass;
		private DummyCallable<A> defaultResolver;
		private DummyStrategyCreator<A> creator;
		private B implementation;
		private B defaultResolved;
		private B defaultCreated;

		@Before
		public void before() {
			classLoaderService = new DummyClassLoaderService();
			strategySelector = new StrategySelectorImpl(classLoaderService);

			interfaceClass = A.class;
			implementation = new B("implementation");
			defaultResolved = new B("defaultResolved");
			defaultCreated = new B("defaultCreated");

			defaultResolver = new DummyCallable<A>();
			defaultResolver.setResult(defaultResolved);

			creator = new DummyStrategyCreator<A>();
			creator.setResult(defaultCreated);
		}

		/** If strategy reference is null, use default resolver **/
		@Test
		public void test1() {

			A strategy = strategySelector.resolveStrategy(interfaceClass, null, defaultResolver, creator);
			aeq(defaultResolved, strategy);
		}

		/** Default resolver may throw **/
		@Test(expected = StrategySelectionException.class)
		public void test2() {

			defaultResolver.setException(new RuntimeException("exception"));

			strategySelector.resolveStrategy(interfaceClass, null, defaultResolver, creator);
		}

		/** If strategy reference is an instance of strategy, return that **/
		@Test
		public void test3() {

			A strategy = strategySelector.resolveStrategy(interfaceClass, implementation, defaultResolver, creator);
			aeq(implementation, strategy);
		}

		/**
		 * If strategy reference is a class which is compatible with the strategy class,
		 * use creator with that class to get an implementation
		 **/
		@Test
		public void test4() {

			A strategy = strategySelector.resolveStrategy(interfaceClass, A.class, defaultResolver, creator);
			aeq(defaultCreated, strategy);
		}

		/**
		 * If strategy reference is not a class , find the implementation with the
		 * strategy implementation selection procedure
		 **/
		@Test
		public void test5() {

			creator.setNatural();
			strategySelector.registerStrategyImplementor(interfaceClass, "name", C.class);

			A strategy = strategySelector.resolveStrategy(interfaceClass, "name", defaultResolver, creator);
			at(strategy instanceof C);
		}

		/**
		 * The creator may throw
		 **/
		@Test(expected = StrategySelectionException.class)
		public void test6() {

			creator.setNatural();
			strategySelector.registerStrategyImplementor(interfaceClass, "name", D.class);

			strategySelector.resolveStrategy(interfaceClass, "name", defaultResolver, creator);
		}
	}

	public static class MainLogicWithDefaultValue extends AbstractTest {

		private DummyClassLoaderService classLoaderService;
		private StrategySelectorImpl strategySelector;
		private Class<A> interfaceClass;
		private DummyStrategyCreator<A> creator;
		private B implementation;
		private B defaultCreated;
		private B defaultValue;

		@Before
		public void before() {
			classLoaderService = new DummyClassLoaderService();
			strategySelector = new StrategySelectorImpl(classLoaderService);

			interfaceClass = A.class;
			implementation = new B("implementation");
			defaultValue = new B("defaultValue");
			defaultCreated = new B("defaultCreated");

			creator = new DummyStrategyCreator<A>();
			creator.setResult(defaultCreated);
		}

		/** If strategy reference is null, use default resolver **/
		@Test
		public void test1() {

			A strategy = strategySelector.resolveStrategy(interfaceClass, null, defaultValue, creator);
			aeq(defaultValue, strategy);
		}

		/** Default resolver may throw / cannot happen with default value **/
		@Test
		public void test2() {
		}

		/** If strategy reference is an instance of strategy, return that **/
		@Test
		public void test3() {

			A strategy = strategySelector.resolveStrategy(interfaceClass, implementation, defaultValue, creator);
			aeq(implementation, strategy);
		}

		/**
		 * If strategy reference is a class which is compatible with the strategy class,
		 * use creator with that class to get an implementation
		 **/
		@Test
		public void test4() {

			A strategy = strategySelector.resolveStrategy(interfaceClass, A.class, defaultValue, creator);
			aeq(defaultCreated, strategy);
		}

		/**
		 * If strategy reference is not a class , find the implementation with the
		 * strategy implementation selection procedure
		 **/
		@Test
		public void test5() {

			creator.setNatural();
			strategySelector.registerStrategyImplementor(interfaceClass, "name", C.class);

			A strategy = strategySelector.resolveStrategy(interfaceClass, "name", defaultValue, creator);
			at(strategy instanceof C);
		}

		/**
		 * The creator may throw
		 **/
		@Test(expected = StrategySelectionException.class)
		public void test6() {

			creator.setNatural();
			strategySelector.registerStrategyImplementor(interfaceClass, "name", D.class);

			strategySelector.resolveStrategy(interfaceClass, "name", defaultValue, creator);
		}
	}

	public static class MainLogicWithNullDefaultValue extends AbstractTest {

		private DummyClassLoaderService classLoaderService;
		private StrategySelectorImpl strategySelector;
		private Class<A> interfaceClass;
		private DummyStrategyCreator<A> creator;
		private B implementation;
		private B defaultCreated;

		@Before
		public void before() {
			classLoaderService = new DummyClassLoaderService();
			strategySelector = new StrategySelectorImpl(classLoaderService);

			interfaceClass = A.class;
			implementation = new B("implementation");
			defaultCreated = new B("defaultCreated");

			creator = new DummyStrategyCreator<A>();
			creator.setResult(defaultCreated);
		}

		/** If strategy reference is null, use default resolver **/
		@Test
		public void test1() {

			A strategy = strategySelector.resolveStrategy(interfaceClass, null);
			an(strategy);
		}

		/** Default resolver may throw / cannot happen with default value **/
		@Test
		public void test2() {
		}

		/** If strategy reference is an instance of strategy, return that **/
		@Test
		public void test3() {

			A strategy = strategySelector.resolveStrategy(interfaceClass, implementation);
			aeq(implementation, strategy);
		}

		/**
		 * If strategy reference is a class which is compatible with the strategy class,
		 * use creator with that class to get an implementation / throw when the
		 * strategy class is an interface
		 **/
		@Test(expected = StrategySelectionException.class)
		public void test4() {

			A strategy = strategySelector.resolveStrategy(interfaceClass, A.class);
			aeq(defaultCreated, strategy);
		}

		/**
		 * If strategy reference is a class which is compatible with the strategy class,
		 * use creator with that class to get an implementation / ok when provided class
		 * has a default constructor
		 **/
		@Test
		public void test4a() {

			A strategy = strategySelector.resolveStrategy(interfaceClass, C.class);
			at(strategy instanceof C);
		}

		/**
		 * If strategy reference is not a class , find the implementation with the
		 * strategy implementation selection procedure
		 **/
		@Test
		public void test5() {

			creator.setNatural();
			strategySelector.registerStrategyImplementor(interfaceClass, "name", C.class);

			A strategy = strategySelector.resolveStrategy(interfaceClass, "name");
			at(strategy instanceof C);
		}

		/**
		 * The creator may throw
		 **/
		@Test(expected = StrategySelectionException.class)
		public void test6() {

			creator.setNatural();
			strategySelector.registerStrategyImplementor(interfaceClass, "name", D.class);

			strategySelector.resolveStrategy(interfaceClass, "name");
		}
	}

	public static class MainLogicWithDefaultableStrategyDefaultResolver extends AbstractTest {

		private DummyClassLoaderService classLoaderService;
		private StrategySelectorImpl strategySelector;
		private Class<A> interfaceClass;
		private DummyCallable<A> defaultResolver;
		private B implementation;
		private B defaultResolved;

		@Before
		public void before() {
			classLoaderService = new DummyClassLoaderService();
			strategySelector = new StrategySelectorImpl(classLoaderService);

			interfaceClass = A.class;
			implementation = new B("implementation");
			defaultResolved = new B("defaultResolved");

			defaultResolver = new DummyCallable<A>();
			defaultResolver.setResult(defaultResolved);

		}

		/** If strategy reference is null, use default resolver **/
		@Test
		public void test1() {
			A strategy = strategySelector.resolveDefaultableStrategy(interfaceClass, null, defaultResolver);
			aeq(defaultResolved, strategy);
		}

		/** Default resolver may throw **/
		@Test(expected = StrategySelectionException.class)
		public void test2() {

			defaultResolver.setException(new RuntimeException("exception"));

			strategySelector.resolveDefaultableStrategy(interfaceClass, null, defaultResolver);
		}

		/** If strategy reference is an instance of strategy, return that **/
		@Test
		public void test3() {

			A strategy = strategySelector.resolveDefaultableStrategy(interfaceClass, implementation, defaultResolver);
			aeq(implementation, strategy);
		}

		/**
		 * If strategy reference is a class which is compatible with the strategy class,
		 * use creator with that class to get an implementation / fail when the strategy
		 * reference does not have a default constructor
		 **/
		@Test(expected = StrategySelectionException.class)
		public void test4() {

			strategySelector.resolveDefaultableStrategy(interfaceClass, A.class, defaultResolver);
		}

		/**
		 * If strategy reference is a class which is compatible with the strategy class,
		 * use creator with that class to get an implementation / fail when the strategy
		 * reference does not have a default constructor
		 **/
		@Test
		public void test4b() {

			A strategy = strategySelector.resolveDefaultableStrategy(interfaceClass, C.class, defaultResolver);
			at(strategy instanceof C);
		}

		/**
		 * If strategy reference is not a class , find the implementation with the
		 * strategy implementation selection procedure
		 **/
		@Test
		public void test5() {

			strategySelector.registerStrategyImplementor(interfaceClass, "name", C.class);

			A strategy = strategySelector.resolveDefaultableStrategy(interfaceClass, "name", defaultResolver);
			at(strategy instanceof C);
		}

		/**
		 * The creator may throw
		 **/
		@Test(expected = StrategySelectionException.class)
		public void test6() {

			strategySelector.registerStrategyImplementor(interfaceClass, "name", D.class);

			strategySelector.resolveDefaultableStrategy(interfaceClass, "name", defaultResolver);
		}
	}

	public static class MainLogicWithDefaultableStrategyDefaultValue extends AbstractTest {

		private DummyClassLoaderService classLoaderService;
		private StrategySelectorImpl strategySelector;
		private Class<A> interfaceClass;
		private B implementation;
		private B defaultResolved;
		private B defaultCreated;
		private B defaultValue;

		@Before
		public void before() {
			classLoaderService = new DummyClassLoaderService();
			strategySelector = new StrategySelectorImpl(classLoaderService);

			interfaceClass = A.class;
			implementation = new B("implementation");
			defaultResolved = new B("defaultResolved");
			defaultCreated = new B("defaultCreated");
			defaultValue = new B("efaultValue");

		}

		/** If strategy reference is null, use default resolver **/
		@Test
		public void test1() {

			A strategy = strategySelector.resolveDefaultableStrategy(interfaceClass, null, defaultValue);
			aeq(defaultValue, strategy);
		}

		/** Default resolver may throw / not width default value **/
		@Test
		public void test2() {
		}

		/** If strategy reference is an instance of strategy, return that **/
		@Test
		public void test3() {

			A strategy = strategySelector.resolveDefaultableStrategy(interfaceClass, implementation, defaultValue);
			aeq(implementation, strategy);
		}

		/**
		 * If strategy reference is a class which is compatible with the strategy class,
		 * use creator with that class to get an implementation / throw when reference
		 * does not have a default constructor
		 **/
		@Test(expected = StrategySelectionException.class)
		public void test4() {

			A strategy = strategySelector.resolveDefaultableStrategy(interfaceClass, A.class, defaultValue);
			aeq(defaultCreated, strategy);
		}

		/**
		 * If strategy reference is a class which is compatible with the strategy class,
		 * use creator with that class to get an implementation / require reference to
		 * have a default constructor
		 **/
		@Test
		public void test4a() {

			A strategy = strategySelector.resolveDefaultableStrategy(interfaceClass, C.class, defaultValue);
			at(strategy instanceof C);
		}

		/**
		 * If strategy reference is not a class , find the implementation with the
		 * strategy implementation selection procedure
		 **/
		@Test
		public void test5() {

			strategySelector.registerStrategyImplementor(interfaceClass, "name", C.class);

			A strategy = strategySelector.resolveDefaultableStrategy(interfaceClass, "name", defaultValue);
			at(strategy instanceof C);
		}

		/**
		 * The creator may throw
		 **/
		@Test(expected = StrategySelectionException.class)
		public void test6() {

			strategySelector.registerStrategyImplementor(interfaceClass, "name", D.class);

			strategySelector.resolveDefaultableStrategy(interfaceClass, "name", defaultValue);
		}
	}

	public static class RegistrationTest extends AbstractTest {

		private Class<A> interfaceClass;
		private Class<B> implementationClass;
		private DummyClassLoaderService classLoaderService;
		private StrategySelectorImpl strategySelector;

		@Before
		public void before() {
			interfaceClass = A.class;
			implementationClass = B.class;

			classLoaderService = new DummyClassLoaderService();
			classLoaderService.getForNames().put("name", D.class);

			strategySelector = new StrategySelectorImpl(classLoaderService);
		}

		/** When a custom implementor is registered, it is used **/
		@Test
		public void test1() {

			strategySelector.registerStrategyImplementor(interfaceClass, "name", implementationClass);

			Class<? extends A> implementor = strategySelector.selectStrategyImplementor(interfaceClass, "name");

			aeq(B.class, implementor);

			strategySelector.unRegisterStrategyImplementor(interfaceClass, implementationClass);

			implementor = strategySelector.selectStrategyImplementor(interfaceClass, "name");
			aeq(D.class, implementor);

		}

		/** Otherwise, the name is passed to the class loader service **/
		@Test
		public void test2() {

			Class<? extends A> implementor = strategySelector.selectStrategyImplementor(interfaceClass, "name");
			aeq(D.class, implementor);

		}

		/** Registered implementors can be removed **/
		@Test
		public void test3() {

			strategySelector.registerStrategyImplementor(interfaceClass, "name", implementationClass);
			strategySelector.unRegisterStrategyImplementor(interfaceClass, implementationClass);

			Class<? extends A> implementor = strategySelector.selectStrategyImplementor(interfaceClass, "name");
			aeq(D.class, implementor);

		}

	}

}
