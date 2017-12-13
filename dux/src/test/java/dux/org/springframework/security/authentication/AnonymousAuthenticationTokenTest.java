package dux.org.springframework.security.authentication;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(AnonymousAuthenticationToken.class)
@Related({ AbstractAuthenticationTokenTest.class, AnonymousAuthenticationProviderTest.class })
public class AnonymousAuthenticationTokenTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * org.springframework.security.authentication.AnonymousAuthenticationToken
		 * extends
		 * org.springframework.security.authentication.AbstractAuthenticationToken
		 */

		String key = "key";
		Object principal = new Object();

		/* The list of authorities cannot be null or empty */
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("role"));

		AnonymousAuthenticationToken token = new AnonymousAuthenticationToken(key, principal, authorities);

		/* It stores only the hash of the supplied key */
		aeqr("key".hashCode(), token.getKeyHash());

		/* The principal is untouched */
		aeqr(principal, token.getPrincipal());

		/* The credentials are always the empty string */
		aeq("", token.getCredentials());

	}
}
