package dux.org.hibernate.proxy;

import org.hibernate.proxy.HibernateProxyHelper;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.proxy.DummyHibernateProxy;
import dum.org.hibernate.proxy.DummyLazyInitializer;

@Done
public class HibernateProxyHelperTest extends AbstractTest {

	public static class A {

	}

	public static class B {

	}

	private A object;
	private DummyLazyInitializer lazyInitializer;
	private DummyHibernateProxy hibernateProxy;

	public HibernateProxyHelperTest() {

		object = new A();

		lazyInitializer = new DummyLazyInitializer();
		lazyInitializer.setPersistentClass(B.class);

		hibernateProxy = new DummyHibernateProxy();
		hibernateProxy.setLazyInitializer(lazyInitializer);

	}

	@Test
	public void test() {

		aeq(A.class, HibernateProxyHelper.getClassWithoutInitializingProxy(object));

		aeq(B.class, HibernateProxyHelper.getClassWithoutInitializingProxy(hibernateProxy));
	}
}
