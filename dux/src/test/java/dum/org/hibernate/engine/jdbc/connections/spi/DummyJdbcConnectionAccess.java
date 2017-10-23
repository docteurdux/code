package dum.org.hibernate.engine.jdbc.connections.spi;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyJdbcConnectionAccess extends TestEventCollector implements JdbcConnectionAccess {

	private static final long serialVersionUID = 1L;
	private Connection connection;
	private SQLException obtainConnectionException;
	private SQLException releaseConnectionException;

	@Override
	public Connection obtainConnection() throws SQLException {
		if (obtainConnectionException != null) {
			throw obtainConnectionException;
		}
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void releaseConnection(Connection connection) throws SQLException {
		testEvents.add(new TestEvent("releaseConnection").prop("connection", connection));
		if (releaseConnectionException != null) {
			throw releaseConnectionException;
		}
	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setObtainConnectionException(SQLException obtainConnectionException) {
		this.obtainConnectionException = obtainConnectionException;

	}

	public void setReleaseConnectionException(SQLException releaseConnectionException) {
		this.releaseConnectionException = releaseConnectionException;

	}

}
