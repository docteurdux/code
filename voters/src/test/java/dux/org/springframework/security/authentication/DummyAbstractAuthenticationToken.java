package dux.org.springframework.security.authentication;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class DummyAbstractAuthenticationToken extends AbstractAuthenticationToken {

	private Object credentials;
	private Object principal;

	public DummyAbstractAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
	}

	private static final long serialVersionUID = 1L;

	@Override
	public Object getCredentials() {
		return credentials;
	}

	@Override
	public Object getPrincipal() {
		return principal;
	}

	public void setCredentials(Object credentials) {
		this.credentials = credentials;
	}

	public void setPrincipal(Object principal) {
		this.principal = principal;
	}

}
