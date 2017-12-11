package dux.org.springframework.core.env;

import org.junit.Test;
import org.springframework.core.env.PropertyResolver;
import org.springframework.core.env.PropertySources;
import org.springframework.core.env.PropertySourcesPropertyResolver;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

@Topic(PropertyResolver.class)
@Prerequisites({PropertySourcesTest.class})
public class PropertyResolverTest {

	@Test
	public void test() {
		/*-
		containsProperty(String)
		getProperty(String)
		getProperty(String, Class<T>)
		getProperty(String, Class<T>, T)
		getProperty(String, String)
		getRequiredProperty(String)
		getRequiredProperty(String, Class<T>)
		resolvePlaceholders(String)
		resolveRequiredPlaceholders(String)
		*/

		PropertySources propertySources = null;
		PropertySourcesPropertyResolver r = new PropertySourcesPropertyResolver(propertySources);
	}
}
