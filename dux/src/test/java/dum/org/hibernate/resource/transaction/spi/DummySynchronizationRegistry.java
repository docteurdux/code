package dum.org.hibernate.resource.transaction.spi;

import javax.transaction.Synchronization;

import org.hibernate.resource.transaction.spi.SynchronizationRegistry;

public class DummySynchronizationRegistry implements SynchronizationRegistry {

	@Override
	public void registerSynchronization(Synchronization synchronization) {
		// TODO Auto-generated method stub

	}

}
