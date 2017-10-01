package dum.org.springframework.security.web.csrf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;

public class DummyCsrfTokenRepository implements CsrfTokenRepository {

	private CsrfToken token;
	private CsrfToken newToken;

	@Override
	public CsrfToken generateToken(HttpServletRequest request) {
		return newToken;
	}

	public void setNewToken(CsrfToken newToken) {
		this.newToken = newToken;
	}

	@Override
	public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {
		this.token = token;
	}

	@Override
	public CsrfToken loadToken(HttpServletRequest request) {
		return token;
	}

}
