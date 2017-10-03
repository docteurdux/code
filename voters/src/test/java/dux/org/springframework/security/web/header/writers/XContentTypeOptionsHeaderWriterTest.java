package dux.org.springframework.security.web.header.writers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.header.writers.XContentTypeOptionsHeaderWriter;

public class XContentTypeOptionsHeaderWriterTest {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@Before
	public void before() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
	}

	@Test
	public void test() {
		XContentTypeOptionsHeaderWriter writer = new XContentTypeOptionsHeaderWriter();
		writer.writeHeaders(request, response);
		Assert.assertEquals(1, response.getHeaderNames().size());
		Assert.assertEquals(response.getHeader("X-Content-Type-Options"), "nosniff");
	}
}
