package duu.org.springframework.security.web.authentication.logout;

import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.RequestMatcher;

import duu.Exposer;
import duu.java.lang.reflect.FieldUtils;

public class LogoutFilterExposer implements Exposer<LogoutFilter> {

	private LogoutFilter exposed;

	public LogoutFilterExposer(LogoutFilter exposed) {
		this.exposed = exposed;
	}

	@Override
	public LogoutFilter getExposed() {
		return exposed;
	}

	public LogoutSuccessHandler getLogoutSuccessHandler() {
		return (LogoutSuccessHandler) FieldUtils.getFieldValue(LogoutFilter.class, "logoutSuccessHandler", exposed);
	}

	public LogoutHandler getHandler() {
		return (LogoutHandler) FieldUtils.getFieldValue(LogoutFilter.class, "handler", exposed);
	}

	public RequestMatcher getLogoutRequestMatcher() {
		return (RequestMatcher) FieldUtils.getFieldValue(LogoutFilter.class, "logoutRequestMatcher", exposed);
	}

}
