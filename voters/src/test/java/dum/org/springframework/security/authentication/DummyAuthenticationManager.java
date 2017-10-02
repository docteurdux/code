package dum.org.springframework.security.authentication;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class DummyAuthenticationManager implements AuthenticationManager {

	private int count;
	private Authentication authentication;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		++count;
		return this.authentication;
	}

	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}

	public int getCount() {
		return count;
	}

}
