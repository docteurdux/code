package dux.org.springframework.security.authentication;

import java.security.Principal;
import java.util.ArrayList;

import org.junit.Test;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.security.access.intercept.RunAsUserTokenTest;
import dux.org.springframework.security.core.AuthenticationTest;
import dux.org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationTokenTest;

@Topic(AbstractAuthenticationToken.class)
@Related({ AuthenticationTest.class, AnonymousAuthenticationTokenTest.class,
		PreAuthenticatedAuthenticationTokenTest.class, RememberMeAuthenticationTokenTest.class,
		RunAsUserTokenTest.class, TestingAuthenticationTokenTest.class, UsernamePasswordAuthenticationTokenTest.class })
public class AbstractAuthenticationTokenTest extends AbstractTest {

	public static class CC implements CredentialsContainer {

		private String secret;

		public CC(String secret) {
			super();
			this.secret = secret;
		}

		@Override
		public void eraseCredentials() {
			secret = null;
		}

		public String getSecret() {
			return secret;
		}

	}

	@Test
	public void test() {

		/*
		 * org.springframework.security.authentication.AbstractAuthenticationToken
		 * imlements part of org.springframework.security.core.Authentication but leaves
		 * abstract getPrincipal() and getCredentials()
		 */

		GrantedAuthority authority = Recorder.create(GrantedAuthority.class).v("toString", "authority1").p();
		ArrayList<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(authority);

		Object[] principal = new Object[] { null };
		Object[] credentials = new Object[] { null };

		AbstractAuthenticationToken token = new AbstractAuthenticationToken(authorities) {

			private static final long serialVersionUID = 1L;

			@Override
			public Object getPrincipal() {
				return principal[0];
			}

			@Override
			public Object getCredentials() {
				return credentials[0];
			}

		};

		/*
		 * The list of authorities must be specified on the constructor, and is slightly
		 * modified
		 */
		aeqr(authority, token.getAuthorities().iterator().next());

		/* principal and credentials are obviously null in this specific case */
		aeq(null, token.getPrincipal());
		aeq(null, token.getCredentials());

		/* the token is initially not authenticated, but this can be modified */
		aeq(false, token.isAuthenticated());
		token.setAuthenticated(true);
		aeq(true, token.isAuthenticated());

		/* details are null, but can be set */
		Object details = new Object();
		aeq(null, token.getDetails());
		token.setDetails(details);
		aeqr(details, token.getDetails());

		/*
		 * An interesting method is eraseCredentials(). To illustrate it, we will let
		 * principal, credentials, and details be an instances of
		 * org.springframework.security.core.CredentialsContainer, which is implemented
		 * by the class CC
		 */

		principal[0] = new CC("principal");
		credentials[0] = new CC("credentials");
		token.setDetails(new CC("details"));

		/* Let's check that we can get all the secrets */
		aeq("principal", ((CC) token.getPrincipal()).getSecret());
		aeq("credentials", ((CC) token.getCredentials()).getSecret());
		aeq("details", ((CC) token.getDetails()).getSecret());

		/* Now, call eraseCredentials() */
		token.eraseCredentials();

		/* The secrets have disappeared */
		aeq(null, ((CC) token.getPrincipal()).getSecret());
		aeq(null, ((CC) token.getCredentials()).getSecret());
		aeq(null, ((CC) token.getDetails()).getSecret());

		/* Another interesting method is getName, which delegate to the principal */

		/* If the principal is null, the name is the empty string */
		principal[0] = null;
		aeq("", token.getName());

		/* If the principal is an arbitrary object, it uses toString() */
		principal[0] = new Object() {
			@Override
			public String toString() {
				return "tostring";
			}
		};
		aeq("tostring", token.getName());

		/* If the principal is an actual object, it uses getName() on the principal */
		principal[0] = new Principal() {
			@Override
			public String getName() {
				return "name";
			}
		};
		aeq("name", token.getName());

		/*
		 * Finally, if the principal is an instance of
		 * org.springframework.security.core.userdetails.UserDetails, then it delegates
		 * to getUsername()
		 */
		principal[0] = Recorder.create(UserDetails.class).v("getUsername", "username").p();
		aeq("username", token.getName());

		/* toString() protects the credentials */
		principal[0] = "principal";
		credentials[0] = "credentials";
		token.setDetails("details");
		aeq("dux.org.springframework.security.authentication.AbstractAuthenticationTokenTest$1@21e05f54: Principal: principal; Credentials: [PROTECTED]; Authenticated: true; Details: details; Granted Authorities: authority1",
				token.toString());

		/*
		 * equality and hashCode apply to all fields and expect the objects to implement
		 * hashCode and equality properly
		 */

	}
}
