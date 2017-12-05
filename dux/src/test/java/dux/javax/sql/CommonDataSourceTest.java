package dux.javax.sql;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Next;

@Next(WrapperTest.class)
public class CommonDataSourceTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * The javax.sql.CommonDataSource interface defines a getter/setter pair for
		 * connection timeouts in seconds, and a getter/setter pair for a log writer. A
		 * log writer is just a printwriter.
		 * 
		 * It also defines a getter for the parent logger, as an instance of
		 * java.util.logging.Logger.
		 * 
		 * Every getter and setter can throw an java.sql.SQLException, but the getter
		 * for the parent logger can only throw a
		 * java.sql.SQLFeatureNotSupportedException
		 */

		/*
		 * Some interfaces that extends javax.sql.CommonDataSource include :
		 */

		/*- 
		* javax.sql.DataSource
		* javax.sql.ConnectionPoolDataSource
		* javax.sql.XADataSource
		*/

		next(WrapperTest.class);
	}

	
}
