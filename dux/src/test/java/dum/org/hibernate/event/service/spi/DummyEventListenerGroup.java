package dum.org.hibernate.event.service.spi;

import java.util.ArrayList;

import org.hibernate.event.service.spi.DuplicationStrategy;
import org.hibernate.event.service.spi.EventListenerGroup;
import org.hibernate.event.spi.EventType;

public class DummyEventListenerGroup<T> implements EventListenerGroup<T> {

	private static final long serialVersionUID = 1L;
	private ArrayList<T> listeners;

	public DummyEventListenerGroup() {
		listeners = new ArrayList<T>();
	}

	@Override
	public EventType<T> getEventType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<T> listeners() {
		return listeners;
	}

	@Override
	public void addDuplicationStrategy(DuplicationStrategy strategy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void appendListener(T listener) {
		listeners.add(listener);
	}

	@Override
	public void appendListeners(T... listeners) {
		// TODO Auto-generated method stub

	}

	@Override
	public void prependListener(T listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void prependListeners(T... listeners) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
