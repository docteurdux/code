package dux.org.springframework.transaction.interceptor;

import org.junit.Test;
import org.springframework.transaction.interceptor.NoRollbackRuleAttribute;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(NoRollbackRuleAttribute.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class NoRollbackRuleAttributeTest extends AbstractTest {
	@Test
	public void test() {

		Class<?> clazz = null;
		String exceptionName = null;
		NoRollbackRuleAttribute a = new NoRollbackRuleAttribute(clazz);
		a = new NoRollbackRuleAttribute(exceptionName);
		a.toString();

	}
}