package dux.org.springframework.security.access.intercept;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.springframework.security.access.intercept.RunAsUserToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.security.authentication.AbstractAuthenticationTokenTest;

@Topic(RunAsUserToken.class)
@Related({ AbstractAuthenticationTokenTest.class })
public class RunAsUserTokenTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * org.springframework.security.access.intercept.RunAsUserToken extends
		 * org.springframework.security.authentication.AbstractAuthenticationToken
		 */

		/*
		 * It has a key, a principal, credentials, a list of authorities which can be
		 * empty, and an original authentication class
		 */

		Object principal = "principal";
		Object credentials = "credentials";
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		Class<? extends Authentication> originalAuthentication = UsernamePasswordAuthenticationToken.class;
		RunAsUserToken token = new RunAsUserToken("key", principal, credentials, authorities, originalAuthentication);

		/* Only the key hash is retained */
		aeq("key".hashCode(), token.getKeyHash());

		/* The principal and credentials are untouched */
		aeq(principal, token.getPrincipal());
		aeq(credentials, token.getCredentials());

		/* The original authentication is untouched */
		aeq(originalAuthentication, token.getOriginalAuthentication());

		/* The token is assumed authenticated */
		aeq(true, token.isAuthenticated());

		/* toString() does something meanigful */
		aeq(true, token.toString().endsWith(
				"Principal: principal; Credentials: [PROTECTED]; Authenticated: true; Details: null; Not granted any authorities; Original Class: org.springframework.security.authentication.UsernamePasswordAuthenticationToken"));

	}
}
