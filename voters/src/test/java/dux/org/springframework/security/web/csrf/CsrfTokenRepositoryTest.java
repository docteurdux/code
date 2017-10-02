package dux.org.springframework.security.web.csrf;

import javax.servlet.http.Cookie;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.csrf.LazyCsrfTokenRepository;

import dum.org.springframework.security.web.csrf.DummyCsrfTokenRepository;

public class CsrfTokenRepositoryTest {
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@Before
	public void before() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
	}

//	@Test
	public void test() {
		CookieCsrfTokenRepository cookieCsrfTokenRepository = new CookieCsrfTokenRepository();

		// CookieCsrfTokenRepository.withHttpOnlyFalse();

		Assert.assertEquals(null, cookieCsrfTokenRepository.getCookiePath());

		CsrfToken token = cookieCsrfTokenRepository.generateToken(request);
		Assert.assertEquals("X-XSRF-TOKEN", token.getHeaderName());
		Assert.assertEquals("_csrf", token.getParameterName());
		Assert.assertNotNull(token.getToken());
		Assert.assertNotEquals(0, token.getToken().length());

		cookieCsrfTokenRepository.saveToken(token, request, response);

		Assert.assertEquals(1, response.getCookies().length);
		Cookie cookie = response.getCookies()[0];

		Assert.assertEquals(null, cookie.getComment());
		Assert.assertEquals(null, cookie.getDomain());
		Assert.assertEquals(-1, cookie.getMaxAge());
		Assert.assertEquals("XSRF-TOKEN", cookie.getName());
		Assert.assertEquals("/", cookie.getPath());
		Assert.assertEquals(false, cookie.getSecure());
		Assert.assertEquals(token.getToken(), cookie.getValue());
		Assert.assertEquals(0, cookie.getVersion());
		Assert.assertEquals(true, cookie.isHttpOnly());

		// cookieCsrfTokenRepository.loadToken(request);
		// cookieCsrfTokenRepository.setCookieHttpOnly(cookieHttpOnly);
		// cookieCsrfTokenRepository.setCookieName(cookieName);
		// cookieCsrfTokenRepository.setHeaderName(headerName);
		// cookieCsrfTokenRepository.setParameterName(parameterName);

		HttpSessionCsrfTokenRepository httpSessionCsrfTokenRepository = new HttpSessionCsrfTokenRepository();
		CsrfTokenRepository delegate = new DummyCsrfTokenRepository();
		LazyCsrfTokenRepository lazyCsrfTokenRepository = new LazyCsrfTokenRepository(delegate);

	}

	@Test
	public void testCookieSaveToken() {
		CookieCsrfTokenRepository cookieCsrfTokenRepository = new CookieCsrfTokenRepository();
		cookieCsrfTokenRepository.saveToken(null, request, response);
		Assert.assertEquals(1, response.getCookies().length);
		Cookie cookie = response.getCookies()[0];
		Assert.assertEquals(null, cookie.getComment());
		Assert.assertEquals(null, cookie.getDomain());
		Assert.assertEquals(0, cookie.getMaxAge());
		Assert.assertEquals("XSRF-TOKEN", cookie.getName());
		Assert.assertEquals("/", cookie.getPath());
		Assert.assertEquals(false, cookie.getSecure());
		Assert.assertEquals("", cookie.getValue());
		Assert.assertEquals(0, cookie.getVersion());
		Assert.assertEquals(true, cookie.isHttpOnly());
	}
}
