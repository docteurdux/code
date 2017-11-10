package dux.org.hibernate.boot.jaxb.hbm.internal;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.boot.jaxb.hbm.internal.ExecuteUpdateResultCheckStyleConverter;
import org.hibernate.engine.spi.ExecuteUpdateResultCheckStyle;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class ExecuteUpdateResultCheckStyleConverterTest extends AbstractTest {

	Map<ExecuteUpdateResultCheckStyle, String> map = new HashMap<>();

	@Before
	public void before() {
		map.put(ExecuteUpdateResultCheckStyle.NONE, "none");
		map.put(ExecuteUpdateResultCheckStyle.COUNT, "rowcount");
		map.put(ExecuteUpdateResultCheckStyle.PARAM, "param");

	}

	@Test
	public void test() {

		for (ExecuteUpdateResultCheckStyle style : ExecuteUpdateResultCheckStyle.values()) {
			String text = map.get(style);
			aeq(style, ExecuteUpdateResultCheckStyleConverter.fromXml(text));
		}
	}
}
