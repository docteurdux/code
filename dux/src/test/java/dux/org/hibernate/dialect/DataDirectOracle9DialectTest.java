package dux.org.hibernate.dialect;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.dialect.DataDirectOracle9Dialect;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.RunnableWithArgs;

import dum.java.sql.DummyCallableStatement;
import dum.java.sql.DummyResultSet;

@Done("more coverage possible")
public class DataDirectOracle9DialectTest extends AbstractTest {
	private DummyCallableStatement statement;
	private RunnableWithArgs<Boolean> executeRWA;
	private DummyResultSet resultSet;
	private RunnableWithArgs<ResultSet> getResultSetRWA;

	@Before
	public void before() {

		resultSet = new DummyResultSet();

		executeRWA = new RunnableWithArgs<Boolean>() {
			@Override
			public Boolean run(Object... args) {
				return true;
			}
		};

		getResultSetRWA = new RunnableWithArgs<ResultSet>() {
			@Override
			public ResultSet run(Object... args) {
				return resultSet;
			}
		};

		statement = new DummyCallableStatement();
		statement.setExecuteRWA(executeRWA);
		statement.setGetResultSetRWA(getResultSetRWA);
	}

	@Test
	public void test() throws SQLException {
		DataDirectOracle9Dialect dialect = new DataDirectOracle9Dialect();
		aeq(7, dialect.registerResultSetOutParameter(statement, 7));
		aeqr(resultSet, dialect.getResultSet(statement));

	}
}
