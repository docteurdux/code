package dux.org.springframework.beans.factory.xml;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.xml.BeanDefinitionDecorator;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Node;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(BeanDefinitionDecorator.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class BeanDefinitionDecoratorTest extends AbstractTest {
	@Test
	public void test() {
		Node node = null;
		BeanDefinitionHolder definition = null;
		ParserContext parserContext = null;
		BeanDefinitionDecorator d = Recorder.create(BeanDefinitionDecorator.class).p();
		d.decorate(node, definition, parserContext);
	}
}