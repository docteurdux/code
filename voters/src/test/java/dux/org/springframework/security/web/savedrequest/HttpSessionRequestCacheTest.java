package dux.org.springframework.security.web.savedrequest;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.PortResolver;
import org.springframework.security.web.PortResolverImpl;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

import dum.org.springframework.security.web.util.matcher.DummyRequestMatcher;
import duu.java.lang.reflect.FieldUtils;

public class HttpSessionRequestCacheTest {
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private DummyRequestMatcher requestMatcher;
	private HttpSessionRequestCache cache;
	private SavedRequest savedRequest;
	private PortResolver portResolver;
	private MockHttpServletRequest otherRequest;

	@Before
	public void before() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		requestMatcher = new DummyRequestMatcher();
		cache = new HttpSessionRequestCache();
		cache.setRequestMatcher(requestMatcher);
		portResolver = new PortResolverImpl();
		otherRequest = new MockHttpServletRequest();
		savedRequest = new DefaultSavedRequest(otherRequest, portResolver);
	}

	/**
	 * If no session, getRequest returns is null
	 */
	@Test
	public void testGetRequestNoSessionNull() {
		Assert.assertNull(cache.getRequest(request, response));
	}

	/**
	 * If some session, but request attribute not set, getRequest returns null
	 */
	@Test
	public void testGetRequestSessionNoAttributeNull() {
		request.getSession();
		Assert.assertNull(cache.getRequest(request, response));
	}

	/**
	 * If some session, and request attribute set, returns that
	 */
	@Test
	public void testGetRequestSessionNottributeSetNull() {
		request.getSession().setAttribute("SPRING_SECURITY_SAVED_REQUEST", savedRequest);
		Assert.assertEquals(savedRequest, cache.getRequest(request, response));
	}

	/**
	 * If some session, and request attribute set, returns that
	 */
	@Test
	public void testRemoveRequest() {
		request.getSession().setAttribute("SPRING_SECURITY_SAVED_REQUEST", savedRequest);
		cache.removeRequest(request, response);
		Assert.assertNull(request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST"));
	}

	@Test
	public void testSaveRequestMatchCreateSessionNotAllowedNoSession() {

		request.setQueryString("hello");

		requestMatcher.setMatches(true);

		cache.setCreateSessionAllowed(false);

		cache.saveRequest(request, response);

		Assert.assertNull(request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST"));

	}

	@Test
	public void testSaveRequestMatchCreateSessionAllowedNoSession() {

		request.setQueryString("hello");

		requestMatcher.setMatches(true);

		cache.setCreateSessionAllowed(true);

		cache.saveRequest(request, response);

		DefaultSavedRequest defaultSavedRequest = (DefaultSavedRequest) request.getSession()
				.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
		Assert.assertEquals("hello", defaultSavedRequest.getQueryString());

	}

	@Test
	public void testSaveRequestMatchCreateSessionNotAllowedNoExistingSession() {

		request.setQueryString("hello");
		request.getSession();

		requestMatcher.setMatches(true);

		cache.setCreateSessionAllowed(false);

		cache.saveRequest(request, response);

		DefaultSavedRequest defaultSavedRequest = (DefaultSavedRequest) request.getSession()
				.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
		Assert.assertEquals("hello", defaultSavedRequest.getQueryString());

	}

	@Test
	public void testSaveRequestNoMatch() {

		request.setQueryString("hello");
		requestMatcher.setMatches(false);
		cache.saveRequest(request, response);

		Assert.assertNull(request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST"));

	}

	/**
	 * If not request was saved, no mathing request can be found
	 */
	@Test
	public void testGetMatchingRequestNotSaved() {
		Assert.assertNull(cache.getMatchingRequest(request, response));
	}

	/**
	 * If saved request do not match, returned request is null
	 */
	@Test
	public void testGetMatchingRequestSavedNoMatch() {

		otherRequest.setQueryString("other");
		DefaultSavedRequest defaultSavedRequest = new DefaultSavedRequest(otherRequest, portResolver);

		request.getSession().setAttribute("SPRING_SECURITY_SAVED_REQUEST", defaultSavedRequest);

		Assert.assertNull(cache.getMatchingRequest(request, response));
	}

	/**
	 * If saved request does match, returned request is not null, and saved request
	 * is removed from session
	 */
	@Test
	public void testGetMatchingRequestSavedMatch() {

		DefaultSavedRequest defaultSavedRequest = new DefaultSavedRequest(otherRequest, portResolver);

		request.getSession().setAttribute("SPRING_SECURITY_SAVED_REQUEST", defaultSavedRequest);

		HttpServletRequest matchingRequest = cache.getMatchingRequest(request, response);
		Assert.assertEquals("org.springframework.security.web.savedrequest.SavedRequestAwareWrapper",
				matchingRequest.getClass().getName());
		Assert.assertNull(request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST"));

	}

	@Test
	public void testDefaultRequestMatcher() {
		cache = new HttpSessionRequestCache();
		Assert.assertTrue(FieldUtils.getFieldValue(HttpSessionRequestCache.class, "requestMatcher",
				cache) instanceof AnyRequestMatcher);
	}

}
