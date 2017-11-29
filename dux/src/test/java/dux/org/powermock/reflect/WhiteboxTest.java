package dux.org.powermock.reflect;

import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import com.github.docteurdux.test.AbstractTest;

public class WhiteboxTest extends AbstractTest {

	public static class A {

	}

	@Before
	public void before() {
		requireSources("powermock-reflect-1.6.4", Whitebox.class);
	}

	@Test
	public void test() {
		A a = new A();
		Whitebox.getAllInstanceFields(a);
	}
}
