package dux.javax.transaction;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.InvalidTransactionException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;

import org.hibernate.engine.transaction.jta.platform.internal.WebSphereExtendedJtaPlatform.TransactionManagerAdapter;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;
import com.sun.enterprise.transaction.TransactionManagerHelper;
import com.sun.enterprise.transaction.api.JavaEETransactionManager;
import com.sun.jts.jta.TransactionManagerImpl;

import bitronix.tm.BitronixTransactionManager;

@Topic(TransactionManager.class)
@Extends({})
@ExtendedBy({ BitronixTransactionManager.class, TransactionManagerAdapter.class, TransactionManagerHelper.class,
		TransactionManagerImpl.class, JavaEETransactionManager.class })
@Related({})
public class TransactionManagerTest extends AbstractTest {
	@Test
	public void test() throws NotSupportedException, SystemException, SecurityException, IllegalStateException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException, InvalidTransactionException {

		Transaction tobj = null;
		int seconds = 0;

		TransactionManager m = Recorder.create(TransactionManager.class).p();

		m.begin();
		m.commit();
		m.getStatus();
		m.getTransaction();
		m.resume(tobj);
		m.rollback();
		m.setRollbackOnly();
		m.setTransactionTimeout(seconds);
		m.suspend();

	}
}
