package dum.org.hibernate.resource.jdbc.spi;

import java.sql.Connection;

import org.hibernate.resource.jdbc.spi.JdbcObserver;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyJdbcObserver extends TestEventCollector implements JdbcObserver {

	@Override
	public void jdbcConnectionAcquisitionStart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void jdbcConnectionAcquisitionEnd(Connection connection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void jdbcConnectionReleaseStart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void jdbcConnectionReleaseEnd() {
		// TODO Auto-generated method stub

	}

	@Override
	public void jdbcPrepareStatementStart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void jdbcPrepareStatementEnd() {
		// TODO Auto-generated method stub

	}

	@Override
	public void jdbcExecuteStatementStart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void jdbcExecuteStatementEnd() {
		// TODO Auto-generated method stub

	}

	@Override
	public void jdbcExecuteBatchStart() {
		testEvents.add(new TestEvent("jdbcExecuteBatchStart"));

	}

	@Override
	public void jdbcExecuteBatchEnd() {
		testEvents.add(new TestEvent("jdbcExecuteBatchEnd"));
	}

}
