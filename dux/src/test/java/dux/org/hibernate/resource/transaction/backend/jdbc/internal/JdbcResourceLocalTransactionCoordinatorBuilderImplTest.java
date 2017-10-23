package dux.org.hibernate.resource.transaction.backend.jdbc.internal;

import org.hibernate.resource.transaction.backend.jdbc.internal.JdbcResourceLocalTransactionCoordinatorBuilderImpl;
import org.hibernate.resource.transaction.spi.TransactionCoordinatorBuilder.Options;
import org.hibernate.resource.transaction.spi.TransactionCoordinatorOwner;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.org.hibernate.resource.transaction.spi.DummyTransactionCoordinatorOwner;
import dum.org.hibernate.resource.transaction.spi.TransactionCoordinatorBuilder.DummyOptions;
import dum.org.hibernate.tool.schema.internal.exec.DummyJdbcContext;

public class JdbcResourceLocalTransactionCoordinatorBuilderImplTest extends AbstractTest {
	@Test
	public void test() {
		JdbcResourceLocalTransactionCoordinatorBuilderImpl builder = new JdbcResourceLocalTransactionCoordinatorBuilderImpl();
		DummyJdbcContext jdbcContext = new DummyJdbcContext();
		builder.buildDdlTransactionIsolator(jdbcContext );
		TransactionCoordinatorOwner owner = new DummyTransactionCoordinatorOwner();
		Options options = new DummyOptions();
		builder.buildTransactionCoordinator(owner , options );
		builder.getDefaultConnectionHandlingMode();
		builder.getDefaultConnectionAcquisitionMode();
		builder.getDefaultConnectionReleaseMode();
		builder.isJta();
	}
}
