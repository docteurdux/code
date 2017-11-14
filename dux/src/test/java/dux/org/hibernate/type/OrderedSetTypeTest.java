package dux.org.hibernate.type;

import java.util.LinkedHashSet;

import org.hibernate.type.OrderedSetType;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.type.TypeFactory.DummyTypeScope;

@Done
public class OrderedSetTypeTest extends AbstractTest {

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

		OrderedSetType orderedSetType = new OrderedSetType(typeScope, role, propertyRef);

		@SuppressWarnings("rawtypes")
		LinkedHashSet lhs = (LinkedHashSet) orderedSetType.instantiate(anticipatedSize);

		aeq(0, lhs.size());
	}
}
