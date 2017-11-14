package dux.org.hibernate.event.spi;

import java.io.Serializable;

import org.hibernate.event.spi.AbstractEvent;
import org.hibernate.event.spi.AbstractPreDatabaseOperationEvent;
import org.hibernate.event.spi.PreUpdateEvent;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.event.spi.DummyEventSource;
import dum.org.hibernate.persister.entity.DummyEntityPersister;

@Done
public class PreUpdateEventTest extends AbstractTest {

	private Object entity;
	private Serializable entityId;
	private Object[] states;
	private Object[] oldStates;
	private DummyEntityPersister entityPersister;
	private DummyEventSource eventSource;

	@Before
	public void before() {
		entity = new Object();
		entityId = new Serializable() {
			private static final long serialVersionUID = 1L;
		};
		states = new Object[] {};
		oldStates = new Object[] {};
		entityPersister = new DummyEntityPersister();
		eventSource = new DummyEventSource();
	}

	@Test
	public void test() {

		PreUpdateEvent preUpdateEvent = new PreUpdateEvent(entity, entityId, states, oldStates, entityPersister,
				eventSource);
		aeqr(states, preUpdateEvent.getState());
		aeqr(oldStates, preUpdateEvent.getOldState());

		AbstractPreDatabaseOperationEvent abstractPreDatabaseOperationEvent = (AbstractPreDatabaseOperationEvent) preUpdateEvent;
		aeqr(entity, abstractPreDatabaseOperationEvent.getEntity());
		aeqr(entityId, abstractPreDatabaseOperationEvent.getId());
		an(abstractPreDatabaseOperationEvent.getEntityName());
		aeqr(entityPersister, abstractPreDatabaseOperationEvent.getPersister());

		AbstractEvent abstractEvent = (AbstractEvent) preUpdateEvent;
		aeqr(eventSource, abstractEvent.getSession());

	}
}
