package dux.org.springframework.jdbc.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Next;
import com.github.docteurdux.test.Previous;
import com.github.docteurdux.test.Recorder;

import dux.org.springframework.beans.factory.DisposableBeanTest;
import dux.org.springframework.beans.factory.InitializingBeanTest;

@Previous(DisposableBeanTest.class)
@Next(InitializingBeanTest.class)
public class SingleConnectionDataSourceTest extends AbstractTest {

	@Test
	public void test() throws SQLException {

		/*
		 * org.springframework.jdbc.datasource.SingleConnectionDataSource extends
		 * org.springframework.jdbc.datasource.DriverManagerDataSource and also
		 * implements org.springframework.jdbc.datasource.SmartDataSource and
		 * org.springframework.beans.factory.DisposableBean
		 */

		/* As often, there is a default constructor */

		/*
		 * There are also two constructors that accept an url, one of which also accepts
		 * a username and a password. But they also require the "suppressClose" boolean.
		 */

		/*
		 * The constructor that accepts java.util.Properties is missing, and there is a
		 * new constructor which accepts a java.sql.Connection and the "suppressClose"
		 * flag
		 */

		/*
		 * initConnection() initializes the connection, closing the previous one if
		 * needed. If close suppression is enabled, the connection is wrapped in a proxy
		 * which ingore calls to close
		 */

		/*
		 * resetConnection() closes the connection, and prepare the object for future
		 * uses
		 */

		/* destroy() just closes the connection */

		/*
		 * setAutoCommit(boolean) sets the expected autocommit mode, which is
		 * initialized to null
		 */

		/*
		 * setSuppressClose(boolean) enables or disables the close suppression feature
		 */

		/*
		 * getConnection() initialize the connection if necessary, and returns the
		 * existing connection otherwise. If the connection has been closed, an
		 * exception is thrown.
		 */

		/*
		 * getConnection(String, String) only works when the username and password match
		 * the configured one. Indeed, calling twice this function with different values
		 * is incompatible with using the previous connection.
		 */

		/*
		 * shouldClose(Connection) does not tell whether the current connection should
		 * be closed. Instead, it returns true when its argument is not the current
		 * connection
		 */

		/*
		 * So basically, the purpose of
		 * org.springframework.jdbc.datasource.SingleConnectionDataSource is to always
		 * use the same connection, and close the connection only when the bean is
		 * destroyed
		 */

		/*
		 * As a test, we will only check that we always get the provided connection when
		 * calling getConnection()
		 */

		Connection connection = Recorder.create("connection", this, Connection.class).p();
		SingleConnectionDataSource ds = new SingleConnectionDataSource(connection, false);
		aeqr(connection, ds.getConnection());
		aeqr(connection, ds.getConnection());

		/*
		 * Next, we will have a look at
		 * org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
		 * 
		 * But first, we need to make ourselves familiar with
		 * org.springframework.beans.factory.InitializingBean
		 */

		next(InitializingBeanTest.class);
	}
}
