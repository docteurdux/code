package dux.org.springframework.web.context.support.xmlWebApplicationContext;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import javax.servlet.ServletContext;
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
import org.springframework.mock.web.MockServletContext;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import dum.org.springframework.core.io.DummyProtocolResolver;

public class SecurityNoneTest {

	private static final String BEANS_XSD = "http://www.springframework.org/schema/beans/spring-beans-3.0.xsd";
	private static final String BEANS_NS = "http://www.springframework.org/schema/beans";
	private static final String SECURITY_NS = "http://www.springframework.org/schema/security";
	private static final String SECURITY_XSD = "http://www.springframework.org/schema/security/spring-security-4.2.xsd";
	private static final String XSI_NS = "http://www.w3.org/2001/XMLSchema-instance";

	@Test
	public void test() throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {

		ServletContext servletContext = new MockServletContext();

		DummyProtocolResolver pr = new DummyProtocolResolver();
		pr.getResources().put("/WEB-INF/applicationContext.xml", getResource());

		XmlWebApplicationContext context = new XmlWebApplicationContext();
		context.addProtocolResolver(pr);

		context.setServletContext(servletContext);
		context.refresh();

		Assert.assertEquals(3, context.getBeanDefinitionNames().length);

		@SuppressWarnings("rawtypes")
		ArrayList fiterChains = (ArrayList) context.getBean("org.springframework.security.filterChains");

		FilterChainProxy filterChainProxy = (FilterChainProxy) context
				.getBean("org.springframework.security.filterChainProxy");

		DefaultSecurityFilterChain defaultSecurityFilterChain = (DefaultSecurityFilterChain) context
				.getBean("org.springframework.security.web.DefaultSecurityFilterChain#0");

		Assert.assertEquals(1, fiterChains.size());
		Assert.assertEquals(defaultSecurityFilterChain, fiterChains.get(0));

		AntPathRequestMatcher antPathRequestMatcher = (AntPathRequestMatcher) defaultSecurityFilterChain
				.getRequestMatcher();

		Assert.assertEquals("/*", antPathRequestMatcher.getPattern());

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
		http.setAttribute("pattern", "/*");
		http.setAttribute("security", "none");
		beans.appendChild(http);

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
