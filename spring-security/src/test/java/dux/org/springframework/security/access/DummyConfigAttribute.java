package dux.org.springframework.security.access;

import org.springframework.security.access.ConfigAttribute;

public class DummyConfigAttribute implements ConfigAttribute {

	private static final long serialVersionUID = 1L;

	private String attribute;

	@Override
	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

}
