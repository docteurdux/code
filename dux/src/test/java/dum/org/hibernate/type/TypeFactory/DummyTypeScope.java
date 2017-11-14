package dum.org.hibernate.type.TypeFactory;

import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.type.TypeFactory.TypeScope;

public class DummyTypeScope implements TypeScope {

	private static final long serialVersionUID = 1L;

	private SessionFactoryImplementor factory;

	@Override
	public SessionFactoryImplementor resolveFactory() {
		return factory;
	}

	public void setFactory(SessionFactoryImplementor factory) {
		this.factory = factory;
	}

}
