package dux.org.springframework.security.authentication;

import org.junit.Test;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.TestingAuthenticationProvider;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(AuthenticationProvider.class)
@Related({ AnonymousAuthenticationProviderTest.class, RememberMeAuthenticationProviderTest.class })
public class AuthenticationProviderTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * org.springframework.security.authentication.AuthenticationProvider defines a
		 * method supports(Class) which tells whethever a token class is supported, and
		 * an authenticate(org.springframework.security.core.Authentication) method
		 * which returns an Authentication
		 */

		/*
		 * As an an example,
		 * org.springframework.security.authentication.TestingAuthenticationProvider
		 * supports
		 * org.springframework.security.authentication.TestingAuthenticationToken and
		 * just returns what it has been given
		 */

		TestingAuthenticationProvider provider = new TestingAuthenticationProvider();
		aeq(true, provider.supports(TestingAuthenticationToken.class));

		Authentication authentication = new TestingAuthenticationToken(new Object(), new Object());
		aeqr(authentication, provider.authenticate(authentication));

	}
}
