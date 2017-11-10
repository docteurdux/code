package dux.org.hibernate.boot.jaxb.hbm.internal;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.LockMode;
import org.hibernate.boot.jaxb.hbm.internal.LockModeConverter;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class LockModeConverterTest extends AbstractTest {

	private Map<LockMode, String> map = new HashMap<>();

	@SuppressWarnings("deprecation")
	@Before
	public void before() {
		map.put(LockMode.NONE, "none");
		map.put(LockMode.READ, "read");
		map.put(LockMode.UPGRADE, "upgrade");
		map.put(LockMode.UPGRADE_NOWAIT, "upgrade-nowait");
		map.put(LockMode.UPGRADE_SKIPLOCKED, "upgrade-skiplocked");
		map.put(LockMode.WRITE, "write");
		map.put(LockMode.FORCE, "force");
		map.put(LockMode.OPTIMISTIC, "optimistic");
		map.put(LockMode.OPTIMISTIC_FORCE_INCREMENT, "optimistic_force_increment");
		map.put(LockMode.PESSIMISTIC_READ, "pessimistic_read");
		map.put(LockMode.PESSIMISTIC_WRITE, "pessimistic_write");
		map.put(LockMode.PESSIMISTIC_FORCE_INCREMENT, "pessimistic_force_increment");
	}

	@Test
	public void test() {

		for (LockMode lm : LockMode.values()) {
			String text = map.get(lm);
			aeq(text, LockModeConverter.toXml(lm));
			aeq(lm, LockModeConverter.fromXml(text));
		}
	}
}
