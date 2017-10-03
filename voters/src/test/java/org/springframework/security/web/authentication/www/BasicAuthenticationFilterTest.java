package org.springframework.security.web.authentication.www;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;

import org.apache.xerces.impl.dv.util.Base64;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import dum.javax.servlet.DummyServlet;
import dum.org.springframework.security.authentication.DummyAuthenticationManager;
import dum.org.springframework.security.core.DummyAuthentication;
import dum.org.springframework.security.web.DummyAuthenticationEntryPoint;
import dum.org.springframework.security.web.authentication.DummyRememberMeServices;
import duu.javax.servlet.CountingFilter;
import dux.org.springframework.security.core.DummyGrantedAuthority;
import dux.org.springframework.security.core.userdetails.DummyUserDetails;

public class BasicAuthenticationFilterTest {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private MockFilterChain filterChain;
	private DummyServlet servlet;
	private CountingFilter countingFilter;
	private DummyAuthenticationManager authenticationManager;
	private DummyRememberMeServices rememberMeServices;
	private DummyAuthenticationEntryPoint authenticationEntryPoint;
	private SecurityContext context;

	@Before
	public void before() {
		context = SecurityContextHolder.getContext();
		servlet = new DummyServlet();
		countingFilter = new CountingFilter();
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		filterChain = new MockFilterChain(servlet, countingFilter);
		authenticationManager = new DummyAuthenticationManager();
		rememberMeServices = new DummyRememberMeServices();
		authenticationEntryPoint = new DummyAuthenticationEntryPoint();

	}

	@After
	public void after() {
		SecurityContextHolder.clearContext();
	}

	/**
	 * When no authorization header is given, filter is passthrough
	 */
	@Test
	public void testNoAuthorizationHeaderPassthrough() throws ServletException, IOException {

		BasicAuthenticationFilter filter = new BasicAuthenticationFilter(authenticationManager);
		filter.setRememberMeServices(rememberMeServices);
		Assert.assertTrue(filter.isIgnoreFailure());

		filter.doFilter(request, response, filterChain);

		assertRequestProceeded();
		assertAuthenticationNotAttempted();

	}

	/**
	 * When another authorization mechanism is used, filter is passthrough
	 */
	@Test
	public void testOtherAuthorizationHeaderPassthrough() throws ServletException, IOException {

		request.addHeader("Authorization", "Other:frobnicate");

		BasicAuthenticationFilter filter = new BasicAuthenticationFilter(authenticationManager);
		filter.setRememberMeServices(rememberMeServices);
		Assert.assertTrue(filter.isIgnoreFailure());

		filter.doFilter(request, response, filterChain);

		assertRequestProceeded();
		assertAuthenticationNotAttempted();

	}

	/**
	 * When authentication manager returns a null authentication, this is
	 * interpreted as success
	 */
	@Test
	public void testSuccessfulAuthenticationWhenAuthenticationManagerReturnsNull()
			throws ServletException, IOException {

		String base64 = Base64.encode("x:y".getBytes());
		request.addHeader("Authorization", "Basic " + base64);

		BasicAuthenticationFilter filter = new BasicAuthenticationFilter(authenticationManager);
		filter.setRememberMeServices(rememberMeServices);
		Assert.assertTrue(filter.isIgnoreFailure());

		filter.doFilter(request, response, filterChain);

		assertRequestProceeded();
		assertAuthenticationSuccess();
	}

	/**
	 * Failing requires an exception to be thrown by the authentication manager ;
	 * also, authentication failures still allow the request to proceed
	 */
	@Test
	public void testUnsuccessfulAuthenticationWhenAuthenticationManagerThrows() throws ServletException, IOException {

		String base64 = Base64.encode("x:y".getBytes());
		request.addHeader("Authorization", "Basic " + base64);

		authenticationManager.setException(new BadCredentialsException("bad credentials"));

		BasicAuthenticationFilter filter = new BasicAuthenticationFilter(authenticationManager);
		filter.setRememberMeServices(rememberMeServices);
		Assert.assertTrue(filter.isIgnoreFailure());

		filter.doFilter(request, response, filterChain);

		assertRequestProceeded();
		assertAuthenticationFailure();
	}

	/**
	 * To prevent the request from proceeding, use an authentication entry point
	 */
	@Test
	public void testIgnoreFailureFalseAuthenticationFails() throws ServletException, IOException {

		String base64 = Base64.encode("x:y".getBytes());
		request.addHeader("Authorization", "Basic " + base64);

		authenticationManager.setException(new BadCredentialsException("bad credentials"));

		BasicAuthenticationFilter filter = new BasicAuthenticationFilter(authenticationManager,
				authenticationEntryPoint);
		filter.setRememberMeServices(rememberMeServices);
		Assert.assertFalse(filter.isIgnoreFailure());

		filter.doFilter(request, response, filterChain);

		assertRequestNotProceeded();
		assertAuthenticationFailure();

		Assert.assertEquals(1, authenticationEntryPoint.getCount());
	}

	/**
	 * Entry point is not invoked on authentication success
	 */
	@Test
	public void testIgnoreFailureFalseAuthenticationSuccess() throws ServletException, IOException {

		String base64 = Base64.encode("x:y".getBytes());
		request.addHeader("Authorization", "Basic " + base64);

		BasicAuthenticationFilter filter = new BasicAuthenticationFilter(authenticationManager,
				authenticationEntryPoint);
		filter.setRememberMeServices(rememberMeServices);
		Assert.assertFalse(filter.isIgnoreFailure());

		filter.doFilter(request, response, filterChain);

		assertRequestProceeded();
		assertAuthenticationSuccess();

		Assert.assertEquals(0, authenticationEntryPoint.getCount());
	}

