package dux.org.hibernate.boot.jaxb.hbm.spi;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.boot.jaxb.hbm.spi.Adapter2;
import org.hibernate.cache.spi.access.AccessType;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class Adapter2Test extends AbstractTest {

	private Map<AccessType, String> map;

	@Before
	public void before() {
		map = new HashMap<>();
		map.put(AccessType.READ_ONLY, "read-only");
		map.put(AccessType.READ_WRITE, "read-write");
		map.put(AccessType.NONSTRICT_READ_WRITE, "nonstrict-read-write");
		map.put(AccessType.TRANSACTIONAL, "transactional");
	}

	@Test
	public void test() {
		Adapter2 adapter = new Adapter2();
		for (AccessType accessType : AccessType.values()) {
			String accessTypeStr = map.get(accessType);
			aeq(accessTypeStr, adapter.marshal(accessType));
			aeq(accessType, adapter.unmarshal(accessTypeStr));
		}
	}
}
