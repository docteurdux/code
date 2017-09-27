package dux.org.springframework.security.access.expression.method;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.core.Authentication;

public class DummyMethodSecurityExpressionHandler implements MethodSecurityExpressionHandler {

	private ExpressionParser expressionParser;
	private EvaluationContext evaluationContext;
	private Object object;

	@Override
	public ExpressionParser getExpressionParser() {
		return expressionParser;
	}

	@Override
	public EvaluationContext createEvaluationContext(Authentication authentication, MethodInvocation invocation) {
		return evaluationContext;
	}

	@Override
	public Object filter(Object filterTarget, Expression filterExpression, EvaluationContext ctx) {
		return object;
	}

	@Override
	public void setReturnObject(Object returnObject, EvaluationContext ctx) {

	}

	public void setExpressionParser(ExpressionParser expressionParser) {
		this.expressionParser = expressionParser;
	}

	public void setEvaluationContext(EvaluationContext evaluationContext) {
		this.evaluationContext = evaluationContext;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}
