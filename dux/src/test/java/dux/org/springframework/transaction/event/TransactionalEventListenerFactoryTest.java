package dux.org.springframework.transaction.event;

import java.lang.reflect.Method;

import org.junit.Test;
import org.springframework.transaction.event.TransactionalEventListenerFactory;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(TransactionalEventListenerFactory.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class TransactionalEventListenerFactoryTest extends AbstractTest {
	@Test
	public void test() {

		String beanName = null;
		Class<?> type = null;
		Method method = null;
		int order = 0;

		TransactionalEventListenerFactory f = new TransactionalEventListenerFactory();
		f.createApplicationListener(beanName, type, method);
		f.getOrder();
		f.setOrder(order);
		f.supportsMethod(method);
	}
}