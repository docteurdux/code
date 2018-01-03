package dux.org.springframework.transaction.interceptor;

import org.junit.Test;
import org.springframework.transaction.interceptor.TransactionAttribute;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(TransactionAttribute.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class TransactionAttributeTest extends AbstractTest {
	@Test
	public void test() {

		Throwable ex = null;

		TransactionAttribute a = Recorder.create(TransactionAttribute.class).p();
		a.getQualifier();
		a.rollbackOn(ex);

	}
}