package dux.org.springframework.security.web.header.writers.frameoptions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.header.writers.frameoptions.AllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter.XFrameOptionsMode;

import dum.org.springframework.security.web.header.writers.frameoptions.DummyAllowFromStrategy;

public class XFrameOptionsHeaderWriterTest {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@Before
	public void before() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
	}

	@Test
	public void testDeny() {
		XFrameOptionsHeaderWriter writer = new XFrameOptionsHeaderWriter();
		writer.writeHeaders(request, response);
		Assert.assertEquals(1, response.getHeaderNames().size());
		Assert.assertEquals(response.getHeader("X-Frame-Options"), "DENY");
	}

	@Test
	public void testSameOrigin() {
		XFrameOptionsHeaderWriter writer = new XFrameOptionsHeaderWriter(XFrameOptionsMode.SAMEORIGIN);

		writer.writeHeaders(request, response);
		Assert.assertEquals(1, response.getHeaderNames().size());
		Assert.assertEquals(response.getHeader("X-Frame-Options"), "SAMEORIGIN");
	}

	@Test
	public void testAllowFrom() {

		AllowFromStrategy strategy = new DummyAllowFromStrategy("hello");
		XFrameOptionsHeaderWriter writer = new XFrameOptionsHeaderWriter(strategy);

		writer.writeHeaders(request, response);
		Assert.assertEquals(1, response.getHeaderNames().size());
		Assert.assertEquals(response.getHeader("X-Frame-Options"), "ALLOW-FROM hello");
	}
}
