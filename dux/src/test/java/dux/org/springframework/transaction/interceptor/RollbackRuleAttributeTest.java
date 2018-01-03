package dux.org.springframework.transaction.interceptor;

import org.junit.Test;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(RollbackRuleAttribute.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class RollbackRuleAttributeTest extends AbstractTest {
	@Test
	public void test() {

		Class<?> clazz = null;
		Throwable ex = null;
		String exceptionName = null;

		RollbackRuleAttribute a = new RollbackRuleAttribute(clazz);
		a = new RollbackRuleAttribute(exceptionName);
		a.getDepth(ex);
		a.getExceptionName();
		a.toString();

	}
}
