package dux.org.springframework.security.authentication;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.security.authentication.RememberMeAuthenticationToken;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(RememberMeAuthenticationToken.class)
@Related({ AbstractAuthenticationTokenTest.class, RememberMeAuthenticationProviderTest.class })
public class RememberMeAuthenticationTokenTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * org.springframework.security.authentication.RememberMeAuthenticationToken
		 * extends
		 * org.springframework.security.authentication.AbstractAuthenticationToken
		 */

		/*
		 * It takes a key, a principal, and a list of granted authorities which can be
		 * empty
		 */

		Object principal = new Object();
		RememberMeAuthenticationToken token = new RememberMeAuthenticationToken("key", principal, new ArrayList<>());

		/* only the hash of the key is retained */
		aeq("key".hashCode(), token.getKeyHash());

		/* the principal is untouched */
		aeqr(principal, token.getPrincipal());

		/* the credentials are always the empty string */
		aeq("", token.getCredentials());

		/* the token is assumed authenticated */
		aeq(true, token.isAuthenticated());

	}
}
