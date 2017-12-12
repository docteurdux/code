package dux.org.springframework.security.authentication;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(TestingAuthenticationToken.class)
@Related(AbstractAuthenticationTokenTest.class)
public class TestingAuthenticationTokenTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * dux.org.springframework.security.authentication.
		 * TestingAuthenticationTokenTest extends
		 * org.springframework.security.authentication.AbstractAuthenticationToken
		 */

		/*
		 * It simply define getPrincipal() and getCredentials() and provide a variety of
		 * constructors for specifying authorities
		 */

		Object principal = new Object();
		Object credentials = new Object();
		List<GrantedAuthority> authorities = new ArrayList<>();
		TestingAuthenticationToken token1 = new TestingAuthenticationToken(principal, credentials, authorities);

		aeqr(principal, token1.getPrincipal());
		aeqr(credentials, token1.getCredentials());
		aeq(false, token1.isAuthenticated());

		/* Other constructors */

		TestingAuthenticationToken token2 = new TestingAuthenticationToken(principal, credentials, "role1", "role2");
		Iterator<GrantedAuthority> iterator2 = token2.getAuthorities().iterator();
		aeq("role1", iterator2.next().getAuthority());
		aeq("role2", iterator2.next().getAuthority());

		TestingAuthenticationToken token3 = new TestingAuthenticationToken(principal, credentials);
		aeq(false, token3.getAuthorities().iterator().hasNext());

	}
}
