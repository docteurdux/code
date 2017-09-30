package dux.org.springframework.security.authentication;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class UsernamePasswordAuthenticationTokenTest {
	@Test
	public void test1() {
		Object principal = new Object();
		Object credentials = new Object();
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(principal, credentials);
		Assert.assertFalse(token.isAuthenticated());
		Assert.assertEquals(principal, token.getPrincipal());
		Assert.assertEquals(credentials, token.getCredentials());
		token.eraseCredentials();
		Assert.assertEquals(principal, token.getPrincipal());
		Assert.assertNull(token.getCredentials());
	}

	@Test
	public void test2() {
		Object principal = null;
		Object credentials = null;
		Collection<GrantedAuthority> authorities = null;
		new UsernamePasswordAuthenticationToken(principal, credentials, authorities);
	}
}
