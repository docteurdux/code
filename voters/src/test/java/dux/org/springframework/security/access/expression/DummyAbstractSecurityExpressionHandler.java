package dux.org.springframework.security.access.expression;

import org.springframework.security.access.expression.AbstractSecurityExpressionHandler;
import org.springframework.security.access.expression.SecurityExpressionOperations;
import org.springframework.security.core.Authentication;

public class DummyAbstractSecurityExpressionHandler extends AbstractSecurityExpressionHandler<String> {

	public DummyAbstractSecurityExpressionHandler() {
	}

	@Override
	protected SecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication,
			String invocation) {
		return null;
	}

}
