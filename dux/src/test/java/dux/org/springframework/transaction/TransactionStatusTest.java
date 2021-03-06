package dux.org.springframework.transaction;

import org.junit.Test;
import org.springframework.transaction.TransactionStatus;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(TransactionStatus.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class TransactionStatusTest extends AbstractTest {
	@Test
	public void test() {

		TransactionStatus s = Recorder.create(TransactionStatus.class).p();
		s.flush();
		s.hasSavepoint();
		s.isCompleted();
		s.isNewTransaction();
		s.isRollbackOnly();
		s.setRollbackOnly();

	}
}