package dux.org.hibernate.property.access.internal;

import java.lang.reflect.Field;

import org.hibernate.property.access.spi.EnhancedSetterImpl;
import org.hibernate.property.access.spi.Setter;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.property.access.internal.DummyPropertyAccessEnhancedImpl;

@Done
public class PropertyAccessEnhancedImplTest extends AbstractTest {

	public static class A {

		private Object foo;

		public Object getFoo() {
			return foo;
		}

		public void setFoo(Object foo) {
			this.foo = foo;
		}

	}

	private DummyPropertyAccessStrategy propertyAccessStrategy;
	private Class<?> clazz;
	private String propertyName;
	private Field field;

	@Before
	public void before() throws Exception {
		propertyAccessStrategy = new DummyPropertyAccessStrategy();
		clazz = A.class;
		propertyName = "foo";
		field = A.class.getDeclaredField("foo");
	}

	@Test
	public void test() {

		DummyPropertyAccessEnhancedImpl propertyAccessEnhancedImpl = new DummyPropertyAccessEnhancedImpl(
				propertyAccessStrategy, clazz, propertyName);

		Setter setter = propertyAccessEnhancedImpl.fieldSetter(clazz, propertyName, field);

		aeq(EnhancedSetterImpl.class, setter.getClass());
	}
}
