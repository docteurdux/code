package dux.org.springframework.transaction.interceptor;

import org.junit.Test;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(DefaultTransactionAttribute.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class DefaultTransactionAttributeTest extends AbstractTest {
	@Test
	public void test() {

		int propagationBehavior = 0;
		TransactionAttribute other = null;
		Throwable ex = null;
		String descriptor = null;
		String qualifier = null;

		DefaultTransactionAttribute a = new DefaultTransactionAttribute();
		a = new DefaultTransactionAttribute(propagationBehavior);
		a = new DefaultTransactionAttribute(other);

		a.getDescriptor();
		a.getQualifier();
		a.rollbackOn(ex);
		a.setDescriptor(descriptor);
		a.setQualifier(qualifier);

	}
}