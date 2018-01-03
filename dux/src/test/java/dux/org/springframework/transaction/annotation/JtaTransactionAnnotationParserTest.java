package dux.org.springframework.transaction.annotation;

import java.lang.reflect.AnnotatedElement;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.transaction.annotation.JtaTransactionAnnotationParser;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(JtaTransactionAnnotationParser.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class JtaTransactionAnnotationParserTest extends AbstractTest {
	@Test
	public void test() {
		AnnotatedElement ae = null;
		Transactional ann = null;

		JtaTransactionAnnotationParser p = new JtaTransactionAnnotationParser();
		p.parseTransactionAnnotation(ae);
		p.parseTransactionAnnotation(ann);
	}
}