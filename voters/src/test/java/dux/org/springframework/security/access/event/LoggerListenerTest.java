package dux.org.springframework.security.access.event;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.event.AbstractAuthorizationEvent;
import org.springframework.security.access.event.AuthenticationCredentialsNotFoundEvent;
import org.springframework.security.access.event.AuthorizationFailureEvent;
import org.springframework.security.access.event.AuthorizedEvent;
import org.springframework.security.access.event.LoggerListener;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;

import dux.org.springframework.security.core.DummyAuthentication;

public class LoggerListenerTest {
	@Test
	public void test() {

		LoggerListener logger = new LoggerListener();

		Object object = new Object();
		Collection<ConfigAttribute> attributes = new ArrayList<>();
		Authentication authentication = new DummyAuthentication();

		AuthenticationCredentialsNotFoundException acnfex = new AuthenticationCredentialsNotFoundException(
				"authorization credentials not found");
		AccessDeniedException adex = new AccessDeniedException("access denied");

		AbstractAuthorizationEvent event = null;

		event = new AuthenticationCredentialsNotFoundEvent(object, attributes, acnfex);
		logger.onApplicationEvent(event);

		event = new AuthorizationFailureEvent(object, attributes, authentication, adex);
		logger.onApplicationEvent(event);

		event = new AuthorizedEvent(object, attributes, authentication);
		logger.onApplicationEvent(event);

		event = new PublicInvocationEvent(object);
		logger.onApplicationEvent(event);
	}
}
