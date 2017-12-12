package dux.org.springframework.security.authentication.dao;

import org.junit.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.DUXMessageSource;
import com.github.docteurdux.test.Topic;

@Topic(AbstractUserDetailsAuthenticationProvider.class)
public class AbstractUserDetailsAuthenticationProviderTest extends AbstractTest {
	@Test
	public void test() throws Exception {
		AbstractUserDetailsAuthenticationProvider p = new AbstractUserDetailsAuthenticationProvider() {
			@Override
			protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
					throws AuthenticationException {
				return null;
			}

			@Override
			protected void additionalAuthenticationChecks(UserDetails userDetails,
					UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
			}
		};

		UserCache userCache = null;
		p.setUserCache(userCache);
		p.setMessageSource(new DUXMessageSource());
		p.afterPropertiesSet();

		aeq(true, p.supports(UsernamePasswordAuthenticationToken.class));

		/*-
		AbstractUserDetailsAuthenticationProvider()
		afterPropertiesSet()
		authenticate(Authentication)
		getUserCache()
		isForcePrincipalAsString()
		isHideUserNotFoundExceptions()
		setAuthoritiesMapper(GrantedAuthoritiesMapper)
		setForcePrincipalAsString(boolean)
		setHideUserNotFoundExceptions(boolean)
		setMessageSource(MessageSource)
		setPostAuthenticationChecks(UserDetailsChecker)
		setPreAuthenticationChecks(UserDetailsChecker)
		setUserCache(UserCache)
		supports(Class<?>)
		 */
	}
}
