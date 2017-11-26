package dum.org.hibernate.engine.jdbc.batch.spi;

import org.hibernate.engine.jdbc.batch.spi.BatchObserver;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyBatchObserver extends TestEventCollector implements BatchObserver {

	@Override
	public void batchExplicitlyExecuted() {
		testEvents.add(new TestEvent("batchExplicitlyExecuted"));
	}

	@Override
	public void batchImplicitlyExecuted() {
		testEvents.add(new TestEvent("batchImplicitlyExecuted"));
	}

}
