package duu.org.springframework.mock.web;

import org.springframework.mock.web.MockHttpServletResponse;

import duu.java.lang.ObjectUtils;

public class MockHttpServletResponseUtils {

	public static void dumpHeaders(MockHttpServletResponse response) {
		for (String name : response.getHeaderNames()) {
			for (Object value : response.getHeaderValues(name)) {
				System.out.println(name + " : " + ObjectUtils.compact(value));
			}
		}
	}

}
