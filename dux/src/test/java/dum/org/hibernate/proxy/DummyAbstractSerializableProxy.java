package dum.org.hibernate.proxy;

import java.io.Serializable;

import org.hibernate.proxy.AbstractLazyInitializer;
import org.hibernate.proxy.AbstractSerializableProxy;

public class DummyAbstractSerializableProxy extends AbstractSerializableProxy {

	private static final long serialVersionUID = 1L;

	public DummyAbstractSerializableProxy(String entityName, Serializable id, Boolean readOnly) {
		super(entityName, id, readOnly);
	}

	@Override
	public String getEntityName() {
		return super.getEntityName();
	}

	@Override
	public Serializable getId() {
		return super.getId();
	}

	@Override
	public void setReadOnlyBeforeAttachedToSession(AbstractLazyInitializer li) {
		super.setReadOnlyBeforeAttachedToSession(li);
	}
	
	
	
	

}
