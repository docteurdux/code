package dum.org.hibernate.resource.transaction.spi;

import org.hibernate.resource.jdbc.spi.PhysicalConnectionHandlingMode;
import org.hibernate.resource.transaction.spi.TransactionCoordinator;
import org.hibernate.resource.transaction.spi.TransactionCoordinatorBuilder;
import org.hibernate.resource.transaction.spi.TransactionCoordinatorOwner;

import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyTransactionCoordinatorBuilder extends TestEventCollector implements TransactionCoordinatorBuilder {

	private static final long serialVersionUID = 1L;
	private RunnableWithArgs<TransactionCoordinator> buildTransactionCoordinatorRWA;
	private PhysicalConnectionHandlingMode defaultConnectionHandlingMode;

	@Override
	public TransactionCoordinator buildTransactionCoordinator(TransactionCoordinatorOwner owner, Options options) {
		testEvents.add(new TestEvent("buildTransactionCoordinator").prop("owner", owner).prop("options", options));
		if (buildTransactionCoordinatorRWA != null) {
			return buildTransactionCoordinatorRWA.run(owner, options);
		}
		return null;
	}

	public void setBuildTransactionCoordinatorRWA(
			RunnableWithArgs<TransactionCoordinator> buildTransactionCoordinatorRWA) {
		this.buildTransactionCoordinatorRWA = buildTransactionCoordinatorRWA;
	}

	@Override
	public boolean isJta() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PhysicalConnectionHandlingMode getDefaultConnectionHandlingMode() {
		return defaultConnectionHandlingMode;
	}

	public void setDefaultConnectionHandlingMode(PhysicalConnectionHandlingMode defaultConnectionHandlingMode) {
		this.defaultConnectionHandlingMode = defaultConnectionHandlingMode;
	}

}
