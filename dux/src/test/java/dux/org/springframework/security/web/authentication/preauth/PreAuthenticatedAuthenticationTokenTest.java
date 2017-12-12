package dux.org.springframework.security.web.authentication.preauth;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.security.authentication.AbstractAuthenticationTokenTest;

@Topic(PreAuthenticatedAuthenticationToken.class)
@Related({ AbstractAuthenticationTokenTest.class })
public class PreAuthenticatedAuthenticationTokenTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * org.springframework.security.web.authentication.preauth.
		 * PreAuthenticatedAuthenticationToken extends
		 * org.springframework.security.authentication.AbstractAuthenticationToken
		 */

		/*
		 * The token is assumed unauthenticated if the constructor without authorities
		 * is used, and authenticated if the constructor with authorities is used
		 */

		Object principal = new Object();
		Object credentials = new Object();

		PreAuthenticatedAuthenticationToken token1 = new PreAuthenticatedAuthenticationToken(principal, credentials);
		aeqr(principal, token1.getPrincipal());
		aeqr(credentials, token1.getCredentials());
		aeq(false, token1.isAuthenticated());

		PreAuthenticatedAuthenticationToken token2 = new PreAuthenticatedAuthenticationToken(principal, credentials,
				new ArrayList<>());
		aeqr(principal, token2.getPrincipal());
		aeqr(credentials, token2.getCredentials());
		aeq(true, token2.isAuthenticated());

	}
}
