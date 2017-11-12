package dux.org.hibernate.secure.internal;

import java.io.Serializable;

import org.hibernate.event.spi.PreDeleteEvent;
import org.hibernate.secure.internal.AbstractJaccSecurableEventListener;
import org.hibernate.secure.internal.JaccPreDeleteEventListener;
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
public class JaccPreDeleteEventListenerTest extends AbstractTest {

	private Object entity;
	private Serializable id;
	private Object[] deletedStates;
	private DummyEntityPersister entityPersister;
	private DummyJaccService jaccService;
	private DummyEventSource eventSource;
	private PreDeleteEvent preDeleteEvent;

	@Before
	public void before() {

		entity = new Object();
		id = new Serializable() {
			private static final long serialVersionUID = 1L;
		};
		deletedStates = new Object[] {};

		entityPersister = new DummyEntityPersister();

		Instances eventSourceInstances = new Instances();
		eventSource = EventSourceUtils.getAnInstance(eventSourceInstances);

		jaccService = eventSourceInstances.get(DummyJaccService.class);

		preDeleteEvent = new PreDeleteEvent(entity, id, deletedStates, entityPersister, eventSource);
	}

	@Test
	public void test() {

		aeq(AbstractJaccSecurableEventListener.class, JaccPreDeleteEventListener.class.getSuperclass());

		JaccPreDeleteEventListener jpdel = new JaccPreDeleteEventListener();

		jpdel.onPreDelete(preDeleteEvent);

		aeqr(preDeleteEvent, testEvent(jaccService, 0, "entityInformation"));
		aeqr(PermissibleAction.DELETE, testEvent(jaccService, 0, "action"));

	}

}
