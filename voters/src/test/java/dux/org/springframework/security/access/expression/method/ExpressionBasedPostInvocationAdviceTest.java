package dux.org.springframework.security.access.expression.method;

import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;
import org.springframework.security.access.expression.method.ExpressionBasedPostInvocationAdvice;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.PostInvocationExpressionAttributeHijack;
import org.springframework.security.access.prepost.PostInvocationAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.util.SimpleMethodInvocation;

import dux.org.springframework.security.core.DummyAuthentication;

public class ExpressionBasedPostInvocationAdviceTest {

	private static class Foo {
		public void foo() {

		}
	}

	@Test
	public void test() throws NoSuchMethodException, SecurityException {
		MethodSecurityExpressionHandler mseh = new DummyMethodSecurityExpressionHandler();
		ExpressionBasedPostInvocationAdvice ebpia = new ExpressionBasedPostInvocationAdvice(mseh);

		Authentication authentication = new DummyAuthentication();
		Foo foo = new Foo();
		MethodInvocation mi = new SimpleMethodInvocation(foo, Foo.class.getMethod("foo"));
		String filterExpression = "filterExpression";
		String authorizeExpression = "authorizeExpression";
		PostInvocationAttribute postAttr = PostInvocationExpressionAttributeHijack.get(filterExpression, authorizeExpression);
		Object returnedObject = new Object();
		ebpia.after(authentication, mi, postAttr, returnedObject);

	}

}
