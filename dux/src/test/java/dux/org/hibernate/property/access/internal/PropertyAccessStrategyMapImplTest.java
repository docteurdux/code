package dux.org.hibernate.property.access.internal;

import org.hibernate.property.access.internal.PropertyAccessMapImpl;
import org.hibernate.property.access.internal.PropertyAccessStrategyMapImpl;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class PropertyAccessStrategyMapImplTest extends AbstractTest {
	@Test
	public void test() {

		Class<?> anyContainerJavaType = Object.class;
		String propertyName = "propertyName";

		PropertyAccessMapImpl propertyAccess = (PropertyAccessMapImpl) PropertyAccessStrategyMapImpl.INSTANCE
				.buildPropertyAccess(anyContainerJavaType, propertyName);

		aeqr(PropertyAccessStrategyMapImpl.INSTANCE, propertyAccess.getPropertyAccessStrategy());

		// propertyName is used to build getters and setters, but access to the value
		// itself is lost

	}
}
