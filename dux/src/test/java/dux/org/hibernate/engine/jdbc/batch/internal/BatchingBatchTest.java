package dux.org.hibernate.engine.jdbc.batch.internal;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.engine.jdbc.batch.internal.AbstractBatchImpl;
import org.hibernate.engine.jdbc.batch.internal.BatchingBatch;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

import dum.java.sql.DummyPreparedStatement;
import dum.org.hibernate.engine.jdbc.batch.spi.DummyBatchKey;
import dum.org.hibernate.engine.jdbc.batch.spi.DummyBatchObserver;
import dum.org.hibernate.engine.jdbc.spi.DummyJdbcCoordinator;
import dum.org.hibernate.engine.jdbc.spi.DummyJdbcServices;
import dum.org.hibernate.engine.jdbc.spi.DummyStatementPreparer;
import dum.org.hibernate.jdbc.DummyExpectation;
import dum.org.hibernate.resource.jdbc.DummyResourceRegistry;
import dum.org.hibernate.resource.jdbc.spi.DummyJdbcObserver;
import dum.org.hibernate.resource.jdbc.spi.DummyJdbcSessionContext;
import dum.org.hibernate.resource.jdbc.spi.DummyJdbcSessionOwner;
import dum.org.hibernate.resource.jdbc.spi.DummyLogicalConnectionImplementor;
import dum.org.hibernate.service.DummyServiceRegistry;
import dus.hibernate.core.HibernateCoreSummaryTest;

public class BatchingBatchTest extends AbstractTest {

	private DummyExpectation expectation;
	private DummyBatchKey batchKey;
	private DummyJdbcServices jdbcServices;
	private DummyServiceRegistry serviceRegistry;
	private DummyJdbcObserver jdbcObserver;
	private DummyJdbcSessionContext jdbcSessionContext;
	private DummyJdbcSessionOwner jdbcSessionOwner;
	private DummyPreparedStatement preparedStatement1;
	private DummyStatementPreparer statementPreparer;
	private DummyResourceRegistry resourceRegistry;
	private DummyLogicalConnectionImplementor logicalConnectionImplementor;
	private DummyJdbcCoordinator jdbcCoordinator;
	private int batchSize;
	private DummyBatchObserver batchObserver;
	private String sql1;
	private Map<String, PreparedStatement> preparedStatements;
	private RunnableWithArgs<int[]> executeBatchRWA;
	private String sql2;
	private DummyPreparedStatement preparedStatement2;
	private TestEventCollector tec;

	@Before
	public void before() {
		requireSources(HibernateCoreSummaryTest.MVNNAME, BatchingBatch.class, AbstractBatchImpl.class);
	}

	@Test
	public void test() {

		executeBatchRWA = new RunnableWithArgs<int[]>() {
			@Override
			public int[] run(Object... args) {
				return new int[] { 0 };
			}
		};

		preparedStatements = new HashMap<String, PreparedStatement>();

		sql1 = "sql1";
		preparedStatement1 = new DummyPreparedStatement();
		preparedStatement1.setTestEventSourceName("preparedStatement1");
		preparedStatement1.setExecuteBatchRWA(executeBatchRWA);
		preparedStatements.put(sql1, preparedStatement1);

		sql2 = "sql2";
		preparedStatement2 = new DummyPreparedStatement();
		preparedStatement2.setTestEventSourceName("preparedStatement2");
		preparedStatement2.setExecuteBatchRWA(executeBatchRWA);
		preparedStatements.put(sql2, preparedStatement1);

		statementPreparer = new DummyStatementPreparer();
		statementPreparer.setPrepareStatementRWA(new RunnableWithArgs<PreparedStatement>() {
			@Override
			public PreparedStatement run(Object... args) {
				String sql = (String) args[0];
				return preparedStatements.get(sql);
			}
		});

		expectation = new DummyExpectation();
		expectation.setCanBeBatched(true);
		batchKey = new DummyBatchKey();
		batchKey.setExpectation(expectation);
		jdbcServices = new DummyJdbcServices();
		serviceRegistry = new DummyServiceRegistry();
		serviceRegistry.setService(JdbcServices.class, jdbcServices);
		jdbcObserver = new DummyJdbcObserver();
		jdbcSessionContext = new DummyJdbcSessionContext();
		jdbcSessionContext.setServiceRegistry(serviceRegistry);
		jdbcSessionContext.setObserver(jdbcObserver);
		jdbcSessionOwner = new DummyJdbcSessionOwner();
		jdbcSessionOwner.setJdbcSessionContext(jdbcSessionContext);

		resourceRegistry = new DummyResourceRegistry();
		logicalConnectionImplementor = new DummyLogicalConnectionImplementor();
		logicalConnectionImplementor.setResourceRegistry(resourceRegistry);
		jdbcCoordinator = new DummyJdbcCoordinator();
		jdbcCoordinator.setJdbcSessionOwner(jdbcSessionOwner);
		jdbcCoordinator.setStatementPreparer(statementPreparer);
		jdbcCoordinator.setLogicalConnectionImplementor(logicalConnectionImplementor);
		batchSize = 2;

		tec = new TestEventCollector() {
		};
		tec.setTestEventSourceName("-----");

		BatchingBatch bb = new BatchingBatch(batchKey, jdbcCoordinator, batchSize);

		tec.getTestEvents().add(new TestEvent("-----"));

		batchObserver = new DummyBatchObserver();
		
		tec.getTestEvents().add(new TestEvent("-----"));
		
		bb.addObserver(batchObserver);
		
		tec.getTestEvents().add(new TestEvent("-----"));

		bb.getBatchStatement(sql1, false);
		
		tec.getTestEvents().add(new TestEvent("-----"));

		bb.addToBatch();
		
		tec.getTestEvents().add(new TestEvent("-----"));

		bb.getBatchStatement(sql2, false);
		
		tec.getTestEvents().add(new TestEvent("-----"));

		bb.addToBatch();
		
		tec.getTestEvents().add(new TestEvent("-----"));

		bb.execute();
		
		tec.getTestEvents().add(new TestEvent("-----"));

		dumpTestEvents(this);

	}
}
