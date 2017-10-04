package dux.org.springframework.security.web.servletapi;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;

import dum.java.lang.DummyObject;
import dum.org.springframework.security.core.DummyAuthentication;
import duu.java.lang.reflect.FieldUtils;
import dux.org.springframework.security.access.expression.DummyAuthenticationTrustResolver;
import dux.org.springframework.security.core.DummyGrantedAuthority;
import dux.org.springframework.security.core.userdetails.DummyUserDetails;

public class SecurityContextHolderAwareRequestWrapperTest {
	private MockHttpServletRequest request;
	private String rolePrefix;
	private DummyAuthenticationTrustResolver trustResolver;

	@Before
	public void before() {
		request = new MockHttpServletRequest();
		rolePrefix = "PREFIX_";
		trustResolver = new DummyAuthenticationTrustResolver();
	}

	@After
	public void after() {
		SecurityContextHolder.clearContext();
	}

	/**
	 * getRemoteUser return username if principal is UserDetails
	 */
	@Test
	public void getRemoteUserUsername() {

		trustResolver.setAnonymous(false);

		SecurityContextHolderAwareRequestWrapper wrapper = new SecurityContextHolderAwareRequestWrapper(request,
				trustResolver, rolePrefix);

		DummyUserDetails principal = new DummyUserDetails();
		principal.setUsername("username");
		DummyAuthentication authentication = new DummyAuthentication();
		authentication.setPrincipal(principal);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		Assert.assertEquals("username", wrapper.getRemoteUser());

	}

	/**
	 * getRemoteUser return null if authentication is reputed anonymous
	 */
	@Test
	public void getRemoteUserAnonymous() {

		trustResolver.setAnonymous(true);

		SecurityContextHolderAwareRequestWrapper wrapper = new SecurityContextHolderAwareRequestWrapper(request,
				trustResolver, rolePrefix);

		DummyUserDetails principal = new DummyUserDetails();
		principal.setUsername("username");
		DummyAuthentication authentication = new DummyAuthentication();
		authentication.setPrincipal(principal);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		Assert.assertNull(wrapper.getRemoteUser());

	}

	/**
	 * getRemoteUser converts principal to string if it is not UserDetails
	 */
	@Test
	public void getRemoteUserPrincipalObject() {

		trustResolver.setAnonymous(false);

		SecurityContextHolderAwareRequestWrapper wrapper = new SecurityContextHolderAwareRequestWrapper(request,
				trustResolver, rolePrefix);

		DummyObject principal = new DummyObject();
		principal.setToString("username");
		DummyAuthentication authentication = new DummyAuthentication();
		authentication.setPrincipal(principal);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		Assert.assertEquals("username", wrapper.getRemoteUser());
	}

	/**
	 * getRemoteUser return null if principal is null
	 */
	@Test
	public void getRemoteUserNoPrincipal() {

		trustResolver.setAnonymous(false);

		SecurityContextHolderAwareRequestWrapper wrapper = new SecurityContextHolderAwareRequestWrapper(request,
				trustResolver, rolePrefix);

		DummyAuthentication authentication = new DummyAuthentication();
		Assert.assertNull(authentication.getPrincipal());
		SecurityContextHolder.getContext().setAuthentication(authentication);

		Assert.assertNull(wrapper.getRemoteUser());

	}

	/**
	 * getRemoteUser return null if authentication is null
	 */
	@Test
	public void getRemoteUserNoAuthentication() {

		trustResolver.setAnonymous(false);

		SecurityContextHolderAwareRequestWrapper wrapper = new SecurityContextHolderAwareRequestWrapper(request,
				trustResolver, rolePrefix);

		Assert.assertNull(SecurityContextHolder.getContext().getAuthentication());

		Assert.assertNull(wrapper.getRemoteUser());

	}

	/**
	 * getUserPrincipal returns the authentication if the authentication has a
	 * principal and is not reputed anonymous
	 **/
	@Test
	public void getUserPrincipal() {

		trustResolver.setAnonymous(false);

		SecurityContextHolderAwareRequestWrapper wrapper = new SecurityContextHolderAwareRequestWrapper(request,
				trustResolver, rolePrefix);

		DummyAuthentication authentication = new DummyAuthentication();
		authentication.setPrincipal(new Object());
		SecurityContextHolder.getContext().setAuthentication(authentication);

		Assert.assertEquals(authentication, wrapper.getUserPrincipal());

	}

