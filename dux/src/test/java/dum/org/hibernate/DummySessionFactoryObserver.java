package dum.org.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummySessionFactoryObserver extends TestEventCollector implements SessionFactoryObserver {

	private static final long serialVersionUID = 1L;

	@Override
	public void sessionFactoryClosed(SessionFactory factory) {
		testEvents.add(new TestEvent("sessionFactoryClosed").prop("factory", factory));
	}

	@Override
	public void sessionFactoryCreated(SessionFactory factory) {
		testEvents.add(new TestEvent("sessionFactoryCreated").prop("factory", factory));
	}

	@Override
	public void sessionFactoryClosing(SessionFactory factory) {
		testEvents.add(new TestEvent("sessionFactoryClosing").prop("factory", factory));
	}
}
