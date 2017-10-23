package dum.org.hibernate.proxy;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.proxy.LazyInitializer;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyLazyInitializer extends TestEventCollector implements LazyInitializer {

	private boolean uninitialized;
	private Object implementation;

	public void initialize() throws HibernateException {
		testEvents.add(new TestEvent("initialize"));
	}

	public Serializable getIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setIdentifier(Serializable id) {
		// TODO Auto-generated method stub

	}

	public String getEntityName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Class getPersistentClass() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isUninitialized() {
		return uninitialized;
	}

	public Object getImplementation() {
		return implementation;
	}

	public Object getImplementation(SharedSessionContractImplementor session) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setImplementation(Object target) {
		this.implementation = target;
	}

	public boolean isReadOnlySettingAvailable() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isReadOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setReadOnly(boolean readOnly) {
		// TODO Auto-generated method stub

	}

	public SharedSessionContractImplementor getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSession(SharedSessionContractImplementor session) throws HibernateException {
		// TODO Auto-generated method stub

	}

	public void unsetSession() {
		// TODO Auto-generated method stub

	}

	public void setUnwrap(boolean unwrap) {
		// TODO Auto-generated method stub

	}

	public boolean isUnwrap() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setUninitialized(boolean uninitialized) {
		this.uninitialized = uninitialized;
	}

}
