package dux.org.springframework.security.web.csrf;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.security.web.csrf.MissingCsrfTokenException;

import dum.javax.servlet.DummyServlet;
import dum.org.springframework.security.web.access.DummyAccessDeniedHandler;
import dum.org.springframework.security.web.csrf.DummyCsrfTokenRepository;
import duu.javax.servlet.CountingFilter;

public class CsrfFilterTest {

	private static final String TOKEN_VALUE = "tokenValue";
	private static final String TOKEN_NEW_VALUE = "tokenNewValue";
	private static final String TOKEN_PARAMETER = "tokenParameter";
	private static final String TOKEN_HEADER = "tokenHeader";

	private DummyServlet servlet;
	private CountingFilter countingFilter;
	private MockFilterChain filterChain;
	private DefaultCsrfToken token;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private DummyCsrfTokenRepository csrfTokenRepository;
	private CsrfFilter filter;
	private DefaultCsrfToken newToken;
	private DummyAccessDeniedHandler accessDeniedHandler;

	@Before
	public void before() {
		servlet = new DummyServlet();
		countingFilter = new CountingFilter();
		filterChain = new MockFilterChain(servlet, countingFilter);
		token = new DefaultCsrfToken(TOKEN_HEADER, TOKEN_PARAMETER, TOKEN_VALUE);
		newToken = new DefaultCsrfToken(TOKEN_HEADER, TOKEN_PARAMETER, TOKEN_NEW_VALUE);
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		csrfTokenRepository = new DummyCsrfTokenRepository();
		filter = new CsrfFilter(csrfTokenRepository);
		accessDeniedHandler = new DummyAccessDeniedHandler();
		filter.setAccessDeniedHandler(accessDeniedHandler);
	}

	@Test
	public void testTokenHeaderPresent() throws ServletException, IOException {

		request.addHeader(TOKEN_HEADER, TOKEN_VALUE);

		csrfTokenRepository.saveToken(token, null, null);

		filter.doFilter(request, response, filterChain);

		Assert.assertEquals(1, countingFilter.getCount());

	}

	@Test
	public void testTokenParameterPresent() throws ServletException, IOException {

		request.addParameter(TOKEN_PARAMETER, TOKEN_VALUE);

		csrfTokenRepository.saveToken(token, null, null);

		filter.doFilter(request, response, filterChain);

		Assert.assertEquals(1, countingFilter.getCount());

	}

	@Test
	public void testTokenMissing() throws ServletException, IOException {

		request.addParameter(TOKEN_PARAMETER, TOKEN_NEW_VALUE);

		csrfTokenRepository.setNewToken(newToken);

		filter.doFilter(request, response, filterChain);

		Assert.assertEquals(1, countingFilter.getCount());

	}

	@Test
	public void testTokenNotMatchMissing() throws ServletException, IOException {

		request.addParameter(TOKEN_PARAMETER, TOKEN_VALUE);

		csrfTokenRepository.setNewToken(newToken);

		filter.doFilter(request, response, filterChain);

		Assert.assertEquals(0, countingFilter.getCount());
		Assert.assertTrue(accessDeniedHandler.getAccessDeniedException() instanceof MissingCsrfTokenException);
		Assert.assertEquals("Could not verify the provided CSRF token because your session was not found.",
				accessDeniedHandler.getAccessDeniedException().getMessage());

	}

	@Test
	public void testTokenNotMatchInvalid() throws ServletException, IOException {

		request.addParameter(TOKEN_PARAMETER, TOKEN_VALUE);

		csrfTokenRepository.saveToken(newToken, request, response);

		filter.doFilter(request, response, filterChain);

		Assert.assertEquals(0, countingFilter.getCount());
		Assert.assertTrue(accessDeniedHandler.getAccessDeniedException() instanceof InvalidCsrfTokenException);
		Assert.assertEquals(
				"Invalid CSRF Token 'tokenValue' was found on the request parameter 'tokenParameter' or header 'tokenHeader'.",
				accessDeniedHandler.getAccessDeniedException().getMessage());

	}

	@Test
	public void testTokenCsrfProtectionNotNeeded() throws ServletException, IOException {

		request.setMethod("GET");

		csrfTokenRepository.saveToken(token, request, response);

		filter.doFilter(request, response, filterChain);

		Assert.assertEquals(1, countingFilter.getCount());
		Assert.assertNull(accessDeniedHandler.getAccessDeniedException());

	}

}
