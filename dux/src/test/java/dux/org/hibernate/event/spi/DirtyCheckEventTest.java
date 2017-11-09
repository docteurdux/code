package dux.org.hibernate.event.spi;

import org.hibernate.event.spi.DirtyCheckEvent;
import org.hibernate.event.spi.EventSource;
import org.hibernate.event.spi.FlushEvent;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.event.spi.DummyEventSource;

@Done
public class DirtyCheckEventTest extends AbstractTest {

	private EventSource source;

	@Before
	public void before() {
		source = new DummyEventSource();
	}

	@Test
	public void test() throws Exception {

		aeq(FlushEvent.class, DirtyCheckEvent.class.getSuperclass());

		DirtyCheckEvent event = new DirtyCheckEvent(source);

		af(event.isDirty());
		event.setDirty(true);
		at(event.isDirty());
	}

}
