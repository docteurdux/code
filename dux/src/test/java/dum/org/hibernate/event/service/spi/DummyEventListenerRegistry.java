package dum.org.hibernate.event.service.spi;

import org.hibernate.event.service.spi.DuplicationStrategy;
import org.hibernate.event.service.spi.EventListenerGroup;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyEventListenerRegistry implements EventListenerRegistry {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	private RunnableWithArgs<EventListenerGroup> getEventListenerGroupRWA;

	@Override
	@SuppressWarnings("unchecked")
	public <T> EventListenerGroup<T> getEventListenerGroup(EventType<T> eventType) {
		if (getEventListenerGroupRWA != null) {
			return getEventListenerGroupRWA.run(eventType);
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	public void setGetEventListenerGroupRWA(RunnableWithArgs<EventListenerGroup> getEventListenerGroupRWA) {
		this.getEventListenerGroupRWA = getEventListenerGroupRWA;
	}

	@Override
	public void addDuplicationStrategy(DuplicationStrategy strategy) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void setListeners(EventType<T> type, Class<? extends T>... listeners) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void setListeners(EventType<T> type, T... listeners) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void appendListeners(EventType<T> type, Class<? extends T>... listeners) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void appendListeners(EventType<T> type, T... listeners) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void prependListeners(EventType<T> type, Class<? extends T>... listeners) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> void prependListeners(EventType<T> type, T... listeners) {
		// TODO Auto-generated method stub

	}

}
