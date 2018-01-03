package dux.org.springframework.transaction.annotation;

import org.junit.Test;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(TransactionManagementConfigurer.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class TransactionManagementConfigurerTest extends AbstractTest {
	@Test
	public void test() {

		TransactionManagementConfigurer c = Recorder.create(TransactionManagementConfigurer.class).p();
		c.annotationDrivenTransactionManager();

	}
}