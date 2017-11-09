package dux.org.hibernate.event.spi;

import org.hibernate.event.spi.AbstractEvent;
import org.hibernate.event.spi.ClearEvent;
import org.hibernate.event.spi.EventSource;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.event.spi.DummyEventSource;

@Done
public class ClearEventTest extends AbstractTest {
	@Test
	public void test() {

		aeq(AbstractEvent.class, ClearEvent.class.getSuperclass());

		EventSource source = new DummyEventSource();
		ClearEvent event = new ClearEvent(source);
		aeqr(event.getSession(), source);

	}
}
