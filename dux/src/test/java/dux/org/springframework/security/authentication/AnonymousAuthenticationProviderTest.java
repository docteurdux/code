package dux.org.springframework.security.authentication;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.security.authentication.AnonymousAuthenticationProvider;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.DUXMessageSource;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.RunnableWhichThrow;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.context.MessageSourceAwareTest;

@Topic(AnonymousAuthenticationProvider.class)
@Related({ AuthenticationProviderTest.class, MessageSourceAwareTest.class })
public class AnonymousAuthenticationProviderTest extends AbstractTest {
	@Test
	public void test() throws NoSuchAlgorithmException {

		/*
		 * org.springframework.security.authentication.AnonymousAuthenticationProvider
		 * implements
		 * dux.org.springframework.security.authentication.AuthenticationProviderTest
		 * for tokens of type
		 * org.springframework.security.authentication.AnonymousAuthenticationToken
		 */

		/*
		 * Lets create a provider based on "key1" with a message source that sends back
		 * the default messages
		 */
		AnonymousAuthenticationProvider key1Provider = new AnonymousAuthenticationProvider("key1");
		key1Provider.setMessageSource(new DUXMessageSource());
		aeq("key1", key1Provider.getKey());

		/* This provider supports AnonymousAuthenticationToken */
		aeq(true, key1Provider.supports(AnonymousAuthenticationToken.class));

		/* Let's defined some default parameters for tokens */
		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("role"));
		Object principal = new Object();

		/* And let's define two tokens, one with "key1" and one with "key2" */
		AnonymousAuthenticationToken key1Token = new AnonymousAuthenticationToken("key1", principal, authorities);
		AnonymousAuthenticationToken key2Token = new AnonymousAuthenticationToken("key2", principal, authorities);

		/* If the token is not of the correct type, the result is null */
		aeq(null, key1Provider.authenticate(Recorder.create(Authentication.class).p()));

		/* If the authentication success, the token is sent back untouched */
		aeqr(key1Token, key1Provider.authenticate(key1Token));

		/*
		 * Otherwise, a
		 * org.springframework.security.authentication.BadCredentialsException is thrown
		 */
		expect(BadCredentialsException.class,
				"The presented AnonymousAuthenticationToken does not contain the expected key",
				new RunnableWhichThrow() {
					@Override
					public void run() throws Exception {
						key1Provider.authenticate(key2Token);
					}
				});

		/*
		 * Now, comparison based on hashcodes is quite weak. Here are two strings which
		 * have the same hash codes
		 */
		String md5hash1 = "58e6c9c817b9570d54fa61961e22f17e";
		String md5hash2 = "0a5026689a5ccdd7087e3a5562c3dc39";
		aeq(false, md5hash1.equals(md5hash2));
		aeq(true, md5hash1.hashCode() == md5hash2.hashCode());

		/*
		 * Here's a provider that authenticates against
		 * "58e6c9c817b9570d54fa61961e22f17e"
		 */
		AnonymousAuthenticationProvider md5hash1provider = new AnonymousAuthenticationProvider(md5hash1);

		/* And a token whose key was mdhash2 */
		AnonymousAuthenticationToken md5hash2token = new AnonymousAuthenticationToken(md5hash2, principal, authorities);

		/* Authentication succeeds, which is bad */
		aeqr(md5hash2token, md5hash1provider.authenticate(md5hash2token));

	}
}
