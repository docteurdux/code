package dux.org.springframework.http.converter;

import org.junit.Test;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.GenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(HttpMessageConverter.class)
@Extends({})
@ExtendedBy({ AbstractHttpMessageConverter.class, BufferedImageHttpMessageConverter.class,
		FormHttpMessageConverter.class, GenericHttpMessageConverter.class })
@Related({})
public class HttpMessageConverterTest extends AbstractTest {
	@Test
	public void test() {

	}
}
