package dux.org.springframework.transaction.annotation;

import java.lang.reflect.AnnotatedElement;

import org.junit.Test;
import org.springframework.transaction.annotation.Ejb3TransactionAnnotationParser;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(Ejb3TransactionAnnotationParser.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class Ejb3TransactionAnnotationParserTest extends AbstractTest {
	@Test
	public void test() {

		AnnotatedElement ae = null;
		AnnotatedElement ann = null;

		Ejb3TransactionAnnotationParser p = new Ejb3TransactionAnnotationParser();
		p.parseTransactionAnnotation(ae);
		p.parseTransactionAnnotation(ann);

	}
}