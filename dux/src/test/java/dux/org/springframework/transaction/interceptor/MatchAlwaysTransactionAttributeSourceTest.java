package dux.org.springframework.transaction.interceptor;

import java.lang.reflect.Method;

import org.junit.Test;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionAttribute;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(MatchAlwaysTransactionAttributeSource.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class MatchAlwaysTransactionAttributeSourceTest extends AbstractTest {
	@Test
	public void test() {

		Method method = null;
		Class<?> targetClass = null;
		TransactionAttribute transactionAttribute = null;

		MatchAlwaysTransactionAttributeSource s = new MatchAlwaysTransactionAttributeSource();
		s.getTransactionAttribute(method, targetClass);
		s.setTransactionAttribute(transactionAttribute);
		s.toString();
	}
}