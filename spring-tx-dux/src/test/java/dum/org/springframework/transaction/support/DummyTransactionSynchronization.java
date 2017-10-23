package dum.org.springframework.transaction.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.support.TransactionSynchronization;

import com.github.docteurdux.test.Event;

public class DummyTransactionSynchronization implements TransactionSynchronization {

	List<Event> events = new ArrayList<Event>();

	public void afterCommit() {
		events.add(new Event("afterCommit"));
	}

	public void afterCompletion(int status) {
		events.add(new Event("afterCompletion").prop("status", status));
	}

	public void beforeCommit(boolean readOnly) {
		events.add(new Event("beforeCommit").prop("readOnly", readOnly));
	}

	public void beforeCompletion() {
		events.add(new Event("beforeCompletion"));
	}

	public void flush() {
		events.add(new Event("flush"));
	}

	public void resume() {
		events.add(new Event("resume"));
	}

	public void suspend() {
		events.add(new Event("suspend"));
	}
}
