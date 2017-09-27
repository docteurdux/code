package dux.org.springframework.security.authentication;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import dux.org.springframework.security.core.DummyGrantedAuthority;

public class AuthenticationTrustResolverImplTest {
	@Test
	public void test() {
		AuthenticationTrustResolverImpl atri = new AuthenticationTrustResolverImpl();

		ArrayList<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new DummyGrantedAuthority("authority"));
		
		Authentication authentication = new AnonymousAuthenticationToken("key", new Object(), authorities);
		Assert.assertTrue(atri.isAnonymous(authentication));
		
		authentication = new RememberMeAuthenticationToken("key", new Object(), new ArrayList<>());
		Assert.assertTrue(atri.isRememberMe(authentication));
	}
}
