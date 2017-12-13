package dux.org.springframework.web.bind;

import org.junit.Test;
import org.springframework.web.bind.ServletRequestParameterPropertyValues;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.beans.MutablePropertyValuesTest;

@Topic(ServletRequestParameterPropertyValues.class)
@Related({ MutablePropertyValuesTest.class })
public class ServletRequestParameterPropertyValuesTest extends AbstractTest {

	@Test
	public void test() {
		/*-
		ServletRequestParameterPropertyValues(ServletRequest)
		ServletRequestParameterPropertyValues(ServletRequest, String)
		ServletRequestParameterPropertyValues(ServletRequest, String, String)
		 */
	}
}
