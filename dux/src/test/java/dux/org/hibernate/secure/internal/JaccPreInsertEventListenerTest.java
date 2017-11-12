package dux.org.hibernate.secure.internal;

import java.io.Serializable;

import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.secure.internal.AbstractJaccSecurableEventListener;
import org.hibernate.secure.internal.JaccPreInsertEventListener;
import org.hibernate.secure.spi.PermissibleAction;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.Instances;

import dum.org.hibernate.event.spi.DummyEventSource;
import dum.org.hibernate.persister.entity.DummyEntityPersister;
import dum.org.hibernate.secure.spi.DummyJaccService;
import duu.org.hibernate.event.spi.EventSourceUtils;

@Done
public class JaccPreInsertEventListenerTest extends AbstractTest {

	private Object entity;
	private Serializable entityId;
	private Object[] states;
	private DummyEntityPersister persister;
	private Instances eventSourceInstances;
	private DummyEventSource eventSource;
	private DummyJaccService jaccService;
	private PreInsertEvent preInsertEvent;

	@Before
	public void before() {

		entity = new Object();
		entityId = new Serializable() {
			private static final long serialVersionUID = 1L;
		};

		states = new Object[] {};

		persister = new DummyEntityPersister();

		eventSourceInstances = new Instances();
		eventSource = EventSourceUtils.getAnInstance(eventSourceInstances);
		jaccService = eventSourceInstances.get(DummyJaccService.class);

		preInsertEvent = new PreInsertEvent(entity, entityId, states, persister, eventSource);
	}

	@Test
	public void test() {

		aeq(AbstractJaccSecurableEventListener.class, JaccPreInsertEventListener.class.getSuperclass());

		JaccPreInsertEventListener jaccPreInsertEventListener = new JaccPreInsertEventListener();
		jaccPreInsertEventListener.onPreInsert(preInsertEvent);

		aeqr(preInsertEvent, testEvent(jaccService, 0, "entityInformation"));
		aeqr(PermissibleAction.INSERT, testEvent(jaccService, 0, "action"));

	}
}
