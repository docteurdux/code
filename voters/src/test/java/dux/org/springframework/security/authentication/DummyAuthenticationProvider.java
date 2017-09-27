package dux.org.springframework.security.authentication;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class DummyAuthenticationProvider implements AuthenticationProvider {

	private boolean supports;
	private Authentication authentication;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		return this.authentication;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return supports;
	}

	public void setSupports(boolean supports) {
		this.supports = supports;
	}

	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}

}
