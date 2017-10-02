package duu.org.springframework.security.web.authentication.logout;

import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.RequestMatcher;

import duu.java.lang.reflect.FieldUtils;

public class LogoutFilterUtils {

	public static LogoutSuccessHandler getLogoutSuccessHandler(LogoutFilter logoutFilter)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		return (LogoutSuccessHandler) FieldUtils.getFieldValue(LogoutFilter.class, "logoutSuccessHandler",
				logoutFilter);
	}

	public static LogoutHandler getHandler(LogoutFilter logoutFilter)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		return (LogoutHandler) FieldUtils.getFieldValue(LogoutFilter.class, "handler", logoutFilter);
	}

	public static RequestMatcher getLogoutRequestMatcher(LogoutFilter logoutFilter) {
		return (RequestMatcher) FieldUtils.getFieldValue(LogoutFilter.class, "logoutRequestMatcher", logoutFilter);
	}

}
