package dux.org.springframework.security.access.expression;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.security.core.Authentication;

import dux.org.springframework.security.core.DummyAuthentication;

public class AbstractSecurityExpressionHandlerTest {

	@Test
	public void test() {
		DummyAbstractSecurityExpressionHandler daseh = new DummyAbstractSecurityExpressionHandler();
		Authentication authentication = new DummyAuthentication();
		String invocation = "invocation";
		EvaluationContext context = daseh.createEvaluationContext(authentication, invocation);
	}
}
