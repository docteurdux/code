package dux.java.lang;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class ClassTest extends AbstractTest {

	public static class A {

	}

	@Test
	public void test() {
		aeq(Object.class, A.class.getSuperclass());
		aeq(null, Object.class.getSuperclass());
	}
}
