package dux.org.springframework.security.web.savedrequest;

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
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;

import dum.javax.servlet.DummyServlet;
import dum.org.springframework.security.web.savedrequest.DummyRequestCache;
import duu.java.lang.reflect.FieldUtils;
import duu.javax.servlet.CountingFilter;
import duu.javax.servlet.InspectingFilter;
import duu.javax.servlet.Inspector;

public class RequestCacheAwareFilterTest {

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

	/**
	 * Uses cached request if a "matching" request is found in the request cache
	 */
	@Test
	public void testCachedRequest() throws IOException, ServletException {

		request.setAttribute("cacheUsed", false);

		MockHttpServletRequest matchingRequest = new MockHttpServletRequest();
		matchingRequest.setAttribute("cacheUsed", true);

		DummyRequestCache requestCache = new DummyRequestCache();
		requestCache.setMatchingRequest(matchingRequest);

		RequestCacheAwareFilter filter = new RequestCacheAwareFilter(requestCache);

		inspectingFilter.setInspector(new Inspector() {
			@Override
			public void inspect(ServletRequest request, ServletResponse response) {
				Assert.assertTrue(Boolean.TRUE.equals(request.getAttribute("cacheUsed")));
			}
		});

		filter.doFilter(request, response, chain);
		Assert.assertEquals(1, countingFilter.getCount());
	}

	/**
	 * Uses provided request if no "matching" request is found in the request cache
	 */
	@Test
	public void testProvidedRequest() throws IOException, ServletException {

		request.setAttribute("cacheUsed", false);

		DummyRequestCache requestCache = new DummyRequestCache();

		RequestCacheAwareFilter filter = new RequestCacheAwareFilter(requestCache);

		inspectingFilter.setInspector(new Inspector() {
			@Override
			public void inspect(ServletRequest request, ServletResponse response) {
				Assert.assertTrue(Boolean.FALSE.equals(request.getAttribute("cacheUsed")));
			}
		});

		filter.doFilter(request, response, chain);
		Assert.assertEquals(1, countingFilter.getCount());
	}

	/**
	 * Default request cache is an HttpSessionRequestCache
	 */
	@Test
	public void testDefaultRequestCache() throws IOException, ServletException {
		RequestCacheAwareFilter filter = new RequestCacheAwareFilter();

		Object requestCache = FieldUtils.getFieldValue(RequestCacheAwareFilter.class, "requestCache", filter);
		Assert.assertTrue(requestCache instanceof HttpSessionRequestCache);
	}
}
