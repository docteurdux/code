package dux.org.hibernate.boot.jaxb.hbm.spi;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.boot.jaxb.hbm.spi.Adapter9;
import org.hibernate.engine.OptimisticLockStyle;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class Adapter9Test extends AbstractTest {

	private Map<OptimisticLockStyle, String> map;

	@Before
	public void before() {
		map = new HashMap<>();
		map.put(OptimisticLockStyle.NONE, "none");
		map.put(OptimisticLockStyle.VERSION, "version");
		map.put(OptimisticLockStyle.DIRTY, "dirty");
		map.put(OptimisticLockStyle.ALL, "all");

	}

	@Test
	public void test() {
		Adapter9 adapter = new Adapter9();
		for (OptimisticLockStyle optimisticLockStyle : OptimisticLockStyle.values()) {
			String optimisticLockStyleStr = map.get(optimisticLockStyle);
			aeq(optimisticLockStyleStr, adapter.marshal(optimisticLockStyle));
			aeq(optimisticLockStyle, adapter.unmarshal(optimisticLockStyleStr));
		}
	}
}
