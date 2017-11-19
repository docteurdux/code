package dux.org.hibernate.boot;

import org.hibernate.boot.CacheRegionDefinition;
import org.hibernate.boot.CacheRegionDefinition.CacheRegionType;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class CacheRegionDefinitionTest extends AbstractTest {

	private CacheRegionType cacheRegionType;
	private String role;
	private String usage;
	private String region;
	private boolean lazy;

	@Before
	public void before() {
		cacheRegionType = CacheRegionType.COLLECTION;
		role = "role";
		usage = "usage";
		region = "region";
		lazy = false;
	}

	@Test
	public void test() {

		CacheRegionDefinition cacheRegionDefinition = new CacheRegionDefinition(cacheRegionType, role, usage, region,
				lazy);

		aeq(cacheRegionType, cacheRegionDefinition.getRegionType());
		aeq(role, cacheRegionDefinition.getRole());
		aeq(usage, cacheRegionDefinition.getUsage());
		aeq(region, cacheRegionDefinition.getRegion());
		aeq(lazy, cacheRegionDefinition.isCacheLazy());
	}
}
