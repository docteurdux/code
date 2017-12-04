package dux.java.lang;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class SystemTest extends AbstractTest {
	@Test
	public void test() {
		SecurityManager sm = System.getSecurityManager();
		aeq(null, sm);

		SecurityManager s = null;
		System.setSecurityManager(s);
	}
}
