package dux.java.security;

import java.security.Principal;

public class DummyPrincipal implements Principal {

	private String name;

	public DummyPrincipal() {
	}

	public DummyPrincipal(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
