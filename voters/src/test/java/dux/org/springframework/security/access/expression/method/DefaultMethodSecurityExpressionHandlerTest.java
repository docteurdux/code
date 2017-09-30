package dux.org.springframework.security.access.expression.method;

import java.util.ArrayList;

import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.core.Authentication;
import org.springframework.security.util.SimpleMethodInvocation;

import dux.org.springframework.expression.DummyExpression;
import dux.org.springframework.security.core.DummyAuthentication;

public class DefaultMethodSecurityExpressionHandlerTest {

	private static class Foo {
		@SuppressWarnings("unused")
		public void foo() {
		}
	}

	@Test
	public void test() throws NoSuchMethodException, SecurityException {
		DefaultMethodSecurityExpressionHandler dmseh = new DefaultMethodSecurityExpressionHandler();
		Authentication authentication = new DummyAuthentication();
		Foo foo = new Foo();
		MethodInvocation invocation = new SimpleMethodInvocation(foo, Foo.class.getMethod("foo"));
		EvaluationContext ec = dmseh.createEvaluationContext(authentication, invocation);

		DummyExpression expression = new DummyExpression();
		ArrayList<Object> objects = new ArrayList<Object>();
		objects.add(new Object());
		expression.setValue(Boolean.TRUE);
		dmseh.filter(objects, expression, ec);
		dmseh.filter(new Object[] { Boolean.TRUE }, expression, ec);
	}
}
