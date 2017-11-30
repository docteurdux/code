package dux.java.lang;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class BooleanTest extends AbstractTest {
	@Test
	public void test() {
		aeq(true, Boolean.TYPE.isPrimitive());
	}
}
