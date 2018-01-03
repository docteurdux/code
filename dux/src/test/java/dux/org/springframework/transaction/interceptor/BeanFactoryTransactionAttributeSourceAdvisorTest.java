package dux.org.springframework.transaction.interceptor;

import org.junit.Test;
import org.springframework.aop.ClassFilter;
import org.springframework.transaction.interceptor.BeanFactoryTransactionAttributeSourceAdvisor;
import org.springframework.transaction.interceptor.TransactionAttributeSource;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(BeanFactoryTransactionAttributeSourceAdvisor.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class BeanFactoryTransactionAttributeSourceAdvisorTest extends AbstractTest {
	@Test
	public void test() {

		ClassFilter classFilter = null;
		TransactionAttributeSource transactionAttributeSource = null;

		BeanFactoryTransactionAttributeSourceAdvisor a = new BeanFactoryTransactionAttributeSourceAdvisor();
		a.getPointcut();
		a.setClassFilter(classFilter);
		a.setTransactionAttributeSource(transactionAttributeSource);

	}
}