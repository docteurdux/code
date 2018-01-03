package dux.org.springframework.transaction.interceptor;

import java.lang.reflect.Method;

import org.junit.Test;
import org.springframework.transaction.interceptor.CompositeTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionAttributeSource;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(CompositeTransactionAttributeSource.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class CompositeTransactionAttributeSourceTest extends AbstractTest {
	@Test
	public void test() {

		Method method = null;
		Class<?> targetClass = null;

		TransactionAttributeSource[] transactionAttributeSources = null;
		CompositeTransactionAttributeSource s = new CompositeTransactionAttributeSource(transactionAttributeSources);
		s.getTransactionAttribute(method, targetClass);
		s.getTransactionAttributeSources();
	}
}
