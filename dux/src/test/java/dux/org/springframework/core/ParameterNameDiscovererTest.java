package dux.org.springframework.core;

import org.junit.Test;
import org.springframework.core.ParameterNameDiscoverer;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.security.core.parameters.AnnotationParameterNameDiscovererTest;

@Topic(ParameterNameDiscoverer.class)
@Related({ AnnotationParameterNameDiscovererTest.class })
public class ParameterNameDiscovererTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		getParameterNames(Constructor<?>)
		getParameterNames(Method)
		 */
	}
}
