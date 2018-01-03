package dux.org.springframework.jca.endpoint;

import javax.resource.ResourceException;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.endpoint.MessageEndpointFactory;

import org.junit.Test;
import org.springframework.jca.endpoint.GenericMessageEndpointManager;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(GenericMessageEndpointManager.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class GenericMessageEndpointManagerTest extends AbstractTest {
	@Test
	public void test() throws ResourceException {

		ActivationSpec activationSpec = null;
		boolean autoStartup = false;
		MessageEndpointFactory messageEndpointFactory = null;
		int phase = 0;
		ResourceAdapter resourceAdapter = null;
		Runnable callback = null;

		GenericMessageEndpointManager m = new GenericMessageEndpointManager();
		m.afterPropertiesSet();
		m.destroy();
		m.getActivationSpec();
		m.getMessageEndpointFactory();
		m.getPhase();
		m.getResourceAdapter();
		m.isAutoStartup();
		m.isRunning();
		m.setActivationSpec(activationSpec);
		m.setAutoStartup(autoStartup);
		m.setMessageEndpointFactory(messageEndpointFactory);
		m.setPhase(phase);
		m.setResourceAdapter(resourceAdapter);
		m.start();
		m.stop();
		m.stop(callback);

		/*-
		GenericMessageEndpointManager()
		afterPropertiesSet()
		destroy()
		getActivationSpec()
		getMessageEndpointFactory()
		getPhase()
		getResourceAdapter()
		isAutoStartup()
		isRunning()
		setActivationSpec(ActivationSpec)
		setAutoStartup(boolean)
		setMessageEndpointFactory(MessageEndpointFactory)
		setPhase(int)
		setResourceAdapter(ResourceAdapter)
		start()
		stop()
		stop(Runnable)
		 */
	}
}