	/**
	 * getUserPrincipal returns null if the authentication is reputed anonymous
	 **/
	@Test
	public void getUserPrincipalAnonymous() {

		trustResolver.setAnonymous(true);

		SecurityContextHolderAwareRequestWrapper wrapper = new SecurityContextHolderAwareRequestWrapper(request,
				trustResolver, rolePrefix);

		DummyAuthentication authentication = new DummyAuthentication();
		authentication.setPrincipal(new Object());
		SecurityContextHolder.getContext().setAuthentication(authentication);

		Assert.assertNull(wrapper.getUserPrincipal());

	}

	/**
	 * getUserPrincipal returns null if the authentication has no principal
	 **/
	@Test
	public void getUserPrincipalNoPrincipal() {

		trustResolver.setAnonymous(false);

		SecurityContextHolderAwareRequestWrapper wrapper = new SecurityContextHolderAwareRequestWrapper(request,
				trustResolver, rolePrefix);

		DummyAuthentication authentication = new DummyAuthentication();
		SecurityContextHolder.getContext().setAuthentication(authentication);

		Assert.assertNull(wrapper.getUserPrincipal());

	}

	/**
	 * getUserPrincipal returns null if authentication is null
	 **/
	@Test
	public void getUserPrincipalNullAuthentication() {

		trustResolver.setAnonymous(false);

		SecurityContextHolderAwareRequestWrapper wrapper = new SecurityContextHolderAwareRequestWrapper(request,
				trustResolver, rolePrefix);

		Assert.assertNull(SecurityContextHolder.getContext().getAuthentication());

		Assert.assertNull(wrapper.getUserPrincipal());

	}

	/**
	 * User is in specified role if security context holder has an authenticaiton
	 * with a principal and an authority which is that role, and the trust resolver
	 * don't say the authentication is anonymous
	 */
	@Test
	public void userInRole() {

		trustResolver.setAnonymous(false);

		SecurityContextHolderAwareRequestWrapper wrequest = new SecurityContextHolderAwareRequestWrapper(request,
				trustResolver, rolePrefix);

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new DummyGrantedAuthority("PREFIX_role"));

		DummyAuthentication authentication = new DummyAuthentication();
		authentication.setAuthorities(authorities);

