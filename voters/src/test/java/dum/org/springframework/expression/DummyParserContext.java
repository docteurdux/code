package dum.org.springframework.expression;

import org.springframework.expression.ParserContext;

public class DummyParserContext implements ParserContext {

	private boolean template;
	private String expressionPrefix;
	private String expressionSuffix;

	@Override
	public boolean isTemplate() {
		return template;
	}

	@Override
	public String getExpressionPrefix() {
		return expressionPrefix;
	}

	@Override
	public String getExpressionSuffix() {
		return expressionSuffix;
	}

	public void setTemplate(boolean template) {
		this.template = template;
	}

	public void setExpressionPrefix(String expressionPrefix) {
		this.expressionPrefix = expressionPrefix;
	}

	public void setSuffix(String expressionSuffix) {
		this.expressionSuffix = expressionSuffix;
	}

}
