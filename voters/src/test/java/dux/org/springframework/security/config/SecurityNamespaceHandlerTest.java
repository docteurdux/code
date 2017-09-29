package dux.org.springframework.security.config;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.beans.factory.parsing.FailFastProblemReporter;
import org.springframework.beans.factory.parsing.NullSourceExtractor;
import org.springframework.beans.factory.parsing.ProblemReporter;
import org.springframework.beans.factory.parsing.ReaderEventListener;
import org.springframework.beans.factory.parsing.SourceExtractor;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.DefaultNamespaceHandlerResolver;
import org.springframework.beans.factory.xml.NamespaceHandlerResolver;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlReaderContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.security.config.SecurityNamespaceHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SecurityNamespaceHandlerTest {
	@Test
	public void test() throws ParserConfigurationException {
		SecurityNamespaceHandler handler = new SecurityNamespaceHandler();
		handler.init();
		DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		Document document = documentBuilder.newDocument();

		Element element = document.createElementNS("http://www.springframework.org/schema/security", "http");
		element.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "schemaLocation",
				"http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.2.xsd"
						+ " "
						+ "http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security-4.2.xsd");
		element.setAttribute("pattern", "/hello/**");
		element.setAttribute("security", "full");
		document.appendChild(element);

		Resource resource = new ByteArrayResource(new byte[] {});
		ProblemReporter problemReporter = new FailFastProblemReporter();
		ReaderEventListener eventListener = new EmptyReaderEventListener();
		SourceExtractor sourceExtractor = new NullSourceExtractor();
		SimpleBeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
		NamespaceHandlerResolver namespacehr = new DefaultNamespaceHandlerResolver();
		XmlReaderContext readerContext = new XmlReaderContext(resource, problemReporter, eventListener, sourceExtractor,
				reader, namespacehr);
		BeanDefinitionParserDelegate delegate = new BeanDefinitionParserDelegate(readerContext);
		ParserContext pc = new ParserContext(readerContext, delegate);
		handler.parse(element, pc);
	}
}
