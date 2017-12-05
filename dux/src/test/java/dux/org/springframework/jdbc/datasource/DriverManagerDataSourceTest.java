package dux.org.springframework.jdbc.datasource;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Next;
import com.github.docteurdux.test.Previous;
import com.github.docteurdux.test.Recorder;

@Previous(SimpleDriverDataSourceTest.class)
@Next(SmartDataSourceTest.class)
public class DriverManagerDataSourceTest extends AbstractTest {

	@Test
	public void test() throws SQLException {

		/*
		 * org.springframework.jdbc.datasource.DriverManagerDataSource extends
		 * org.springframework.jdbc.datasource.AbstractDriverBasedDataSource and
		 * delegates the connection retrieval to java.sql.DriverManager using the
		 * getConnection(String, java.util.Properties) method
		 */

		/*
		 * Like org.springframework.jdbc.datasource.SimpleDriverDataSource, it features
		 * 4 constructor. One is the default constructor. The other all accept a String
		 * url, one accepts a username/password pair and the other a
		 * java.util.Properties
		 */

		/*
		 * The only setter is setDriverClassName(String), which is kind of a hack. It
		 * can be used to load a specific JDBC driver, and let it register with the JDBC
		 * framework, so that it will be available when java.sql.DriverManager is used.
		 * java.sql.DriverManager will still use the information in the url to determine
		 * which driver to actually use.
		 */

		/*
		 * Below, D implements java.sql.Driver and reacts to url which are equals to
		 * "dummy". It registers itself with java.sql.DriverManager when the class is
		 * initialized, and returns a fake connection which is statically made
		 * available, along with the properties given to connect, for further
		 * investigation.
		 * 
		 * We first create an instance of DriverManagerDataSource and set the driver
		 * class name to register the driver, then call getConneciton. We then check
		 * that the connection returned is the one that has been statically initialized,
		 * and that the username and password are as expected.
		 */

		DriverManagerDataSource ds = new DriverManagerDataSource("dummy", "username", "password");
		ds.setDriverClassName(D.class.getName());
		Connection connection = ds.getConnection();
		aeqr(D.connection, connection);
		aeq("username", D.info.get("user"));
		aeq("password", D.info.get("password"));

		/*
		 * One subclass of org.springframework.jdbc.datasource.DriverManagerDataSource
		 * is org.springframework.jdbc.datasource.SingleConnectionDataSource, which we
		 * will examine next. But first, we need to make ourselves familiar with
		 * org.springframework.jdbc.datasource.SmartDataSource and
		 * org.springframework.beans.factory.DisposableBean
		 */

		next(SmartDataSourceTest.class);

	}

	public static class D implements Driver {

		static {
			try {
				java.sql.DriverManager.registerDriver(new D());
			} catch (SQLException E) {
				throw new RuntimeException("Can't register driver!");
			}
		}

		public static Connection connection = Recorder.create("connection", null, Connection.class).p();
		public static Properties info;

		@Override
		public Connection connect(String url, Properties info) throws SQLException {
			D.info = info;
			return connection;
		}

		@Override
		public boolean acceptsURL(String url) throws SQLException {
			return "dummy".equals(url);
		}

		@Override
		public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getMajorVersion() {
			return 1;
		}

		@Override
		public int getMinorVersion() {
			return 1;
		}

		@Override
		public boolean jdbcCompliant() {
			return true;
		}

		@Override
		public Logger getParentLogger() throws SQLFeatureNotSupportedException {
			return Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		}

	}
}
