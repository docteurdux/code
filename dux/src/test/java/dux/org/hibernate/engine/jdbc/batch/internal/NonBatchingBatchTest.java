package dux.org.hibernate.engine.jdbc.batch.internal;

import java.lang.reflect.Constructor;
import java.sql.PreparedStatement;

import org.hibernate.engine.jdbc.batch.internal.AbstractBatchImpl;
import org.hibernate.engine.jdbc.batch.internal.NonBatchingBatch;
import org.hibernate.engine.jdbc.batch.spi.BatchKey;
import org.hibernate.engine.jdbc.spi.JdbcCoordinator;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.RunnableWithArgs;

import dum.java.sql.DummyPreparedStatement;
import dum.org.hibernate.engine.jdbc.batch.spi.DummyBatchKey;
import dum.org.hibernate.engine.jdbc.batch.spi.DummyBatchObserver;
import dum.org.hibernate.engine.jdbc.spi.DummyJdbcCoordinator;
import dum.org.hibernate.engine.jdbc.spi.DummyJdbcServices;
import dum.org.hibernate.engine.jdbc.spi.DummyResultSetReturn;
import dum.org.hibernate.engine.jdbc.spi.DummyStatementPreparer;
import dum.org.hibernate.jdbc.DummyExpectation;
import dum.org.hibernate.resource.jdbc.DummyResourceRegistry;
import dum.org.hibernate.resource.jdbc.spi.DummyJdbcSessionContext;
import dum.org.hibernate.resource.jdbc.spi.DummyJdbcSessionOwner;
import dum.org.hibernate.resource.jdbc.spi.DummyLogicalConnectionImplementor;
import dum.org.hibernate.service.DummyServiceRegistry;
import dus.hibernate.core.HibernateCoreSummaryTest;

public class NonBatchingBatchTest extends AbstractTest {

	private Constructor<NonBatchingBatch> constructor;
	private DummyBatchKey batchKey;
	private DummyJdbcCoordinator jdbcCoordinator;
	private DummyJdbcSessionOwner jdbcSessionOwner;
	private DummyJdbcServices jdbcServices;
	private DummyServiceRegistry serviceRegistry;
	private DummyJdbcSessionContext jdbcSessionContext;
	private DummyBatchObserver batchObserver;
	private DummyStatementPreparer statementPreparer;
	private DummyPreparedStatement preparedStatement;
	private DummyResultSetReturn resultSetReturn;
	private int rowCount;
	private DummyExpectation expectation;
	private DummyLogicalConnectionImplementor logicalConnectionImplementor;
	private DummyResourceRegistry resourceRegistry;

	@Before
	public void before() {

		rowCount = 1;

		requireSources(HibernateCoreSummaryTest.MVNNAME, NonBatchingBatch.class, AbstractBatchImpl.class);

		constructor = getConstructor(NonBatchingBatch.class, BatchKey.class, JdbcCoordinator.class);

		expectation = new DummyExpectation();

		batchKey = new DummyBatchKey();
		batchKey.setExpectation(expectation);

		jdbcServices = new DummyJdbcServices();

		serviceRegistry = new DummyServiceRegistry();
		serviceRegistry.setService(JdbcServices.class, jdbcServices);

		jdbcSessionContext = new DummyJdbcSessionContext();
		jdbcSessionContext.setServiceRegistry(serviceRegistry);

		jdbcSessionOwner = new DummyJdbcSessionOwner();
		jdbcSessionOwner.setJdbcSessionContext(jdbcSessionContext);

		preparedStatement = new DummyPreparedStatement();

		statementPreparer = new DummyStatementPreparer();
		statementPreparer.setPrepareStatementRWA(new RunnableWithArgs<PreparedStatement>() {
			@Override
			public PreparedStatement run(Object... args) {
				return preparedStatement;
			}
		});

		resultSetReturn = new DummyResultSetReturn();
		resultSetReturn.setExecuteUpdateRWA(new RunnableWithArgs<Integer>() {
			@Override
			public Integer run(Object... args) {
				return rowCount;
			}
		});

		resourceRegistry = new DummyResourceRegistry();

		logicalConnectionImplementor = new DummyLogicalConnectionImplementor();
		logicalConnectionImplementor.setResourceRegistry(resourceRegistry);

		jdbcCoordinator = new DummyJdbcCoordinator();
		jdbcCoordinator.setJdbcSessionOwner(jdbcSessionOwner);
		jdbcCoordinator.setStatementPreparer(statementPreparer);
		jdbcCoordinator.setResultSetReturn(resultSetReturn);
		jdbcCoordinator.setLogicalConnectionImplementor(logicalConnectionImplementor);

		batchObserver = new DummyBatchObserver();
	}

	@Test
	public void test() {

		// weird ; behaves as if it were public in BatchBuilderImpl
		aeq(true, isProtected(constructor));

		NonBatchingBatch nbb = instantiate(constructor, batchKey, jdbcCoordinator);

		nbb.addObserver(batchObserver);

		nbb.getBatchStatement("sql", false);

		nbb.addToBatch();

		nbb.getBatchStatement("sql", false);

		nbb.release();

		nbb.getBatchStatement("sql", false);

		nbb.execute();

		dumpTestEvents(this);

	}

}
