package dux.org.springframework.security.web.authentication.logout;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import dum.javax.servlet.DummyServlet;
import dum.org.springframework.security.web.authentication.logout.DummyLogoutHandler;
import dum.org.springframework.security.web.authentication.logout.DummyLogoutSuccessHandler;
import duu.javax.servlet.CountingFilter;

public class LogoutFilterTest {
	private DummyServlet servlet;
	private CountingFilter countingFilter;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private MockFilterChain filterChain;
	private DummyLogoutHandler handler;
	private DummyLogoutSuccessHandler logoutSuccessHandler;

	@Before
	public void before() {
		servlet = new DummyServlet();
		countingFilter = new CountingFilter();
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		filterChain = new MockFilterChain(servlet, countingFilter);
		handler = new DummyLogoutHandler();
		logoutSuccessHandler = new DummyLogoutSuccessHandler();
	}

	@Test
	public void testLogoutDefaultNotRequired() throws ServletException, IOException {
		LogoutFilter filter = new LogoutFilter(logoutSuccessHandler, handler);
		filter.doFilter(request, response, filterChain);
		Assert.assertEquals(1, countingFilter.getCount());
		Assert.assertEquals(0, handler.getCount());
		Assert.assertEquals(0, logoutSuccessHandler.getCount());
	}

	@Test
	public void testLogoutDefaultRequired() throws ServletException, IOException {
		request.setServletPath("/logout");
		LogoutFilter filter = new LogoutFilter(logoutSuccessHandler, handler);
		filter.doFilter(request, response, filterChain);
		Assert.assertEquals(0, countingFilter.getCount());
		Assert.assertEquals(1, handler.getCount());
		Assert.assertEquals(1, logoutSuccessHandler.getCount());
	}

	@Test
	public void testLogoutUrlRequired() throws ServletException, IOException {
		request.setServletPath("/logout");
		LogoutFilter filter = new LogoutFilter("/logout/success", handler);
		filter.doFilter(request, response, filterChain);
		Assert.assertEquals(0, countingFilter.getCount());
		Assert.assertEquals(1, handler.getCount());
		Assert.assertEquals(0, logoutSuccessHandler.getCount());

		Assert.assertEquals("/logout/success", response.getHeader("Location"));
		Assert.assertEquals(HttpServletResponse.SC_MOVED_TEMPORARILY, response.getStatus());
		Assert.assertTrue(response.isCommitted());

	}
}
