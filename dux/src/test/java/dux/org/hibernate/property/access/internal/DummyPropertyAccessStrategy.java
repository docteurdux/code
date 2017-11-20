package dux.org.hibernate.property.access.internal;

import org.hibernate.property.access.spi.PropertyAccess;
import org.hibernate.property.access.spi.PropertyAccessStrategy;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyPropertyAccessStrategy implements PropertyAccessStrategy {

	private RunnableWithArgs<PropertyAccess> buildPropertyAccessRWA;

	@Override
	public PropertyAccess buildPropertyAccess(Class containerJavaType, String propertyName) {
		if (buildPropertyAccessRWA != null) {
			return buildPropertyAccessRWA.run(containerJavaType, propertyName);
		}
		return null;
	}

	public void setBuildPropertyAccessRWA(RunnableWithArgs<PropertyAccess> buildPropertyAccessRWA) {
		this.buildPropertyAccessRWA = buildPropertyAccessRWA;
	}

}
