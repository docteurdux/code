package dum.org.springframework.security.web.authentication.logout;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class DummyLogoutSuccessHandler implements LogoutSuccessHandler {

	private int count;

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		++count;
	}

	public int getCount() {
		return count;
	}

}
