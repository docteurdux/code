package dux.java.lang;

import java.util.Map;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class SystemTest extends AbstractTest {
	@Test
	public void test() {

		SecurityManager sm = System.getSecurityManager();
		aeq(null, sm);

		Map<String, String> env = System.getenv();
		aeq(false, env.containsKey("foo"));

		System.setProperty("foo", "bar");
		aeq(false, env.containsKey("foo"));
	}
}
