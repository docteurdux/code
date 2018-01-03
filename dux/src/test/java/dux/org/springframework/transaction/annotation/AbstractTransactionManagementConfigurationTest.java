package dux.org.springframework.transaction.annotation;

import org.junit.Test;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.transaction.annotation.AbstractTransactionManagementConfiguration;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(AbstractTransactionManagementConfiguration.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class AbstractTransactionManagementConfigurationTest extends AbstractTest {
	@Test
	public void test() {

		AnnotationMetadata importMetadata = null;

		AbstractTransactionManagementConfiguration c = new AbstractTransactionManagementConfiguration() {
		};
		c.setImportMetadata(importMetadata);
		c.transactionalEventListenerFactory();

	}
}
