package dux.org.hibernate.event.internal;

import org.hibernate.event.internal.EntityCopyAllowedObserver;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.event.spi.DummyEventSource;

@Done
public class EntityCopyAllowedObserverTest extends AbstractTest {

	private Object managedEntity;
	private Object mergeEntity1;
	private Object mergeEntity2;

	private DummyEventSource eventSource;

	@Before
	public void before() {

		managedEntity = new Object();
		mergeEntity1 = new Object();
		mergeEntity2 = new Object();

		eventSource = new DummyEventSource();

	}

	@Test
	public void test() {
		EntityCopyAllowedObserver ecao = new EntityCopyAllowedObserver();

		// these three methods do nothing
		ecao.entityCopyDetected(managedEntity, mergeEntity1, mergeEntity2, eventSource);
		ecao.clear();
		ecao.topLevelMergeComplete(eventSource);
	}
}
