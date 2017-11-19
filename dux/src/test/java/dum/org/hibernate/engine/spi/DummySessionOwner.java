package dum.org.hibernate.engine.spi;

import org.hibernate.engine.spi.SessionOwner;
import org.hibernate.resource.transaction.backend.jta.internal.synchronization.AfterCompletionAction;
import org.hibernate.resource.transaction.backend.jta.internal.synchronization.ExceptionMapper;
import org.hibernate.resource.transaction.backend.jta.internal.synchronization.ManagedFlushChecker;

@SuppressWarnings("deprecation")
public class DummySessionOwner implements SessionOwner {

	@Override
	public boolean shouldAutoCloseSession() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ExceptionMapper getExceptionMapper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AfterCompletionAction getAfterCompletionAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagedFlushChecker getManagedFlushChecker() {
		// TODO Auto-generated method stub
		return null;
	}

}
