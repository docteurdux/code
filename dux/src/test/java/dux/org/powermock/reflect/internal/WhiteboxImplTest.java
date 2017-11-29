package dux.org.powermock.reflect.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.exceptions.TooManyMethodsFoundException;
import org.powermock.reflect.internal.WhiteboxImpl;

import com.github.docteurdux.test.AbstractTest;

public class WhiteboxImplTest extends AbstractTest {

	private Method a$foo;

	public static class A {
		public void foo(String input) {

		}
	}

	public static class B {
		public void foo(String input) {

		}

		public void bar(String input) {

		}
	}

	public static class C {
		private String foo = "foo";
	}

	public static class D extends C {
		private String bar = "bar";
	}

	@Before
	public void before() throws Exception {
		requireSources("powermock-reflect-1.6.4", WhiteboxImpl.class);

		a$foo = A.class.getMethod("foo", String.class);

	}

	@Test
	public void test1() throws Exception {
		aeq(a$foo, WhiteboxImpl.getMethod(A.class, String.class));
	}

	@Test(expected = TooManyMethodsFoundException.class)
	public void test2() throws Exception {
		WhiteboxImpl.getMethod(B.class, String.class);
	}

	@Test
	public void test3() throws Exception {
		aeq(a$foo, WhiteboxImpl.getMethod(A.class, "foo", String.class));

	}

	@Test
	public void test4() throws Exception {
		Field c$foo = C.class.getDeclaredField("foo");
		aeq(c$foo, WhiteboxImpl.getField(D.class, "foo"));

	}
}
