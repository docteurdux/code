package dux.org.hibernate.bytecode.internal.bytebuddy;

import org.hibernate.bytecode.internal.bytebuddy.ProxyFactoryFactoryImpl;
import org.hibernate.bytecode.spi.BasicProxyFactory;
import org.hibernate.proxy.ProxyFactory;
import org.hibernate.proxy.pojo.bytebuddy.ByteBuddyProxyFactory;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;

@Done
public class ProxyFactoryFactoryImplTest extends AbstractTest {

	private DummySessionFactoryImplementor sessionFactoryImplementor;

	public static class A {

	}

	public ProxyFactoryFactoryImplTest() {
		sessionFactoryImplementor = new DummySessionFactoryImplementor();
	}

	@Test
	public void test() {

		ProxyFactoryFactoryImpl proxyFactoryFactoryImpl = new ProxyFactoryFactoryImpl();

		BasicProxyFactory basicProxyFactory = proxyFactoryFactoryImpl.buildBasicProxyFactory(A.class, null);
		Object proxy = basicProxyFactory.getProxy();
		at(proxy.getClass().getName().indexOf("$ByteBuddy$") > 0);

		ProxyFactory proxyFactory = proxyFactoryFactoryImpl.buildProxyFactory(sessionFactoryImplementor);
		aeq(ByteBuddyProxyFactory.class, proxyFactory.getClass());

	}
}
