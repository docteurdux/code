package dux.org.springframework.web.context.support;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.context.support.XmlWebApplicationContext;

import dum.javax.servlet.DummyServletContext;
import dum.org.springframework.core.io.DummyProtocolResolver;

public class XmlWebApplicationContextTest {
	private static final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
			+ "<beans:beans xmlns=\"http://www.springframework.org/schema/security\"\r\n"
			+ "	xmlns:beans=\"http://www.springframework.org/schema/beans\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\r\n"
			+ "	xsi:schemaLocation=\"http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.2.xsd\r\n"
			+ "						http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security-3.1.xsd\">"
			+ "<http pattern='/images/**' security='none' />" + "</beans:beans>";

	@Test
	public void test() throws UnsupportedEncodingException {
		@SuppressWarnings("resource")
		XmlWebApplicationContext context = new XmlWebApplicationContext();
		DummyProtocolResolver pr = new DummyProtocolResolver();
		ByteArrayResource resource = new ByteArrayResource(xml.getBytes());
		pr.getResources().put("/WEB-INF/applicationContext.xml", resource);
		context.addProtocolResolver(pr);
		//
		DummyServletContext servletContext = new DummyServletContext();
		context.setServletContext(servletContext);

		context.refresh();
	}
}
