package dum.org.springframework.security.web.util.matcher;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.RequestMatcher;

public class DummyRequestMatcher implements RequestMatcher {

	private boolean matches;

	@Override
	public boolean matches(HttpServletRequest request) {
		return matches;
	}

	public void setMatches(boolean matches) {
		this.matches = matches;
	}

}
