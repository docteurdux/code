package dux.org.springframework.jdbc.datasource;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Next;
import com.github.docteurdux.test.Previous;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.RunnableWithArgs;

@Previous(AbstractDriverBasedDataSourceTest.class)
@Next(DriverManagerDataSourceTest.class)
public class SimpleDriverDataSourceTest extends AbstractTest {

	@Test
	public void test() throws SQLException {

		/*
		 * org.springframework.jdbc.datasource.SimpleDriverDataSource extends
		 * org.springframework.jdbc.datasource.AbstractDriverBasedDataSource
		 */

		/*
		 * It mainly introduces a java.sql.Driver private field and a getter and a
		 * setter for getting/setting that field
		 */

		/*
		 * It also defines a setDriverClass method which instanciates the class to set
		 * the field with a new instance of that driver.
		 * org.springframework.beans.BeanUtils is used for that.
		 */

		/*
		 * Besides the default constructor, all 3 other constructors take a
		 * java.sql.Driver and a String url as argument. One also takes a username and a
		 * password, and another takes a java.util.Properties to define the connection
		 * properties. The setters of
		 * org.springframework.jdbc.datasource.AbstractDriverBasedDataSource are used to
		 * set the fields.
		 */

		/*
		 * Finally, the protected implementation of getConnectionFromDriver just invokes
		 * java.sql.Driver.connect(String, Properties) on the java.sql.Driver field.
		 */

		/*
		 * Here we instanciate a new SimpleDriverDataSource and call getConnection on
		 * it. We use a fake Driver which returns a fake connection, and stores the url
		 * andn properties that was passed to it for further examination
		 */
		Connection connection = Recorder.create("connection", this, Connection.class).p();

		String[] url = new String[] { null };
		Properties[] properties = new Properties[] { null };
		Driver driver = Recorder.create("driver", this, Driver.class).r("connect", new RunnableWithArgs<Connection>() {
			@Override
			public Connection run(Object... args) {
				url[0] = (String) args[0];
				properties[0] = (Properties) args[1];
				return connection;
			}
		}).p();

		SimpleDriverDataSource ds = new SimpleDriverDataSource(driver, "url", "username", "password");
		aeqr(connection, ds.getConnection());

		/* We can see that the user and password have been passed to Driver.connect */
		aeq("url", url[0]);
		aeq("username", properties[0].get("user"));
		aeq("password", properties[0].get("password"));

		/*
		 * Next is org.springframework.jdbc.datasource.DriverManagerDataSource, a cousin
		 * of org.springframework.jdbc.datasource.SimpleDriverDataSource which also
		 * extends org.springframework.jdbc.datasource.AbstractDriverBasedDataSource
		 */
		next(DriverManagerDataSourceTest.class);
	}

}
