package dux.org.hibernate.event.spi;

import org.hibernate.event.spi.AbstractEvent;
import org.hibernate.event.spi.EventSource;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.event.spi.DummyEventSource;

@Done
public class AbstractEventTest extends AbstractTest {
	@Test
	public void test() throws Exception {

		EventSource source = new DummyEventSource();
		AbstractEvent event = new AbstractEvent(source) {
			private static final long serialVersionUID = 1L;
		};

		aeqr(source, event.getSession());
	}

}
