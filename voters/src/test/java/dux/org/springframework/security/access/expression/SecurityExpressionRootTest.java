package dux.org.springframework.security.access.expression;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.access.expression.SecurityExpressionRoot;

import dux.org.springframework.security.core.DummyAuthentication;
import dux.org.springframework.security.core.DummyGrantedAuthority;

public class SecurityExpressionRootTest {
	@Test
	public void test() {

		DummyAuthentication authentication = new DummyAuthentication();
		authentication.addAuthority(new DummyGrantedAuthority("a"));
		authentication.addAuthority(new DummyGrantedAuthority("ROLE_b"));
		SecurityExpressionRoot ser = new SecurityExpressionRoot(authentication) {
		};

		Assert.assertTrue(ser.hasAuthority("a"));
		Assert.assertTrue(ser.hasRole("ROLE_b"));
		Assert.assertTrue(ser.hasRole("b"));
		Assert.assertTrue(ser.permitAll());
		Assert.assertFalse(ser.denyAll());

		DummyAuthenticationTrustResolver trustResolver = new DummyAuthenticationTrustResolver();
		ser.setTrustResolver(trustResolver);

		trustResolver.setAnonymous(true);
		trustResolver.setRememberMe(true);

		Assert.assertTrue(ser.isAnonymous());
		Assert.assertTrue(ser.isRememberMe());
		Assert.assertFalse(ser.isAuthenticated());
		Assert.assertFalse(ser.isFullyAuthenticated());

	}
}
