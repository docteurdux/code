package dux.org.springframework.transaction.annotation;

import org.junit.Test;
import org.springframework.transaction.annotation.TransactionManagementConfigurationSelector;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(TransactionManagementConfigurationSelector.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class TransactionManagementConfigurationSelectorTest extends AbstractTest {
	@Test
	public void test() {
		TransactionManagementConfigurationSelector t = new TransactionManagementConfigurationSelector();
	}
}