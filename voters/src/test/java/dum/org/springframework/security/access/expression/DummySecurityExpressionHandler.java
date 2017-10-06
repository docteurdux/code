package dum.org.springframework.security.access.expression;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.core.Authentication;

public class DummySecurityExpressionHandler<T> implements SecurityExpressionHandler<T> {

	private ExpressionParser expressionParser;

	@Override
	public ExpressionParser getExpressionParser() {
		return expressionParser;
	}

	public void setExpressionParser(ExpressionParser expressionParser) {
		this.expressionParser = expressionParser;
	}

	@Override
	public EvaluationContext createEvaluationContext(Authentication authentication, T invocation) {
		// TODO Auto-generated method stub
		return null;
	}

}
