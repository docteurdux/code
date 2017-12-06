package dux.org.springframework.core.env;

import org.glassfish.config.support.PropertyResolver;
import org.junit.Test;

import com.github.docteurdux.test.Topic;

@Topic(PropertyResolver.class)
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
	}
}
