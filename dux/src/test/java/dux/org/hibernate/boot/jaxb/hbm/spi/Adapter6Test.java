package dux.org.hibernate.boot.jaxb.hbm.spi;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.boot.jaxb.hbm.spi.Adapter6;
import org.hibernate.tuple.GenerationTiming;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done("Same as Adapter7Test")
public class Adapter6Test extends AbstractTest {

	private Map<GenerationTiming, String> map;

	@Before
	public void before() {
		map = new HashMap<>();
		map.put(GenerationTiming.NEVER, "never");
		map.put(GenerationTiming.INSERT, "insert");
		map.put(GenerationTiming.ALWAYS, "always");

	}

	@Test
	public void test() {

		Adapter6 adapter = new Adapter6();

		for (GenerationTiming gt : GenerationTiming.values()) {
			aeq(map.get(gt), adapter.marshal(gt));
			aeq(gt, adapter.unmarshal(map.get(gt)));
		}
	}
}
