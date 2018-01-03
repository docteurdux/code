package dux.org.springframework.transaction.interceptor;

import java.lang.reflect.Method;

import org.junit.Test;
import org.springframework.transaction.interceptor.AbstractFallbackTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionAttribute;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(AbstractFallbackTransactionAttributeSource.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class AbstractFallbackTransactionAttributeSourceTest extends AbstractTest {
	@Test
	public void test() {

		Method method = null;
		Class<?> targetClass = null;

		AbstractFallbackTransactionAttributeSource s = new AbstractFallbackTransactionAttributeSource() {

			@Override
			protected TransactionAttribute findTransactionAttribute(Class<?> clazz) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			protected TransactionAttribute findTransactionAttribute(Method method) {
				// TODO Auto-generated method stub
				return null;
			}
		};

		s.getTransactionAttribute(method, targetClass);
	}
}
