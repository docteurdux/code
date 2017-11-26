package dux.org.hibernate.engine.jdbc.batch.internal;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.cfg.Environment;
import org.hibernate.engine.jdbc.batch.internal.BatchBuilderImpl;
import org.hibernate.engine.jdbc.batch.internal.BatchingBatch;
import org.hibernate.engine.jdbc.batch.internal.NonBatchingBatch;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.engine.jdbc.batch.spi.DummyBatchKey;
import dum.org.hibernate.engine.jdbc.spi.DummyJdbcCoordinator;
import dum.org.hibernate.engine.jdbc.spi.DummyJdbcServices;
import dum.org.hibernate.jdbc.DummyExpectation;
import dum.org.hibernate.resource.jdbc.spi.DummyJdbcSessionContext;
import dum.org.hibernate.resource.jdbc.spi.DummyJdbcSessionOwner;
import dum.org.hibernate.service.DummyServiceRegistry;
import dus.hibernate.core.HibernateCoreSummaryTest;

@Done
public class BatchBuilderImplTest extends AbstractTest {

	private DummyExpectation expectation;
	private DummyBatchKey batchKey;
	private DummyJdbcServices jdbcServices;
	private DummyServiceRegistry serviceRegistry;
	private DummyJdbcSessionContext jdbcSessionContext;
	private DummyJdbcSessionOwner jdbcSessionOwner;
	private DummyJdbcCoordinator jdbcCoordinator;

	public BatchBuilderImplTest() {

		expectation = new DummyExpectation();
		expectation.setCanBeBatched(true);

		batchKey = new DummyBatchKey();
		batchKey.setExpectation(expectation);

		jdbcServices = new DummyJdbcServices();

		serviceRegistry = new DummyServiceRegistry();
		serviceRegistry.setService(JdbcServices.class, jdbcServices);

		jdbcSessionContext = new DummyJdbcSessionContext();
		jdbcSessionContext.setServiceRegistry(serviceRegistry);

		jdbcSessionOwner = new DummyJdbcSessionOwner();
		jdbcSessionOwner.setJdbcSessionContext(jdbcSessionContext);
		jdbcSessionOwner.setJdbcBatchSize(null);

		jdbcCoordinator = new DummyJdbcCoordinator();
		jdbcCoordinator.setJdbcSessionOwner(jdbcSessionOwner);

	}

	@Before
	public void before() {
		requireSources(HibernateCoreSummaryTest.MVNNAME, BatchBuilderImpl.class);
	}

	/**
	 * JDBC batch size can be configured as a parameter to the constructor, a simple
	 * setter, or a configuration value
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void test1() {
		BatchBuilderImpl bbi = new BatchBuilderImpl(1);
		aeq(1, bbi.getJdbcBatchSize());

		Map configurationValues = new HashMap<>();
		configurationValues.put(Environment.STATEMENT_BATCH_SIZE, 2);
		bbi.configure(configurationValues);
		aeq(2, bbi.getJdbcBatchSize());

		bbi.setJdbcBatchSize(3);
		aeq(3, bbi.getJdbcBatchSize());
	}

	/**
	 * Default constructor has batch size 0
	 */
	@Test
	public void test2() {
		BatchBuilderImpl bbi = new BatchBuilderImpl();
		aeq(0, bbi.getJdbcBatchSize());
	}

	/** Batch builder is manageable */
	@Test
	public void test3() {

		BatchBuilderImpl bbi = new BatchBuilderImpl();

		aeq(null, bbi.getManagementDomain());
		aeq(null, bbi.getManagementServiceType());
		aeqr(bbi, bbi.getManagementBean());
	}

	/**
	 * Actual batch instance produced depends on whether batch size is greater than
	 * 1
	 */
	@Test
	public void test4() {

		BatchBuilderImpl bbi = new BatchBuilderImpl();

		bbi.setJdbcBatchSize(0);
		aeq(NonBatchingBatch.class, bbi.buildBatch(batchKey, jdbcCoordinator).getClass());

		bbi.setJdbcBatchSize(1);
		aeq(NonBatchingBatch.class, bbi.buildBatch(batchKey, jdbcCoordinator).getClass());

		bbi.setJdbcBatchSize(2);
		aeq(BatchingBatch.class, bbi.buildBatch(batchKey, jdbcCoordinator).getClass());
	}

	/**
	 * Batch size specified at session owner level takes precedence
	 */
	@Test
	public void test5() {

		BatchBuilderImpl bbi = new BatchBuilderImpl();

		bbi.setJdbcBatchSize(1);
		jdbcSessionOwner.setJdbcBatchSize(2);
		aeq(BatchingBatch.class, bbi.buildBatch(batchKey, jdbcCoordinator).getClass());
	}
}
