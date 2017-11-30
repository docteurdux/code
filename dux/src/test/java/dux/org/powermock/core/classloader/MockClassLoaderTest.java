package dux.org.powermock.core.classloader;

import org.junit.Before;
import org.junit.Test;
import org.powermock.core.classloader.MockClassLoader;

import com.github.docteurdux.test.AbstractTest;

public class MockClassLoaderTest extends AbstractTest {

	public static class A {
		public String foo() {
			return "foo";
		}
	}

	@Before
	public void before() {
		requireSources("powermock-core-1.6.4", MockClassLoader.class);
	}

	@Test
	public void test() throws Exception {
		MockClassLoader mcl = new MockClassLoader(
				new String[] { "dux.org.powermock.core.classloader.MockClassLoaderTest$A" });
		ClassLoader cl = mcl;
		Class<?> clazz = cl.loadClass("dux.org.powermock.core.classloader.MockClassLoaderTest$A");
		Object o = clazz.newInstance();

	}
}
