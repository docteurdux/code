package dum.org.hibernate.property.access.spi;

import org.hibernate.property.access.spi.Getter;
import org.hibernate.property.access.spi.PropertyAccess;
import org.hibernate.property.access.spi.PropertyAccessStrategy;
import org.hibernate.property.access.spi.Setter;

public class DummyPropertyAccess implements PropertyAccess {

	private PropertyAccessStrategy propertyAccessStrategy;
	private Getter getter;
	private Setter setter;

	@Override
	public PropertyAccessStrategy getPropertyAccessStrategy() {
		return propertyAccessStrategy;
	}

	@Override
	public Getter getGetter() {
		return getter;
	}

	@Override
	public Setter getSetter() {
		return setter;
	}

	public void setPropertyAccessStrategy(PropertyAccessStrategy propertyAccessStrategy) {
		this.propertyAccessStrategy = propertyAccessStrategy;
	}

	public void setGetter(Getter getter) {
		this.getter = getter;
	}

	public void setSetter(Setter setter) {
		this.setter = setter;
	}

}
