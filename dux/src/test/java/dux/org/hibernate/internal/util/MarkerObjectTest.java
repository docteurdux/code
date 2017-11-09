package dux.org.hibernate.internal.util;

import org.hibernate.internal.util.MarkerObject;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class MarkerObjectTest extends AbstractTest {
	@Test
	public void test() {
		MarkerObject mo = new MarkerObject("name");
		aeq("name", mo.toString());
	}
}
