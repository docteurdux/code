package dux.org.hibernate.boot.jaxb.hbm.internal;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.boot.jaxb.hbm.internal.CacheAccessTypeConverter;
import org.hibernate.cache.spi.access.AccessType;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class CacheAccessTypeConverterTest extends AbstractTest {

	private Map<AccessType, String> map = new HashMap<>();

	@Before
	public void before() {

		map.put(AccessType.READ_ONLY, "read-only");
		map.put(AccessType.READ_WRITE, "read-write");
		map.put(AccessType.NONSTRICT_READ_WRITE, "nonstrict-read-write");
		map.put(AccessType.TRANSACTIONAL, "transactional");

	}

	@Test
	public void test() {

		for (AccessType type : AccessType.values()) {
			String text = map.get(type);
			aeq(text, CacheAccessTypeConverter.toXml(type));
			aeq(type, CacheAccessTypeConverter.fromXml(text));
		}

	}
}
