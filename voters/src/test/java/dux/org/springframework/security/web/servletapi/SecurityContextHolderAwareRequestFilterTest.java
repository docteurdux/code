package dux.org.springframework.security.web.servletapi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;

import dum.javax.servlet.DummyServlet;
import duu.javax.servlet.CountingFilter;
import duu.javax.servlet.InspectingFilter;
import duu.javax.servlet.Inspector;

public class SecurityContextHolderAwareRequestFilterTest {

	private DummyServlet servlet;
	private CountingFilter countingFilter;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private MockFilterChain chain;
	private InspectingFilter inspectingFilter;

	@Before
	public void before() {
		servlet = new DummyServlet();
		countingFilter = new CountingFilter();
		inspectingFilter = new InspectingFilter();
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		chain = new MockFilterChain(servlet, countingFilter, inspectingFilter);
	}

	@Test
	public void test() throws IOException, ServletException {

		inspectingFilter.setInspector(new Inspector() {
			@Override
			public void inspect(ServletRequest request, ServletResponse response) {
				Assert.assertTrue(request instanceof SecurityContextHolderAwareRequestWrapper);
			}
		});

		SecurityContextHolderAwareRequestFilter filter = new SecurityContextHolderAwareRequestFilter();
		filter.afterPropertiesSet();
		filter.doFilter(request, response, chain);
		Assert.assertEquals(1, countingFilter.getCount());
	}
}
