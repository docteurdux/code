package dum.org.hibernate.resource.transaction.spi.TransactionCoordinatorBuilder;

import org.hibernate.resource.transaction.spi.TransactionCoordinatorBuilder.Options;

public class DummyOptions implements Options {

	private boolean shouldAutoJoinTransaction;

	@Override
	public boolean shouldAutoJoinTransaction() {
		return shouldAutoJoinTransaction;
	}

	public void setShouldAutoJoinTransaction(boolean shouldAutoJoinTransaction) {
		this.shouldAutoJoinTransaction = shouldAutoJoinTransaction;
	}

}
