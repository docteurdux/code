package dux.org.springframework.security.config.http;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.security.config.http.HttpSecurityBeanDefinitionParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import duu.org.springframework.beans.factory.xml.ParserContextUtils;

public class HttpSecurityBeanDefinitionParserTest {
	@Test
	public void testSecurityNone() throws ParserConfigurationException {

		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element element = document.createElement("http");
		element.setAttribute("pattern", "/*");
		element.setAttribute("security", "none");
		document.appendChild(element);

		HttpSecurityBeanDefinitionParser parser = new HttpSecurityBeanDefinitionParser();
		ParserContext pc = ParserContextUtils.getParserContext();
		parser.parse(element, pc);
	}

}
