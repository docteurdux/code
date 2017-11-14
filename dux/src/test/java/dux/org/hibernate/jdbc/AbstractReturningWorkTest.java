package dux.org.hibernate.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.jdbc.AbstractReturningWork;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.java.sql.DummyConnection;

@Done
public class AbstractReturningWorkTest extends AbstractTest {

	private DummyConnection connection;

	@Before
	public void before() {
		connection = new DummyConnection();
	}

	@Test
	public void test() throws SQLException {

		AbstractReturningWork<String> arw = new AbstractReturningWork<String>() {
			@Override
			public String execute(Connection connection) throws SQLException {
				return "string";
			}
		};

		aeq("string", arw.execute(connection));
	}
}
