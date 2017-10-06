package dux.org.springframework.security.web.access.expression;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

import dum.javax.servlet.DummyServlet;
import dum.org.springframework.security.core.DummyAuthentication;
import duu.javax.servlet.CountingFilter;
import dux.org.springframework.security.access.expression.DummyAuthenticationTrustResolver;

public class DefaultWebSecurityExpressionHandlerTest {
	private String defaultRolePrefix;
	private AuthenticationTrustResolver trustResolver;
	private DummyAuthentication authentication;
	private FilterInvocation filterInvocation;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private MockFilterChain chain;
	private DummyServlet servlet;
	private CountingFilter countingFilter;

	@Before
	public void before() {

		servlet = new DummyServlet();
		countingFilter = new CountingFilter();

		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		chain = new MockFilterChain(servlet, countingFilter);

		trustResolver = new DummyAuthenticationTrustResolver();
		authentication = new DummyAuthentication();
		filterInvocation = new FilterInvocation(request, response, chain);
	}

	@Test
	public void test() {
		DefaultWebSecurityExpressionHandler h = new DefaultWebSecurityExpressionHandler();
		h.setTrustResolver(trustResolver);
		h.setDefaultRolePrefix(defaultRolePrefix);
		h.createEvaluationContext(authentication, filterInvocation);
		h.getExpressionParser();
		// h.setApplicationContext(applicationContext);
		// h.setPermissionEvaluator(permissionEvaluator);
		// h.setRoleHierarchy(roleHierarchy);
	}
}
