package dum.org.hibernate.jpa.event.spi.jpa;

import org.hibernate.jpa.event.spi.jpa.CallbackRegistry;
import org.hibernate.jpa.event.spi.jpa.CallbackType;

import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyCallbackRegistry extends TestEventCollector implements CallbackRegistry {

	private static final long serialVersionUID = 1L;

	private RunnableWithArgs<Boolean> postLoadRWA = RunnableWithArgs.always(false);

	@Override
	public boolean hasRegisteredCallbacks(Class entityClass, CallbackType callbackType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void preCreate(Object entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postCreate(Object entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preUpdate(Object entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void postUpdate(Object entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preRemove(Object entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postRemove(Object entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean postLoad(Object entity) {
		testEvents.add(new TestEvent("postLoad").prop("entity", entity));
		return postLoadRWA.run(entity);
	}

	public void setPostLoadRWA(RunnableWithArgs<Boolean> postLoadRWA) {
		if (postLoadRWA == null) {
			throw new NullPointerException();
		}
		this.postLoadRWA = postLoadRWA;
	}

	@Override
	public boolean hasPostCreateCallbacks(Class entityClass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPostUpdateCallbacks(Class entityClass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPostRemoveCallbacks(Class entityClass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasRegisteredCallbacks(Class entityClass, Class annotationClass) {
		// TODO Auto-generated method stub
		return false;
	}

}
