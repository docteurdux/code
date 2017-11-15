package dux.org.hibernate.boot.jaxb.hbm.internal;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.boot.jaxb.hbm.internal.OptimisticLockStyleConverter;
import org.hibernate.engine.OptimisticLockStyle;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class OptimisticLockStyleConverterTest extends AbstractTest {

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
	public void test1() {

		for (OptimisticLockStyle l : OptimisticLockStyle.values()) {
			String str = map.get(l);
			aeq(str, OptimisticLockStyleConverter.toXml(l));
			aeq(l, OptimisticLockStyleConverter.fromXml(str));
		}

		an(OptimisticLockStyleConverter.toXml(null));
	}

	@Test(expected = NullPointerException.class)
	public void test2() {
		an(OptimisticLockStyleConverter.fromXml(null));
	}
}
