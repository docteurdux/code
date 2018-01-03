package dux.org.springframework.transaction.interceptor;

import java.util.List;

import org.junit.Test;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(RuleBasedTransactionAttribute.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class RuleBasedTransactionAttributeTest extends AbstractTest {
	@Test
	public void test() {

		int propagationBehavior = 0;
		List<RollbackRuleAttribute> rollbackRules = null;
		RuleBasedTransactionAttribute other = null;
		Throwable ex = null;

		RuleBasedTransactionAttribute a = new RuleBasedTransactionAttribute();
		a = new RuleBasedTransactionAttribute(propagationBehavior, rollbackRules);
		a = new RuleBasedTransactionAttribute(other);
		a.getRollbackRules();
		a.rollbackOn(ex);
		a.setRollbackRules(rollbackRules);
		a.toString();
	}
}