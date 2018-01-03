package dux.org.springframework.transaction.config;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.beans.factory.parsing.FailFastProblemReporter;
import org.springframework.beans.factory.parsing.NullSourceExtractor;
import org.springframework.beans.factory.parsing.ProblemReporter;
import org.springframework.beans.factory.parsing.ReaderEventListener;
import org.springframework.beans.factory.parsing.SourceExtractor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.DefaultNamespaceHandlerResolver;
import org.springframework.beans.factory.xml.NamespaceHandlerResolver;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlReaderContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.config.AnnotationDrivenBeanDefinitionParser;
import org.springframework.transaction.config.JtaTransactionManagerBeanDefinitionParser;
import org.springframework.transaction.config.TxNamespaceHandler;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.beans.factory.xml.NamespaceHandlerSupportTest;

@Topic(TxNamespaceHandler.class)
@Extends({ NamespaceHandlerSupportTest.class })
@ExtendedBy({})
@Related({ AnnotationDrivenBeanDefinitionParser.class, JtaTransactionManagerBeanDefinitionParser.class })
public class TxNamespaceHandlerTest extends AbstractTest {
	@Test
	public void test() throws DOMException, ParserConfigurationException {
		TxNamespaceHandler h = new TxNamespaceHandler();
		h.init();
		Element element = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument().createElementNS("ns",
				"advice");
		element.setAttribute("id", "id");
		byte[] byteArray = new byte[] {};
		Resource resource = new ByteArrayResource(byteArray);
		ProblemReporter problemReporter = new FailFastProblemReporter();
		ReaderEventListener eventListener = new EmptyReaderEventListener();
		SourceExtractor sourceExtractor = new NullSourceExtractor();
		BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
		NamespaceHandlerResolver namespaceHandlerResolver = new DefaultNamespaceHandlerResolver();
		XmlReaderContext readerContext = new XmlReaderContext(resource, problemReporter, eventListener, sourceExtractor,
				reader, namespaceHandlerResolver);
		BeanDefinitionParserDelegate delegate = new BeanDefinitionParserDelegate(readerContext);
		ParserContext parserContext = new ParserContext(readerContext, delegate);
		BeanDefinition def = h.parse(element, parserContext);
	}
}