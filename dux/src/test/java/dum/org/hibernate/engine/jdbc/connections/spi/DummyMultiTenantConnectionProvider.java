package dum.org.hibernate.engine.jdbc.connections.spi;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyMultiTenantConnectionProvider implements MultiTenantConnectionProvider {

	private static final long serialVersionUID = 1L;
	private RunnableWithArgs<Connection> getConnectionRWA;

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
	public Connection getAnyConnection() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void releaseAnyConnection(Connection connection) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Connection getConnection(String tenantIdentifier) throws SQLException {
		if (getConnectionRWA != null) {
			return getConnectionRWA.run(tenantIdentifier);
		}
		return null;
	}

	public void setGetConnectionRWA(RunnableWithArgs<Connection> getConnectionRWA) {
		this.getConnectionRWA = getConnectionRWA;
	}

	@Override
	public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}
