package dux.org.hibernate.cache.internal;

import org.hibernate.cache.internal.StandardQueryCache;
import org.hibernate.cache.internal.StandardQueryCacheFactory;
import org.hibernate.cache.spi.QueryCache;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.cache.spi.DummyQueryResultsRegion;
import dum.org.hibernate.engine.spi.DummyCacheImplementor;

@Done
public class StandardQueryCacheFactoryTest extends AbstractTest {
	private DummyQueryResultsRegion region;
	private DummyCacheImplementor cacheManager;

	@Before
	public void before() {
		region = new DummyQueryResultsRegion();
		cacheManager = new DummyCacheImplementor();
	}

	@Test
	public void test() {
		QueryCache queryCache = StandardQueryCacheFactory.INSTANCE.buildQueryCache(region, cacheManager);
		aeq(StandardQueryCache.class, queryCache.getClass());
		aeqr(region, queryCache.getRegion());

	}
}
