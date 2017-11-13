package dux.org.hibernate.property.access.internal;

import org.hibernate.property.access.internal.PropertyAccessStrategyBasicImpl;
import org.hibernate.property.access.spi.PropertyAccess;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class PropertyAccessStrategyBasicImplTest extends AbstractTest {

	public static class A {

		private Object foo;

		public Object getFoo() {
			return foo;
		}

		public void setFoo(Object foo) {
			this.foo = foo;

		}
	}

	@Test
	public void test() throws Exception {
		
		Class<?> containerJavaType = A.class;
		String propertyName = "foo";

		PropertyAccess pa = PropertyAccessStrategyBasicImpl.INSTANCE.buildPropertyAccess(containerJavaType,
				propertyName);

		aeqr(PropertyAccessStrategyBasicImpl.INSTANCE, pa.getPropertyAccessStrategy());

		aeq(A.class.getMethod("getFoo"), pa.getGetter().getMethod());
		aeq(A.class.getMethod("setFoo", Object.class), pa.getSetter().getMethod());

	}
}
