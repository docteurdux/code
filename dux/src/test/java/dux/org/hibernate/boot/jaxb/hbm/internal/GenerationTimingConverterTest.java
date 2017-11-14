package dux.org.hibernate.boot.jaxb.hbm.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.boot.jaxb.hbm.internal.GenerationTimingConverter;
import org.hibernate.tuple.GenerationTiming;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class GenerationTimingConverterTest extends AbstractTest {

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

		for (Entry<GenerationTiming, String> entry : map.entrySet()) {
			GenerationTiming key = entry.getKey();
			String value = entry.getValue();
			aeq(value, GenerationTimingConverter.toXml(key));
			aeq(key, GenerationTimingConverter.fromXml(value));
		}

		an(GenerationTimingConverter.toXml(null));

	}
}
