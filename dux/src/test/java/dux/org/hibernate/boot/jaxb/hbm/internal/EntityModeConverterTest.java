package dux.org.hibernate.boot.jaxb.hbm.internal;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.EntityMode;
import org.hibernate.boot.jaxb.hbm.internal.EntityModeConverter;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class EntityModeConverterTest extends AbstractTest {

	Map<EntityMode, String> map = new HashMap<>();

	@Before
	public void before() {
		map.put(EntityMode.POJO, "pojo");
		map.put(EntityMode.MAP, "dynamic-map");

	}

	@Test
	public void test() {

		an(EntityModeConverter.toXml(null));

		for (EntityMode em : EntityMode.values()) {
			String text = map.get(em);
			aeq(text, EntityModeConverter.toXml(em));
			aeq(em, EntityModeConverter.fromXml(text));
		}
	}
}