	/**
	 * Authorization is not required if security context already contains an unknown
	 * authentication token
	 */
	@Test
	public void testAuthenticationNotRequiredForUnknownExistingToken() throws ServletException, IOException {

		DummyAuthentication authentication = new DummyAuthentication();
		authentication.setAuthenticated(true);
		context.setAuthentication(authentication);
		SecurityContextHolder.setContext(context);

		String base64 = Base64.encode("x:y".getBytes());
		request.addHeader("Authorization", "Basic " + base64);

		BasicAuthenticationFilter filter = new BasicAuthenticationFilter(authenticationManager);
		filter.setRememberMeServices(rememberMeServices);
		Assert.assertTrue(filter.isIgnoreFailure());

		filter.doFilter(request, response, filterChain);

		assertRequestProceeded();
		assertAuthenticationNotAttempted();

	}

	/**
	 * Authorization is required if security context contains a user/password token
	 * in which user name does not match
	 */
	@Test
	public void testAuthenticationRequiredUserNotMatch() throws ServletException, IOException {

		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new DummyGrantedAuthority("AUTHORITY"));
		DummyUserDetails details = new DummyUserDetails("z");
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(details,
				new Object(), authorities);
		context.setAuthentication(authentication);
		SecurityContextHolder.setContext(context);

		String base64 = Base64.encode("x:y".getBytes());
		request.addHeader("Authorization", "Basic " + base64);

		BasicAuthenticationFilter filter = new BasicAuthenticationFilter(authenticationManager);
		filter.setRememberMeServices(rememberMeServices);
		Assert.assertTrue(filter.isIgnoreFailure());

		filter.doFilter(request, response, filterChain);

		assertRequestProceeded();
		assertAuthenticationAttempted();
	}

	/**
	 * Authorization is not required if security context contains a user/password
	 * token in which user name match
	 */
	@Test
	public void testAuthenticationRequiredUserMatch() throws ServletException, IOException {

		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new DummyGrantedAuthority("AUTHORITY"));
		DummyUserDetails details = new DummyUserDetails("x");
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(details,
				new Object(), authorities);
		context.setAuthentication(authentication);
		SecurityContextHolder.setContext(context);

		String base64 = Base64.encode("x:y".getBytes());
		request.addHeader("Authorization", "Basic " + base64);

		BasicAuthenticationFilter filter = new BasicAuthenticationFilter(authenticationManager);
		filter.setRememberMeServices(rememberMeServices);
		Assert.assertTrue(filter.isIgnoreFailure());

		filter.doFilter(request, response, filterChain);

		assertRequestProceeded();
		assertAuthenticationNotAttempted();

	}

	/**
	 * Authorization is required if security context contains an anonymous token in
	 * which user name match
	 */
	@Test
	public void testAuthenticationRequiredIfAnonymous() throws ServletException, IOException {

		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new DummyGrantedAuthority("AUTHORITY"));
		AnonymousAuthenticationToken authentication = new AnonymousAuthenticationToken("key", new Object(),
				authorities);
		authentication.setAuthenticated(true);
		context.setAuthentication(authentication);
		SecurityContextHolder.setContext(context);

		String base64 = Base64.encode("x:y".getBytes());
		request.addHeader("Authorization", "Basic " + base64);

		BasicAuthenticationFilter filter = new BasicAuthenticationFilter(authenticationManager);
		filter.setRememberMeServices(rememberMeServices);
		Assert.assertTrue(filter.isIgnoreFailure());

		filter.doFilter(request, response, filterChain);

		assertRequestProceeded();
		assertAuthenticationAttempted();
	}

	/**
	 * Authorization is required if security context contains a token which is not
	 * authenticated
	 */
	@Test
	public void testAuthenticationRequiredIfExistingAuthenticationNotAuthenticated()
			throws ServletException, IOException {

		DummyAuthentication authentication = new DummyAuthentication();
		authentication.setAuthenticated(false);
		context.setAuthentication(authentication);
		SecurityContextHolder.setContext(context);

		String base64 = Base64.encode("x:y".getBytes());
		request.addHeader("Authorization", "Basic " + base64);

		BasicAuthenticationFilter filter = new BasicAuthenticationFilter(authenticationManager);
		filter.setRememberMeServices(rememberMeServices);
		Assert.assertTrue(filter.isIgnoreFailure());

		filter.doFilter(request, response, filterChain);

		assertRequestProceeded();
		assertAuthenticationAttempted();
	}

	private void assertAuthenticationAttempted() {
		Assert.assertTrue(rememberMeServices.getSuccessCount() == 1 || rememberMeServices.getFailureCount() == 1);
	}

	private void assertAuthenticationNotAttempted() {
		Assert.assertFalse(rememberMeServices.getSuccessCount() == 1 || rememberMeServices.getFailureCount() == 1);
	}

	private void assertAuthenticationSuccess() {
		Assert.assertTrue(rememberMeServices.getSuccessCount() == 1);
	}

	private void assertAuthenticationFailure() {
		Assert.assertTrue(rememberMeServices.getFailureCount() == 1);
	}

	private void assertRequestProceeded() {
		Assert.assertTrue(countingFilter.getCount() == 1);
	}

	private void assertRequestNotProceeded() {
		Assert.assertTrue(countingFilter.getCount() == 0);
	}

}
