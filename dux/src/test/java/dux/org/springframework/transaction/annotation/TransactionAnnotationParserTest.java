package dux.org.springframework.transaction.annotation;

import java.lang.reflect.AnnotatedElement;

import org.junit.Test;
import org.springframework.transaction.annotation.TransactionAnnotationParser;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(TransactionAnnotationParser.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class TransactionAnnotationParserTest extends AbstractTest {
	@Test
	public void test() {
		AnnotatedElement ae = null;
		TransactionAnnotationParser p = Recorder.create(TransactionAnnotationParser.class).p();
		p.parseTransactionAnnotation(ae);
	}
}