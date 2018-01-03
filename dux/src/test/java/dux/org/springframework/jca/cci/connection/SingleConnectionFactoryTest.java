package dux.org.springframework.jca.cci.connection;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.ConnectionSpec;

import org.junit.Test;
import org.springframework.jca.cci.connection.SingleConnectionFactory;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(SingleConnectionFactory.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class SingleConnectionFactoryTest extends AbstractTest {
	@Test
	public void test() throws ResourceException {

		Connection target = null;
		ConnectionFactory targetConnectionFactory = null;
		ConnectionSpec connectionSpec = null;

		SingleConnectionFactory s = new SingleConnectionFactory();
		s = new SingleConnectionFactory(target);
		s = new SingleConnectionFactory(targetConnectionFactory);
		s.afterPropertiesSet();
		s.destroy();
		s.getConnection();
		s.getConnection(connectionSpec);
		s.initConnection();
		s.resetConnection();

		/*-
		SingleConnectionFactory()
		SingleConnectionFactory(Connection)
		SingleConnectionFactory(ConnectionFactory)
		afterPropertiesSet()
		destroy()
		getConnection()
		getConnection(ConnectionSpec)
		initConnection()
		resetConnection()
		 */
	}
}
