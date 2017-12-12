package dux.org.springframework.security.authentication;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.RunnableWhichThrow;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.security.authentication.jaas.JaasAuthenticationTokenTest;

@Topic(UsernamePasswordAuthenticationToken.class)
@Related({ AbstractAuthenticationTokenTest.class, JaasAuthenticationTokenTest.class })
public class UsernamePasswordAuthenticationTokenTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * org.springframework.security.authentication.
		 * UsernamePasswordAuthenticationToken extends
		 * org.springframework.security.authentication.AbstractAuthenticationToken
		 */

		Object principal = new Object();
		Object credentials = new Object();

		/* The constructor that does not take authorities is unauthenticated */
		UsernamePasswordAuthenticationToken token1 = new UsernamePasswordAuthenticationToken(principal, credentials);
		aeqr(principal, token1.getPrincipal());
		aeqr(credentials, token1.getCredentials());
		aeq(false, token1.isAuthenticated());

		/*
		 * Erasing the credentials set the credentials to null, instead of the default
		 * behavior which delegate erasing to the credentials if possible
		 */
		token1.eraseCredentials();
		aeq(null, token1.getCredentials());

		/* It's not possible to change the authentication to true */
		expect(IllegalArgumentException.class,
				"Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead",
				new RunnableWhichThrow() {
					@Override
					public void run() throws Exception {
						token1.setAuthenticated(true);
					}
				});
		/* But changing to false works */
		token1.setAuthenticated(false);

		/*
		 * The constructor which takes a list of authorities produces an authenticated
		 * token
		 */
		UsernamePasswordAuthenticationToken token2 = new UsernamePasswordAuthenticationToken(principal, credentials,
				new ArrayList<>());
		aeq(true, token2.isAuthenticated());

		/* The authentication can be set to false */
		token2.setAuthenticated(false);
		aeq(false, token2.isAuthenticated());

	}
}
