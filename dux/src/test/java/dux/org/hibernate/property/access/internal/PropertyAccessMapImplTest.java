package dux.org.hibernate.property.access.internal;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.property.access.internal.PropertyAccessMapImpl;
import org.hibernate.property.access.internal.PropertyAccessStrategyMapImpl;
import org.hibernate.property.access.spi.Getter;
import org.hibernate.property.access.spi.Setter;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.engine.spi.DummySharedSessionContractImplementor;

@Done
public class PropertyAccessMapImplTest extends AbstractTest {

	private String propertyName;

	private Object firstValue;
	private Object secondValue;

	private Map<String, Object> owner;

	private PropertyAccessStrategyMapImpl propertyAccessStrategyMapImpl;
	@SuppressWarnings("rawtypes")
	private Map ignoredMergeMap;
	private DummySharedSessionContractImplementor ignoredSharedSessionContractImplementor;

	private DummySessionFactoryImplementor ignoredSessionFactoryImplementor;

	@Before
	public void before() {

		propertyName = "propertyName";

		firstValue = new Object();
		secondValue = new Object();

		owner = new HashMap<>();
		owner.put(propertyName, firstValue);

		propertyAccessStrategyMapImpl = new PropertyAccessStrategyMapImpl();

		ignoredMergeMap = new HashMap<>();

		ignoredSharedSessionContractImplementor = new DummySharedSessionContractImplementor();
		ignoredSessionFactoryImplementor = new DummySessionFactoryImplementor();
	}

	@Test
	public void test() {
		PropertyAccessMapImpl propertyAccessMapImpl = new PropertyAccessMapImpl(propertyAccessStrategyMapImpl,
				propertyName);
		aeqr(propertyAccessStrategyMapImpl, propertyAccessMapImpl.getPropertyAccessStrategy());

		Getter getter = propertyAccessMapImpl.getGetter();
		aeqr(firstValue, getter.get(owner));
		aeqr(firstValue, getter.getForInsert(owner, ignoredMergeMap, ignoredSharedSessionContractImplementor));

		aeq(Object.class, getter.getReturnType());

		aeq(null, getter.getMember());
		aeq(null, getter.getMethodName());
		aeq(null, getter.getMethod());

		Setter setter = propertyAccessMapImpl.getSetter();
		setter.set(owner, secondValue, ignoredSessionFactoryImplementor);
		aeqr(secondValue, owner.get(propertyName));

		aeq(null, setter.getMethodName());
		aeq(null, setter.getMethod());
	}
}
