package dux.org.hibernate.internal;

import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.PersistEvent;
import org.hibernate.event.spi.PersistEventListener;

import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyPersistEventListener extends TestEventCollector implements PersistEventListener {

	private static final long serialVersionUID = 1L;

	private RunnableWithArgs<Void> onPersistRWA;

	@Override
	public void onPersist(PersistEvent event) throws HibernateException {
		testEvents.add(new TestEvent("onPersist").prop("event", event));
		if (onPersistRWA != null) {
			onPersistRWA.run(event);
		}
	}

	@Override
	public void onPersist(PersistEvent event, @SuppressWarnings("rawtypes") Map createdAlready)
			throws HibernateException {
		testEvents.add(new TestEvent("onPersist").prop("event", event).prop("createdAlready", createdAlready));
		if (onPersistRWA != null) {
			onPersistRWA.run(event, createdAlready);
		}
	}

	public void setOnPersistRWA(RunnableWithArgs<Void> onPersistRWA) {
		this.onPersistRWA = onPersistRWA;
	}

}
