package dux.org.springframework.transaction.interceptor;

import org.junit.Test;
import org.springframework.transaction.interceptor.DelegatingTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(DelegatingTransactionAttribute.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class DelegatingTransactionAttributeTest extends AbstractTest {
	@Test
	public void test() {
		TransactionAttribute b = null;
		Throwable ex = null;

		DelegatingTransactionAttribute a = new DelegatingTransactionAttribute(b) {
			private static final long serialVersionUID = 1L;
		};

		b.getQualifier();
		b.rollbackOn(ex);
	}
}