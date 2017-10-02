package duu.org.springframework.security.web.authentication;

import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;

import duu.java.lang.reflect.FieldUtils;

public class AbstractAuthenticationTargetUrlRequestHandlerUtils {

	public static String getTargetUrlParameter(AbstractAuthenticationTargetUrlRequestHandler handler) {
		return (String) FieldUtils.getFieldValue(AbstractAuthenticationTargetUrlRequestHandler.class,
				"targetUrlParameter", handler);
	}

	public static String getDefaultTargetUrl(AbstractAuthenticationTargetUrlRequestHandler handler) {
		return (String) FieldUtils.getFieldValue(AbstractAuthenticationTargetUrlRequestHandler.class,
				"defaultTargetUrl", handler);
	}

	public static boolean getAlwaysUseDefaultTargetUrl(AbstractAuthenticationTargetUrlRequestHandler handler) {
		return (boolean) FieldUtils.getFieldValue(AbstractAuthenticationTargetUrlRequestHandler.class,
				"alwaysUseDefaultTargetUrl", handler);
	}

	public static boolean getUseReferer(AbstractAuthenticationTargetUrlRequestHandler handler) {
		return (boolean) FieldUtils.getFieldValue(AbstractAuthenticationTargetUrlRequestHandler.class, "useReferer",
				handler);
	}

	public static RedirectStrategy getRedirectStrategy(AbstractAuthenticationTargetUrlRequestHandler handler) {
		return (RedirectStrategy) FieldUtils.getFieldValue(AbstractAuthenticationTargetUrlRequestHandler.class,
				"redirectStrategy", handler);
	}

}