		Object o = new Object();
		authentication.setPrincipal(o);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		Assert.assertTrue(wrequest.isUserInRole("PREFIX_role"));
	}

	/**
	 * If the trust resolver says the authentication is anonymous, then the user is
	 * reputed to have any role
	 */
	@Test
	public void userInRoleAnonymous() {

		trustResolver.setAnonymous(true);

		SecurityContextHolderAwareRequestWrapper wrequest = new SecurityContextHolderAwareRequestWrapper(request,
				trustResolver, rolePrefix);

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new DummyGrantedAuthority("PREFIX_role"));

		DummyAuthentication authentication = new DummyAuthentication();
		authentication.setAuthorities(authorities);

		Object o = new Object();
		authentication.setPrincipal(o);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		Assert.assertFalse(wrequest.isUserInRole("PREFIX_role"));
	}

	/**
	 * If authority list is not empty but does not contains the specified role, then
	 * false
	 */
	@Test
	public void userInRoleAuthorityNotMatch() {
		SecurityContextHolderAwareRequestWrapper wrapper = new SecurityContextHolderAwareRequestWrapper(request,
				trustResolver, rolePrefix);
		DummyAuthentication authentication = new DummyAuthentication();
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new DummyGrantedAuthority("authority"));
		authentication.setAuthorities(authorities);
		Object o = new Object();
		authentication.setPrincipal(o);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		Assert.assertFalse(wrapper.isUserInRole(rolePrefix + "role"));

	}

	/**
	 * If authority list is empty, then false
	 */
	@Test
	public void userInRoleAuthorityEmpty() {
		SecurityContextHolderAwareRequestWrapper wrapper = new SecurityContextHolderAwareRequestWrapper(request,
				trustResolver, rolePrefix);
		DummyAuthentication authentication = new DummyAuthentication();
		List<GrantedAuthority> authorities = new ArrayList<>();
		authentication.setAuthorities(authorities);
		Object o = new Object();
		authentication.setPrincipal(o);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		Assert.assertFalse(wrapper.isUserInRole(rolePrefix + "role"));

	}

	/**
	 * If authority list null, then false
	 */
	@Test
	public void userInRoleNullAuthority() {
		SecurityContextHolderAwareRequestWrapper wrapper = new SecurityContextHolderAwareRequestWrapper(request,
				trustResolver, rolePrefix);
		DummyAuthentication authentication = new DummyAuthentication();
		authentication.setAuthorities(null);
		Object o = new Object();
		authentication.setPrincipal(o);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		Assert.assertFalse(wrapper.isUserInRole(rolePrefix + "role"));

	}

	/**
	 * If no principal, then false
	 */
	@Test
	public void userInRoleNoPrincipal() {

		trustResolver.setAnonymous(false);

		SecurityContextHolderAwareRequestWrapper wrequest = new SecurityContextHolderAwareRequestWrapper(request,
				trustResolver, rolePrefix);

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new DummyGrantedAuthority("PREFIX_role"));

		DummyAuthentication authentication = new DummyAuthentication();
		authentication.setAuthorities(authorities);

		Assert.assertNull(authentication.getPrincipal());

		SecurityContextHolder.getContext().setAuthentication(authentication);

		Assert.assertFalse(wrequest.isUserInRole("PREFIX_role"));
	}

	/**
	 * If no authentication, then false
	 */
	@Test
	public void userInRoleNoAuthenication() {

		trustResolver.setAnonymous(false);

		SecurityContextHolderAwareRequestWrapper wrequest = new SecurityContextHolderAwareRequestWrapper(request,
				trustResolver, rolePrefix);

		Assert.assertNull(SecurityContextHolder.getContext().getAuthentication());

		Assert.assertFalse(wrequest.isUserInRole("PREFIX_role"));
	}

	/**
	 * If role prefix is not null and role is not null and role does not start with
	 * role prefix, then prefix is added
	 */
	@Test
	public void userInRolePrefixAdded() {

		trustResolver.setAnonymous(false);

		SecurityContextHolderAwareRequestWrapper wrequest = new SecurityContextHolderAwareRequestWrapper(request,
				trustResolver, rolePrefix);

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new DummyGrantedAuthority("PREFIX_role"));

		DummyAuthentication authentication = new DummyAuthentication();
		authentication.setAuthorities(authorities);

		Object o = new Object();
		authentication.setPrincipal(o);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		Assert.assertTrue(wrequest.isUserInRole("role"));
		Assert.assertTrue(wrequest.isUserInRole("PREFIX_role"));
	}

	/**
	 * If role prefix is not null and role is not null but role starts with role
	 * prefix, then prefix is not added
	 */
	@Test
	public void userInRoleStartWithPrefix() {

		trustResolver.setAnonymous(false);

		SecurityContextHolderAwareRequestWrapper wrequest = new SecurityContextHolderAwareRequestWrapper(request,
				trustResolver, rolePrefix);

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new DummyGrantedAuthority("PREFIX_PREFIX_role"));

		DummyAuthentication authentication = new DummyAuthentication();
		authentication.setAuthorities(authorities);

		Object o = new Object();
		authentication.setPrincipal(o);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		Assert.assertFalse(wrequest.isUserInRole("PREFIX_role"));
		Assert.assertTrue(wrequest.isUserInRole("PREFIX_PREFIX_role"));
	}

	/**
	 * If role prefix is not null but role is null, then prefix is not added, but a
	 * null pointer exception may be generated
	 */
	@Test
	public void userInRoleNullRole() {

		trustResolver.setAnonymous(false);

		SecurityContextHolderAwareRequestWrapper wrequest = new SecurityContextHolderAwareRequestWrapper(request,
				trustResolver, rolePrefix);

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new DummyGrantedAuthority("PREFIX_PREFIX_role"));

		DummyAuthentication authentication = new DummyAuthentication();
		authentication.setAuthorities(authorities);

		Object o = new Object();
		authentication.setPrincipal(o);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		try {
			wrequest.isUserInRole(null);
			Assert.fail();
		} catch (NullPointerException e) {
		}

	}

	/**
	 * If role prefix is null, then rolePrefix is not added
	 */
	@Test
	public void userInRoleNullPrefix() {

		rolePrefix = null;

		trustResolver.setAnonymous(false);

		SecurityContextHolderAwareRequestWrapper wrequest = new SecurityContextHolderAwareRequestWrapper(request,
				trustResolver, rolePrefix);

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new DummyGrantedAuthority("role"));

		DummyAuthentication authentication = new DummyAuthentication();
		authentication.setAuthorities(authorities);

		Object o = new Object();
		authentication.setPrincipal(o);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		Assert.assertTrue(wrequest.isUserInRole("role"));

	}

	/**
	 * Default trust resolver is an AuthenticationTrustResolverImpl
	 */
	@Test
	public void defaultTrustResolver() {
		SecurityContextHolderAwareRequestWrapper filter = new SecurityContextHolderAwareRequestWrapper(request,
				rolePrefix);
		Assert.assertTrue(FieldUtils.getFieldValue(SecurityContextHolderAwareRequestWrapper.class, "trustResolver",
				filter) instanceof AuthenticationTrustResolverImpl);
	}

}
