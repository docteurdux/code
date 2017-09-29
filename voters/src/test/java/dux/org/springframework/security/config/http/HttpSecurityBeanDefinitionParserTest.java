package dux.org.springframework.security.config.http;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.security.config.http.HttpSecurityBeanDefinitionParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import duu.org.springframework.beans.factory.xml.ParserContextUtils;

public class HttpSecurityBeanDefinitionParserTest {

	private static final String DEFAULT_SECURITY_FILTER_CHAIN = "org.springframework.security.web.DefaultSecurityFilterChain#0";

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

		BeanDefinitionRegistry registry = pc.getRegistry();

		BeanDefinition defaultSecurityFilterChain = registry.getBeanDefinition(DEFAULT_SECURITY_FILTER_CHAIN);
		System.out.println(defaultSecurityFilterChain.getBeanClassName());
		Assert.assertEquals("org.springframework.security.web.DefaultSecurityFilterChain",
				defaultSecurityFilterChain.getBeanClassName());
		RootBeanDefinition rbd = (RootBeanDefinition) defaultSecurityFilterChain.getConstructorArgumentValues()
				.getIndexedArgumentValues().get(0).getValue();
		Assert.assertEquals("org.springframework.security.web.util.matcher.AntPathRequestMatcher",
				rbd.getBeanClassName());
		Assert.assertEquals("/*", rbd.getConstructorArgumentValues().getIndexedArgumentValues().get(0).getValue());

	}

}
