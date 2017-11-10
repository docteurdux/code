package dux.org.hibernate.tuple;

import org.hibernate.tuple.AbstractAttribute;
import org.hibernate.type.Type;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.type.DummyType;

@Done
public class AbstractAttributeTest extends AbstractTest {

	@Test
	public void test() {

		Type type = new DummyType();
		String name = "attributeName";

		AbstractAttribute aa = new AbstractAttribute(name, type) {
		};

		an(aa.getNode());
		aeq(name, aa.getName());
		aeqr(type, aa.getType());

	}
}
