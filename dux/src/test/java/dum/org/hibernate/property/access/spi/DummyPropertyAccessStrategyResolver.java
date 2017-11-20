package dum.org.hibernate.property.access.spi;

import org.hibernate.EntityMode;
import org.hibernate.property.access.spi.PropertyAccessStrategy;
import org.hibernate.property.access.spi.PropertyAccessStrategyResolver;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyPropertyAccessStrategyResolver implements PropertyAccessStrategyResolver {

	private static final long serialVersionUID = 1L;

	private RunnableWithArgs<PropertyAccessStrategy> resolvePropertyAccessStrategyRWA;

	@Override
	public PropertyAccessStrategy resolvePropertyAccessStrategy(@SuppressWarnings("rawtypes") Class containerClass,
			String explicitAccessStrategyName, EntityMode entityMode) {
		if (resolvePropertyAccessStrategyRWA != null) {
			return resolvePropertyAccessStrategyRWA.run(containerClass, explicitAccessStrategyName, entityMode);
		}
		return null;
	}

	public void setResolvePropertyAccessStrategyRWA(
			RunnableWithArgs<PropertyAccessStrategy> resolvePropertyAccessStrategyRWA) {
		this.resolvePropertyAccessStrategyRWA = resolvePropertyAccessStrategyRWA;
	}

}
