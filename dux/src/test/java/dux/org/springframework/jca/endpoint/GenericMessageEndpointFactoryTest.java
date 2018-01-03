package dux.org.springframework.jca.endpoint;

import javax.resource.spi.UnavailableException;
import javax.transaction.xa.XAResource;

import org.junit.Test;
import org.springframework.jca.endpoint.GenericMessageEndpointFactory;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(GenericMessageEndpointFactory.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class GenericMessageEndpointFactoryTest extends AbstractTest {
	@Test
	public void test() throws UnavailableException {

		XAResource xaResource = null;
		Object messageListener = null;

		GenericMessageEndpointFactory f = new GenericMessageEndpointFactory();
		f.createEndpoint(xaResource);
		f.setMessageListener(messageListener);
		/*-
		GenericMessageEndpointFactory()
		createEndpoint(XAResource)
		setMessageListener(Object)
		 */
	}
}