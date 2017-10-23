package dum.org.hibernate.resource.transaction.spi;

import org.hibernate.resource.jdbc.spi.PhysicalConnectionHandlingMode;
import org.hibernate.resource.transaction.spi.TransactionCoordinator;
import org.hibernate.resource.transaction.spi.TransactionCoordinatorBuilder;
import org.hibernate.resource.transaction.spi.TransactionCoordinatorOwner;

public class DummyTransactionCoordinatorBuilder implements TransactionCoordinatorBuilder {

	private static final long serialVersionUID = 1L;

	@Override
	public TransactionCoordinator buildTransactionCoordinator(TransactionCoordinatorOwner owner, Options options) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isJta() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PhysicalConnectionHandlingMode getDefaultConnectionHandlingMode() {
		// TODO Auto-generated method stub
		return null;
	}

}
