package dux.org.springframework.expression.spel.standard;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.OperatorOverloader;
import org.springframework.expression.PropertyAccessor;
import org.springframework.expression.TypeComparator;
import org.springframework.expression.TypedValue;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.ExpressionState;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.ast.IntLiteral;
import org.springframework.expression.spel.ast.Literal;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.expression.spel.support.StandardOperatorOverloader;
import org.springframework.expression.spel.support.StandardTypeComparator;

import com.github.docteurdux.test.DuxTest;

import dum.org.springframework.expression.DummyEvaluationContext;
import dum.org.springframework.expression.DummyParserContext;
import dum.org.springframework.expression.DummyPropertyAccessor;

public class SpelExpressionParserTest extends DuxTest {

	@SuppressWarnings("unused")
	private TemplateParserContext templateParserContext;
	private DummyParserContext parserContext;
	private SpelParserConfiguration configuration;
	private String expressionString;

	@Before
	public void before() {
		templateParserContext = new TemplateParserContext();
		parserContext = new DummyParserContext();
		configuration = new SpelParserConfiguration();
	}

	@Test
	public void testNoTemplate1() {

		expressionString = "1";

		SpelExpressionParser parser = new SpelExpressionParser(configuration);
		Expression exp = parser.parseExpression(expressionString, parserContext);
		atrue(exp instanceof SpelExpression);
		Object value = exp.getValue();
		atrue(value instanceof Integer);
		aeq(1, value);

	}

	@Test
	public void testNoTemplate11() {

		expressionString = "11";

		SpelExpressionParser parser = new SpelExpressionParser(configuration);
		Expression exp = parser.parseExpression(expressionString, parserContext);
		atrue(exp instanceof SpelExpression);
		Object value = exp.getValue();
		atrue(value instanceof Integer);
		aeq(11, value);

	}

	@Test
	public void testNoTemplate1n() {

		expressionString = "1 ";

		SpelExpressionParser parser = new SpelExpressionParser(configuration);
		Expression exp = parser.parseExpression(expressionString, parserContext);
		atrue(exp instanceof SpelExpression);
		Object value = exp.getValue();
		atrue(value instanceof Integer);
		aeq(1, value);

	}

	@Test
	public void testNoTemplate1p2() {

		expressionString = "1+2";

		SpelExpressionParser parser = new SpelExpressionParser(configuration);
		Expression exp = parser.parseExpression(expressionString, parserContext);
		atrue(exp instanceof SpelExpression);
		Object value = exp.getValue();
		atrue(value instanceof Integer);
		aeq(3, value);

	}

	@Test
	public void testNoTemplate2t2() {

		expressionString = "2*2";

		SpelExpressionParser parser = new SpelExpressionParser(configuration);
		Expression exp = parser.parseExpression(expressionString, parserContext);
		atrue(exp instanceof SpelExpression);
		Object value = exp.getValue();
		atrue(value instanceof Integer);
		aeq(4, value);

	}

	@Test
	public void testNoTemplate0eq0then1else2() {

		expressionString = "0==0?1:2";

		SpelExpressionParser parser = new SpelExpressionParser(configuration);
		Expression exp = parser.parseExpression(expressionString, parserContext);
		atrue(exp instanceof SpelExpression);
		Object value = exp.getValue();
		atrue(value instanceof Integer);
		aeq(1, value);

	}

	@Test
	public void testNoTemplate0elvis2() {

		expressionString = "0?:2";

		SpelExpressionParser parser = new SpelExpressionParser(configuration);
		Expression exp = parser.parseExpression(expressionString, parserContext);
		atrue(exp instanceof SpelExpression);
		Object value = exp.getValue();
		atrue(value instanceof Integer);
		aeq(0, value);

	}

	@Test
	public void testNoTemplateaeq2() {

		expressionString = "a=2";

		SpelExpressionParser parser = new SpelExpressionParser(configuration);
		Expression exp = parser.parseExpression(expressionString, parserContext);
		atrue(exp instanceof SpelExpression);
		DummyEvaluationContext evaluationContext = new DummyEvaluationContext();
		TypedValue rootObject = new TypedValue(new Object());
		evaluationContext.setRootObject(rootObject);
		List<PropertyAccessor> propertyAccessors = new ArrayList<>();
		DummyPropertyAccessor propertyAccessor = new DummyPropertyAccessor();
		propertyAccessor.setCanWrite(true);
		propertyAccessors.add(propertyAccessor);
		evaluationContext.setPropertyAccessors(propertyAccessors);
		Object value = exp.getValue(evaluationContext);
		atrue(value instanceof Integer);
		aeq(2, value);
		aeq(2, propertyAccessor.getNewValue());

	}

//	@Test
//	public void testNoTemplateaeq2stEc() {
//
//		expressionString = "a=2";
//
//		SpelExpressionParser parser = new SpelExpressionParser(configuration);
//		Expression exp = parser.parseExpression(expressionString, parserContext);
//		atrue(exp instanceof SpelExpression);
//		EvaluationContext evaluationContext = new StandardEvaluationContext();
//		TypedValue rootObject = new TypedValue(new Object());
//		evaluationContext.setRootObject(rootObject);
//		List<PropertyAccessor> propertyAccessors = new ArrayList<>();
//		DummyPropertyAccessor propertyAccessor = new DummyPropertyAccessor();
//		propertyAccessor.setCanWrite(true);
//		propertyAccessors.add(propertyAccessor);
//		evaluationContext.setPropertyAccessors(propertyAccessors);
//		Object value = exp.getValue(evaluationContext);
//		atrue(value instanceof Integer);
//		aeq(2, value);
//		aeq(2, propertyAccessor.getNewValue());
//
//	}

	@SuppressWarnings("unused")
	private void classesOfInterest() {
		foo(SpelExpressionParser.class);
		foo(SpelExpression.class);
		foo("org.springframework.expression.spel.standard.InternalSpelExpressionParser.InternalSpelExpressionParser");
		foo("org.springframework.expression.spel.standard.Tokenizer");
		foo("org.springframework.expression.spel.standard.Token");
		foo("org.springframework.expression.spel.ast.SpelNodeImpl");
		foo(ExpressionState.class);
		foo(StandardEvaluationContext.class);
		foo(TypeComparator.class);
		foo(StandardTypeComparator.class);
		foo(OperatorOverloader.class);
		foo(StandardOperatorOverloader.class);
		foo(TypedValue.class);
		foo(Literal.class);
		foo(IntLiteral.class);
		foo(SpelCompilerMode.class);
	}
}
