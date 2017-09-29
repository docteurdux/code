package duu.org.springframework.beans.factory.xml;

import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.ParserContext;

public class ParserContextUtils {

	public static ParserContext getParserContext() {
		return new ParserContext(XmlReaderContextUtils.getReaderContext(),
				new BeanDefinitionParserDelegate(XmlReaderContextUtils.getReaderContext()));
	}

}
