package dux.org.springframework.security.web.header;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.header.HeaderWriter;
import org.springframework.security.web.header.HeaderWriterFilter;

import dum.javax.servlet.DummyServlet;
import dum.org.springframework.security.web.header.DummyHeaderWriter;
import duu.javax.servlet.CountingFilter;

public class HeaderWriterFilterTest {

	private DummyServlet servlet;
	private CountingFilter countingFilter;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private MockFilterChain filterChain;

	@Before
	public void before() {
		servlet = new DummyServlet();
		countingFilter = new CountingFilter();
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		filterChain = new MockFilterChain(servlet, countingFilter);
	}

	@Test
	public void test() throws ServletException, IOException {
		List<HeaderWriter> headerWriters = new ArrayList<>();
		HeaderWriter headerWriter = new DummyHeaderWriter("hname", "hvalue");
		headerWriters.add(headerWriter);
		HeaderWriterFilter filter = new HeaderWriterFilter(headerWriters);
		filter.doFilter(request, response, filterChain);
		Assert.assertEquals("hvalue", response.getHeader("hname"));
	}
}
