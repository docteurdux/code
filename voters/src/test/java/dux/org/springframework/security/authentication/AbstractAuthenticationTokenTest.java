package dux.org.springframework.security.authentication;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import dux.java.security.DummyPrincipal;
import dux.org.springframework.security.core.userdetails.DummyUserDetails;

public class AbstractAuthenticationTokenTest {

	@Test
	public void test1() {

		Collection<? extends GrantedAuthority> authorities = new ArrayList<>();
		DummyAbstractAuthenticationToken token = new DummyAbstractAuthenticationToken(authorities);

		Assert.assertEquals("", token.getName());

		token.setPrincipal("name");
		Assert.assertEquals("name", token.getName());

		token.setPrincipal(new DummyPrincipal("principal"));
		Assert.assertEquals("principal", token.getName());

		token.setPrincipal(new DummyUserDetails("userDetail"));
		Assert.assertEquals("userDetail", token.getName());

		Assert.assertFalse(token.isAuthenticated());
		Assert.assertNull(token.getDetails());

		token.eraseCredentials();
	}

	@Test
	public void test2() {
		AbstractAuthenticationToken token = new DummyAbstractAuthenticationToken(null);
		Assert.assertEquals(AuthorityUtils.NO_AUTHORITIES, token.getAuthorities());
	}

	@Test
	public void test3() {

		Collection<? extends GrantedAuthority> authorities = new ArrayList<>();
		DummyAbstractAuthenticationToken token = new DummyAbstractAuthenticationToken(authorities);

		DummyCredentialsContainer credentialsContainer = new DummyCredentialsContainer("credentials");
		token.setCredentials(credentialsContainer);

		DummyCredentialsContainer principalCredentialsContainer = new DummyCredentialsContainer("principal");
		token.setDetails(principalCredentialsContainer);

		DummyCredentialsContainer detailsCredentialsContainer = new DummyCredentialsContainer("details");
		token.setDetails(detailsCredentialsContainer);

		Assert.assertEquals("credentials", credentialsContainer.getSecret());
		Assert.assertEquals("principal", principalCredentialsContainer.getSecret());
		Assert.assertEquals("details", detailsCredentialsContainer.getSecret());

		token.eraseCredentials();

		Assert.assertNull(credentialsContainer.getSecret());
		Assert.assertNull(principalCredentialsContainer.getSecret());
		Assert.assertNull(detailsCredentialsContainer.getSecret());
	}

}
