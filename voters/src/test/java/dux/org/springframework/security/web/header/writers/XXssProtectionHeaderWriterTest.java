package dux.org.springframework.security.web.header.writers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.header.writers.XXssProtectionHeaderWriter;

public class XXssProtectionHeaderWriterTest {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@Before
	public void before() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
	}

	@Test
	public void testEnabledBlock() {
		XXssProtectionHeaderWriter writer = new XXssProtectionHeaderWriter();
		writer.writeHeaders(request, response);
		Assert.assertEquals(1, response.getHeaderNames().size());
		Assert.assertEquals(response.getHeader("X-XSS-Protection"), "1; mode=block");
	}
	
	@Test
	public void testEnabledNotBlock() {
		XXssProtectionHeaderWriter writer = new XXssProtectionHeaderWriter();
		writer.setBlock(false);
		writer.writeHeaders(request, response);
		Assert.assertEquals(1, response.getHeaderNames().size());
		Assert.assertEquals(response.getHeader("X-XSS-Protection"), "1");
	}
	
	@Test
	public void testNotEnabled() {
		XXssProtectionHeaderWriter writer = new XXssProtectionHeaderWriter();
		writer.setEnabled(false);
		writer.writeHeaders(request, response);
		Assert.assertEquals(1, response.getHeaderNames().size());
		Assert.assertEquals(response.getHeader("X-XSS-Protection"), "0");
	}
}
