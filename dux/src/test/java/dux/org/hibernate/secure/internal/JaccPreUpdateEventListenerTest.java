package dux.org.hibernate.secure.internal;

import java.io.Serializable;

import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.secure.internal.AbstractJaccSecurableEventListener;
import org.hibernate.secure.internal.JaccPreUpdateEventListener;
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
public class JaccPreUpdateEventListenerTest extends AbstractTest {

	private Object entity;
	private Serializable entityId;
	private Object[] state;
	private Object[] oldState;
	private DummyEntityPersister persister;
	private Instances eventSourceInstances;
	private DummyEventSource eventSource;
	private DummyJaccService jaccService;
	private PreUpdateEvent preUpdateEvent;

	@Before
	public void before() {

		entity = new Object();
		entityId = new Serializable() {
			private static final long serialVersionUID = 1L;
		};

		state = new Object[] {};
		oldState = new Object[] {};

		persister = new DummyEntityPersister();

		eventSourceInstances = new Instances();
		eventSource = EventSourceUtils.getAnInstance(eventSourceInstances);
		jaccService = eventSourceInstances.get(DummyJaccService.class);

		preUpdateEvent = new PreUpdateEvent(entity, entityId, state, oldState, persister, eventSource);
	}

	@Test
	public void test() {

		aeq(AbstractJaccSecurableEventListener.class, JaccPreUpdateEventListener.class.getSuperclass());

		JaccPreUpdateEventListener jaccPreUpdateEventListener = new JaccPreUpdateEventListener();
		jaccPreUpdateEventListener.onPreUpdate(preUpdateEvent);

		aeqr(preUpdateEvent, testEvent(jaccService, 0, "entityInformation"));
		aeqr(PermissibleAction.UPDATE, testEvent(jaccService, 0, "action"));

	}

}
