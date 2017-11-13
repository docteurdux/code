package dux.org.hibernate.property.access.internal;

import org.hibernate.property.access.internal.PropertyAccessFieldImpl;
import org.hibernate.property.access.internal.PropertyAccessStrategyFieldImpl;
import org.hibernate.property.access.spi.PropertyAccess;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class PropertyAccessStrategyFieldImplTest extends AbstractTest {

	public static class A {
		Object foo;

		public Object getFoo() {
			return foo;
		}

		public void setFoo(Object foo) {
			this.foo = foo;
		}
	}

	private Class<?> containerJavaType;
	private String propertyName;

	@Before
	public void before() {
		containerJavaType = A.class;
		propertyName = "foo";
	}

	@Test
	public void test() {
		PropertyAccess propertyAccess = PropertyAccessStrategyFieldImpl.INSTANCE.buildPropertyAccess(containerJavaType,
				propertyName);
		aeq(PropertyAccessFieldImpl.class, propertyAccess.getClass());
		aeqr(PropertyAccessStrategyFieldImpl.INSTANCE, propertyAccess.getPropertyAccessStrategy());
	}
}
