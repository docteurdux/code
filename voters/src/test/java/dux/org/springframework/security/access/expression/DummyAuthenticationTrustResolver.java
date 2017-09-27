package dux.org.springframework.security.access.expression;

import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;

public class DummyAuthenticationTrustResolver implements AuthenticationTrustResolver {

	private boolean anonymous;
	private boolean rememberMe;

	@Override
	public boolean isAnonymous(Authentication authentication) {
		return anonymous;
	}

	@Override
	public boolean isRememberMe(Authentication authentication) {
		return rememberMe;
	}

	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
	
	

}
