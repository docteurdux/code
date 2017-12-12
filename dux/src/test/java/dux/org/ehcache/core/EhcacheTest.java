package dux.org.ehcache.core;

import org.ehcache.config.CacheConfiguration;
import org.ehcache.core.Ehcache;
import org.ehcache.core.events.CacheEventDispatcher;
import org.ehcache.core.spi.store.Store;
import org.junit.Test;
import org.slf4j.Logger;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(Ehcache.class)
public class EhcacheTest extends AbstractTest {

	public static class K {

	}

	public static class V {

	}

	@Test
	public void test() {
		CacheConfiguration<K, V> configuration = null;
		Store<K, V> store = null;
		CacheEventDispatcher<K, V> eventDispatcher = null;
		Logger logger = null;
		Ehcache<K, V> cache = new Ehcache<>(configuration, store, eventDispatcher, logger);
	}
}
