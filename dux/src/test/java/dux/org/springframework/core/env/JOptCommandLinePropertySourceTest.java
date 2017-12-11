package dux.org.springframework.core.env;

import org.junit.Test;
import org.springframework.core.env.JOptCommandLinePropertySource;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

import joptsimple.OptionSet;

@Topic(JOptCommandLinePropertySource.class)
public class JOptCommandLinePropertySourceTest extends AbstractTest {
	@Test
	public void test() {
		OptionSet options = null;
		JOptCommandLinePropertySource s = new JOptCommandLinePropertySource("name", options );
	}
}
