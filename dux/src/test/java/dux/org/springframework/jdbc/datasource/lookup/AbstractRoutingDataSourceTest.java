package dux.org.springframework.jdbc.datasource.lookup;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.jdbc.datasource.lookup.DataSourceLookup;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.jdbc.datasource.lookup.IsolationLevelDataSourceRouter;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Next;
import com.github.docteurdux.test.Previous;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.beans.factory.InitializingBeanTest;
import dux.org.springframework.core.ConstantsTest;

@Previous(InitializingBeanTest.class)
@Topic(AbstractRoutingDataSource.class)
@Next(ConstantsTest.class)
@Related({ IsolationLevelDataSourceRouter.class })
public class AbstractRoutingDataSourceTest extends AbstractTest {
	@Test
	public void test() throws SQLException {

		/*
		 * org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource extends
		 * org.springframework.jdbc.datasource.AbstractDataSource and implements
		 * org.springframework.beans.factory.InitializingBean
		 */

		/*
		 * The default constructor really does nothing, but is required for beans
		 */

		/* There are 4 setters */

		/* setLenientFallback(boolean) sets whether the default fallback can be used */

		/*
		 * setDefaultTargetDataSource(Object) set the actual javax.sql.DataSource or its
		 * name as a String
		 */

		/* setTargetDataSources(Map<Object, Object>) sets the lookup map */

		/*
		 * setDataSourceLookup(org.springframework.jdbc.datasource.lookup.
		 * DataSourceLookup) sets the actual object capable of doing the lookup. It is
		 * set to an instance of
		 * org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup when null.
		 */

		/*
		 * Usually, once properties have been set, afterPropertiesSet() is called to
		 * complete the bean initialization.
		 * 
		 * In this case, the target data sources is mandatory. For each entry in the
		 * target data sources, the key is resolved with
		 * resolveSpecifiedLookupKey(Object), and the data source is resolved with
		 * resolveSpecifiedDataSource(Object).
		 * 
		 * Then the default target dataSource, if any is resolved to using
		 * resolveSpecifiedDataSource(Object).
		 * 
		 * By default, resolveSpecifiedLookupKey(Object) just returns the key, and
		 * resolveSpecifiedDataSource(Object) returns its argument when it is a
		 * javax.sql.DataSource, and defer to the data source lookup when it is a
		 * string. Other types are not supported.
		 */

		/*
		 * determineTargetDataSource() use the result of determineCurrentLookupKey() to
		 * obtain the data sources from the resolved data sources, and returns the
		 * default datasources if lenient fallback is on. If no datasource is found, an
		 * exception is thrown.
		 */

		/*
		 * isWrapperFor(java.lang.Class<?><?>) and unwrap(java.lang.Class<?><T>)
		 * delegate to the current resolved data source, but first check against the
		 * instance of AbstractRoutingDataSource itself
		 */

		/*
		 * getConnection() and getConnection(String, String) also delegates to the
		 * current resolved data source
		 */

		/*
		 * TODO : do org.springframework.jdbc.datasource.lookup.DataSourceLookup before
		 * org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
		 */

		/*
		 * In the following example, "key" maps to "awesomeDataSource", which is
		 * resolved to awesomeDataSource by dataSourceLookup.
		 * 
		 * Because the dataSource is lenient, setting any other currentKey gives back
		 * the lameDataSource, which is passed directly to setDefaultTargetDataSource
		 */

		String[] currentKey = new String[] { "key" };

		Connection lameConnection = Recorder.create("lameConnection", this, Connection.class).p();
		DataSource lameDataSource = Recorder.create("lameDataSource", this, DataSource.class)
				.v("getConnection", lameConnection).p();

		Connection awesomeConnection = Recorder.create("awesomeConnection", this, Connection.class).p();
		DataSource awesomeDataSource = Recorder.create("awesomeDataSource", this, DataSource.class)
				.v("getConnection", awesomeConnection).p();

		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put("key", "awesomeDatasource");

		DataSourceLookup dataSourceLookup = new DataSourceLookup() {
			@Override
			public DataSource getDataSource(String dataSourceName) throws DataSourceLookupFailureException {
				if ("awesomeDatasource".equals(dataSourceName)) {
					return awesomeDataSource;
				}
				return null;
			}
		};

		AbstractRoutingDataSource ds = new AbstractRoutingDataSource() {
			@Override
			protected Object determineCurrentLookupKey() {
				return currentKey[0];
			}
		};

		ds.setDataSourceLookup(dataSourceLookup);
		ds.setTargetDataSources(targetDataSources);
		ds.setLenientFallback(true);
		ds.setDefaultTargetDataSource(lameDataSource);
		ds.afterPropertiesSet();

		aeqr(awesomeConnection, ds.getConnection());

		currentKey[0] = "key2";
		aeqr(lameConnection, ds.getConnection());

		/*
		 * Now, we are ready to look at
		 * org.springframework.jdbc.datasource.lookup.IsolationLevelDataSourceRouter,
		 * after we've looked at
		 * org.springframework.transaction.support.TransactionSynchronizationManager,
		 * org.springframework.transaction.TransactionDefinition,
		 * org.springframework.core.Constants and
		 * org.springframework.transaction.support.DefaultTransactionDefinition
		 */

		/* Let's start with org.springframework.core.Constants */
		next(ConstantsTest.class);
	}
}
