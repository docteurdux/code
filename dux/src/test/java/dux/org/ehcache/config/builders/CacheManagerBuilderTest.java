package dux.org.ehcache.config.builders;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(CacheManagerBuilder.class)
public class CacheManagerBuilderTest extends AbstractTest {
	@Test
	public void test() {
		CacheManager cm = CacheManagerBuilder.newCacheManagerBuilder().build(true);

		Cache<Integer, Integer> squareNumberCache = cm.createCache("squaredNumber", CacheConfigurationBuilder
				.newCacheConfigurationBuilder(Integer.class, Integer.class, ResourcePoolsBuilder.heap(10)));
	}
}
