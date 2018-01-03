package dux.org.springframework.jca.support;

import javax.resource.ResourceException;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.XATerminator;
import javax.resource.spi.work.WorkManager;

import org.junit.Test;
import org.springframework.jca.support.ResourceAdapterFactoryBean;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ResourceAdapterFactoryBean.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class ResourceAdapterFactoryBeanTest extends AbstractTest {
	@Test
	public void test() throws ResourceException {

		ResourceAdapterFactoryBean b = new ResourceAdapterFactoryBean();

		BootstrapContext bootstrapContext = null;
		ResourceAdapter resourceAdapter = null;
		Class<? extends ResourceAdapter> resourceAdapterClass = null;
		WorkManager workManager = null;
		XATerminator xaTerminator = null;

		b.afterPropertiesSet();
		b.destroy();
		b.getObject();
		b.getObjectType();
		b.isSingleton();
		b.setBootstrapContext(bootstrapContext);
		b.setResourceAdapter(resourceAdapter);
		b.setResourceAdapterClass(resourceAdapterClass);
		b.setWorkManager(workManager);
		b.setXaTerminator(xaTerminator);

		/*-
		afterPropertiesSet()
		destroy()
		getObject()
		getObjectType()
		isSingleton()
		setBootstrapContext(BootstrapContext)
		setResourceAdapter(ResourceAdapter)
		setResourceAdapterClass(Class<? extends ResourceAdapter>)
		setWorkManager(WorkManager)
		setXaTerminator(XATerminator)
		 */
	}
}
