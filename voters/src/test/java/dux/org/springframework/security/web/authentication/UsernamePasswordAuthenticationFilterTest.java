package dux.org.springframework.security.web.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

import dum.javax.servlet.DummyServlet;
import dum.org.springframework.security.authentication.DummyAuthenticationManager;
import dum.org.springframework.security.core.DummyAuthentication;
import dum.org.springframework.security.web.authentication.session.DummySessionAuthenticationStrategy;
import duu.javax.servlet.CountingFilter;

public class UsernamePasswordAuthenticationFilterTest {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private MockFilterChain chain;
	private DummyServlet servlet;
	private CountingFilter countingFilter;
	private DummyAuthenticationManager authenticationManager;

	@Before
	public void before() {
		authenticationManager = new DummyAuthenticationManager();
		servlet = new DummyServlet();
		countingFilter = new CountingFilter();
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		chain = new MockFilterChain(servlet, countingFilter);
	}

	@Test
	public void testAuthenticationNotRequired() throws IOException, ServletException {
		UsernamePasswordAuthenticationFilter filter = new UsernamePasswordAuthenticationFilter();
		filter.doFilter(request, response, chain);
		Assert.assertEquals(1, countingFilter.getCount());
	}

	@Test
	public void testAuthenticationRequired() throws IOException, ServletException {

		request.setMethod("POST");
		request.setServletPath("/login");

		UsernamePasswordAuthenticationFilter filter = new UsernamePasswordAuthenticationFilter();

		filter.setAuthenticationManager(authenticationManager);
		filter.doFilter(request, response, chain);
		Assert.assertEquals(0, countingFilter.getCount());
		Assert.assertEquals(1, authenticationManager.getCount());
		Assert.assertFalse(response.isCommitted());
	}

	@Test
	public void testAuthenticationRequiredNotNull() throws IOException, ServletException {

		request.setMethod("POST");
		request.setServletPath("/login");

		UsernamePasswordAuthenticationFilter filter = new UsernamePasswordAuthenticationFilter();

		SessionAuthenticationStrategy authenticationStrategy = new DummySessionAuthenticationStrategy();
		filter.setSessionAuthenticationStrategy(authenticationStrategy);

		authenticationManager.setAuthentication(new DummyAuthentication());
		filter.setAuthenticationManager(authenticationManager);
		filter.doFilter(request, response, chain);
		Assert.assertEquals(0, countingFilter.getCount());
		Assert.assertEquals(1, authenticationManager.getCount());

		Assert.assertEquals("/", response.getHeader("Location"));
		Assert.assertEquals(HttpServletResponse.SC_MOVED_TEMPORARILY, response.getStatus());
		Assert.assertTrue(response.isCommitted());
	}

	@Test
	public void testAuthenticationRequiredNotNullDoFilter() throws IOException, ServletException {

		request.setMethod("POST");
		request.setServletPath("/login");

		UsernamePasswordAuthenticationFilter filter = new UsernamePasswordAuthenticationFilter();
		filter.setContinueChainBeforeSuccessfulAuthentication(true);

		authenticationManager.setAuthentication(new DummyAuthentication());
		filter.setAuthenticationManager(authenticationManager);
		filter.doFilter(request, response, chain);
		Assert.assertEquals(1, countingFilter.getCount());
		Assert.assertEquals(1, authenticationManager.getCount());

		Assert.assertEquals("/", response.getHeader("Location"));
		Assert.assertEquals(HttpServletResponse.SC_MOVED_TEMPORARILY, response.getStatus());
		Assert.assertTrue(response.isCommitted());
	}

}
