package dux.org.springframework.jdbc.datasource;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.junit.Test;
import org.springframework.jdbc.datasource.AbstractDataSource;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Next;
import com.github.docteurdux.test.Previous;
import com.github.docteurdux.test.RunnableWhichThrow;

import dux.javax.sql.DataSourceTest;

@Previous(DataSourceTest.class)
@Next(AbstractDriverBasedDataSourceTest.class)
public class AbstractDataSourceTest extends AbstractTest {

	@Test
	public void test() throws SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException {

		/*
		 * org.springframework.jdbc.datasource.AbstractDataSource is an abstract
		 * implementation of javax.sql.DataSource in Spring JDBC. It's main purpose is
		 * to only leave the two getConnection methods undefined, and implement the rest
		 * with "suitable" defaults.
		 */

		AbstractDataSource ds = new AbstractDataSource() {

			@Override
			public Connection getConnection() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Connection getConnection(String username, String password) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}

		};

		/* The suitable default is to have 0 for login timeout */
		aeq(0, ds.getLoginTimeout());

		/*
		 * Also, setting the login timeout or attempting to use the LogWriter throw an
		 * exception
		 */
		expect(UnsupportedOperationException.class, new RunnableWhichThrow() {
			@Override
			public void run() throws Exception {
				ds.setLoginTimeout(0);
			}
		});
		expect(UnsupportedOperationException.class, new RunnableWhichThrow() {
			@Override
			public void run() throws Exception {
				ds.getLogWriter();
			}
		});
		expect(UnsupportedOperationException.class, new RunnableWhichThrow() {
			@Override
			public void run() throws Exception {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ds.setLogWriter(new PrintWriter(baos));
			}
		});

		/*
		 * Additionally, it is only a wrapper for itself and the interfaces it
		 * implements
		 */
		aeqr(ds, ds.unwrap(DataSource.class));

		/* The parent logger is well defined */
		aeq("global", ds.getParentLogger().getName());

		/*
		 * It also defines a protected logger that can be use by subclasses, of type
		 * org.apache.commons.logging.Log
		 */
		Field loggerField = AbstractDataSource.class.getField("logger");
		loggerField.setAccessible(true);
		aeq(true, Modifier.isProtected(loggerField.getModifiers()));
		aeq(Log.class, loggerField.get(ds).getClass());

		/*
		 * Note here that JDBC mandates the use of a java.util.logging.Logger but Spring
		 * internally use org.apache.commons.logging.Log
		 */

		/*
		 * Two subclases of org.springframework.jdbc.datasource.AbstractDataSource are
		 * org.springframework.jdbc.datasource.AbstractDriverBasedDataSource and
		 * org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
		 */

		next(AbstractDriverBasedDataSourceTest.class);
	}
}
