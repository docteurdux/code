package dux.org.springframework.core.env;

import org.junit.Test;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySources;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

@Topic(PropertySources.class)
@Prerequisites({ PropertySourceTest.class })
public class PropertySourcesTest extends AbstractTest {
	@Test
	public void test() {

		MutablePropertySources s = new MutablePropertySources();

		s.contains("property");
		s.get("property");

	}
}
