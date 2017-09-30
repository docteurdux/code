package dux.org.springframework.web.context.support.xmlWebApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import dum.org.springframework.core.io.DummyProtocolResolver;

public class UserPasswordTest {

	private static final String BEANS_XSD = "http://www.springframework.org/schema/beans/spring-beans-3.0.xsd";
	private static final String BEANS_NS = "http://www.springframework.org/schema/beans";
	private static final String SECURITY_NS = "http://www.springframework.org/schema/security";
	private static final String SECURITY_XSD = "http://www.springframework.org/schema/security/spring-security-4.2.xsd";
	private static final String XSI_NS = "http://www.w3.org/2001/XMLSchema-instance";

	@Test
	public void test() throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException,
			IOException, ServletException {

		ServletContext servletContext = new MockServletContext();

		DummyProtocolResolver pr = new DummyProtocolResolver();
		pr.getResources().put("/WEB-INF/applicationContext.xml", getResource());

		XmlWebApplicationContext context = new XmlWebApplicationContext();
		context.addProtocolResolver(pr);

		context.setServletContext(servletContext);
		context.refresh();

		for (String name : context.getBeanDefinitionNames()) {
			System.out.println(name);
		}

		Assert.assertEquals(23, context.getBeanDefinitionCount());

		FilterChainProxy filterChainProxy = (FilterChainProxy) context
				.getBean("org.springframework.security.filterChainProxy");

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		FilterChain chain = new MockFilterChain();
		filterChainProxy.doFilter(request, response, chain);
		Assert.assertEquals(403, response.getStatus());
		System.out.println(response.getContentAsString());

	}

	private Resource getResource()
			throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element beans = document.createElementNS(BEANS_NS, ("b:beans"));
		beans.setAttribute("xmlns", SECURITY_NS);
		beans.setAttribute("xmlns:xsi", XSI_NS);
		beans.setAttribute("xmlns:b", BEANS_NS);
		beans.setAttributeNS(XSI_NS, "xsi:schemaLocation",
				BEANS_NS + " " + BEANS_XSD + " " + SECURITY_NS + " " + SECURITY_XSD);
		document.appendChild(beans);

		Element http = document.createElement("http");
		beans.appendChild(http);

		Element userService = document.createElement("user-service");
		beans.appendChild(userService);

		Element user = document.createElement("user");
		user.setAttribute("name", "user");
		user.setAttribute("password", "password");
		user.setAttribute("authorities", "ROLE_USER");
		userService.appendChild(user);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

		transformer.transform(new DOMSource(document), new StreamResult(baos));
		byte[] bytes = baos.toByteArray();
		System.out.println(new String(bytes));
		Resource resource = new ByteArrayResource(bytes);
		return resource;
	}

}
