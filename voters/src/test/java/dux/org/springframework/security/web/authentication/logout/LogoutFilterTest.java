package dux.org.springframework.security.web.authentication.logout;

import java.io.IOException;

import javax.servlet.ServletException;

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

	@Before
	public void before() {
		servlet = new DummyServlet();
		countingFilter = new CountingFilter();
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		filterChain = new MockFilterChain(servlet, countingFilter);
	}

	@Test
	public void test() throws ServletException, IOException {
		LogoutSuccessHandler logoutSuccessHandler = new DummyLogoutSuccessHandler();
		LogoutHandler handler = new DummyLogoutHandler();
		LogoutFilter filter = new LogoutFilter(logoutSuccessHandler, handler);
		String logoutSuccessUrl = "/logout/success";
//		filter = new LogoutFilter(logoutSuccessUrl, handler);
		filter.doFilter(request, response, filterChain);
		Assert.assertEquals(1, countingFilter.getCount());
	}
}
