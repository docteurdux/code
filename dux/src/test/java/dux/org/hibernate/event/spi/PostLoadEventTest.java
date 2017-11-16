package dux.org.hibernate.event.spi;

import java.io.Serializable;

import org.hibernate.event.spi.PostLoadEvent;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.event.spi.DummyEventSource;
import dum.org.hibernate.persister.entity.DummyEntityPersister;

@Done
public class PostLoadEventTest extends AbstractTest {

	private Object entity;
	private Serializable id;
	private DummyEntityPersister entityPersister;
	private DummyEventSource eventSource;

	@Before
	public void before() {

		entity = new Object();

		id = new Serializable() {
			private static final long serialVersionUID = 1L;
		};

		eventSource = new DummyEventSource();

		entityPersister = new DummyEntityPersister();
	}

	@Test
	public void test() {
		PostLoadEvent postLoadEvent = new PostLoadEvent(eventSource);

		an(postLoadEvent.getEntity());
		postLoadEvent.setEntity(entity);
		aeqr(entity, postLoadEvent.getEntity());

		an(postLoadEvent.getId());
		postLoadEvent.setId(id);
		aeqr(id, postLoadEvent.getId());

		an(postLoadEvent.getPersister());
		postLoadEvent.setPersister(entityPersister);
		aeqr(entityPersister, postLoadEvent.getPersister());
	}
}
