package dux.org.springframework.transaction.annotation;

import org.junit.Test;
import org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ProxyTransactionManagementConfiguration.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class ProxyTransactionManagementConfigurationTest extends AbstractTest {
	@Test
	public void test() {
		ProxyTransactionManagementConfiguration c = new ProxyTransactionManagementConfiguration();
		c.transactionAdvisor();
		c.transactionAttributeSource();
		c.transactionInterceptor();
	}
}