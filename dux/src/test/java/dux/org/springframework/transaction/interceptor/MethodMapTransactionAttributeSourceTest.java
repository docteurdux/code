package dux.org.springframework.transaction.interceptor;

import java.lang.reflect.Method;
import java.util.Map;

import org.junit.Test;
import org.springframework.transaction.interceptor.MethodMapTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionAttribute;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(MethodMapTransactionAttributeSource.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class MethodMapTransactionAttributeSourceTest extends AbstractTest {
	@Test
	public void test() {

		Method method = null;
		TransactionAttribute attr = null;
		String name = null;
		Class<?> clazz = null;
		String mappedName = null;
		Class<?> targetClass = null;
		ClassLoader beanClassLoader = null;
		Map<String, TransactionAttribute> methodMap = null;

		MethodMapTransactionAttributeSource s = new MethodMapTransactionAttributeSource();
		s.addTransactionalMethod(method, attr);
		s.addTransactionalMethod(name, attr);
		s.addTransactionalMethod(clazz, mappedName, attr);
		s.afterPropertiesSet();
		s.getTransactionAttribute(method, targetClass);
		s.setBeanClassLoader(beanClassLoader);
		s.setMethodMap(methodMap);
		s.toString();

	}
}