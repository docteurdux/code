package dux.org.hibernate.engine.config.spi;

import org.hibernate.engine.config.spi.StandardConverters;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class StandardConvertersTest extends AbstractTest {

	@Test(expected = IllegalArgumentException.class)
	public void test1() {
		StandardConverters.BOOLEAN.convert(null);
	}

	@Test
	public void test2() {
		aeq(true, StandardConverters.BOOLEAN.convert(true));
	}

	@Test
	public void test3() {

		Object object = new Object() {
			@Override
			public String toString() {
				return "true";
			}
		};

		aeq(true, StandardConverters.BOOLEAN.convert(object));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test4() {
		StandardConverters.STRING.convert(null);
	}

	@Test
	public void test5() {

		Object object = new Object() {
			@Override
			public String toString() {
				return "value";
			}
		};

		aeq("value", StandardConverters.STRING.convert(object));
	}
}
