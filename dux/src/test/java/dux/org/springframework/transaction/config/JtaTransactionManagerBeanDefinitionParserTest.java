package dux.org.springframework.transaction.config;

import org.junit.Test;
import org.springframework.transaction.config.JtaTransactionManagerBeanDefinitionParser;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(JtaTransactionManagerBeanDefinitionParser.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class JtaTransactionManagerBeanDefinitionParserTest extends AbstractTest {
	@Test
	public void test() {
		JtaTransactionManagerBeanDefinitionParser p = new JtaTransactionManagerBeanDefinitionParser();
	}
}