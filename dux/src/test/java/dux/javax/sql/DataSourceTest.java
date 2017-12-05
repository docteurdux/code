package dux.javax.sql;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Next;
import com.github.docteurdux.test.Previous;

import dux.org.springframework.jdbc.datasource.AbstractDataSourceTest;

@Previous(WrapperTest.class)
@Next(AbstractDataSourceTest.class)
public class DataSourceTest extends AbstractTest {

	@Test
	public void test() {

		/*
		 * The javax.sql.DataSource interface extends javax.sql.CommonDataSource and
		 * java.sql.Wrapper with two getConnection methods. Both return a
		 * java.sql.Connection instance but the first takes no argument, while the other
		 * accepts a username and a password.
		 */

		/*
		 * Cousins of javax.sql.DataSource are javax.sql.XADataSource and
		 * javax.sql.ConnectionPoolDataSource
		 */

		/*
		 * Spring JDBC defines a number of implemention of javax.sql.DataSource. One
		 * family has org.springframework.jdbc.datasource.AbstractDataSource as
		 * ancestor, and the other has
		 * org.springframework.jdbc.datasource.DelegatingDataSource as ancestor
		 */

		/*
		 * The MySQL connector also a family whose ancestor is
		 * com.mysql.cj.jdbc.MysqlDataSource
		 */

		next(AbstractDataSourceTest.class);

	}
}
