package dux.org.springframework.jca.support;

import javax.resource.spi.UnavailableException;
import javax.resource.spi.XATerminator;
import javax.resource.spi.work.WorkContext;
import javax.resource.spi.work.WorkManager;
import javax.transaction.TransactionSynchronizationRegistry;

import org.junit.Test;
import org.springframework.jca.support.SimpleBootstrapContext;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(SimpleBootstrapContext.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class SimpleBootstrapContextTest extends AbstractTest {
	@Test
	public void test() throws UnavailableException {

		WorkManager workManager = null;
		XATerminator xaTerminator = null;
		TransactionSynchronizationRegistry transactionSynchronizationRegistry = null;

		SimpleBootstrapContext s = new SimpleBootstrapContext(workManager);
		s = new SimpleBootstrapContext(workManager, xaTerminator);
		s = new SimpleBootstrapContext(workManager, xaTerminator, transactionSynchronizationRegistry);

		Class<? extends WorkContext> workContextClass = null;

		s.createTimer();
		s.getWorkManager();
		s.getXATerminator();
		s.getTransactionSynchronizationRegistry();
		s.isContextSupported(workContextClass);

		/*-
		SimpleBootstrapContext(WorkManager)
		SimpleBootstrapContext(WorkManager, XATerminator)
		SimpleBootstrapContext(WorkManager, XATerminator, TransactionSynchronizationRegistry)
		createTimer()
		getTransactionSynchronizationRegistry()
		getWorkManager()
		getXATerminator()
		isContextSupported(Class<? extends WorkContext>)
		 */
	}
}