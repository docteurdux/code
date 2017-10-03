package dux.org.springframework.security.web.header.writers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.header.writers.HstsHeaderWriter;

import duu.org.springframework.mock.web.MockHttpServletResponseUtils;

public class HstsHeaderWriterTest {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@Before
	public void before() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
	}

	@Test
	public void testNoMatch() {
		HstsHeaderWriter writer = new HstsHeaderWriter();
		writer.writeHeaders(request, response);
		MockHttpServletResponseUtils.dumpHeaders(response);
		Assert.assertEquals(0, response.getHeaderNames().size());
	}

	@Test
	public void testSecure() {

		request.setSecure(true);

		HstsHeaderWriter writer = new HstsHeaderWriter();
		writer.writeHeaders(request, response);
		Assert.assertEquals(1, response.getHeaderNames().size());
		Assert.assertEquals(response.getHeader("Strict-Transport-Security"), "max-age=31536000 ; includeSubDomains");
	}

	@Test
	public void testHttps() {

		request.setScheme("https");

		HstsHeaderWriter writer = new HstsHeaderWriter();
		writer.writeHeaders(request, response);
		Assert.assertEquals(1, response.getHeaderNames().size());
		Assert.assertEquals(response.getHeader("Strict-Transport-Security"), "max-age=31536000 ; includeSubDomains");
	}

	@Test
	public void testNoSubDomains() {

		request.setScheme("https");

		HstsHeaderWriter writer = new HstsHeaderWriter();
		writer.setIncludeSubDomains(false);
		writer.writeHeaders(request, response);
		Assert.assertEquals(1, response.getHeaderNames().size());
		Assert.assertEquals(response.getHeader("Strict-Transport-Security"), "max-age=31536000");
	}
}
