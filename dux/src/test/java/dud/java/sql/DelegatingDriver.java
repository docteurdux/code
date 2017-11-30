package dud.java.sql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import com.github.docteurdux.test.Delegating;
import com.github.docteurdux.test.TestEvents;

public class DelegatingDriver implements Driver, Delegating {

	private static Driver delegate;

	public static void setDelegate(Driver delegate) {
		DelegatingDriver.delegate = delegate;
	}

	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		return TestEvents.record(delegate, "connect", url, info)
				.result(new DelegatingConnection(delegate.connect(url, info)));
	}

	@Override
	public boolean acceptsURL(String url) throws SQLException {
		return TestEvents.record(delegate, "acceptsURL", url).result(delegate.acceptsURL(url));
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		return TestEvents.record(delegate, "getPropertyInfo", url, info).result(delegate.getPropertyInfo(url, info));
	}

	@Override
	public int getMajorVersion() {
		return TestEvents.record(delegate, "getMajorVersion").result(delegate.getMajorVersion());
	}

	@Override
	public int getMinorVersion() {
		return TestEvents.record(delegate, "getMinorVersion").result(delegate.getMinorVersion());
	}

	@Override
	public boolean jdbcCompliant() {
		return TestEvents.record(delegate, "jdbcCompliant").result(delegate.jdbcCompliant());
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return TestEvents.record(delegate, "getParentLogger").result(delegate.getParentLogger());
	}

	@Override
	public Object getTestDelegate() {
		return delegate;
	}

}
