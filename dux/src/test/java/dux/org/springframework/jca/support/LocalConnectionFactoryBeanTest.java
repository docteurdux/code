package dux.org.springframework.jca.support;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ManagedConnectionFactory;

import org.junit.Test;
import org.springframework.jca.support.LocalConnectionFactoryBean;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(LocalConnectionFactoryBean.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class LocalConnectionFactoryBeanTest extends AbstractTest {
	@Test
	public void test() throws ResourceException {

		LocalConnectionFactoryBean b = new LocalConnectionFactoryBean();

		ConnectionManager connectionManager = null;
		ManagedConnectionFactory managedConnectionFactory = null;

		b.afterPropertiesSet();
		b.getObject();
		b.getObjectType();
		b.isSingleton();
		b.setConnectionManager(connectionManager);
		b.setManagedConnectionFactory(managedConnectionFactory);

		/*-
		afterPropertiesSet()
		getObject()
		getObjectType()
		isSingleton()
		setConnectionManager(ConnectionManager)
		setManagedConnectionFactory(ManagedConnectionFactory)
		 */

	}
}
