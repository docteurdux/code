package duu.org.springframework.security.web.authentication.logout;

import java.util.List;

import org.springframework.security.web.authentication.logout.CompositeLogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import duu.java.lang.reflect.FieldUtils;

public class CompositeLogoutHandlerUtils {

	@SuppressWarnings("unchecked")
	public static List<LogoutHandler> getLogoutHandlers(CompositeLogoutHandler logoutHandler) {
		return (List<LogoutHandler>) FieldUtils.getFieldValue(CompositeLogoutHandler.class, "logoutHandlers",
				logoutHandler);
	}

}
