package dux.org.hibernate.boot.jaxb.hbm.spi;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.CacheMode;
import org.hibernate.boot.jaxb.hbm.spi.Adapter1;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class Adapter1Test extends AbstractTest {

	private Map<CacheMode, String> map;

	@Before
	public void before() {
		map = new HashMap<>();
		map.put(CacheMode.NORMAL, "normal");
		map.put(CacheMode.IGNORE, "ignore");
		map.put(CacheMode.GET, "get");
		map.put(CacheMode.PUT, "put");
		map.put(CacheMode.REFRESH, "refresh");

	}

	@Test
	public void test() {
		Adapter1 adapter = new Adapter1();
		for (CacheMode cacheMode : CacheMode.values()) {
			String cacheModeStr = map.get(cacheMode);
			aeq(cacheModeStr, adapter.marshal(cacheMode));
			aeq(cacheMode, adapter.unmarshal(cacheModeStr));
		}
	}
}
