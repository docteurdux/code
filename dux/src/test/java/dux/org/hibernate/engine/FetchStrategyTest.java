package dux.org.hibernate.engine;

import org.hibernate.engine.FetchStrategy;
import org.hibernate.engine.FetchStyle;
import org.hibernate.engine.FetchTiming;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class FetchStrategyTest extends AbstractTest {

	@Test
	public void test() {

		FetchTiming fetchTiming = FetchTiming.IMMEDIATE;
		FetchStyle fetchStyle = FetchStyle.SELECT;

		FetchStrategy fetchStrategy = new FetchStrategy(fetchTiming, fetchStyle);

		aeq(fetchTiming, fetchStrategy.getTiming());
		aeq(fetchStyle, fetchStrategy.getStyle());
	}
}
