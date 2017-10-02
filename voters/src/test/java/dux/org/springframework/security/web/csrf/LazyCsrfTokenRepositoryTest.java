package dux.org.springframework.security.web.csrf;

import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.security.web.csrf.LazyCsrfTokenRepository;

import dum.org.springframework.security.web.csrf.DummyCsrfTokenRepository;
import dum.org.springframework.security.web.csrf.DummyCsrfTokenRepository.MethodName;

public class LazyCsrfTokenRepositoryTest {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@Before
	public void before() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();

	}

	/**
	 * Generated token is saved when accessed
	 */
	@Test
	public void testGenerateToken() {

		CsrfToken newToken = new DefaultCsrfToken("h", "p", "newTokenValue");

		DummyCsrfTokenRepository delegate = new DummyCsrfTokenRepository();
		delegate.setNewToken(newToken);

		LazyCsrfTokenRepository repository = new LazyCsrfTokenRepository(delegate);

		request.setAttribute(HttpServletResponse.class.getName(), response);

		CsrfToken token = repository.generateToken(request);
		Assert.assertEquals(1, delegate.getCounter(MethodName.GENERATE_TOKEN));
		Assert.assertEquals(0, delegate.getCounter(MethodName.SAVE_TOKEN));
		Assert.assertEquals(0, delegate.getCounter(MethodName.LOAD_TOKEN));
		Assert.assertEquals("newTokenValue", token.getToken());
		Assert.assertEquals(1, delegate.getCounter(MethodName.GENERATE_TOKEN));
		// token has been saved upon access
		Assert.assertEquals(1, delegate.getCounter(MethodName.SAVE_TOKEN));
		Assert.assertEquals(0, delegate.getCounter(MethodName.LOAD_TOKEN));

	}

	/**
	 * Saving a null token clears the token
	 */
	@Test
	public void testSaveNull() {

		DummyCsrfTokenRepository delegate = new DummyCsrfTokenRepository();
		CsrfToken dummyToken = new DefaultCsrfToken("h", "p", "dummy");
		delegate.setToken(dummyToken);

		LazyCsrfTokenRepository repository = new LazyCsrfTokenRepository(delegate);

		// request.setAttribute(HttpServletResponse.class.getName(), response);

		Assert.assertNotNull(delegate.getToken());
		repository.saveToken(null, request, response);
		Assert.assertNull(delegate.getToken());

	}

	/**
	 * Saving a non null token does nothing, generating a new token then accessing
	 * its value is required to have the token saved
	 */
	@Test
	public void testSaveNotNull() {

		DummyCsrfTokenRepository delegate = new DummyCsrfTokenRepository();
		CsrfToken dummyToken = new DefaultCsrfToken("h", "p", "dummy");
		delegate.setToken(dummyToken);

		LazyCsrfTokenRepository repository = new LazyCsrfTokenRepository(delegate);

		Assert.assertEquals("dummy", delegate.getToken().getToken());
		CsrfToken token = new DefaultCsrfToken("h", "p", "token");
		repository.saveToken(token, request, response);
		Assert.assertEquals("dummy", delegate.getToken().getToken());

		// set the token that will be "generated"
		delegate.setNewToken(token);

		// set the response attribute
		request.setAttribute(HttpServletResponse.class.getName(), response);

		// ask for token generation
		CsrfToken newToken = repository.generateToken(request);

		// access the token, triggering the generation
		newToken.getToken();

		// check that token has been generated
		Assert.assertEquals("token", delegate.getToken().getToken());

	}

	/**
	 * Loading just load the token from the delegate
	 */
	@Test
	public void testLoadToken() {

		DummyCsrfTokenRepository delegate = new DummyCsrfTokenRepository();
		CsrfToken dummyToken = new DefaultCsrfToken("h", "p", "dummy");
		delegate.setToken(dummyToken);

		LazyCsrfTokenRepository repository = new LazyCsrfTokenRepository(delegate);

		CsrfToken loadedToken = repository.loadToken(request);
		Assert.assertEquals("dummy", loadedToken.getToken());

	}

	/**
	 * response attribute is required on request, because token generation only
	 * expects a request, but token saving requires a response too
	 */
	@Test
	public void testResponseAttributeRequired() {

		DummyCsrfTokenRepository delegate = new DummyCsrfTokenRepository();
		LazyCsrfTokenRepository repository = new LazyCsrfTokenRepository(delegate);
		String message = null;
		try {
			repository.generateToken(request);
		} catch (IllegalArgumentException ex) {
			message = ex.getMessage();
		}
		Assert.assertEquals(
				"The HttpServletRequest attribute must contain an HttpServletResponse for the attribute javax.servlet.http.HttpServletResponse",
				message);
	}

}
