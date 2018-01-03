package dux.org.springframework.jca.cci.connection;

import javax.resource.cci.ConnectionFactory;

import org.junit.Test;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jca.cci.connection.CciLocalTransactionManager;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.transaction.support.ResourceTransactionManager;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(CciLocalTransactionManager.class)
@Extends({ AbstractPlatformTransactionManager.class, ResourceTransactionManager.class, InitializingBean.class })
@ExtendedBy({})
@Related({})
public class CciLocalTransactionManagerTest extends AbstractTest {
	@Test
	public void test() {

		ConnectionFactory connectionFactory = null;

		CciLocalTransactionManager c = new CciLocalTransactionManager();
		c = new CciLocalTransactionManager(connectionFactory);

		c.afterPropertiesSet();
		c.getConnectionFactory();
		c.getResourceFactory();
		c.setConnectionFactory(connectionFactory);
		/*-
		CciLocalTransactionManager()
		CciLocalTransactionManager(ConnectionFactory)
		afterPropertiesSet()
		getConnectionFactory()
		getResourceFactory()
		setConnectionFactory(ConnectionFactory)
		 */
	}
}