package dux.org.springframework.security.authentication.jaas;

import java.util.ArrayList;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import org.junit.Test;
import org.springframework.security.authentication.jaas.JaasAuthenticationToken;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.security.authentication.UsernamePasswordAuthenticationTokenTest;

@Topic(JaasAuthenticationToken.class)
@Related({ UsernamePasswordAuthenticationTokenTest.class })
public class JaasAuthenticationTokenTest extends AbstractTest {
	@Test
	public void test() throws LoginException {

		/*
		 * org.springframework.security.authentication.jaas.JaasAuthenticationToken
		 * extends org.springframework.security.authentication.
		 * UsernamePasswordAuthenticationToken with a
		 * javax.security.auth.login.LoginContext
		 */

		Object principal = new Object();
		Object credentials = new Object();
		/* TODO : create an actual login context */
		LoginContext loginContext = null;

		JaasAuthenticationToken token1 = new JaasAuthenticationToken(principal, credentials, loginContext);
		aeq(null, token1.getLoginContext());
		aeq(false, token1.isAuthenticated());

		JaasAuthenticationToken token2 = new JaasAuthenticationToken(principal, credentials, new ArrayList<>(),
				loginContext);
		aeq(null, token2.getLoginContext());
		aeq(true, token2.isAuthenticated());

	}
}
