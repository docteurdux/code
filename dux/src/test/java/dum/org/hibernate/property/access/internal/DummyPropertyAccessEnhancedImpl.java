package dum.org.hibernate.property.access.internal;

import java.lang.reflect.Field;

import org.hibernate.property.access.internal.PropertyAccessEnhancedImpl;
import org.hibernate.property.access.spi.PropertyAccessStrategy;
import org.hibernate.property.access.spi.Setter;

public class DummyPropertyAccessEnhancedImpl extends PropertyAccessEnhancedImpl {

	public DummyPropertyAccessEnhancedImpl(PropertyAccessStrategy strategy, Class containerJavaType,
			String propertyName) {
		super(strategy, containerJavaType, propertyName);
	}

	@Override
	public Setter fieldSetter(Class<?> containerJavaType, String propertyName, Field field) {
		return super.fieldSetter(containerJavaType, propertyName, field);
	}

}
