package dux.org.hibernate.resource.transaction.backend.jdbc.internal;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.spi.SQLExceptionConverter;
import org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.TestEvent;

import dum.java.sql.DummyConnection;
import dum.org.hibernate.engine.jdbc.connections.spi.DummyJdbcConnectionAccess;
import dum.org.hibernate.exception.spi.DummySQLExceptionConverter;
import dum.org.hibernate.tool.schema.internal.exec.DummyJdbcContext;

public class DdlTransactionIsolatorNonJtaImplTest extends AbstractTest {

	private DummyConnection connection;
	private DummyJdbcConnectionAccess jdbcConnectionAccess;
	private DummyJdbcContext jdbcContext;
	private DdlTransactionIsolatorNonJtaImpl isolator;
	private SqlExceptionHelper sqlExceptionHelper;
	private SQLExceptionConverter sqlExceptionConverter;

	@Before
	public void before() {

		sqlExceptionConverter = new DummySQLExceptionConverter();

		sqlExceptionHelper = new SqlExceptionHelper(sqlExceptionConverter, false);

		connection = new DummyConnection();

		jdbcConnectionAccess = new DummyJdbcConnectionAccess();
		jdbcConnectionAccess.setConnection(connection);

		jdbcContext = new DummyJdbcContext();
		jdbcContext.setJdbcConnectionAccess(jdbcConnectionAccess);
		jdbcContext.setSqlExceptionHelper(sqlExceptionHelper);
		isolator = new DdlTransactionIsolatorNonJtaImpl(jdbcContext);
	}

	/**
	 * If the isolator does not have a connection, it creates one, commit and set
	 * auto commit to true
	 **/
	@Test
	public void test1() throws SQLException {

		connection.setAutoCommit(false);

		Connection isolatedConnection = isolator.getIsolatedConnection();

		aeq(connection, isolatedConnection);
		at(connection.getAutoCommit());
		event(connection, "commit");
	}

	/**
	 * If the isolator does not have a connection and autocommit is true, it creates
	 * one, but does not autocommit and does not modify the value
	 **/
	@Test
	public void test1a() throws SQLException {

		connection.setAutoCommit(true);

		Connection isolatedConnection = isolator.getIsolatedConnection();

		aeq(connection, isolatedConnection);
		at(connection.getAutoCommit());
		noevent(connection, "commit");
	}

	/**
	 * Next time, it just reuse the existing connection
	 **/
	@Test
	public void test2() throws SQLException {

		test1();
		connection.getTestEvents().clear();

		connection.setAutoCommit(false);

		DummyConnection otherConnection = new DummyConnection();
		otherConnection.setAutoCommit(false);
		jdbcConnectionAccess.setConnection(otherConnection);

		Connection isolatedConnection = isolator.getIsolatedConnection();

		aeq(connection, isolatedConnection);
		af(connection.getAutoCommit());
		noevent(connection, "commit");

	}

	/**
	 * commit can throw
	 **/
	@Test
	public void test3() throws SQLException {

		SQLException commitException = new SQLException();

		connection.setAutoCommit(false);
		connection.setCommitException(commitException);

		try {
			isolator.getIsolatedConnection();
			fail();
		} catch (Exception ex) {
			aeq(commitException, ex.getCause());
		}

	}

	/**
	 * getAutoCommit can throw
	 **/
	@Test
	public void test4() throws SQLException {

		SQLException getAutoCommitException = new SQLException();

		connection.setAutoCommit(false);
		connection.setGetAutoCommitException(getAutoCommitException);
		;

		try {
			isolator.getIsolatedConnection();
			fail();
		} catch (Exception ex) {
			aeq(getAutoCommitException, ex.getCause());
		}

	}

	/**
	 * obtainConnection can throw
	 **/
	@Test
	public void test5() throws SQLException {

		SQLException obtainConnectionException = new SQLException();
		jdbcConnectionAccess.setObtainConnectionException(obtainConnectionException);

		try {
			isolator.getIsolatedConnection();
			fail();
		} catch (Exception ex) {
			aeq(obtainConnectionException, ex.getCause());
		}

	}

	/**
	 * If there is a connection, it can be released
	 **/
	@Test
	public void test6() throws SQLException {

		Connection isolatedConnection = isolator.getIsolatedConnection();
		aeq(connection, isolatedConnection);

		isolator.release();
		TestEvent event = event(jdbcConnectionAccess, "releaseConnection");
		aeq(connection, event.getProps().get("connection"));

	}

	/**
	 * Releasing a connection can throw
	 **/
	@Test
	public void test7() throws SQLException {

		Connection isolatedConnection = isolator.getIsolatedConnection();
		aeq(connection, isolatedConnection);

		SQLException releaseConnectionException = new SQLException();
		jdbcConnectionAccess.setReleaseConnectionException(releaseConnectionException);

		try {
			isolator.release();
			fail();
		} catch (Exception ex) {
			aeq(releaseConnectionException, ex.getCause());
		}

	}

	/**
	 * If the connection is null, nothing happens
	 **/
	@Test
	public void test8() throws SQLException {

		SQLException releaseConnectionException = new SQLException();
		jdbcConnectionAccess.setReleaseConnectionException(releaseConnectionException);

		isolator.release();

	}

}
