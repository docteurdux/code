package dux.org.springframework.core.env;

import org.junit.Test;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(SimpleCommandLinePropertySource.class)
public class SimpleCommandLinePropertySourceTest extends AbstractTest {
	@Test
	public void test() {
		SimpleCommandLinePropertySource s = new SimpleCommandLinePropertySource("a", "b", "c");
		s.getProperty("foo");
	}
}
