package dux.org.springframework.security.authentication;

import org.springframework.security.core.CredentialsContainer;

public class DummyCredentialsContainer implements CredentialsContainer {

	private String secret;

	public DummyCredentialsContainer(String secret) {
		this.secret = secret;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Override
	public void eraseCredentials() {
		secret = null;
	}

}
