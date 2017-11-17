package dux.org.hibernate.boot.jaxb.hbm.spi;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.boot.jaxb.hbm.spi.Adapter3;
import org.hibernate.engine.spi.ExecuteUpdateResultCheckStyle;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class Adapter3Test extends AbstractTest {

	private Map<ExecuteUpdateResultCheckStyle, String> map;

	@Before
	public void before() {

		map = new HashMap<>();
		map.put(ExecuteUpdateResultCheckStyle.NONE, "none");
		map.put(ExecuteUpdateResultCheckStyle.COUNT, "rowcount");
		map.put(ExecuteUpdateResultCheckStyle.PARAM, "param");
	}

	@Test
	public void test() {
		
		Adapter3 adapter = new Adapter3();

		for (ExecuteUpdateResultCheckStyle executeUpdateResultCheckStyle : ExecuteUpdateResultCheckStyle.values()) {
			String string = map.get(executeUpdateResultCheckStyle);
			aeq(string, adapter.marshal(executeUpdateResultCheckStyle));
			aeq(executeUpdateResultCheckStyle, adapter.unmarshal(string));
		}
	}
}
