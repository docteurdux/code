package dux.org.springframework.transaction.interceptor;

import java.util.Properties;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.interceptor.TransactionAttributeSource;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(TransactionAspectSupport.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class TransactionAspectSupportTest extends AbstractTest {
	@Test
	public void test() {

		BeanFactory beanFactory = null;
		Properties transactionAttributes = null;
		TransactionAttributeSource transactionAttributeSource = null;
		TransactionAttributeSource transactionAttributeSource1 = null;
		TransactionAttributeSource transactionAttributeSource2 = null;
		PlatformTransactionManager transactionManager = null;
		String transactionManagerBeanName = null;

		TransactionAspectSupport.currentTransactionStatus();

		TransactionAspectSupport s = new TransactionAspectSupport() {
		};

		s.afterPropertiesSet();
		s.getTransactionAttributeSource();
		s.getTransactionManager();
		s.setBeanFactory(beanFactory);
		s.setTransactionAttributes(transactionAttributes);
		s.setTransactionAttributeSource(transactionAttributeSource);
		s.setTransactionAttributeSources(transactionAttributeSource1, transactionAttributeSource2);
		s.setTransactionManager(transactionManager);
		s.setTransactionManagerBeanName(transactionManagerBeanName);

	}
}