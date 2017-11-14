package dux.org.hibernate.event.spi;

import java.io.Serializable;

import org.hibernate.event.spi.AbstractEvent;
import org.hibernate.event.spi.AbstractPreDatabaseOperationEvent;
import org.hibernate.event.spi.PreDeleteEvent;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.event.spi.DummyEventSource;
import dum.org.hibernate.persister.entity.DummyEntityPersister;

@Done
public class PreDeleteEventTest extends AbstractTest {

	private Object entity;
	private Serializable entityId;
	private Object[] deletedStates;
	private DummyEntityPersister entityPersister;
	private DummyEventSource eventSource;

	@Before
	public void before() {

		entity = new Object();

		entityId = new Serializable() {
			private static final long serialVersionUID = 1L;
		};

		deletedStates = new Object[] {};

		entityPersister = new DummyEntityPersister();

		eventSource = new DummyEventSource();
	}

	@Test
	public void test() {

		PreDeleteEvent preDeleteEvent = new PreDeleteEvent(entity, entityId, deletedStates, entityPersister,
				eventSource);

		aeqr(deletedStates, preDeleteEvent.getDeletedState());

		AbstractPreDatabaseOperationEvent abstractPreDatabaseOperationEvent = preDeleteEvent;
		an(abstractPreDatabaseOperationEvent.getEntityName());
		aeqr(entity, abstractPreDatabaseOperationEvent.getEntity());
		aeqr(entityId, abstractPreDatabaseOperationEvent.getId());
		aeqr(entityPersister, abstractPreDatabaseOperationEvent.getPersister());

		AbstractEvent abstractEvent = preDeleteEvent;
		aeqr(eventSource, abstractEvent.getSession());
	}
}
