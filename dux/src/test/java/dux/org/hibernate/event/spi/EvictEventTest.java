package dux.org.hibernate.event.spi;

import org.hibernate.event.spi.AbstractEvent;
import org.hibernate.event.spi.EvictEvent;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.event.spi.DummyEventSource;

@Done
public class EvictEventTest extends AbstractTest {

	private Object object;
	private Object anotherObject;
	private DummyEventSource eventSource;

	@Before
	public void before() {
		object = new Object();
		anotherObject = new Object();
		eventSource = new DummyEventSource();
	}

	@Test
	public void test() {

		aeq(AbstractEvent.class, EvictEvent.class.getSuperclass());

		EvictEvent evictEvent = new EvictEvent(object, eventSource);
		aeqr(object, evictEvent.getObject());
		aeqr(eventSource, evictEvent.getSession());

		evictEvent.setObject(anotherObject);
		aeqr(anotherObject, evictEvent.getObject());

	}
}
