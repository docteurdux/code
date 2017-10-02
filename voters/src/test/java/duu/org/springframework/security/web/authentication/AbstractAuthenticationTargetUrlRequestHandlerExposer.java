package duu.org.springframework.security.web.authentication;

import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;

import duu.java.lang.reflect.FieldUtils;

public class AbstractAuthenticationTargetUrlRequestHandlerExposer {

	private static final Class<AbstractAuthenticationTargetUrlRequestHandler> CLAZZ = AbstractAuthenticationTargetUrlRequestHandler.class;

	private AbstractAuthenticationTargetUrlRequestHandler exposed;

	public AbstractAuthenticationTargetUrlRequestHandlerExposer(AbstractAuthenticationTargetUrlRequestHandler exposed) {
		this.exposed = exposed;
	}

	public String getTargetUrlParameter() {
		return (String) FieldUtils.getFieldValue(CLAZZ, "targetUrlParameter", exposed);
	}

	public String getDefaultTargetUrl() {
		return (String) FieldUtils.getFieldValue(CLAZZ, "defaultTargetUrl", exposed);
	}

	public boolean getAlwaysUseDefaultTargetUrl() {
		return (boolean) FieldUtils.getFieldValue(CLAZZ, "alwaysUseDefaultTargetUrl", exposed);
	}

	public boolean getUseReferer() {
		return (boolean) FieldUtils.getFieldValue(CLAZZ, "useReferer", exposed);
	}

	public RedirectStrategy getRedirectStrategy() {
		return (RedirectStrategy) FieldUtils.getFieldValue(CLAZZ, "redirectStrategy", exposed);
	}
}
