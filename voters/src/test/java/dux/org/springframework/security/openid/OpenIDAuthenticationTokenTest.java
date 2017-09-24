package dux.org.springframework.security.openid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationStatus;
import org.springframework.security.openid.OpenIDAuthenticationToken;

public class OpenIDAuthenticationTokenTest {

	@Test
	public void test1() {
		OpenIDAuthenticationStatus status = OpenIDAuthenticationStatus.SETUP_NEEDED;
		String identityUrl = "identityUrl";
		String message = "message";
		List<OpenIDAttribute> attributes = new ArrayList<>();
		OpenIDAuthenticationToken token = new OpenIDAuthenticationToken(status, identityUrl, message, attributes);
		Assert.assertFalse(token.isAuthenticated());
		Assert.assertNull(token.getCredentials());
		Assert.assertEquals(identityUrl, token.getIdentityUrl());
		Assert.assertEquals(message, token.getMessage());
		Assert.assertEquals(identityUrl, token.getPrincipal());
		Assert.assertEquals(status, token.getStatus());
		Assert.assertEquals(attributes, token.getAttributes());
	}

	@Test
	public void test2() {

		String identityUrl = "identityUrl";
		List<OpenIDAttribute> attributes = new ArrayList<>();
		Object principal = new Object();
		Collection<? extends GrantedAuthority> authorities = null;
		OpenIDAuthenticationToken token = new OpenIDAuthenticationToken(principal, authorities, identityUrl,
				attributes);
		Assert.assertTrue(token.isAuthenticated());
		Assert.assertNull(token.getCredentials());
		Assert.assertEquals(identityUrl, token.getIdentityUrl());
		Assert.assertEquals(null, token.getMessage());
		Assert.assertEquals(principal, token.getPrincipal());
		Assert.assertEquals(OpenIDAuthenticationStatus.SUCCESS, token.getStatus());
		Assert.assertEquals(attributes, token.getAttributes());
	}
}
