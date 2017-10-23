package dux.org.hibernate;

import java.util.HashSet;
import java.util.Iterator;

import org.hibernate.Hibernate;
import org.hibernate.bytecode.enhance.spi.interceptor.LazyAttributeLoadingInterceptor;
import org.hibernate.engine.jdbc.LobCreator;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.spi.PersistentAttributeInterceptor;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.java.util.DummyIterator;
import dum.org.hibernate.DummySession;
import dum.org.hibernate.collection.spi.DummyPersistentCollection;
import dum.org.hibernate.engine.DummyHibernateIterator;
import dum.org.hibernate.engine.jdbc.DummyLobCreator;
import dum.org.hibernate.engine.jdbc.spi.DummyJdbcServices;
import dum.org.hibernate.engine.spi.DummyPersistentAttributeInterceptable;
import dum.org.hibernate.engine.spi.DummyPersistentAttributeInterceptor;
import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.engine.spi.DummySessionImplementor;
import dum.org.hibernate.engine.spi.DummySharedSessionContractImplementor;
import dum.org.hibernate.proxy.DummyHibernateProxy;
import dum.org.hibernate.proxy.DummyLazyInitializer;
import dum.org.hibernate.service.spi.DummyServiceRegistryImplementor;

public class HibernateTest extends AbstractTest {

	public static class A {

	}

	@Test
	public void test1() {

		Object proxy = new Object();
		at(Hibernate.isInitialized(proxy));

		// Hibernate.close(iterator);
		// Hibernate.getClass(proxy);
		// Hibernate.getLobCreator(sessionImplementor);
		// Hibernate.getLobCreator(shareSessionContractImplementor);
		// Hibernate.getLobCreator(session);
		//
		// Hibernate.isPropertyInitialized(proxy, propertyName);
		// Hibernate.unproxy(proxy);
	}

	@Test
	public void test2() {

		at(Hibernate.isInitialized(null));

	}

	@Test
	public void test3() {

		DummyLazyInitializer lazyInitializer = new DummyLazyInitializer();
		lazyInitializer.setUninitialized(false);

		DummyHibernateProxy proxy = new DummyHibernateProxy();
		proxy.setLazyInitializer(lazyInitializer);

		at(Hibernate.isInitialized(proxy));

	}

	@Test
	public void test5() {

		DummyLazyInitializer lazyInitializer = new DummyLazyInitializer();
		lazyInitializer.setUninitialized(true);

		DummyHibernateProxy proxy = new DummyHibernateProxy();
		proxy.setLazyInitializer(lazyInitializer);

		af(Hibernate.isInitialized(proxy));

	}

	@Test
	public void test6() {

		DummyPersistentCollection proxy = new DummyPersistentCollection();
		proxy.setWasInitialized(false);

		af(Hibernate.isInitialized(proxy));

	}

	@Test
	public void test7() {

		DummyPersistentCollection proxy = new DummyPersistentCollection();
		proxy.setWasInitialized(true);

		at(Hibernate.isInitialized(proxy));

	}

	@Test
	public void test8() {
		Hibernate.initialize(null);
	}

	@Test
	public void test9() {

		DummyLazyInitializer lazyInitializer = new DummyLazyInitializer();
		lazyInitializer.initialize();

		DummyHibernateProxy proxy = new DummyHibernateProxy();
		proxy.setLazyInitializer(lazyInitializer);
		Hibernate.initialize(proxy);

		event(lazyInitializer, "initialize");
	}

	@Test
	public void test10() {

		DummyPersistentCollection proxy = new DummyPersistentCollection();
		proxy.forceInitialization();

		Hibernate.initialize(proxy);

		event(proxy, "forceInitialization");
	}

	@Test
	public void test11() {

		Object proxy = new Object();

		Hibernate.initialize(proxy);
	}

	@Test
	public void test12() {
		Object proxy = new Object();
		Class<?> clazz = Hibernate.getClass(proxy);
		aeq(Object.class, clazz);
	}

	@Test
	public void test13() {

		A target = new A();

		DummyLazyInitializer lazyInitializer = new DummyLazyInitializer();
		lazyInitializer.setImplementation(target);

		DummyHibernateProxy proxy = new DummyHibernateProxy();
		proxy.setLazyInitializer(lazyInitializer);
		Class<?> clazz = Hibernate.getClass(proxy);
		aeq(A.class, clazz);
	}

	@Test
	public void test14() {

		LobCreator lobCreator = new DummyLobCreator();

		DummyJdbcServices service = new DummyJdbcServices();
		service.setLobCreator(lobCreator);

		DummyServiceRegistryImplementor serviceRegistry = new DummyServiceRegistryImplementor();
		serviceRegistry.getServices().put(JdbcServices.class, service);

		DummySessionFactoryImplementor factory = new DummySessionFactoryImplementor();
		factory.setServiceRegistry(serviceRegistry);

		DummySessionImplementor sessionImplementor = new DummySessionImplementor();
		sessionImplementor.setFactory(factory);

		aeq(lobCreator, Hibernate.getLobCreator(sessionImplementor));

	}

	@Test(expected = ClassCastException.class)
	public void test15() {
		DummySession session = new DummySession();
		Hibernate.getLobCreator(session);
	}

	@Test
	public void test16() {

		LobCreator lobCreator = new DummyLobCreator();

		DummyJdbcServices service = new DummyJdbcServices();
		service.setLobCreator(lobCreator);

		DummyServiceRegistryImplementor serviceRegistry = new DummyServiceRegistryImplementor();
		serviceRegistry.getServices().put(JdbcServices.class, service);

		DummySessionFactoryImplementor factory = new DummySessionFactoryImplementor();
		factory.setServiceRegistry(serviceRegistry);

		DummySharedSessionContractImplementor implementor = new DummySharedSessionContractImplementor();
		implementor.setFactory(factory);

		Hibernate.getLobCreator(implementor);
	}

