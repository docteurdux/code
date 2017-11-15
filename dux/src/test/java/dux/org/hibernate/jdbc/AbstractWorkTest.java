package dux.org.hibernate.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.jdbc.AbstractWork;
import org.hibernate.jdbc.WorkExecutor;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.java.sql.DummyConnection;

@Done
public class AbstractWorkTest extends AbstractTest {

	private Object[] results;
	private DummyConnection connection;
	private WorkExecutor<Void> executor;

	@Before
	public void before() {
		results = new Object[] { null };
		executor = new WorkExecutor<>();
		connection = new DummyConnection();
	}

	@Test
	public void test() throws SQLException {

		AbstractWork abstractWork = new AbstractWork() {
			@Override
			public void execute(Connection connection) throws SQLException {
				results[0] = "result";
			}
		};
		
		abstractWork.accept(executor, connection);
		
		aeq("result", results[0]);

	}
}
