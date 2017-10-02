package dum.org.springframework.security.web.authentication.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

public class DummySessionAuthenticationStrategy implements SessionAuthenticationStrategy {

	private int count;

	@Override
	public void onAuthentication(Authentication authentication, HttpServletRequest request,
			HttpServletResponse response) throws SessionAuthenticationException {
		++count;
	}

	public int getCount() {
		return count;
	}

}
