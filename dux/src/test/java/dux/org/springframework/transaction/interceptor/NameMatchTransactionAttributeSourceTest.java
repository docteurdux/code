package dux.org.springframework.transaction.interceptor;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionAttribute;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(NameMatchTransactionAttributeSource.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class NameMatchTransactionAttributeSourceTest extends AbstractTest {
	@Test
	public void test() {

		String methodName = null;
		TransactionAttribute attr = null;
		Method method = null;
		Class<?> targetClass = null;
		Properties transactionAttributes = null;
		Map<String, TransactionAttribute> nameMap = null;

		NameMatchTransactionAttributeSource s = new NameMatchTransactionAttributeSource();
		s.addTransactionalMethod(methodName, attr);
		s.getTransactionAttribute(method, targetClass);
		s.setNameMap(nameMap);
		s.setProperties(transactionAttributes);
		s.toString();
	}
}