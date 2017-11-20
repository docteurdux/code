package dum.org.hibernate.boot.spi;

import org.hibernate.boot.spi.AbstractDelegatingSessionFactoryBuilderImplementor;
import org.hibernate.boot.spi.SessionFactoryBuilderImplementor;

public class DummyAbstractDelegatingSessionFactoryBuilderImplementor<T extends SessionFactoryBuilderImplementor>
		extends AbstractDelegatingSessionFactoryBuilderImplementor<T> {

	private T that;

	public DummyAbstractDelegatingSessionFactoryBuilderImplementor(SessionFactoryBuilderImplementor delegate) {
		super(delegate);
	}

	@Override
	protected T getThis() {
		return that;
	}

	public void setThis(T that) {
		this.that = that;
	}

}
