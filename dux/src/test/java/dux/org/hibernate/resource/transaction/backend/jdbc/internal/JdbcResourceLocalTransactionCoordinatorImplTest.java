package dux.org.hibernate.resource.transaction.backend.jdbc.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.engine.transaction.spi.IsolationDelegate;
import org.hibernate.resource.transaction.backend.jdbc.internal.JdbcResourceLocalTransactionCoordinatorImpl;
import org.hibernate.resource.transaction.backend.jdbc.spi.JdbcResourceTransaction;
import org.hibernate.resource.transaction.backend.jdbc.spi.JdbcResourceTransactionAccess;
import org.hibernate.resource.transaction.spi.TransactionCoordinator.TransactionDriver;
import org.hibernate.resource.transaction.spi.TransactionCoordinatorBuilder;
import org.hibernate.resource.transaction.spi.TransactionCoordinatorOwner;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.org.hibernate.engine.jdbc.spi.DummyJdbcServices;
import dum.org.hibernate.engine.transaction.spi.DummyTransactionObserver;
import dum.org.hibernate.exception.spi.DummySQLExceptionConverter;
import dum.org.hibernate.resource.jdbc.spi.DummyJdbcSessionContext;
import dum.org.hibernate.resource.jdbc.spi.DummyJdbcSessionOwner;
import dum.org.hibernate.resource.transaction.backend.jdbc.spi.DummyJdbcResourceTransaction;
import dum.org.hibernate.resource.transaction.backend.jdbc.spi.DummyJdbcResourceTransactionAccess;
import dum.org.hibernate.resource.transaction.spi.DummyTransactionCoordinatorBuilder;
import dum.org.hibernate.resource.transaction.spi.DummyTransactionCoordinatorOwner;
import dum.org.hibernate.service.DummyServiceRegistry;

public class JdbcResourceLocalTransactionCoordinatorImplTest extends AbstractTest {

	private DummyTransactionCoordinatorBuilder transactionCoordinatorBuilder;
	private DummyTransactionCoordinatorOwner owner;
	private DummyJdbcResourceTransactionAccess jdbcResourceTransactionAccess;
	private JdbcResourceLocalTransactionCoordinatorImpl coordinator;
	private DummyJdbcSessionOwner jdbcSessionOwner;
	private DummyJdbcSessionContext jdbcSessionContext;
	private DummyServiceRegistry serviceRegistry;
	private DummySQLExceptionConverter sqlExceptionConverter;
	private SqlExceptionHelper sqlExceptionHelper;
	private DummyJdbcServices jdbcServices;
	private DummyTransactionObserver observer;

	@Before
	public void before() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {

		observer = new DummyTransactionObserver();

		sqlExceptionConverter = new DummySQLExceptionConverter();

		sqlExceptionHelper = new SqlExceptionHelper(sqlExceptionConverter, false);

		jdbcServices = new DummyJdbcServices();
		jdbcServices.setSqlExceptionHelper(sqlExceptionHelper);

		serviceRegistry = new DummyServiceRegistry();
		serviceRegistry.getServices().put(JdbcServices.class, jdbcServices);

		jdbcSessionContext = new DummyJdbcSessionContext();
		jdbcSessionContext.setServiceRegistry(serviceRegistry);

		jdbcSessionOwner = new DummyJdbcSessionOwner();
		jdbcSessionOwner.setJdbcSessionContext(jdbcSessionContext);

		transactionCoordinatorBuilder = new DummyTransactionCoordinatorBuilder();
		owner = new DummyTransactionCoordinatorOwner();
		owner.setJdbcSessionOwner(jdbcSessionOwner);
		jdbcResourceTransactionAccess = new DummyJdbcResourceTransactionAccess();

		Constructor<JdbcResourceLocalTransactionCoordinatorImpl> constructor = JdbcResourceLocalTransactionCoordinatorImpl.class
				.getDeclaredConstructor(TransactionCoordinatorBuilder.class, TransactionCoordinatorOwner.class,
						JdbcResourceTransactionAccess.class);
		constructor.setAccessible(true);
		coordinator = constructor.newInstance(transactionCoordinatorBuilder, owner, jdbcResourceTransactionAccess);
	}

	@Test
	public void test1() {

		JdbcResourceTransaction resourceLocalTransaction = new DummyJdbcResourceTransaction();
		jdbcResourceTransactionAccess.setResourceLocalTransaction(resourceLocalTransaction);

		TransactionDriver driverControl = coordinator.getTransactionDriverControl();
		coordinator.explicitJoin();
		coordinator.isJoined();
		coordinator.pulse();
		coordinator.getLocalSynchronizations();
		coordinator.isActive();
		IsolationDelegate delegate = coordinator.createIsolationDelegate();
		TransactionCoordinatorBuilder builder = coordinator.getTransactionCoordinatorBuilder();
		coordinator.setTimeOut(0);
		int timeOut = coordinator.getTimeOut();

		coordinator.addObserver(observer);
		coordinator.removeObserver(observer);

		driverControl.begin();
		driverControl.commit();
		driverControl.rollback();
		driverControl.getStatus();
		driverControl.markRollbackOnly();
		driverControl.isActive(false);
	}
}
