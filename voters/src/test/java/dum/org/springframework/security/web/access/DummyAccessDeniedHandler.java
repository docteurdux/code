package dum.org.springframework.security.web.access;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class DummyAccessDeniedHandler implements AccessDeniedHandler {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private AccessDeniedException accessDeniedException;

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		this.request = request;
		this.response = response;
		this.accessDeniedException = accessDeniedException;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public AccessDeniedException getAccessDeniedException() {
		return accessDeniedException;
	}

	public void setAccessDeniedException(AccessDeniedException accessDeniedException) {
		this.accessDeniedException = accessDeniedException;
	}

}
