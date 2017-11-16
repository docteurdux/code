package dux.org.hibernate.event.spi;

import java.io.Serializable;

import org.hibernate.event.spi.AbstractEvent;
import org.hibernate.event.spi.PostInsertEvent;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.event.spi.DummyEventSource;
import dum.org.hibernate.persister.entity.DummyEntityPersister;

@Done
public class PostInsertEventTest extends AbstractTest {

	private Object entity;
	private Serializable entityId;
	private Object[] states;
	private DummyEntityPersister entityPersister;
	private DummyEventSource eventSource;

	@Before
	public void before() {
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

		PostInsertEvent postInsertEvent = new PostInsertEvent(entity, entityId, states, entityPersister, eventSource);

		aeqr(entity, postInsertEvent.getEntity());
		aeqr(entityId, postInsertEvent.getId());
		aeqr(entityPersister, postInsertEvent.getPersister());
		aeqr(states, postInsertEvent.getState());

		AbstractEvent abstractEvent = (AbstractEvent) postInsertEvent;
		aeqr(eventSource, abstractEvent.getSession());

	}
}
