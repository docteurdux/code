package dux.org.springframework.web.bind;

import org.junit.Test;
import org.springframework.web.bind.WebDataBinder;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(WebDataBinder.class)
public class WebDataBinderTest extends AbstractTest {
	@Test
	public void test() {
		Object target = new Object();
		WebDataBinder wdb = new WebDataBinder(target);
		/*-
		WebDataBinder(Object)
		WebDataBinder(Object, String)
		getFieldDefaultPrefix()
		getFieldMarkerPrefix()
		isBindEmptyMultipartFiles()
		setBindEmptyMultipartFiles(boolean)
		setFieldDefaultPrefix(String)
		setFieldMarkerPrefix(String)
		 */

	}
}
