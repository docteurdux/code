package dux.org.hibernate.event.spi;

import java.io.Serializable;

import org.hibernate.event.spi.AbstractEvent;
import org.hibernate.event.spi.AbstractPreDatabaseOperationEvent;
import org.hibernate.event.spi.PreInsertEvent;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.event.spi.DummyEventSource;
import dum.org.hibernate.persister.entity.DummyEntityPersister;

@Done
public class PreInsertEventTest extends AbstractTest {

	private Object entity;
	private Serializable entityId;
	private Object[] states;

	private DummyEntityPersister entityPersister;
	private DummyEventSource eventSource;

	public PreInsertEventTest() {

		entity = new Object();
		entityId = new Serializable() {
			private static final long serialVersionUID = 1L;
		};
		states = new Object[] {};

		entityPersister = new DummyEntityPersister();
		eventSource = new DummyEventSource();
	}

	@Test
	public void test() {

		aeq(AbstractPreDatabaseOperationEvent.class, PreInsertEvent.class.getSuperclass());

		PreInsertEvent preInsertEvent = new PreInsertEvent(entity, entityId, states, entityPersister, eventSource);
		AbstractPreDatabaseOperationEvent preInsertEventUp = (AbstractPreDatabaseOperationEvent) preInsertEvent;
		AbstractEvent preInsertEventUpUp = (AbstractEvent) preInsertEvent;

		aeqr(states, preInsertEvent.getState());

		aeqr(entity, preInsertEventUp.getEntity());
		aeqr(entityId, preInsertEventUp.getId());
		an(preInsertEventUp.getEntityName());
		aeqr(entityPersister, preInsertEventUp.getPersister());

		aeqr(eventSource, preInsertEventUpUp.getSession());
	}
}
