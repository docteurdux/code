package dum.org.hibernate.proxy;

import java.io.Serializable;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.proxy.AbstractLazyInitializer;

public class DummyAbstractLazyInitializer extends AbstractLazyInitializer {

	public DummyAbstractLazyInitializer(String entityName, Serializable id, SharedSessionContractImplementor session) {
		super(entityName, id, session);
	}

	@Override
	public Class getPersistentClass() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
