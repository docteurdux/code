package dux.org.springframework.http.converter;

import java.awt.image.BufferedImage;

import org.junit.Test;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(BufferedImageHttpMessageConverter.class)
@Extends({HttpMessageConverterTest.class})
@ExtendedBy({})
@Related({BufferedImage.class})
public class BufferedImageHttpMessageConverterTest extends AbstractTest {
	@Test
	public void test() {

	}
}
