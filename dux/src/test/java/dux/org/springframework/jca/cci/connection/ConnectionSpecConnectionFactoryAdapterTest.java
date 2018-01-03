package dux.org.springframework.jca.cci.connection;

import javax.resource.ResourceException;
import javax.resource.cci.ConnectionSpec;

import org.junit.Test;
import org.springframework.jca.cci.connection.ConnectionSpecConnectionFactoryAdapter;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ConnectionSpecConnectionFactoryAdapter.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class ConnectionSpecConnectionFactoryAdapterTest extends AbstractTest {
	@Test
	public void test() throws ResourceException {
		ConnectionSpecConnectionFactoryAdapter a = new ConnectionSpecConnectionFactoryAdapter();

		ConnectionSpec connectionSpec = null;

		a.getConnection();
		a.removeConnectionSpecFromCurrentThread();
		a.setConnectionSpec(connectionSpec);
		a.setConnectionSpecForCurrentThread(connectionSpec);

		/*-
		getConnection()
		removeConnectionSpecFromCurrentThread()
		setConnectionSpec(ConnectionSpec)
		setConnectionSpecForCurrentThread(ConnectionSpec)
		 */

	}
}