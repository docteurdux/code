package dux.org.hibernate.property.access.internal;

import org.hibernate.property.access.internal.PropertyAccessMixedImpl;
import org.hibernate.property.access.internal.PropertyAccessStrategyMixedImpl;
import org.hibernate.property.access.spi.PropertyAccess;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class PropertyAccessStrategyMixedImplTest extends AbstractTest {

	private Class<?> containerJavaType;
	private String propertyName;

	public static class A {
		Object foo;

		public Object getFoo() {
			return foo;
		}

		public void setFoo(Object foo) {
			this.foo = foo;
		}

	}

	public PropertyAccessStrategyMixedImplTest() {
		containerJavaType = A.class;
		propertyName = "foo";
	}

	@Test
	public void test() {

		PropertyAccessStrategyMixedImpl instance = PropertyAccessStrategyMixedImpl.INSTANCE;

		PropertyAccess propertyAccess = instance.buildPropertyAccess(containerJavaType, propertyName);

		aeq(PropertyAccessMixedImpl.class, propertyAccess.getClass());
		aeqr(instance, propertyAccess.getPropertyAccessStrategy());
	}
}
