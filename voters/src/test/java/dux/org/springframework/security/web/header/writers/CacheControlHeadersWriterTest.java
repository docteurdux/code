package dux.org.springframework.security.web.header.writers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.header.writers.CacheControlHeadersWriter;

public class CacheControlHeadersWriterTest {
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@Before
	public void before() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
	}

	@Test
	public void test() {
		CacheControlHeadersWriter writer = new CacheControlHeadersWriter();
		writer.writeHeaders(request, response);
		Assert.assertEquals(3, response.getHeaderNames().size());
		Assert.assertEquals(response.getHeader("Cache-Control"), "no-cache, no-store, max-age=0, must-revalidate");
		Assert.assertEquals(response.getHeader("Pragma"), "no-cache");
		Assert.assertEquals(response.getHeader("Expires"), "0");
	}
}
