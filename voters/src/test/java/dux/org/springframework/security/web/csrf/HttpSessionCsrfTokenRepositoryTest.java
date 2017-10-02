package dux.org.springframework.security.web.csrf;

import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

public class HttpSessionCsrfTokenRepositoryTest {

	private static final String CSRF_SESSION_ATTR_NAME = "org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository.CSRF_TOKEN";
	
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@Before
	public void before() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
	}

	/**
	 * Generate token has expected header and parameter names
	 */
	@Test
	public void testGenerate() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();

		CsrfToken token = repository.generateToken(request);
		Assert.assertEquals("X-CSRF-TOKEN", token.getHeaderName());
		Assert.assertEquals("_csrf", token.getParameterName());
		Assert.assertNotNull(token.getToken());
		Assert.assertTrue(token.getToken().length() > 0);

		// CsrfTokenRepository delegate = new DummyCsrfTokenRepository();
		// LazyCsrfTokenRepository lazyCsrfTokenRepository = new
		// LazyCsrfTokenRepository(delegate);
	}

	/**
	 * Saving null token cause attribute to be removed from session
	 */
	@Test
	public void testSaveNull() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		HttpSession session = request.getSession();
		session.setAttribute(CSRF_SESSION_ATTR_NAME, "something");
		repository.saveToken(null, request, response);
		Assert.assertNull(session.getAttribute(CSRF_SESSION_ATTR_NAME));
	}

	/**
	 * Saving null token does not create new session
	 */
	@Test
	public void testSaveNullNoSession() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.saveToken(null, request, response);
		Assert.assertNull(request.getSession(false));
	}

	/**
	 * Saving non null token cause session attribute to be set
	 */
	@Test
	public void testSaveNonNull() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		CsrfToken token = new DefaultCsrfToken("h", "p", "tokenValue");
		repository.saveToken(token, request, response);

		HttpSession session = request.getSession(false);
		CsrfToken sessionToken = (CsrfToken) session.getAttribute(CSRF_SESSION_ATTR_NAME);

		Assert.assertEquals("tokenValue", sessionToken.getToken());
	}

	@Test
	public void testLoadNullWhenSessionNull() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		CsrfToken token = repository.loadToken(request);
		Assert.assertNull(token);
	}

	@Test
	public void testLoadNullSessionNotNull() {
		request.getSession();
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		CsrfToken token = repository.loadToken(request);
		Assert.assertNull(token);
	}

	@Test
	public void testLoadNotNull() {
		HttpSession session = request.getSession();
		CsrfToken token = new DefaultCsrfToken("h", "p", "tokenValue");
		session.setAttribute(CSRF_SESSION_ATTR_NAME, token);
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		CsrfToken loadedToken = repository.loadToken(request);
		Assert.assertEquals("tokenValue", loadedToken.getToken());
	}
}
