package dux.org.springframework.beans.factory;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Next;
import com.github.docteurdux.test.Previous;

import dux.org.springframework.jdbc.datasource.SingleConnectionDataSourceTest;
import dux.org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSourceTest;

@Previous(SingleConnectionDataSourceTest.class)
@Next(AbstractRoutingDataSourceTest.class)
public class InitializingBeanTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * org.springframework.beans.factory.InitializingBean is a very simple interface
		 * that only defines afterPropertiesSet(
		 */

		/*
		 * Now, lets examine
		 * org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
		 */

		next(AbstractRoutingDataSourceTest.class);

	}
}