	@Test
	public void test17() {
		an(Hibernate.unproxy(null));
	}

	@Test
	public void test18() {
		Object proxy = new Object();
		aeq(proxy, Hibernate.unproxy(proxy));
	}

	@Test
	public void test19() {
		Object implementation = new Object();

		DummyLazyInitializer lazyInitializer = new DummyLazyInitializer();
		lazyInitializer.setImplementation(implementation);

		DummyHibernateProxy proxy = new DummyHibernateProxy();
		proxy.setLazyInitializer(lazyInitializer);
		aeq(implementation, Hibernate.unproxy(proxy));
	}

	/**
	 * When proxy is an HibernateProxy which has been initialized, and its
	 * implementation is an interceptable whose interceptor is lazy, then property
	 * initialization is queried to that interceptor
	 */
	@Test
	public void test20() {

		HashSet<String> lazyFields = new HashSet<String>();
		lazyFields.add("lazyProp");

		LazyAttributeLoadingInterceptor lazyInterceptor = new LazyAttributeLoadingInterceptor("entityName", lazyFields,
				null);

		DummyPersistentAttributeInterceptable interceptable = new DummyPersistentAttributeInterceptable();
		interceptable.$$_hibernate_setInterceptor(lazyInterceptor);

		DummyLazyInitializer lazyInitializer = new DummyLazyInitializer();
		lazyInitializer.setUninitialized(false);
		lazyInitializer.setImplementation(interceptable);

		DummyHibernateProxy proxy = new DummyHibernateProxy();
		proxy.setLazyInitializer(lazyInitializer);

		af(Hibernate.isPropertyInitialized(proxy, "lazyProp"));
		at(Hibernate.isPropertyInitialized(proxy, "nonLazyProp"));
	}

	/**
	 * When the proxy is an HibernateProxy which has not been initialized, then the
	 * answer is always false
	 */
	@Test
	public void test21() {

		HashSet<String> lazyFields = new HashSet<String>();
		lazyFields.add("lazyProp");

		LazyAttributeLoadingInterceptor lazyInterceptor = new LazyAttributeLoadingInterceptor("entityName", lazyFields,
				null);

		DummyPersistentAttributeInterceptable interceptable = new DummyPersistentAttributeInterceptable();
		interceptable.$$_hibernate_setInterceptor(lazyInterceptor);

		DummyLazyInitializer lazyInitializer = new DummyLazyInitializer();
		lazyInitializer.setUninitialized(true);
		lazyInitializer.setImplementation(interceptable);

		DummyHibernateProxy proxy = new DummyHibernateProxy();
		proxy.setLazyInitializer(lazyInitializer);

		af(Hibernate.isPropertyInitialized(proxy, "lazyProp"));
		af(Hibernate.isPropertyInitialized(proxy, "nonLazyProp"));
	}

	/**
	 * The proxy can be directly the interceptable (i.e. there is no proxy)
	 */
	@Test
	public void test22() {

		HashSet<String> lazyFields = new HashSet<String>();
		lazyFields.add("lazyProp");

		LazyAttributeLoadingInterceptor lazyInterceptor = new LazyAttributeLoadingInterceptor("entityName", lazyFields,
				null);

		DummyPersistentAttributeInterceptable interceptable = new DummyPersistentAttributeInterceptable();
		interceptable.$$_hibernate_setInterceptor(lazyInterceptor);

		af(Hibernate.isPropertyInitialized(interceptable, "lazyProp"));
		at(Hibernate.isPropertyInitialized(interceptable, "nonLazyProp"));
	}

	/**
	 * If the interceptor is not LazyAttributeLoadingInterceptor, then the answer is
	 * always true
	 */
	@Test
	public void test23() {

		PersistentAttributeInterceptor interceptor = new DummyPersistentAttributeInterceptor();

		DummyPersistentAttributeInterceptable interceptable = new DummyPersistentAttributeInterceptable();
		interceptable.$$_hibernate_setInterceptor(interceptor);

		at(Hibernate.isPropertyInitialized(interceptable, "lazyProp"));
		at(Hibernate.isPropertyInitialized(interceptable, "nonLazyProp"));
	}

	/**
	 * The interceptor can ben null
	 */
	@Test
	public void test24() {

		DummyPersistentAttributeInterceptable interceptable = new DummyPersistentAttributeInterceptable();
		interceptable.$$_hibernate_setInterceptor(null);

		at(Hibernate.isPropertyInitialized(interceptable, "lazyProp"));
		at(Hibernate.isPropertyInitialized(interceptable, "nonLazyProp"));
	}

	/**
	 * The interceptable can actually be anything, and it's always true
	 */
	@Test
	public void test25() {
		Object anything = new Object();
		at(Hibernate.isPropertyInitialized(anything, "lazyProp"));
		at(Hibernate.isPropertyInitialized(anything, "nonLazyProp"));
	}

	/**
	 * Closing an iterator close an hibernate iterator
	 */
	@Test
	public void test26() {
		DummyHibernateIterator iterator = new DummyHibernateIterator();
		Hibernate.close(iterator);
		event(iterator, "close");
	}
	
	/**
	 * and only works on Hibernate iterators
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test27() {
		Iterator<Object> iterator = new DummyIterator<Object>();
		Hibernate.close(iterator);
	}


}
