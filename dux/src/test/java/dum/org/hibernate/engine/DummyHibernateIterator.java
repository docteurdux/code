package dum.org.hibernate.engine;

import org.hibernate.JDBCException;
import org.hibernate.engine.HibernateIterator;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyHibernateIterator extends TestEventCollector implements HibernateIterator {

	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	public Object next() {
		// TODO Auto-generated method stub
		return null;
	}

	public void close() throws JDBCException {
		testEvents.add(new TestEvent("close"));
	}

}
