package dux.org.ehcache.core.config;

import org.ehcache.core.config.DefaultConfiguration;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(DefaultConfiguration.class)
public class DefaultConfigurationTest extends AbstractTest {
	@Test
	public void test() {

		ClassLoader classLoader = this.getClass().getClassLoader();
		DefaultConfiguration c = new DefaultConfiguration(classLoader);

		aeqr(classLoader, c.getClassLoader());
		aeq(0, c.getCacheConfigurations().size());
		aeq(0, c.getServiceCreationConfigurations().size());

		/*-
		DefaultConfiguration(ClassLoader, ServiceCreationConfiguration<?>...)
		DefaultConfiguration(Map<String, CacheConfiguration<?, ?>>, ClassLoader, ServiceCreationConfiguration<?>...)
		DefaultConfiguration(Configuration)
		addCacheConfiguration(String, CacheConfiguration<?, ?>)
		readableString()
		removeCacheConfiguration(String)
		replaceCacheConfiguration(String, CacheConfiguration<K, V>, CacheRuntimeConfiguration<K, V>)
		 */

	}
}
