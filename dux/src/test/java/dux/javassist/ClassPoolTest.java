package dux.javassist;

import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Instrumenter;
import com.github.docteurdux.test.TestEvents;

import javassist.ClassPool;

public class ClassPoolTest extends AbstractTest {

	public static class A {
		public String foo() {
			return "foo";
		}
	}

	public static class B extends A {
		public String bar() {
			return "bar";
		}
	}

	@Before
	public void before() {
		requireSources("javassist-3.20.0-GA", ClassPool.class);
	}

	@Test
	public void test() throws Exception {

		Class clazz = Instrumenter.instrument("dux.javassist.ClassPoolTest$B");
		System.out.println(clazz.getClassLoader().getClass().getName());

		B b = new B();

		System.out.println(TestEvents.getIdentity(b));
		System.out.println(b.bar());
		System.out.println(b.foo());
	}

}
