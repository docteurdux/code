package dux.com.sun.jts.jta;

import java.util.Enumeration;
import java.util.Properties;

import javax.resource.spi.work.WorkException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.InvalidTransactionException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.xa.Xid;

import org.junit.Test;
import org.omg.CosTransactions.Status;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;
import com.sun.jts.jta.TransactionManagerImpl;

@Topic(TransactionManagerImpl.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class TransactionManagerImplTest extends AbstractTest {
	@SuppressWarnings("rawtypes")
	@Test
	public void test() throws WorkException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, InvalidTransactionException {
		
		Properties props = null;
		String logDir = null;
		boolean trace = false;
		String traceDir = null;
		Status status = null;
		Enumeration xaResourceList = null;
		Xid xid = null;
		long timeout = 0;
		int value = 0;
		int timeoutt = 0;
		Transaction suspended = null;
		int seconds = 0;
		
		TransactionManagerImpl i = TransactionManagerImpl.getTransactionManagerImpl();
		TransactionManagerImpl.getXAResourceTimeOut();
		TransactionManagerImpl.getXATerminator();
		TransactionManagerImpl.initJTSProperties(props, logDir, trace, traceDir);
		TransactionManagerImpl.mapStatus(status);
		TransactionManagerImpl.recover(xaResourceList);
		TransactionManagerImpl.recreate(xid, timeout);
		TransactionManagerImpl.release(xid);
		TransactionManagerImpl.setXAResourceTimeOut(value);

		i.begin();
		i.begin(timeoutt);
		i.commit();
		i.getStatus();
		i.getTransaction();
		i.resume(suspended);
		i.rollback();
		i.setRollbackOnly();
		i.setTransactionTimeout(seconds);
		i.suspend();

	}
}