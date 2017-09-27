package dux.org.springframework.security.access.expression.method;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.access.expression.method.ExpressionBasedAnnotationAttributeFactory;
import org.springframework.security.access.prepost.PostInvocationAttribute;
import org.springframework.security.access.prepost.PreInvocationAttribute;

import dux.org.springframework.expression.DummyExpression;
import dux.org.springframework.expression.DummyExpressionParser;

public class ExpressionBasedAnnotationAttributeFactoryTest {
	@Test
	public void test() {
		DummyMethodSecurityExpressionHandler mseh = new DummyMethodSecurityExpressionHandler();
		DummyExpressionParser expressionParser = new DummyExpressionParser();
		expressionParser.setExpression(new DummyExpression());
		mseh.setExpressionParser(expressionParser);
		ExpressionBasedAnnotationAttributeFactory ebaaf = new ExpressionBasedAnnotationAttributeFactory(mseh);

		String preFilterAttribute = "preFilterAttribute";
		String filterObject = "filterObject";
		String preAuthorizeAttribute = "permitAll";
		PreInvocationAttribute preInvocationAttribute = ebaaf.createPreInvocationAttribute(preFilterAttribute,
				filterObject, preAuthorizeAttribute);
		Assert.assertNotNull(preInvocationAttribute);

		String postFilterAttribute = "postFilterAttribute";
		String postAuthorizeAttribute = "postAuthorizeAttribute";
		PostInvocationAttribute postInvocationAttribute = ebaaf.createPostInvocationAttribute(postFilterAttribute,
				postAuthorizeAttribute);
		Assert.assertNotNull(postInvocationAttribute);

	}
}
