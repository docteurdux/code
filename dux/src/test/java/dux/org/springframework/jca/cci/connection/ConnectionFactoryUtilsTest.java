package dux.org.springframework.jca.cci.connection;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.ConnectionSpec;

import org.junit.Test;
import org.springframework.jca.cci.connection.ConnectionFactoryUtils;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ConnectionFactoryUtils.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class ConnectionFactoryUtilsTest extends AbstractTest {
	@Test
	public void test() throws ResourceException {
		
		ConnectionFactory cf = null;
		Connection con = null;
		ConnectionSpec spec = null;
		
		ConnectionFactoryUtils.doGetConnection(cf);
		ConnectionFactoryUtils.doReleaseConnection(con, cf);
		ConnectionFactoryUtils.getConnection(cf);
		ConnectionFactoryUtils.getConnection(cf, spec);
		ConnectionFactoryUtils.isConnectionTransactional(con, cf);
		ConnectionFactoryUtils.releaseConnection(con, cf);
		
		/*-
		doGetConnection(ConnectionFactory)
		doReleaseConnection(Connection, ConnectionFactory)
		getConnection(ConnectionFactory)
		getConnection(ConnectionFactory, ConnectionSpec)
		isConnectionTransactional(Connection, ConnectionFactory)
		releaseConnection(Connection, ConnectionFactory)
		 */
	}
}
