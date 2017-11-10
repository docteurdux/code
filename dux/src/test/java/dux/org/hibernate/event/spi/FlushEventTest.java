package dux.org.hibernate.event.spi;

import org.hibernate.event.spi.AbstractEvent;
import org.hibernate.event.spi.FlushEvent;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.event.spi.DummyEventSource;

@Done
public class FlushEventTest extends AbstractTest {

	private DummyEventSource eventSource;

	@Before
	public void before() {
		eventSource = new DummyEventSource();
	}

	@Test
	public void test() {

		aeq(AbstractEvent.class, FlushEvent.class.getSuperclass());

		FlushEvent fe = new FlushEvent(eventSource);

		aeq(0, fe.getNumberOfEntitiesProcessed());
		fe.setNumberOfEntitiesProcessed(1);
		aeq(1, fe.getNumberOfEntitiesProcessed());

		aeq(0, fe.getNumberOfCollectionsProcessed());
		fe.setNumberOfCollectionsProcessed(1);
		aeq(1, fe.getNumberOfCollectionsProcessed());
	}
}
