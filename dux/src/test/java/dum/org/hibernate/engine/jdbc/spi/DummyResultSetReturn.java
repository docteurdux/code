package dum.org.hibernate.engine.jdbc.spi;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.engine.jdbc.spi.ResultSetReturn;

import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyResultSetReturn extends TestEventCollector implements ResultSetReturn {

	private RunnableWithArgs<ResultSet> extractRWA;
	private RunnableWithArgs<ResultSet> executeRWA;
	private RunnableWithArgs<Integer> executeUpdateRWA;

	@Override
	public ResultSet extract(PreparedStatement statement) {
		if (extractRWA != null) {
			return extractRWA.run(statement);
		}
		return null;
	}

	@Override
	public ResultSet extract(CallableStatement callableStatement) {
		if (extractRWA != null) {
			return extractRWA.run(callableStatement);
		}
		return null;
	}

	@Override
	public ResultSet extract(Statement statement, String sql) {
		if (extractRWA != null) {
			return extractRWA.run(statement, sql);
		}
		return null;
	}

	@Override
	public ResultSet execute(PreparedStatement statement) {
		if (executeRWA != null) {
			return executeRWA.run(statement);
		}
		return null;
	}

	@Override
	public ResultSet execute(Statement statement, String sql) {
		if (executeRWA != null) {
			return executeRWA.run(statement, sql);
		}
		return null;
	}

	@Override
	public int executeUpdate(PreparedStatement statement) {
		testEvents.add(new TestEvent("executeUpdate").prop("statement", statement));
		if (executeUpdateRWA != null) {
			return executeUpdateRWA.run(statement);
		}
		return 0;
	}

	@Override
	public int executeUpdate(Statement statement, String sql) {
		if (executeUpdateRWA != null) {
			return executeUpdateRWA.run(statement, sql);
		}
		return 0;
	}

	public void setExtractRWA(RunnableWithArgs<ResultSet> extractRWA) {
		this.extractRWA = extractRWA;
	}

	public void setExecuteRWA(RunnableWithArgs<ResultSet> executeRWA) {
		this.executeRWA = executeRWA;
	}

	public void setExecuteUpdateRWA(RunnableWithArgs<Integer> executeUpdateRWA) {
		this.executeUpdateRWA = executeUpdateRWA;
	}

}
