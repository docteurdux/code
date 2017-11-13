package dux.org.hibernate.event.spi;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.event.spi.AutoFlushEvent;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.event.spi.DummyEventSource;

@Done
public class AutoFlushEventTest extends AbstractTest {

	@SuppressWarnings("rawtypes")
	private Set querySpaces;

	@SuppressWarnings("rawtypes")
	private Set querySpaces2;

	private DummyEventSource eventSource;

	@Before
	public void before() {
		querySpaces = new HashSet<>();
		querySpaces2 = new HashSet<>();
		eventSource = new DummyEventSource();
	}

	@Test
	public void test() {

		AutoFlushEvent afe = new AutoFlushEvent(querySpaces, eventSource);

		aeqr(eventSource, afe.getSession());

		aeqr(querySpaces, afe.getQuerySpaces());
		afe.setQuerySpaces(querySpaces2);
		aeqr(querySpaces2, afe.getQuerySpaces());

		af(afe.isFlushRequired());
		afe.setFlushRequired(true);
		at(afe.isFlushRequired());

	}
}
