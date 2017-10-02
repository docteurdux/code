package dum.org.springframework.security.web.header;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.header.HeaderWriter;

public class DummyHeaderWriter implements HeaderWriter {

	private String name;
	private String value;

	public DummyHeaderWriter(String name, String value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public void writeHeaders(HttpServletRequest request, HttpServletResponse response) {
		response.addHeader(name, value);
	}

}
