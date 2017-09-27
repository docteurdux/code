package dux.org.springframework.security.web.authentication.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;

public class DummyFilterConfig implements FilterConfig {

	private List<String> initParameterNames = new ArrayList<>();

	@Override
	public String getFilterName() {
		return null;
	}

	@Override
	public ServletContext getServletContext() {
		return null;
	}

	@Override
	public String getInitParameter(String name) {
		return null;
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		return Collections.enumeration(initParameterNames);
	}

}
