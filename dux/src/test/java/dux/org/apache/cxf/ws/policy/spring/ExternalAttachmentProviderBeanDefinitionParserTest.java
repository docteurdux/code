package dux.org.apache.cxf.ws.policy.spring;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.cxf.ws.policy.spring.ExternalAttachmentProviderBeanDefinitionParser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.ProblemReporter;
import org.springframework.beans.factory.parsing.ReaderEventListener;
import org.springframework.beans.factory.parsing.SourceExtractor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.NamespaceHandlerResolver;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlReaderContext;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.docteurdux.test.AbstractTest;

import dum.org.springframework.beans.factory.config.DummyBeanDefinition;
import dum.org.springframework.beans.factory.parsing.DummyProblemReporter;
import dum.org.springframework.beans.factory.parsing.DummyReaderEventListener;
import dum.org.springframework.beans.factory.parsing.DummySourceExtractor;
import dum.org.springframework.beans.factory.support.DummyBeanDefinitionRegistry;
import dum.org.springframework.beans.factory.xml.DummyNamespaceHandlerResolver;
import dum.org.springframework.core.io.DummyResource;

public class ExternalAttachmentProviderBeanDefinitionParserTest extends AbstractTest {
	private Document document;
	private ParserContext parserContext;
	private BeanDefinition beanDefinition;
	private BeanDefinitionParserDelegate beanDefinitionParserDelegate;
	private XmlReaderContext xmlReaderContext;
	private NamespaceHandlerResolver namespaceHandlerResolver;
	private XmlBeanDefinitionReader xmlBeanDefinitionReader;
	private BeanDefinitionRegistry beanDefinitionRegistry;
	private SourceExtractor sourceExtractor;
	private ReaderEventListener readerEventListener;
	private ProblemReporter problemReporter;
	private Resource resource;

	@Before
	public void before() throws Exception {
		document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		resource = new DummyResource();
		problemReporter = new DummyProblemReporter();
		readerEventListener = new DummyReaderEventListener();
		sourceExtractor = new DummySourceExtractor();
		beanDefinitionRegistry = new DummyBeanDefinitionRegistry();
		xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanDefinitionRegistry);
		namespaceHandlerResolver = new DummyNamespaceHandlerResolver();
		xmlReaderContext = new XmlReaderContext(resource, problemReporter, readerEventListener, sourceExtractor,
				xmlBeanDefinitionReader, namespaceHandlerResolver);
		beanDefinitionParserDelegate = new BeanDefinitionParserDelegate(xmlReaderContext);
		beanDefinition = new DummyBeanDefinition();
		parserContext = new ParserContext(xmlReaderContext, beanDefinitionParserDelegate, beanDefinition);
	}

	@Test
	public void test() {
		ExternalAttachmentProviderBeanDefinitionParser parser = new ExternalAttachmentProviderBeanDefinitionParser();

		Element element = document.createElementNS("elementNS", "elementLP");
		BeanDefinition definition = parser.parse(element, parserContext);
		
	}
}
