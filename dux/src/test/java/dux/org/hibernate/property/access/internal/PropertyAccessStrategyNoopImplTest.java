package dux.org.hibernate.property.access.internal;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.property.access.internal.PropertyAccessStrategyNoopImpl;
import org.hibernate.property.access.spi.Getter;
import org.hibernate.property.access.spi.PropertyAccess;
import org.hibernate.property.access.spi.Setter;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.engine.spi.DummySharedSessionContractImplementor;

@Done
public class PropertyAccessStrategyNoopImplTest extends AbstractTest {

	private Class<?> containerJavaType1;
	private Class<?> containerJavaType2;

	private String propertyName1;
	private String propertyName2;
	private Object ignoredOwner;

	@SuppressWarnings("rawtypes")
	private Map ignoredMergeMap;

	private DummySharedSessionContractImplementor ignoredSharedSessionContractImplementor;

	private Object ignoredTarget;
	private Object ignoredValue;
	private DummySessionFactoryImplementor ignoredSessionFactoryImplementor;

	@Before
	public void before() {
		containerJavaType1 = Object.class;
		containerJavaType2 = String.class;
		propertyName1 = "propertyName1";
		propertyName2 = "propertyName2";

		ignoredOwner = new Object();
		ignoredMergeMap = new HashMap<>();
		ignoredSharedSessionContractImplementor = new DummySharedSessionContractImplementor();

		ignoredTarget = new Object();
		ignoredValue = new Object();
		ignoredSessionFactoryImplementor = new DummySessionFactoryImplementor();
	}

	@Test
	public void test() {

		PropertyAccessStrategyNoopImpl instance = PropertyAccessStrategyNoopImpl.INSTANCE;

		// the PropertyAccess, getter and setter instances are actually static final
		// fields
		PropertyAccess buildPropertyAccess1 = instance.buildPropertyAccess(containerJavaType1, propertyName1);
		PropertyAccess buildPropertyAccess2 = instance.buildPropertyAccess(containerJavaType2, propertyName2);
		aeqr(buildPropertyAccess1, buildPropertyAccess2);

		aeqr(buildPropertyAccess1.getGetter(), buildPropertyAccess2.getGetter());
		aeqr(buildPropertyAccess1.getSetter(), buildPropertyAccess2.getSetter());

		Getter getter = buildPropertyAccess1.getGetter();
		an(getter.get(ignoredOwner));
		an(getter.getForInsert(ignoredOwner, ignoredMergeMap, ignoredSharedSessionContractImplementor));
		aeq(Object.class, getter.getReturnType());
		an(getter.getMember());
		an(getter.getMethodName());
		an(getter.getMember());

		Setter setter = buildPropertyAccess1.getSetter();
		an(setter.getMethodName());
		an(setter.getMethod());
		// does nothing
		setter.set(ignoredTarget, ignoredValue, ignoredSessionFactoryImplementor);

	}
}
