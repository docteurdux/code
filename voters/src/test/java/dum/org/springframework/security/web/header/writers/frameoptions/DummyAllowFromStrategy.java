package dum.org.springframework.security.web.header.writers.frameoptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.header.writers.frameoptions.AllowFromStrategy;

public class DummyAllowFromStrategy implements AllowFromStrategy {

	private String value;

	public DummyAllowFromStrategy() {
	}
	
	public DummyAllowFromStrategy(String value) {
		this.value = value;
	}

	@Override
	public String getAllowFromValue(HttpServletRequest request) {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
