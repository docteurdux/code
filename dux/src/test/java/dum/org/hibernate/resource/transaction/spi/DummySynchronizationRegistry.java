package dum.org.hibernate.resource.transaction.spi;

import javax.transaction.Synchronization;

import org.hibernate.resource.transaction.spi.SynchronizationRegistry;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummySynchronizationRegistry extends TestEventCollector implements SynchronizationRegistry {

	@Override
	public void registerSynchronization(Synchronization synchronization) {
		testEvents.add(new TestEvent("registerSynchronization").prop("synchronization", synchronization));

	}

}
