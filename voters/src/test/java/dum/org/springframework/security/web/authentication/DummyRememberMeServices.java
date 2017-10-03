package dum.org.springframework.security.web.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.RememberMeServices;

public class DummyRememberMeServices implements RememberMeServices {

	private int autoLoginCount;
	private int failureCount;
	private int successCount;
	private Authentication authentication;

	@Override
	public Authentication autoLogin(HttpServletRequest request, HttpServletResponse response) {
		++autoLoginCount;
		return authentication;
	}

	@Override
	public void loginFail(HttpServletRequest request, HttpServletResponse response) {
		++failureCount;
	}

	@Override
	public void loginSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication successfulAuthentication) {
		++successCount;
	}

	public int getAutoLoginCount() {
		return autoLoginCount;
	}

	public int getFailureCount() {
		return failureCount;
	}

	public int getSuccessCount() {
		return successCount;
	}

	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}

}
