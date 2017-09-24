package dux.org.springframework.security.acls.model;

import org.springframework.security.acls.model.Permission;

public class DummyPermission implements Permission {

	private static final long serialVersionUID = 1L;

	private int mask;
	private String pattern;

	@Override
	public int getMask() {
		return mask;
	}

	@Override
	public String getPattern() {
		return pattern;
	}

	public void setMask(int mask) {
		this.mask = mask;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}
