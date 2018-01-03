package dux.org.springframework.jca.cci.connection;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.resource.ResourceException;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.ConnectionSpec;

import org.junit.Test;
import org.springframework.jca.cci.connection.DelegatingConnectionFactory;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(DelegatingConnectionFactory.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class DelegatingConnectionFactoryTest extends AbstractTest {
	@Test
	public void test() throws ResourceException, NamingException {
		DelegatingConnectionFactory f = new DelegatingConnectionFactory();

		ConnectionSpec connectionSpec = null;
		Reference reference = null;
		ConnectionFactory targetConnectionFactory = null;

		f.afterPropertiesSet();
		f.getConnection();
		f.getConnection(connectionSpec);
		f.getMetaData();
		f.getRecordFactory();
		f.getReference();
		f.getTargetConnectionFactory();
		f.setReference(reference);
		f.setTargetConnectionFactory(targetConnectionFactory);

		/*-
		afterPropertiesSet()
		getConnection()
		getConnection(ConnectionSpec)
		getMetaData()
		getRecordFactory()
		getReference()
		getTargetConnectionFactory()
		setReference(Reference)
		setTargetConnectionFactory(ConnectionFactory)
		 */
	}
}
