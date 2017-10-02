package dux.org.springframework.security.web.context.request.async;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.context.request.async.SecurityContextCallableProcessingInterceptor;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
import org.springframework.web.context.request.async.WebAsyncManager;

import dum.javax.servlet.DummyServlet;
import duu.javax.servlet.CountingFilter;
import duu.org.springframework.security.web.context.request.async.WebAsyncManagerUtils;

public class WebAsyncManagerIntegrationFilterTest {

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

	/**
	 * Test that a SecurityContextCallableProcessingInterceptor has been registered
	 * on a WebAsyncManager request attribute
	 */
	@Test
	public void test() throws ServletException, IOException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		WebAsyncManagerIntegrationFilter filter = new WebAsyncManagerIntegrationFilter();
		filter.doFilter(request, response, filterChain);
		Assert.assertEquals(1, countingFilter.getCount());

		String attributeName = WebAsyncManager.class.getName() + ".WEB_ASYNC_MANAGER";
		WebAsyncManager webAsyncManager = (WebAsyncManager) request.getAttribute(attributeName);
		Object interceptorKey = WebAsyncManagerUtils.getCallableInterceptorKey();
		SecurityContextCallableProcessingInterceptor interceptor = (SecurityContextCallableProcessingInterceptor) webAsyncManager
				.getCallableInterceptor(interceptorKey);
	}

}
