package dux.org.springframework.jdbc.datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;
import org.springframework.jdbc.datasource.AbstractDriverBasedDataSource;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Next;
import com.github.docteurdux.test.Previous;
import com.github.docteurdux.test.Recorder;

@Previous(AbstractDataSourceTest.class)
@Next(SimpleDriverDataSourceTest.class)
public class AbstractDriverBasedDataSourceTest extends AbstractTest {

	@Test
	public void test() throws SQLException {
		/*
		 * org.springframework.jdbc.datasource.AbstractDriverBasedDataSource extends
		 * org.springframework.jdbc.datasource.AbstractDataSource and delegates the
		 * retrieval of the connection to an abstract getConnectionFromDriver method
		 * which uses a java.util.Properties argument which allow more than just setting
		 * the username and password
		 */

		/* Moreover, it defines getters and setters for */

		/*-
		 * - the connection URL
		 * - the username
		 * - the password
		 * - the schema
		 * - the catalog
		 * - any other connection properties through java.util.Properties 
		 */

		/*
		 * The username and password can be set using with the setter or in the
		 * properties; if both are specified, the information set with the setter takes
		 * precedence
		 */

		/*
		 * The catalog and schema must be set with the setters, and are applied after
		 * the connection has be obtained
		 */

		/*
		 * Subclasses include org.springframework.jdbc.datasource.SimpleDriverDataSource
		 * and org.springframework.jdbc.datasource.DriverManagerDataSource
		 */

		/*
		 * Here's the actual test. We instanciate AbstractDriverBasedDataSource with a
		 * function that returns a predefefined connection and just note the properties
		 * it got. The connection is instanciated with a recorder that records
		 * everything that happen on it.
		 */

		Properties[] properties = new Properties[] { null };
		Connection connection = Recorder.create("connection", this, Connection.class).p();
		AbstractDriverBasedDataSource ds = new AbstractDriverBasedDataSource() {
			@Override
			protected Connection getConnectionFromDriver(Properties props) throws SQLException {
				properties[0] = props;
				return connection;
			}
		};

		/*
		 * We use all the getters here, and set user and password information everywhere
		 */
		ds.setUrl("url");
		ds.setUsername("user1");
		ds.setPassword("password1");
		ds.setCatalog("catalog");
		ds.setSchema("schema");
		Properties connectionProperties = new Properties();
		connectionProperties.setProperty("user", "user2");
		connectionProperties.setProperty("password", "password2");
		connectionProperties.setProperty("foo", "bar");
		ds.setConnectionProperties(connectionProperties);

		aeqr(connection, ds.getConnection("user3", "password3"));

		/* The user information is as specified in the method parameters */
		aeq(3, properties[0].size());
		aeq("user3", properties[0].get("user"));
		aeq("password3", properties[0].get("password"));
		aeq("bar", properties[0].get("foo"));

		/* setSchema and setCatalog have been called on the connection */
		ateq("connection", "setCatalog", "\"catalog\"");
		ateq("connection", "setSchema", "\"schema\"");

		/*
		 * Default connection uses user an password information as specified in the
		 * setters
		 */
		ds.getConnection();
		aeq("user1", properties[0].get("user"));
		aeq("password1", properties[0].get("password"));

		/*
		 * Setting those to null => user and password information specified in the
		 * properties is used
		 */
		ds.setUsername(null);
		ds.setPassword(null);
		ds.getConnection();
		aeq("user2", properties[0].get("user"));
		aeq("password2", properties[0].get("password"));

		next(SimpleDriverDataSourceTest.class);
	}

}
