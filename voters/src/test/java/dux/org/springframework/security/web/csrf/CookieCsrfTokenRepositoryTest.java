package dux.org.springframework.security.web.csrf;

import javax.servlet.http.Cookie;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.DefaultCsrfToken;

public class CookieCsrfTokenRepositoryTest {
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@Before
	public void before() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
	}

	/**
	 * When token is null, a 0 XSRF-TOKEN cookie is placed with empty value,
	 * instructing browser to delete it immediately
	 */
	@Test
	public void testCookieSaveNullToken() {
		CookieCsrfTokenRepository repository = new CookieCsrfTokenRepository();
		repository.saveToken(null, request, response);

		Cookie cookie = response.getCookie("XSRF-TOKEN");

		Assert.assertEquals("XSRF-TOKEN", cookie.getName());
		Assert.assertEquals("", cookie.getValue());
		Assert.assertEquals(0, cookie.getMaxAge());
	}

	/**
	 * When token is not null, a XSRF-TOKEN cookie is placed with the token's value;
	 * that cookie will be deleted when the browser exits
	 */
	@Test
	public void testCookieSaveNonNullToken() {

		CsrfToken token = new DefaultCsrfToken("h", "p", "tokenValue");

		CookieCsrfTokenRepository repository = new CookieCsrfTokenRepository();
		repository.saveToken(token, request, response);

		Cookie cookie = response.getCookie("XSRF-TOKEN");

		Assert.assertEquals("XSRF-TOKEN", cookie.getName());
		Assert.assertEquals("tokenValue", cookie.getValue());
		Assert.assertEquals(-1, cookie.getMaxAge());
	}

	/**
	 * Generated cookie is http only
	 */
	@Test
	public void testCookieSaveHttpOnly() {

		CsrfToken token = new DefaultCsrfToken("h", "p", "tokenValue");

		CookieCsrfTokenRepository repository = new CookieCsrfTokenRepository();
		repository.saveToken(token, request, response);

		Cookie cookie = response.getCookie("XSRF-TOKEN");

		Assert.assertTrue(cookie.isHttpOnly());
	}

	/**
	 * Generated cookie not http only if instructed so
	 */
	@Test
	public void testCookieSaveNotHttpOnly() {

		CsrfToken token = new DefaultCsrfToken("h", "p", "tokenValue");

		CookieCsrfTokenRepository repository = new CookieCsrfTokenRepository();
		repository.setCookieHttpOnly(false);
		repository.saveToken(token, request, response);

		Cookie cookie = response.getCookie("XSRF-TOKEN");

		Assert.assertFalse(cookie.isHttpOnly());
	}

	/**
	 * Generated cookie not http only with static method
	 */
	@Test
	public void testCookieSaveNotHttpOnlyStatic() {

		CsrfToken token = new DefaultCsrfToken("h", "p", "tokenValue");

		CookieCsrfTokenRepository repository = CookieCsrfTokenRepository.withHttpOnlyFalse();
		repository.saveToken(token, request, response);

		Cookie cookie = response.getCookie("XSRF-TOKEN");

		Assert.assertFalse(cookie.isHttpOnly());
	}

	/**
	 * Generated token uses default header name and parameter name
	 */
	@Test
	public void testCookieGenerate() {
		CookieCsrfTokenRepository repository = new CookieCsrfTokenRepository();
		CsrfToken token = repository.generateToken(request);
		Assert.assertEquals("X-XSRF-TOKEN", token.getHeaderName());
		Assert.assertEquals("_csrf", token.getParameterName());

	}

	/**
	 * Returns null when csrf cookie is not set
	 */
	@Test
	public void testCookieLoadNull() {
		CookieCsrfTokenRepository repository = new CookieCsrfTokenRepository();
		CsrfToken token = repository.loadToken(request);
		Assert.assertNull(token);
	}

	/**
	 * Returns token when csrf cookie is set
	 */
	@Test
	public void testCookieLoadNotNull() {
		CookieCsrfTokenRepository repository = new CookieCsrfTokenRepository();
		Cookie cookie = new Cookie("XSRF-TOKEN", "tokenValue");
		request.setCookies(cookie);
		CsrfToken token = repository.loadToken(request);
		Assert.assertEquals("tokenValue", token.getToken());
	}

}
