package dux.org.springframework.core.env;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(SystemEnvironmentPropertySource.class)
public class SystemEnvironmentPropertySourceTest extends AbstractTest {
	@Test
	public void test() {
		Map<String, Object> source = new HashMap<>();
		SystemEnvironmentPropertySource s = new SystemEnvironmentPropertySource("name", source);

	}
}
