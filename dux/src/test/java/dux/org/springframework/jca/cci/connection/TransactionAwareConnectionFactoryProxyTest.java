package dux.org.springframework.jca.cci.connection;

import javax.resource.ResourceException;
import javax.resource.cci.ConnectionFactory;

import org.junit.Test;
import org.springframework.jca.cci.connection.TransactionAwareConnectionFactoryProxy;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(TransactionAwareConnectionFactoryProxy.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class TransactionAwareConnectionFactoryProxyTest extends AbstractTest {
	@Test
	public void test() throws ResourceException {

		ConnectionFactory targetConnectionFactory = null;

		TransactionAwareConnectionFactoryProxy p = new TransactionAwareConnectionFactoryProxy();
		p = new TransactionAwareConnectionFactoryProxy(targetConnectionFactory);
		p.getConnection();

	}
}
