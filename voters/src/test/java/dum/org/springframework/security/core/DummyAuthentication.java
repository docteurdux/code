package dum.org.springframework.security.core;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class DummyAuthentication implements Authentication {

	private static final long serialVersionUID = 1L;
	private String name;
	private Collection<GrantedAuthority> authorities = new ArrayList<>();
	private Object credentials;
	private Object details;
	private Object principal;
	private boolean authenticated;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public Object getCredentials() {
		return credentials;
	}

	@Override
	public Object getDetails() {
		return details;
	}

	@Override
	public Object getPrincipal() {
		return principal;
	}

	@Override
	public boolean isAuthenticated() {
		return authenticated;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		authenticated = isAuthenticated;

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public void setCredentials(Object credentials) {
		this.credentials = credentials;
	}

	public void setDetails(Object details) {
		this.details = details;
	}

	public void setPrincipal(Object principal) {
		this.principal = principal;
	}

	public void addAuthority(GrantedAuthority authority) {
		authorities.add(authority);
	}

}
