package dux.org.springframework.security.authentication;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import dux.org.springframework.security.core.DummyGrantedAuthority;

public class AnonymousAuthenticationTokenTest {

	@Test
	public void test() {
		String key = "key";
		Object principal = new Object();
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new DummyGrantedAuthority("authority"));
		AnonymousAuthenticationToken token = new AnonymousAuthenticationToken(key, principal, authorities);
		Assert.assertEquals(token.getCredentials(), "");
	}
}
