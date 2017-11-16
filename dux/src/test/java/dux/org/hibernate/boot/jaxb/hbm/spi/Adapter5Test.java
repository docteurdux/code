package dux.org.hibernate.boot.jaxb.hbm.spi;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.boot.jaxb.hbm.spi.Adapter5;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.RunnableWhichThrow;

@Done
public class Adapter5Test extends AbstractTest {

	private Map<FlushMode, String> map;

	@Before
	public void before() {
		map = new HashMap<>();
		map.put(FlushMode.MANUAL, "never");
		map.put(FlushMode.COMMIT, "commit");
		map.put(FlushMode.AUTO, "auto");
		map.put(FlushMode.ALWAYS, "always");

	}

	@Test
	public void test() {
		Adapter5 adapter = new Adapter5();
		for (FlushMode flushMode : FlushMode.values()) {
			String flushModeStr = map.get(flushMode);
			aeq(flushModeStr, adapter.marshal(flushMode));
			if (flushMode == FlushMode.COMMIT) {
				expect(HibernateException.class, new RunnableWhichThrow() {
					@Override
					public void run() throws Exception {
						adapter.unmarshal(flushModeStr);
					}
				});
			} else {
				aeq(flushMode, adapter.unmarshal(flushModeStr));
			}
		}

	}
}
