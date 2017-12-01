package dux.org.hibernate.event.internal;

import org.hibernate.classic.Lifecycle;
import org.hibernate.event.spi.EventSource;
import org.hibernate.persister.entity.EntityPersister;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.TestEvents;

import dum.org.hibernate.event.internal.DummyAbstractSaveEventListener;

public class AbstractSaveEventListenerTest extends AbstractTest {

	private Recorder<Lifecycle> entity;
	private Recorder<EntityPersister> persister;
	private Recorder<EventSource> eventSource;

	public AbstractSaveEventListenerTest() {
	}

	@Before
	public void before() {
		TestEvents.getTestEvents().clear();
		entity = Recorder.create("entity", this, Lifecycle.class);
		persister = Recorder.create("persister", this, EntityPersister.class);
		eventSource = Recorder.create("eventSource", this, EventSource.class);
	}

	/**
	 * invokeSaveLifecycle returns true when the persister says it implements
	 * lifecycle and the save event returns true
	 */
	@Test
	public void test1() {

		DummyAbstractSaveEventListener abstractSaveEventListener = new DummyAbstractSaveEventListener();

		persister.v("implementsLifecycle", true);
		entity.v("onSave", true);

		boolean result = abstractSaveEventListener.invokeSaveLifecycle(entity.p(), persister.p(), eventSource.p());
		aeq(true, result);
		aeq(true, hasBeenCalled("entity", "onSave"));

	}

	/**
	 * if the persister says it does not implements lifecycle, then onSave is not
	 * called, and invokeSaveLifecle returns false
	 */
	@Test
	public void test2() {

		DummyAbstractSaveEventListener abstractSaveEventListener = new DummyAbstractSaveEventListener();

		persister.v("implementsLifecycle", false);

		boolean result = abstractSaveEventListener.invokeSaveLifecycle(entity.p(), persister.p(), eventSource.p());
		aeq(false, result);
		aeq(false, hasBeenCalled("entity", "onSave"));

	}
}
