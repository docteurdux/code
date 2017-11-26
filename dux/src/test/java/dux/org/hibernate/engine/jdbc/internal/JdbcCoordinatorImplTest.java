package dux.org.hibernate.engine.jdbc.internal;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.hibernate.engine.jdbc.batch.spi.BatchBuilder;
import org.hibernate.engine.jdbc.internal.JdbcCoordinatorImpl;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.jdbc.WorkExecutor;
import org.hibernate.jdbc.WorkExecutorVisitable;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.RunnableWithArgs;

import dum.java.sql.DummyConnection;
import dum.org.hibernate.engine.jdbc.batch.spi.DummyBatch;
import dum.org.hibernate.engine.jdbc.batch.spi.DummyBatchKey;
import dum.org.hibernate.engine.jdbc.spi.DummyJdbcServices;
import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.resource.jdbc.spi.DummyJdbcSessionContext;
import dum.org.hibernate.resource.jdbc.spi.DummyJdbcSessionOwner;
import dum.org.hibernate.service.DummyServiceRegistry;
import dum.org.hibernate.service.spi.DummyServiceRegistryImplementor;
import dus.hibernate.core.HibernateCoreSummaryTest;
import dux.org.hibernate.engine.jdbc.batch.internal.DummyBatchBuilder;

public class JdbcCoordinatorImplTest extends AbstractTest {

	private DummyConnection connection;
	private DummyJdbcSessionContext jdbcSessionContext;
	private DummyServiceRegistry serviceRegistry;
	private DummyJdbcServices jdbcServices;
	private DummyJdbcSessionOwner jdbcSessionOwner;
	private DummySessionFactoryImplementor sessionFactoryImplementor;
	private DummyServiceRegistryImplementor serviceRegistryImplementor;
	private DummyBatchBuilder batchBuilder;
	private DummyBatch batch;

	@Before
	public void before() {
		requireSources(HibernateCoreSummaryTest.MVNNAME, JdbcCoordinatorImpl.class);
	}

	@Test
	public void test() {

		connection = new DummyConnection();

		jdbcServices = new DummyJdbcServices();

		batch = new DummyBatch();

		batchBuilder = new DummyBatchBuilder();
		batchBuilder.setBuildBatchRWA(new RunnableWithArgs<Batch>() {
			@Override
			public Batch run(Object... args) {
				return batch;
			}
		});

		serviceRegistry = new DummyServiceRegistry();
		serviceRegistry.setService(JdbcServices.class, jdbcServices);

		serviceRegistryImplementor = new DummyServiceRegistryImplementor();
		serviceRegistryImplementor.setService(BatchBuilder.class, batchBuilder);

		sessionFactoryImplementor = new DummySessionFactoryImplementor();
		sessionFactoryImplementor.setServiceRegistry(serviceRegistryImplementor);

		jdbcSessionContext = new DummyJdbcSessionContext();
		jdbcSessionContext.setServiceRegistry(serviceRegistry);
		jdbcSessionContext.setSessionFactory(sessionFactoryImplementor);

		jdbcSessionOwner = new DummyJdbcSessionOwner();
		jdbcSessionOwner.setJdbcSessionContext(jdbcSessionContext);

		JdbcCoordinatorImpl j = new JdbcCoordinatorImpl(connection, jdbcSessionOwner);

		DummyBatchKey key = new DummyBatchKey();

		Batch batch = j.getBatch(key);
		j.executeBatch();
		j.abortBatch();

		j.afterStatementExecution();

		j.afterTransaction();

		j.afterTransactionBegin();

		j.afterTransactionCompletion(true, true);

		j.beforeTransactionCompletion();

		j.cancelLastQuery();

		// j.close();

		j.coordinateWork(new WorkExecutorVisitable<String>() {
			@Override
			public String accept(WorkExecutor<String> executor, Connection connection) throws SQLException {
				return null;
			}
		});

		j.determineRemainingTransactionTimeOutPeriod();

		j.disableReleases();
		j.enableReleases();

		j.flushBeforeTransactionCompletion();

		j.flushBeginning();
		j.flushEnding();

		j.getJdbcSessionOwner();

		j.getLogicalConnection();

		j.getResourceLocalTransaction();

		j.getResultSetReturn();

		j.getStatementPreparer();

		j.isActive();

		j.isReadyForSerialization();

		Statement statement = null;
		j.registerLastQuery(statement);

		ObjectOutputStream oos = null;
		try {
			j.serialize(oos);
		} catch (IOException e) {
			// throw new RuntimeException(e);
		}

		// j.setTransactionTimeOut(0);

		j.sqlExceptionHelper();

	}
}
