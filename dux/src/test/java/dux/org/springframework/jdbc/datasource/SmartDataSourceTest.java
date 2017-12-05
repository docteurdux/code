package dux.org.springframework.jdbc.datasource;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Next;
import com.github.docteurdux.test.Previous;

import dux.org.springframework.beans.factory.DisposableBeanTest;

@Previous(DriverManagerDataSourceTest.class)
@Next(DisposableBeanTest.class)
public class SmartDataSourceTest extends AbstractTest {

	@Test
	public void test() {

		/*
		 * org.springframework.jdbc.datasource.SmartDataSource is a very smart
		 * interface. It only defines shouldClose(java.sql.Connection). Of course, the
		 * responsability of knowing how to determine whether a connection should be
		 * closed befalls on those that implements this interface.
		 * 
		 * org.springframework.jdbc.datasource.SingleConnectionDataSource is the only
		 * class that implements org.springframework.jdbc.datasource.SmartDataSource
		 */

		/* Our next stop is org.springframework.beans.factory.DisposableBean */

		next(DisposableBeanTest.class);
	}
}
