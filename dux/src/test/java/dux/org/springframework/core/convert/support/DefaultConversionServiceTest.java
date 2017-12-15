package dux.org.springframework.core.convert.support;

import org.junit.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(DefaultConversionService.class)
public class DefaultConversionServiceTest extends AbstractTest {
	@Test
	public void test() {
		
		DefaultConversionService s = new DefaultConversionService();

		/*-
		addCollectionConverters(ConverterRegistry)
		addDefaultConverters(ConverterRegistry)
		getSharedInstance()
		 */
	}
}
