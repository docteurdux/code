package dum.org.springframework.security.web.authentication.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

public class DummyLogoutHandler implements LogoutHandler {

	private int count;

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		++count;
	}

	public int getCount() {
		return count;
	}

}
