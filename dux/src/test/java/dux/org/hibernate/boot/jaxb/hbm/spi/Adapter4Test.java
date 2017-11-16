package dux.org.hibernate.boot.jaxb.hbm.spi;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.EntityMode;
import org.hibernate.boot.jaxb.hbm.spi.Adapter4;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class Adapter4Test extends AbstractTest {

	private Map<EntityMode, String> map;

	@Before
	public void before() {
		map = new HashMap<>();
		map.put(EntityMode.POJO, "pojo");
		map.put(EntityMode.MAP, "dynamic-map");

	}

	@Test
	public void test() {
		Adapter4 adapter = new Adapter4();
		for (EntityMode entityMode : EntityMode.values()) {
			String entityModeStr = map.get(entityMode);
			aeq(entityModeStr, adapter.marshal(entityMode));
			aeq(entityMode, adapter.unmarshal(entityModeStr));
		}
	}
}
