package dux.org.springframework.security.web.session;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.session.SessionManagementFilter;

import dum.javax.servlet.DummyServlet;
import dum.org.springframework.security.core.DummyAuthentication;
import dum.org.springframework.security.web.authentication.DummyAuthenticationFailureHandler;
import dum.org.springframework.security.web.authentication.session.DummySessionAuthenticationStrategy;
import dum.org.springframework.security.web.context.DummySecurityContextRepository;
import duu.javax.servlet.CountingFilter;
import dux.org.springframework.security.access.expression.DummyAuthenticationTrustResolver;

public class SessionManagementFilterTest {

	private DummySecurityContextRepository securityContextRepository;
	private DummySessionAuthenticationStrategy sessionStrategy;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private MockFilterChain chain;
	private CountingFilter countingFilter;
	private DummyServlet servlet;
	private DummyAuthenticationTrustResolver trustResolver;
	private DummyAuthenticationFailureHandler failureHandler;

	@Before
	public void before() {
		securityContextRepository = new DummySecurityContextRepository();
		sessionStrategy = new DummySessionAuthenticationStrategy();
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		countingFilter = new CountingFilter();
		servlet = new DummyServlet();
		chain = new MockFilterChain(servlet, countingFilter);
		trustResolver = new DummyAuthenticationTrustResolver();
		failureHandler = new DummyAuthenticationFailureHandler();
	}

	@After
	public void after() {
		SecurityContextHolder.clearContext();
	}

	@Test
	public void test() throws IOException, ServletException {

		DummyAuthentication authentication = new DummyAuthentication();
		SecurityContextHolder.getContext().setAuthentication(authentication);

		trustResolver.setAnonymous(false);

		SessionManagementFilter filter = new SessionManagementFilter(securityContextRepository, sessionStrategy);
		filter.setTrustResolver(trustResolver);
		filter.setAuthenticationFailureHandler(failureHandler);
		filter.doFilter(request, response, chain);
		Assert.assertEquals(1, countingFilter.getCount());

		Assert.assertNotNull(securityContextRepository.containsContext(null));
		Assert.assertEquals(1, sessionStrategy.getCount());
		Assert.assertEquals(0, failureHandler.getCount());

	}
}
