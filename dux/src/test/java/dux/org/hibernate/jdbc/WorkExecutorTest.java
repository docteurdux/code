package dux.org.hibernate.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;
import org.hibernate.jdbc.WorkExecutor;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.java.sql.DummyConnection;

@Done
public class WorkExecutorTest extends AbstractTest {

	private String[] result1;
	private DummyConnection connection;
	private Work simpleWork;
	private ReturningWork<String> returningWork;

	@Before
	public void before() {

		result1 = new String[] { null };

		connection = new DummyConnection();

		simpleWork = new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				result1[0] = "result1";
			}
		};

		returningWork = new ReturningWork<String>() {
			@Override
			public String execute(Connection connection) throws SQLException {
				return "result2";
			}
		};
	}

	@Test
	public void test() throws SQLException {

		WorkExecutor<String> workExecutor = new WorkExecutor<String>();

		workExecutor.executeWork(simpleWork, connection);
		aeq("result1", result1[0]);

		aeq("result2", workExecutor.executeReturningWork(returningWork, connection));
	}
}
