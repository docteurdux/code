package dum.org.hibernate.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.jdbc.Expectation;

import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyExpectation extends TestEventCollector implements Expectation {

	private boolean canBeBatched;
	private RunnableWithArgs<Void> verifyOutcomeRWA;

	@Override
	public void verifyOutcome(int rowCount, PreparedStatement statement, int batchPosition)
			throws SQLException, HibernateException {
		testEvents.add(new TestEvent("verifyOutcome").prop("rowCount", rowCount).prop("statement", statement)
				.prop("batchPosition", batchPosition));
		if (verifyOutcomeRWA != null) {
			verifyOutcomeRWA.run(rowCount, statement, batchPosition);
		}
	}

	public void setVerifyOutcomeRWA(RunnableWithArgs<Void> verifyOutcomeRWA) {
		this.verifyOutcomeRWA = verifyOutcomeRWA;
	}

	@Override
	public int prepare(PreparedStatement statement) throws SQLException, HibernateException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean canBeBatched() {
		return canBeBatched;
	}

	public void setCanBeBatched(boolean canBeBatched) {
		this.canBeBatched = canBeBatched;
	}

}
