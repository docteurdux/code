package dux.javassist;

import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.TestEvents;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

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

		ClassPool pool = ClassPool.getDefault();

		CtClass ca = pool.get("dux.javassist.ClassPoolTest$A");
		for (CtMethod m : ca.getMethods()) {
			if (!"java.lang.Object".equals(m.getDeclaringClass().getName())) {
				String n = m.getName();
//				System.out.println(n);
				m.insertBefore("dux.javassist.ClassPoolTest.hello(\"" + n + "\");");
			}
		}
		ca.toClass();

		CtClass cc = pool.get("dux.javassist.ClassPoolTest$B");
		for (CtMethod m : cc.getMethods()) {
			if ("dux.javassist.ClassPoolTest$B".equals(m.getDeclaringClass().getName())) {
				String n = m.getName();
//				System.out.println(n);
				m.insertBefore("dux.javassist.ClassPoolTest.hello(\"" + n + "\");");
			}
		}
		Class cl = cc.toClass();
		//B b = (B) cl.newInstance();
		B b = new B();
		System.out.println(TestEvents.getIdentity(b));
		System.out.println(b.bar());
		System.out.println(b.foo());
	}

	public static void hello(String name) {
		System.out.println("Hello from " + name);
	}
}
