package dux.org.hibernate.engine.jdbc.batch.internal;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.cfg.Environment;
import org.hibernate.engine.jdbc.batch.internal.BatchBuilderImpl;
import org.hibernate.engine.jdbc.batch.internal.BatchBuilderInitiator;
import org.hibernate.engine.jdbc.batch.spi.BatchBuilder;
import org.hibernate.service.spi.ServiceException;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.RunnableWhichThrow;
import com.github.docteurdux.test.RunnableWithArgs;

import dum.org.hibernate.boot.registry.classloading.spi.DummyClassLoaderService;
import dum.org.hibernate.service.spi.DummyServiceRegistryImplementor;
import dus.hibernate.core.HibernateCoreSummaryTest;

@Done
public class BatchBuilderInitiatorTest extends AbstractTest {

	@SuppressWarnings("rawtypes")
	private Map configurationValues;

	private DummyServiceRegistryImplementor serviceRegistryImplementor;
	private BatchBuilderInitiator instance;
	private DummyClassLoaderService classLoaderService;

	public BatchBuilderInitiatorTest() {

	}

	@Before
	public void before() {
		requireSources(HibernateCoreSummaryTest.MVNNAME, BatchBuilderInitiator.class);

		configurationValues = new HashMap<>();

		classLoaderService = new DummyClassLoaderService();
		classLoaderService.setClassForNameRWA(new RunnableWithArgs<Class<?>>() {
			@Override
			public Class<?> run(Object... args) {
				String className = (String) args[0];
				try {
					return Class.forName(className);
				} catch (ClassNotFoundException e) {
					throw new RuntimeException(e);
				}
			}
		});

		serviceRegistryImplementor = new DummyServiceRegistryImplementor();
		serviceRegistryImplementor.setService(ClassLoaderService.class, classLoaderService);

		instance = BatchBuilderInitiator.INSTANCE;
	}

	/** Configuration constants */
	@Test
	public void test0() {
		aeq(BatchBuilder.class, instance.getServiceInitiated());
	}

	/** Configuration constants */
	@Test
	public void test1() {

		aeq("hibernate.jdbc.batch.builder", BatchBuilderInitiator.BUILDER);
		aeq("hibernate.jdbc.batch_size", Environment.STATEMENT_BATCH_SIZE);

	}

	/** Default behavior */
	@Test
	public void test2() {

		BatchBuilderImpl batchBuilder = (BatchBuilderImpl) instance.initiateService(configurationValues,
				serviceRegistryImplementor);
		aeq(1, batchBuilder.getJdbcBatchSize());
	}

	/** Configured default implementation */
	@Test
	@SuppressWarnings("unchecked")
	public void test3() {

		configurationValues.put(Environment.STATEMENT_BATCH_SIZE, 2);

		BatchBuilderImpl batchBuilder = (BatchBuilderImpl) instance.initiateService(configurationValues,
				serviceRegistryImplementor);
		aeq(2, batchBuilder.getJdbcBatchSize());

	}

	/** Custom instance **/
	@Test
	@SuppressWarnings("unchecked")
	public void test4() {

		DummyBatchBuilder bb = new DummyBatchBuilder();
		configurationValues.put(BatchBuilderInitiator.BUILDER, bb);

		aeqr(bb, instance.initiateService(configurationValues, serviceRegistryImplementor));

	}

	/** Custom instance with class name **/
	@Test
	@SuppressWarnings("unchecked")
	public void test5() {

		configurationValues.put(BatchBuilderInitiator.BUILDER,
				"dux.org.hibernate.engine.jdbc.batch.internal.DummyBatchBuilder");

		aeqr(DummyBatchBuilder.class,
				instance.initiateService(configurationValues, serviceRegistryImplementor).getClass());

	}

	/** Class name not found **/
	@Test
	@SuppressWarnings("unchecked")
	public void test6() {

		configurationValues.put(BatchBuilderInitiator.BUILDER,
				"dux.org.hibernate.engine.jdbc.batch.internal.DummyBatchBuilder");

		classLoaderService.setClassForNameRWA(new RunnableWithArgs<Class<?>>() {
			@Override
			public Class<?> run(Object... args) {
				return null;
			}
		});

		expect(ServiceException.class,
				"Could not build explicit BatchBuilder [dux.org.hibernate.engine.jdbc.batch.internal.DummyBatchBuilder]",
				new RunnableWhichThrow() {
					@Override
					public void run() throws Exception {
						instance.initiateService(configurationValues, serviceRegistryImplementor).getClass();
					}
				});

	}
}
