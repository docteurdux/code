package dum.org.hibernate.engine.jdbc.batch.spi;

import java.sql.PreparedStatement;

import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.hibernate.engine.jdbc.batch.spi.BatchKey;
import org.hibernate.engine.jdbc.batch.spi.BatchObserver;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyBatch extends TestEventCollector implements Batch {

	@Override
	public BatchKey getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addObserver(BatchObserver observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public PreparedStatement getBatchStatement(String sql, boolean callable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addToBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute() {
		testEvents.add(new TestEvent("execute"));
	}

	@Override
	public void release() {
		testEvents.add(new TestEvent("release"));

	}

}
