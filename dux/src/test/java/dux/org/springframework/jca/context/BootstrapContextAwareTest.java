package dux.org.springframework.jca.context;

import javax.resource.spi.BootstrapContext;

import org.junit.Test;
import org.springframework.jca.context.BootstrapContextAware;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(BootstrapContextAware.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class BootstrapContextAwareTest extends AbstractTest {
	@Test
	public void test() {
		BootstrapContext bootstrapContext = null;
		BootstrapContextAware a = Recorder.create(BootstrapContextAware.class).p();
		a.setBootstrapContext(bootstrapContext);
	}
}
