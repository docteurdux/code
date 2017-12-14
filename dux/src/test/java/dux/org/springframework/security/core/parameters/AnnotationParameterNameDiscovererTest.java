package dux.org.springframework.security.core.parameters;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.security.core.parameters.AnnotationParameterNameDiscoverer;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(AnnotationParameterNameDiscoverer.class)
public class AnnotationParameterNameDiscovererTest extends AbstractTest {
	@Test
	public void test() {
		Set<String> annotationClassesToUse = new HashSet<>();
		AnnotationParameterNameDiscoverer d = new AnnotationParameterNameDiscoverer(annotationClassesToUse);
		
		
	}
}
