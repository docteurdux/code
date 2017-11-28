package dux.java.lang.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class ProxyTest extends AbstractTest {

	private ClassLoader classLoader;
	private Class<?>[] interfaces;
	private InvocationHandler stringInvocationHandler;

	public static interface I1 {
		public String foo1();
	}

	public static interface I2 {
		public String foo2();
	}

	public static class C implements I1, I2 {

		@Override
		public String foo1() {
			return "hello1";
		}

		@Override
		public String foo2() {
			return "hello2";
		}

	}

	@Before
	public void before() {
		classLoader = this.getClass().getClassLoader();
		interfaces = new Class<?>[] { I1.class, I2.class };
		stringInvocationHandler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				return method.getName();
			}
		};
	}

	@Test
	public void test1() throws Exception {

		Class<?> proxyClass = Proxy.getProxyClass(classLoader, interfaces);

		I1 i1 = (I1) proxyClass.getConstructor(InvocationHandler.class).newInstance(stringInvocationHandler);

		aeq("foo1", i1.foo1());

		I2 i2 = (I2) i1;

		aeq("foo2", i2.foo2());

		aeq("foo2", I2.class.getMethod("foo2").invoke(i2));
		aeq("foo2", i1.getClass().getMethod("foo2").invoke(i2));

		aeq(true, Proxy.isProxyClass(proxyClass));
		aeq(true, Proxy.isProxyClass(i1.getClass()));
		aeqr(stringInvocationHandler, Proxy.getInvocationHandler(i1));

	}

	public void test2() {
		I1 i1 = (I1) Proxy.newProxyInstance(classLoader, interfaces, stringInvocationHandler);
		aeq("foo1", i1.foo1());
	}

}
