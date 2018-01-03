package dux.org.springframework.jca.endpoint;

import java.lang.reflect.Method;

import javax.resource.spi.UnavailableException;
import javax.transaction.xa.XAResource;

import org.junit.Test;
import org.springframework.jca.endpoint.AbstractMessageEndpointFactory;
import org.springframework.transaction.jta.TransactionFactory;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(AbstractMessageEndpointFactory.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class AbstractMessageEndpointFactoryTest extends AbstractTest {
	@Test
	public void test() throws UnavailableException, NoSuchMethodException {

		AbstractMessageEndpointFactory f = new AbstractMessageEndpointFactory() {
			@Override
			protected AbstractMessageEndpoint createEndpointInternal() throws UnavailableException {
				return null;
			}
		};

		XAResource xaResource = null;
		long timeout = 0;
		Method method = null;
		String beanName = null;
		TransactionFactory transactionFactory = null;
		Object transactionManager = null;
		String transactionName = null;
		int transactionTimeout = 0;

		f.createEndpoint(xaResource);
		f.createEndpoint(xaResource, timeout);
		f.getActivationName();
		f.getEndpointClass();
		f.isDeliveryTransacted(method);
		f.setBeanName(beanName);
		f.setTransactionFactory(transactionFactory);
		f.setTransactionManager(transactionManager);
		f.setTransactionName(transactionName);
		f.setTransactionTimeout(transactionTimeout);

		/*-
		AbstractMessageEndpointFactory()
		createEndpoint(XAResource)
		createEndpoint(XAResource, long)
		getActivationName()
		getEndpointClass()
		isDeliveryTransacted(Method)
		setBeanName(String)
		setTransactionFactory(TransactionFactory)
		setTransactionManager(Object)
		setTransactionName(String)
		setTransactionTimeout(int)
		 */
	}
}