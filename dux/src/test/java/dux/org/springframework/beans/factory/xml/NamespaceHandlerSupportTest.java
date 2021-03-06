package dux.org.springframework.beans.factory.xml;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(NamespaceHandlerSupport.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class NamespaceHandlerSupportTest extends AbstractTest {
	@Test
	public void test() {
		NamespaceHandlerSupport s = new NamespaceHandlerSupport() {
			@Override
			public void init() {
			}
		};

		/*-
		decorate(Node, BeanDefinitionHolder, ParserContext)
		parse(Element, ParserContext)
		 */

		Node node = null;
		BeanDefinitionHolder definition = null;
		ParserContext parserContext = null;
		Element element = null;
		s.decorate(node, definition, parserContext);
		s.parse(element, parserContext);

	}
}