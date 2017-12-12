package dux.org.springframework.security.core;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.java.security.PrincipalTest;
import dux.org.springframework.security.authentication.AbstractAuthenticationTokenTest;

@Topic(Authentication.class)
@Related({PrincipalTest.class, AbstractAuthenticationTokenTest.class})
public class AuthenticationTest extends AbstractTest {

	@Test
	public void test() {

		/*
		 * org.springframework.security.core.Authentication extends
		 * java.security.Principal with the notions of principal, credentials,
		 * authorities, details, and authentication boolean
		 */

		/*
		 * We illustrate this with org.springframework.security.authentication.
		 * UsernamePasswordAuthenticationToken
		 */

		Object principal = new Object();
		Object credentials = new Object();
		GrantedAuthority authority = Recorder.create(GrantedAuthority.class).p();
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(authority);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(principal,
				credentials, authorities);

		/*
		 * For UsernamePasswordAuthenticationToken, the principal, credentials, and
		 * authorities are passed in the constructor, and the list of authority is a
		 * little modified
		 */
		aeqr(principal, authentication.getPrincipal());
		aeqr(credentials, authentication.getCredentials());
		aeqr(authority, authentication.getAuthorities().iterator().next());

		/* The authentication is initially authenticated, but this can be changed */
		aeq(true, authentication.isAuthenticated());
		authentication.setAuthenticated(false);
		aeq(false, authentication.isAuthenticated());

		/*
		 * And the details are null. The interface does not specify how they can be set.
		 */
		aeq(null, authentication.getDetails());

		/*
		 * Also, because an authentication is a principal, it has a name, but we won't
		 * be to specific here
		 */
		aeq(true, authentication.getName() != null);

		/*
		 * One thing is weird here. Authentication is a Principal, but takes as input a
		 * "principal" which can be of any type. A principal has a name, and one
		 * strategy is to resolve the name against the principal attribute. How this is
		 * handled is documented in the actual implementations.
		 */
	}
}
