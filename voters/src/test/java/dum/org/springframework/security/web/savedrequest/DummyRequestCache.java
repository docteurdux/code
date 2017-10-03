package dum.org.springframework.security.web.savedrequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

public class DummyRequestCache implements RequestCache {

	private SavedRequest savedRequest;
	private HttpServletRequest matchingRequest;

	@Override
	public void saveRequest(HttpServletRequest request, HttpServletResponse response) {

	}

	@Override
	public SavedRequest getRequest(HttpServletRequest request, HttpServletResponse response) {
		return savedRequest;
	}

	@Override
	public HttpServletRequest getMatchingRequest(HttpServletRequest request, HttpServletResponse response) {
		return matchingRequest;
	}

	@Override
	public void removeRequest(HttpServletRequest request, HttpServletResponse response) {

	}

	public void setSavedRequest(SavedRequest savedRequest) {
		this.savedRequest = savedRequest;
	}

	public void setMatchingRequest(HttpServletRequest matchingRequest) {
		this.matchingRequest = matchingRequest;
	}

}
