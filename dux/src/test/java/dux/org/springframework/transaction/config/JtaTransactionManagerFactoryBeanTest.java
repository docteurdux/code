package dux.org.springframework.transaction.config;

import org.junit.Test;
import org.springframework.transaction.config.JtaTransactionManagerFactoryBean;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(JtaTransactionManagerFactoryBean.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class JtaTransactionManagerFactoryBeanTest extends AbstractTest {
	@Test
	public void test() {
		JtaTransactionManagerFactoryBean b = new JtaTransactionManagerFactoryBean();
		b.getObject();
		b.getObjectType();
		b.isSingleton();
	}
}