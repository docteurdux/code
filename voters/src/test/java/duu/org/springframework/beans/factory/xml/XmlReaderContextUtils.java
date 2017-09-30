package duu.org.springframework.beans.factory.xml;

import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.beans.factory.parsing.FailFastProblemReporter;
import org.springframework.beans.factory.parsing.NullSourceExtractor;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.DefaultNamespaceHandlerResolver;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlReaderContext;
import org.springframework.core.io.ByteArrayResource;

public class XmlReaderContextUtils {

	public static XmlReaderContext getReaderContext() {
		return new XmlReaderContext(new ByteArrayResource(new byte[] {}), new FailFastProblemReporter(),
				new EmptyReaderEventListener(), new NullSourceExtractor(),
				new XmlBeanDefinitionReader(new SimpleBeanDefinitionRegistry()), new DefaultNamespaceHandlerResolver());
	}

}
