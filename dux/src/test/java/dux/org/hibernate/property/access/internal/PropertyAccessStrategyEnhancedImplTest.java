package dux.org.hibernate.property.access.internal;

import org.hibernate.property.access.internal.PropertyAccessEnhancedImpl;
import org.hibernate.property.access.internal.PropertyAccessStrategyEnhancedImpl;
import org.hibernate.property.access.spi.PropertyAccess;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class PropertyAccessStrategyEnhancedImplTest extends AbstractTest {

	private Class<A> containerJavaType;
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

	@Before
	public void before() {
		containerJavaType = A.class;
		propertyName = "foo";
	}

	@Test
	public void test() {

		PropertyAccessStrategyEnhancedImpl instance = PropertyAccessStrategyEnhancedImpl.INSTANCE;

		PropertyAccess propertyAccess = instance.buildPropertyAccess(containerJavaType, propertyName);

		aeq(PropertyAccessEnhancedImpl.class, propertyAccess.getClass());
		aeqr(instance, propertyAccess.getPropertyAccessStrategy());

	}
}
