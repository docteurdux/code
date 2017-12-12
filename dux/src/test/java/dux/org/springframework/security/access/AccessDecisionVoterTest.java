package dux.org.springframework.security.access;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(AccessDecisionVoter.class)
public class AccessDecisionVoterTest extends AbstractTest {
	@Test
	public void test() {

		/*-
		supports(Class<?>)
		supports(ConfigAttribute)
		vote(Authentication, S, Collection<ConfigAttribute>)
		 */

		Object principal = new Object();
		Object credentials = new Object();
		String authorities = "authorities";
		Authentication authentication = new TestingAuthenticationToken(principal, credentials, authorities);
		Object object = new Object();
		Collection<ConfigAttribute> attributes = new ArrayList<>();

		AuthenticatedVoter voter = new AuthenticatedVoter();
		voter.vote(authentication, object, attributes);

	}
}
