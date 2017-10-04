package dux.org.springframework.security.web.access;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.ExceptionTranslationFilter;

import dum.javax.servlet.DummyServlet;
import dum.org.springframework.security.web.DummyAuthenticationEntryPoint;
import dum.org.springframework.security.web.access.DummyAccessDeniedHandler;
import dum.org.springframework.security.web.savedrequest.DummyRequestCache;
import duu.javax.servlet.CountingFilter;
import duu.javax.servlet.InspectingFilter;
import duu.javax.servlet.Inspector;
import dux.org.springframework.security.access.expression.DummyAuthenticationTrustResolver;

public class ExceptionTranslationFilterTest {

	private DummyAuthenticationEntryPoint authenticationEntryPoint;
	private DummyRequestCache requestCache;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private MockFilterChain chain;
	private CountingFilter countingFilter;
	private InspectingFilter inspectingFilter;
	private DummyAuthenticationTrustResolver authenticationTrustResolver;
	private ExceptionTranslationFilter filter;
	private DummyAccessDeniedHandler accessDeniedHandler;

	@Before
	public void before() {

		DummyServlet servlet = new DummyServlet();
		countingFilter = new CountingFilter();
		inspectingFilter = new InspectingFilter();
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		chain = new MockFilterChain(servlet, inspectingFilter, countingFilter);

		authenticationEntryPoint = new DummyAuthenticationEntryPoint();
		requestCache = new DummyRequestCache();
		authenticationTrustResolver = new DummyAuthenticationTrustResolver();
		accessDeniedHandler = new DummyAccessDeniedHandler();

		filter = new ExceptionTranslationFilter(authenticationEntryPoint, requestCache);
		filter.setAuthenticationTrustResolver(authenticationTrustResolver);
		filter.setAccessDeniedHandler(accessDeniedHandler);
	}

	@After
	public void after() {
		SecurityContextHolder.clearContext();
	}

	@Test
	public void testNoException() throws IOException, ServletException {
		filter.doFilter(request, response, chain);
		Assert.assertEquals(1, countingFilter.getCount());
	}

	@Test
	public void authenticationException() throws IOException, ServletException {

		inspectingFilter.setInspector(new Inspector() {
			@Override
			public void inspect(ServletRequest request, ServletResponse response) {
				throw new AuthenticationCredentialsNotFoundException("credentials not found");
			}
		});

		filter.doFilter(request, response, chain);
		Assert.assertEquals(0, countingFilter.getCount());

		Assert.assertNull(SecurityContextHolder.getContext().getAuthentication());
		// Assert.assertEquals(request, requestCache.getRequest());
		Assert.assertEquals(1, authenticationEntryPoint.getCount());

	}

	@Test
	public void accessDenied() throws IOException, ServletException {

		inspectingFilter.setInspector(new Inspector() {
			@Override
			public void inspect(ServletRequest request, ServletResponse response) {
				throw new AccessDeniedException("access denied");
			}
		});

		filter.doFilter(request, response, chain);
		Assert.assertEquals(0, countingFilter.getCount());

		Assert.assertNull(SecurityContextHolder.getContext().getAuthentication());
		Assert.assertEquals(0, authenticationEntryPoint.getCount());
		Assert.assertEquals(1, accessDeniedHandler.getCount());

	}

	@Test
	public void accessDeniedAnonymous() throws IOException, ServletException {

		authenticationTrustResolver.setAnonymous(true);

		inspectingFilter.setInspector(new Inspector() {
			@Override
			public void inspect(ServletRequest request, ServletResponse response) {
				throw new AccessDeniedException("access denied");
			}
		});

		filter.doFilter(request, response, chain);
		Assert.assertEquals(0, countingFilter.getCount());

		Assert.assertNull(SecurityContextHolder.getContext().getAuthentication());
		Assert.assertEquals(1, authenticationEntryPoint.getCount());
		Assert.assertEquals(0, accessDeniedHandler.getCount());

	}

	@Test
	public void accessDeniedRememberMe() throws IOException, ServletException {

		authenticationTrustResolver.setRememberMe(true);

		inspectingFilter.setInspector(new Inspector() {
			@Override
			public void inspect(ServletRequest request, ServletResponse response) {
				throw new AccessDeniedException("access denied");
			}
		});

		filter.doFilter(request, response, chain);
		Assert.assertEquals(0, countingFilter.getCount());

		Assert.assertNull(SecurityContextHolder.getContext().getAuthentication());
		Assert.assertEquals(1, authenticationEntryPoint.getCount());
		Assert.assertEquals(0, accessDeniedHandler.getCount());

	}

	@Test
	public void servletException() throws IOException, ServletException {

		inspectingFilter.setInspector(new Inspector() {
			@Override
			public void inspect(ServletRequest request, ServletResponse response) throws ServletException, IOException {
				throw new ServletException("servlet exception");
			}
		});

		ServletException exception = null;
		try {
			filter.doFilter(request, response, chain);
		} catch (ServletException ex) {
			exception = ex;
		}
		Assert.assertNotNull(exception);

	}
	
	@Test
	public void runtimeException() throws IOException, ServletException {
		
		inspectingFilter.setInspector(new Inspector() {
			@Override
			public void inspect(ServletRequest request, ServletResponse response) throws ServletException, IOException {
				throw new RuntimeException("runtime exception");
			}
		});
		
		RuntimeException exception = null;
		try {
			filter.doFilter(request, response, chain);
		} catch (RuntimeException ex) {
			exception = ex;
		}
		Assert.assertNotNull(exception);
		
	}
	
	@Test
	public void ioException() throws IOException, ServletException {
		
		inspectingFilter.setInspector(new Inspector() {
			@Override
			public void inspect(ServletRequest request, ServletResponse response) throws ServletException, IOException {
				throw new IOException("I/O exception");
			}
		});
		
		IOException exception = null;
		try {
			filter.doFilter(request, response, chain);
		} catch (IOException ex) {
			exception = ex;
		}
		Assert.assertNotNull(exception);
		
	}
}
