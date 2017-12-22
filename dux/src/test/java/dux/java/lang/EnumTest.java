package dux.java.lang;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class EnumTest extends AbstractTest {

	private static enum E {
		V
	};

	@Test(expected = IllegalArgumentException.class)
	public void test() {
		E.valueOf("X");
	}
}
