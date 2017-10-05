package dux.org.springframework.security.web.access.intercept;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import dum.javax.servlet.DummyServlet;
import dum.org.springframework.security.web.access.intercept.DummyFilterInvocationSecurityMetadataSource;
import duu.javax.servlet.CountingFilter;

public class FilterSecurityInterceptorTest {
	
	private DummyServlet servlet;
	private CountingFilter countingFilter;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private MockFilterChain chain;
	private FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;

	@Before
	public void before() {
		servlet = new DummyServlet();
		countingFilter = new CountingFilter();
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		chain = new MockFilterChain(servlet, countingFilter);
		filterInvocationSecurityMetadataSource = new DummyFilterInvocationSecurityMetadataSource();
	}

	@Test
	public void test() throws IOException, ServletException {
		FilterSecurityInterceptor filter = new FilterSecurityInterceptor();
		filter.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
		filter.doFilter(request, response, chain);
		Assert.assertEquals(1, countingFilter.getCount());
	}
}
