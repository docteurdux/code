package dux.org.springframework.security.authentication;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.RememberMeAuthenticationProvider;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.DUXMessageSource;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.RunnableWhichThrow;
import com.github.docteurdux.test.Topic;

@Topic(RememberMeAuthenticationProvider.class)
@Related({ AuthenticationProviderTest.class, RememberMeAuthenticationTokenTest.class,
		AnonymousAuthenticationProviderTest.class })
public class RememberMeAuthenticationProviderTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * org.springframework.security.authentication.RememberMeAuthenticationProvider
		 * extends org.springframework.security.authentication.AuthenticationProvider
		 * and supports
		 * org.springframework.security.authentication.RememberMeAuthenticationToken
		 */

		/*
		 * It is very similar to
		 * org.springframework.security.authentication.AnonymousAuthenticationProvider
		 */

		/* Let's create a provider */
		RememberMeAuthenticationProvider provider = new RememberMeAuthenticationProvider("key1");
		provider.setMessageSource(new DUXMessageSource());

		/* It supports RememberMeAuthenticationToken */
		aeq(true, provider.supports(RememberMeAuthenticationToken.class));

		/* If the type is not supported, result is null */
		aeq(null, provider.authenticate(Recorder.create(Authentication.class).p()));

		Object principal = new Object();
		ArrayList<GrantedAuthority> authorities = new ArrayList<>();

		/* Good token are returned untouched */
		RememberMeAuthenticationToken goodToken = new RememberMeAuthenticationToken("key1", principal, authorities);
		aeqr(goodToken, provider.authenticate(goodToken));

		/* Bad tokens trigger an exception */
		RememberMeAuthenticationToken badToken = new RememberMeAuthenticationToken("key2", principal, authorities);
		expect(BadCredentialsException.class,
				"The presented RememberMeAuthenticationToken does not contain the expected key",
				new RunnableWhichThrow() {
					@Override
					public void run() throws Exception {
						provider.authenticate(badToken);
					}
				});

	}
}
