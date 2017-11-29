package dux.org.springframework.cglib;

import java.lang.reflect.Method;

import org.hibernate.dialect.MySQL57Dialect;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.github.docteurdux.test.AbstractTest;

public class CglibTest extends AbstractTest {

	public static class A {
		public String foo() {
			return "foo";
		}
	}

	@Test
	public void test() {

		Enhancer e = new Enhancer();
		e.setSuperclass(A.class);
		e.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object o, Method m, Object[] args, MethodProxy p) throws Throwable {
				return "bar";
			}
		});

		A a = (A) e.create();
		aeq("bar", a.foo());

	}
}
