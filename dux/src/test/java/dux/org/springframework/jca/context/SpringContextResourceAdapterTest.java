package dux.org.springframework.jca.context;

import javax.resource.ResourceException;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.endpoint.MessageEndpointFactory;

import org.junit.Test;
import org.springframework.jca.context.SpringContextResourceAdapter;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(SpringContextResourceAdapter.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class SpringContextResourceAdapterTest extends AbstractTest {
	@Test
	public void test() throws ResourceException {

		MessageEndpointFactory messageEndpointFactory = null;
		ActivationSpec activationSpec = null;
		ActivationSpec[] activationSpecs = null;
		String contextConfigLocation = null;
		BootstrapContext bootstrapContext = null;

		SpringContextResourceAdapter a = new SpringContextResourceAdapter();
		a.endpointActivation(messageEndpointFactory, activationSpec);
		a.endpointDeactivation(messageEndpointFactory, activationSpec);
		a.getXAResources(activationSpecs);
		a.hashCode();
		a.setContextConfigLocation(contextConfigLocation);
		a.start(bootstrapContext);
		a.stop();
		
		/*-
		SpringContextResourceAdapter()
		endpointActivation(MessageEndpointFactory, ActivationSpec)
		endpointDeactivation(MessageEndpointFactory, ActivationSpec)
		equals(Object)
		getXAResources(ActivationSpec[])
		hashCode()
		setContextConfigLocation(String)
		start(BootstrapContext)
		stop()
		 */

	}
}