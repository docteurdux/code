package dux.org.ehcache.config;

import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.EvictionAdvisor;
import org.ehcache.config.ResourcePools;
import org.ehcache.core.config.BaseCacheConfiguration;
import org.ehcache.expiry.Expiry;
import org.ehcache.spi.service.ServiceConfiguration;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(CacheConfiguration.class)
public final class CacheConfigurationTest extends AbstractTest {

	public static class K {

	}

	public static class V {

	}

	@Test
	public void test() {

		EvictionAdvisor<K, V> evictionAdvisor = null;
		Expiry<K, V> expiry = null;
		ResourcePools resourcePools = null;
		ServiceConfiguration serviceConfigurations1 = null;
		ServiceConfiguration serviceConfigurations2 = null;

		BaseCacheConfiguration<K, V> base = new BaseCacheConfiguration<>(K.class, V.class, evictionAdvisor,
				this.getClass().getClassLoader(), expiry, resourcePools, serviceConfigurations1,
				serviceConfigurations2);
		/*-
		getClassLoader()
		getEvictionAdvisor()
		getExpiry()
		getKeyType()
		getResourcePools()
		getServiceConfigurations()
		getValueType()
		 */

	}
}
