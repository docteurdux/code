package dux.org.springframework.jca.context;

import javax.resource.spi.BootstrapContext;

import org.junit.Test;
import org.springframework.jca.context.ResourceAdapterApplicationContext;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ResourceAdapterApplicationContext.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class ResourceAdapterApplicationContextTest extends AbstractTest {
	@Test
	public void test() {
		BootstrapContext bootstrapContext = null;
		ResourceAdapterApplicationContext r = new ResourceAdapterApplicationContext(bootstrapContext);
	}
}