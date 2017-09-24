package dux.org.springframework.security.authentication;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class RememberMeAuthenticationTokenTest {
	@Test
	public void test() {
		Object principal = new Object();
		Collection<? extends GrantedAuthority> authorities = null;
		RememberMeAuthenticationToken token = new RememberMeAuthenticationToken("key", principal, authorities);
		Assert.assertTrue(token.isAuthenticated());
		Assert.assertEquals(token.getCredentials(), "");
		Assert.assertEquals(token.getPrincipal(), principal);
	}
}
