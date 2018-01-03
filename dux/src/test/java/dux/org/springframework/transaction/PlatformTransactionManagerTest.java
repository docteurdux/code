package dux.org.springframework.transaction;

import org.junit.Test;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(PlatformTransactionManager.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class PlatformTransactionManagerTest extends AbstractTest {
	@Test
	public void test() {

		TransactionStatus status = null;
		TransactionDefinition definition = null;

		PlatformTransactionManager m = Recorder.create(PlatformTransactionManager.class).p();
		m.commit(status);
		m.getTransaction(definition);
		m.rollback(status);
	}
}