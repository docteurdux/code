package dum.org.hibernate.engine.jdbc.batch.spi;

import org.hibernate.engine.jdbc.batch.spi.BatchKey;
import org.hibernate.jdbc.Expectation;

public class DummyBatchKey implements BatchKey {

	private Expectation expectation;

	@Override
	public int getBatchedStatementCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Expectation getExpectation() {
		return expectation;
	}

	public void setExpectation(Expectation expectation) {
		this.expectation = expectation;
	}

}
