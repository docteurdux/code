package dux.org.hibernate.engine.jdbc.env.internal;

import java.sql.DatabaseMetaData;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.jdbc.dialect.spi.DialectFactory;
import org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.RunnableWithArgs;

import dum.java.sql.DummyConnection;
import dum.java.sql.DummyDatabaseMetaData;
import dum.org.hibernate.engine.jdbc.connections.spi.DummyConnectionProvider;
import dum.org.hibernate.engine.jdbc.dialect.spi.DummyDialectFactory;
import dum.org.hibernate.service.spi.DummyServiceRegistryImplementor;
import dus.hibernate.core.HibernateCoreSummaryTest;

public class JdbcEnvironmentInitiatorTest extends AbstractTest {
	@Before
	public void before() {
		requireSources(HibernateCoreSummaryTest.MVNNAME, JdbcEnvironmentInitiator.class);
	}

	@Test
	public void test() {

		JdbcEnvironmentInitiator instance = JdbcEnvironmentInitiator.INSTANCE;

		aeq(JdbcEnvironment.class, instance.getServiceInitiated());

		Dialect dialect = new Dialect() {
		};
		Map configurationValues = new HashMap<>();
		DummyDialectFactory object = new DummyDialectFactory();
		object.setBuildDialectRWA(new RunnableWithArgs<Dialect>() {

			@Override
			public Dialect run(Object... args) {
				return dialect;
			}
		});
		DummyConnectionProvider cp = new DummyConnectionProvider();
		DummyConnection connection = new DummyConnection();
		DatabaseMetaData metaData = new DummyDatabaseMetaData();
		connection.setMetaData(metaData);
		cp.setConnection(connection);
		DummyServiceRegistryImplementor registry = new DummyServiceRegistryImplementor();
		registry.setService(DialectFactory.class, object);
		registry.setService(ConnectionProvider.class, cp);
		instance.initiateService(configurationValues, registry);

	}
}
