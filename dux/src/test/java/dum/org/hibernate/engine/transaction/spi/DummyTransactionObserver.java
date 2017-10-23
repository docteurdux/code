package dum.org.hibernate.engine.transaction.spi;

import org.hibernate.engine.transaction.spi.TransactionObserver;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyTransactionObserver extends TestEventCollector implements TransactionObserver {

	@Override
	public void afterBegin() {
		testEvents.add(new TestEvent("afterBegin"));
	}

	@Override
	public void beforeCompletion() {
		testEvents.add(new TestEvent("beforeCompletion"));

	}

	@Override
	public void afterCompletion(boolean successful, boolean delayed) {
		testEvents.add(new TestEvent("afterCompletion").prop("successful", successful).prop("delayed", delayed));
	}

}
