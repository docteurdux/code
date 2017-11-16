package dux.org.hibernate.jpa.event.internal.core;

import org.hibernate.event.spi.PostLoadEvent;
import org.hibernate.jpa.event.internal.core.JpaPostLoadEventListener;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.event.spi.DummyEventSource;
import dum.org.hibernate.jpa.event.spi.jpa.DummyCallbackRegistry;

@Done
public class JpaPostLoadEventListenerTest extends AbstractTest {

	private Object entity;

	private DummyCallbackRegistry callbackRegistry;
	private DummyEventSource eventSource;

	private PostLoadEvent postLoadEvent;

	@Before
	public void before() {

		entity = new Object();

		callbackRegistry = new DummyCallbackRegistry();
		eventSource = new DummyEventSource();

		postLoadEvent = new PostLoadEvent(eventSource);
		postLoadEvent.setEntity(entity);
	}

	@Test
	public void test1() {

		JpaPostLoadEventListener jpaPostLoadEventListener = new JpaPostLoadEventListener();
		jpaPostLoadEventListener.injectCallbackRegistry(callbackRegistry);

		jpaPostLoadEventListener.onPostLoad(postLoadEvent);

		aeq("postLoad", testEvent(callbackRegistry, 0));
		aeqr(entity, testEvent(callbackRegistry, 0, "entity"));
	}

	@Test
	public void test2() {

		JpaPostLoadEventListener jpaPostLoadEventListener = new JpaPostLoadEventListener(callbackRegistry);

		jpaPostLoadEventListener.onPostLoad(postLoadEvent);

		aeq("postLoad", testEvent(callbackRegistry, 0));
		aeqr(entity, testEvent(callbackRegistry, 0, "entity"));
	}
}
