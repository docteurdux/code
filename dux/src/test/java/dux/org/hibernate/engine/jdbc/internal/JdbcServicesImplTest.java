package dux.org.hibernate.engine.jdbc.internal;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.LobCreator;
import org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.ConnectionProviderJdbcConnectionAccess;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.engine.jdbc.internal.JdbcServicesImpl;
import org.hibernate.engine.jdbc.internal.ResultSetWrapperImpl;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.engine.jdbc.spi.SqlStatementLogger;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.RunnableWithArgs;

import dum.org.hibernate.engine.jdbc.DummyLobCreationContext;
import dum.org.hibernate.engine.jdbc.DummyLobCreator;
import dum.org.hibernate.engine.jdbc.env.spi.DummyExtractedDatabaseMetaData;
import dum.org.hibernate.engine.jdbc.env.spi.DummyJdbcEnvironment;
import dum.org.hibernate.engine.jdbc.env.spi.DummyLobCreatorBuilder;
import dum.org.hibernate.service.spi.DummyServiceRegistryImplementor;
import dus.hibernate.core.HibernateCoreSummaryTest;

public class JdbcServicesImplTest extends AbstractTest {
	private SqlExceptionHelper sqlExceptionHelper;
	private DummyExtractedDatabaseMetaData extractedDatabaseMetaData;
	private DummyJdbcEnvironment jdbcEnvironment;
	private Dialect dialect;
	private DummyServiceRegistryImplementor serviceRegistryImplementor;
	private DummyLobCreator lobCreator;
	private DummyLobCreatorBuilder lobCreatorBuilder;
	private DummyLobCreationContext lobCreationContext;

	@Before
	public void before() {
		requireSources(HibernateCoreSummaryTest.MVNNAME, JdbcServicesImpl.class);

		dialect = new Dialect() {
		};

		sqlExceptionHelper = new SqlExceptionHelper(false);

		extractedDatabaseMetaData = new DummyExtractedDatabaseMetaData();

		lobCreator = new DummyLobCreator();

		lobCreatorBuilder = new DummyLobCreatorBuilder();
		lobCreatorBuilder.setBuildLobCreatorRWA(new RunnableWithArgs<LobCreator>() {
			@Override
			public LobCreator run(Object... args) {
				return lobCreator;
			}
		});

		jdbcEnvironment = new DummyJdbcEnvironment();
		jdbcEnvironment.setDialect(dialect);
		jdbcEnvironment.setSqlExceptionHelper(sqlExceptionHelper);
		jdbcEnvironment.setExtractedDatabaseMetaData(extractedDatabaseMetaData);
		jdbcEnvironment.setLobCreatorBuilder(lobCreatorBuilder);

		serviceRegistryImplementor = new DummyServiceRegistryImplementor();
		serviceRegistryImplementor.setService(JdbcEnvironment.class, jdbcEnvironment);

		lobCreationContext = new DummyLobCreationContext();
	}

	@Test
	public void test() {

		JdbcServicesImpl j = new JdbcServicesImpl();

		/** at first, everything is null */

		aeq(null, j.getSqlExceptionHelper());
		aeq(null, j.getExtractedMetaDataSupport());
		aeq(null, j.getLobCreator(lobCreationContext));
		aeq(null, j.getDialect());
		aeq(null, j.getResultSetWrapper());
		aeq(null, j.getJdbcEnvironment());
		aeq(null, j.getSqlStatementLogger());

		/** injecting the service registry is mandatory for configuration */
		j.injectServices(serviceRegistryImplementor);

		Map configValues = new HashMap();
		j.configure(configValues);

		/** the JDBC environment is necessary */
		aeqr(jdbcEnvironment, j.getJdbcEnvironment());

		/** the following are delegated to the JDBC environment */
		aeqr(dialect, j.getDialect());
		aeqr(sqlExceptionHelper, j.getSqlExceptionHelper());
		aeqr(extractedDatabaseMetaData, j.getExtractedMetaDataSupport());

		/** these are instanciated during configuration */
		aeq(ResultSetWrapperImpl.class, j.getResultSetWrapper().getClass());
		aeq(SqlStatementLogger.class, j.getSqlStatementLogger().getClass());

		/** this is delegated to the JDBC environment */
		aeqr(lobCreator, j.getLobCreator(lobCreationContext));

		/**
		 * this is instantiated everytime it is called, using the configured
		 * multitenancy strategy
		 */
		aeq(ConnectionProviderJdbcConnectionAccess.class, j.getBootstrapJdbcConnectionAccess().getClass());

	}
}
