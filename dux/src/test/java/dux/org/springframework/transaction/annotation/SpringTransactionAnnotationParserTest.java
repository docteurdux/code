package dux.org.springframework.transaction.annotation;

import java.lang.reflect.AnnotatedElement;

import org.junit.Test;
import org.springframework.transaction.annotation.SpringTransactionAnnotationParser;
import org.springframework.transaction.annotation.Transactional;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(SpringTransactionAnnotationParser.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class SpringTransactionAnnotationParserTest extends AbstractTest {
	@Test
	public void test() {

		AnnotatedElement ae = null;
		Transactional ann = null;

		SpringTransactionAnnotationParser p = new SpringTransactionAnnotationParser();
		p.parseTransactionAnnotation(ae);
		p.parseTransactionAnnotation(ann);

	}
}