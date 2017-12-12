package dux.org.ehcache.config;

import java.util.HashMap;
import java.util.Map;

import org.ehcache.config.ResourcePool;
import org.ehcache.config.ResourcePools;
import org.ehcache.config.ResourceType;
import org.ehcache.core.config.ResourcePoolsImpl;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(ResourcePools.class)
public class ResourcePoolsTest extends AbstractTest {
	@Test
	public void test() {

		Map<ResourceType<?>, ResourcePool> pools = new HashMap<>();
		ResourcePoolsImpl r = new ResourcePoolsImpl(pools);

		/*-
		getPoolForResource(ResourceType<P>)
		getResourceTypeSet()
		validateAndMerge(ResourcePools)
		 */
	}
}
