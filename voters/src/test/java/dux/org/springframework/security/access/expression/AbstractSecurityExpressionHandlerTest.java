package dux.org.springframework.security.access.expression;

import org.junit.Test;
import org.springframework.security.core.Authentication;

import dux.org.springframework.security.core.DummyAuthentication;

public class AbstractSecurityExpressionHandlerTest {

	@Test
	public void test() {
		DummyAbstractSecurityExpressionHandler daseh = new DummyAbstractSecurityExpressionHandler();
		Authentication authentication = new DummyAuthentication();
		String invocation = "invocation";
		daseh.createEvaluationContext(authentication, invocation);
	}
}
