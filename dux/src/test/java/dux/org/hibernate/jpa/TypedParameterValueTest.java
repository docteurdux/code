package dux.org.hibernate.jpa;

import org.hibernate.jpa.TypedParameterValue;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.type.DummyType;

@Done
public class TypedParameterValueTest extends AbstractTest {

	@Test
	public void test() {

		DummyType type = new DummyType();
		Object value = new Object();

		TypedParameterValue tpv = new TypedParameterValue(type, value);

		aeqr(type, tpv.getType());
		aeqr(value, tpv.getValue());
	}
}
