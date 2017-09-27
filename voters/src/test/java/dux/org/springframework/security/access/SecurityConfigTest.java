package dux.org.springframework.security.access;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;

public class SecurityConfigTest {
	@Test
	public void testSingle() {
		String attribute = "attribute";
		SecurityConfig config = new SecurityConfig(attribute);
		Assert.assertEquals(attribute, config.getAttribute());
		Assert.assertEquals(attribute, config.toString());
	}

	@Test
	public void testCommaList() {
		List<ConfigAttribute> attributes = SecurityConfig.createListFromCommaDelimitedString("a,b,c,d");
		Assert.assertEquals("a", attributes.get(0).getAttribute());
		Assert.assertEquals("b", attributes.get(1).getAttribute());
		Assert.assertEquals("c", attributes.get(2).getAttribute());
		Assert.assertEquals("d", attributes.get(3).getAttribute());
	}

	@Test
	public void testList() {
		List<ConfigAttribute> attributes = SecurityConfig.createList("a", "b", "c", "d");
		Assert.assertEquals("a", attributes.get(0).getAttribute());
		Assert.assertEquals("b", attributes.get(1).getAttribute());
		Assert.assertEquals("c", attributes.get(2).getAttribute());
		Assert.assertEquals("d", attributes.get(3).getAttribute());
	}
}
