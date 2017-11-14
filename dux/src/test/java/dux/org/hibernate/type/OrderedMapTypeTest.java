package dux.org.hibernate.type;

import java.util.LinkedHashMap;

import org.hibernate.type.OrderedMapType;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.type.TypeFactory.DummyTypeScope;

@Done
public class OrderedMapTypeTest extends AbstractTest {

	private DummyTypeScope typeScope;
	private String role;
	private String propertyRef;
	private int anticipatedSize;

	@Before
	public void before() {
		typeScope = new DummyTypeScope();
		role = "role";
		propertyRef = "propertyRef";
		anticipatedSize = 0;
	}

	@Test
	public void test() {

		OrderedMapType orderedMapType = new OrderedMapType(typeScope, role, propertyRef);

		@SuppressWarnings("rawtypes")
		LinkedHashMap linkedHashMap = (LinkedHashMap) orderedMapType.instantiate(anticipatedSize);

		aeq(0, linkedHashMap.size());

	}
}
