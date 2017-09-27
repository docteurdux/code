package dux.org.springframework.expression;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParseException;
import org.springframework.expression.ParserContext;

public class DummyExpressionParser implements ExpressionParser {

	private Expression expression;

	@Override
	public Expression parseExpression(String expressionString) throws ParseException {
		return expression;
	}

	@Override
	public Expression parseExpression(String expressionString, ParserContext context) throws ParseException {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

}
