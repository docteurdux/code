package dum.org.springframework.security.web.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;

public class DummySecurityContextRepository implements SecurityContextRepository {

	private SecurityContext context;
	private Boolean containsContext;

	@Override
	public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
		return context;
	}

	@Override
	public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
		this.context = context;

	}

	@Override
	public boolean containsContext(HttpServletRequest request) {
		if (containsContext == null) {
			return context != null;
		} else {
			return containsContext;
		}
	}

	public void setContainsContext(Boolean containsContext) {
		this.containsContext = containsContext;
	}

}
