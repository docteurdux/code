package dux.org.springframework.security.web.authentication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import dum.javax.servlet.DummyServlet;
import dum.org.springframework.security.core.DummyAuthentication;
import duu.javax.servlet.CountingFilter;
import duu.javax.servlet.InspectingFilter;
import duu.javax.servlet.Inspector;
import dux.org.springframework.security.core.DummyGrantedAuthority;

public class AnonymousAuthenticationFilterTest {

	private String key;
	private Object principal;
	private List<GrantedAuthority> authorities;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private MockFilterChain chain;
	private CountingFilter countingFilter;
	private DummyGrantedAuthority authority;
	private DummyServlet servlet;
	private InspectingFilter inspectingFilter;

	@Before
	public void before() {

		key = "key";

		principal = new Object();

		authority = new DummyGrantedAuthority("authority");

		authorities = new ArrayList<>();
		authorities.add(authority);

		servlet = new DummyServlet();
		countingFilter = new CountingFilter();
		inspectingFilter = new InspectingFilter();

		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		chain = new MockFilterChain(servlet, countingFilter, inspectingFilter);
	}

	@After
	public void after() {
		SecurityContextHolder.clearContext();
	}

	/**
	 * When an authentication already exist, it is not changed
	 */
	@Test
	public void testExistingAuthentication() throws IOException, ServletException {

		Authentication authentication = new DummyAuthentication();
		SecurityContextHolder.getContext().setAuthentication(authentication);

		AnonymousAuthenticationFilter filter = new AnonymousAuthenticationFilter(key, principal, authorities);

		inspectingFilter.setInspector(new Inspector() {
			@Override
			public void inspect(ServletRequest request, ServletResponse response) {
				Assert.assertEquals(authentication, SecurityContextHolder.getContext().getAuthentication());
			}
		});

		filter.doFilter(request, response, chain);
		Assert.assertEquals(1, countingFilter.getCount());
	}

	/**
	 * When no authentication exist, one is created, session is not created
	 */
	@Test
	public void testNewAuthentication() throws IOException, ServletException {

		AnonymousAuthenticationFilter filter = new AnonymousAuthenticationFilter(key, principal, authorities);

		inspectingFilter.setInspector(new Inspector() {
			@Override
			public void inspect(ServletRequest request, ServletResponse response) {
				AnonymousAuthenticationToken authentication = (AnonymousAuthenticationToken) SecurityContextHolder
						.getContext().getAuthentication();
				Assert.assertEquals(key.hashCode(), authentication.getKeyHash());
				Assert.assertEquals(principal, authentication.getPrincipal());
				Assert.assertEquals("authority", authentication.getAuthorities().iterator().next().getAuthority());
				WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
				Assert.assertNull(details.getSessionId());
				Assert.assertNull(((HttpServletRequest) request).getSession(false));

			}
		});

		filter.doFilter(request, response, chain);
		Assert.assertEquals(1, countingFilter.getCount());
	}

	/**
	 * When no authentication exist, one is created, session is not created
	 */
	@Test
	public void testNewAuthenticationWithExistingSession() throws IOException, ServletException {

		request.getSession();

		AnonymousAuthenticationFilter filter = new AnonymousAuthenticationFilter(key, principal, authorities);

		inspectingFilter.setInspector(new Inspector() {
			@Override
			public void inspect(ServletRequest request, ServletResponse response) {
				AnonymousAuthenticationToken authentication = (AnonymousAuthenticationToken) SecurityContextHolder
						.getContext().getAuthentication();
				Assert.assertEquals(key.hashCode(), authentication.getKeyHash());
				Assert.assertEquals(principal, authentication.getPrincipal());
				Assert.assertEquals("authority", authentication.getAuthorities().iterator().next().getAuthority());
				WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
				Assert.assertEquals(((HttpServletRequest) request).getSession(false).getId(), details.getSessionId());

			}
		});

		filter.doFilter(request, response, chain);
		Assert.assertEquals(1, countingFilter.getCount());
	}
}
