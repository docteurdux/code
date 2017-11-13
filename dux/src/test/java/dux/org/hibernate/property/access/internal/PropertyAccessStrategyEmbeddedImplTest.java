package dux.org.hibernate.property.access.internal;

import org.hibernate.property.access.internal.PropertyAccessEmbeddedImpl;
import org.hibernate.property.access.internal.PropertyAccessStrategyEmbeddedImpl;
import org.hibernate.property.access.spi.PropertyAccess;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class PropertyAccessStrategyEmbeddedImplTest extends AbstractTest {
	private Class<?> containerJavaType;
	private String propertyName;

	public PropertyAccessStrategyEmbeddedImplTest() {
		containerJavaType = Object.class;
		propertyName = "propertyName";
	}

	@Test
	public void test() {

		PropertyAccess propertyAccess = PropertyAccessStrategyEmbeddedImpl.INSTANCE
				.buildPropertyAccess(containerJavaType, propertyName);
		aeq(PropertyAccessEmbeddedImpl.class, propertyAccess.getClass());
		aeqr(PropertyAccessStrategyEmbeddedImpl.INSTANCE, propertyAccess.getPropertyAccessStrategy());
	}
}
