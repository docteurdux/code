package dux.org.springframework.beans.factory;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Next;
import com.github.docteurdux.test.Previous;

import dux.org.springframework.jdbc.datasource.SingleConnectionDataSourceTest;
import dux.org.springframework.jdbc.datasource.SmartDataSourceTest;

@Previous(SmartDataSourceTest.class)
@Next(SingleConnectionDataSourceTest.class)
public class DisposableBeanTest extends AbstractTest {

	@Test
	public void test() {

		/*
		 * This part of a trip is very easy.
		 * 
		 * org.springframework.beans.factory.DisposableBean only defines void destroy()
		 * method, which is to be invoked whenever it makes sense.
		 */

		/*
		 * Now we can focus our interest on
		 * org.springframework.jdbc.datasource.SingleConnectionDataSource
		 */

		next(SingleConnectionDataSourceTest.class);
	}
}
