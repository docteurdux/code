package dum.org.hibernate.engine.jdbc.connections.spi;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;
import com.github.docteurdux.test.TestEventCollectorI;

public class DummyConnectionProvider extends TestEventCollector implements ConnectionProvider {

	private static final long serialVersionUID = 1L;

	private Connection connection;

	@Override
	public boolean isUnwrappableAs(Class unwrapType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection() throws SQLException {
		testEvents.add(new TestEvent("getConnection"));
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void closeConnection(Connection conn) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}
