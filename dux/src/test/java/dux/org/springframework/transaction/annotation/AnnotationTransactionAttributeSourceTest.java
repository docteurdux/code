package dux.org.springframework.transaction.annotation;

import java.util.Set;

import org.junit.Test;
import org.springframework.transaction.annotation.AnnotationTransactionAttributeSource;
import org.springframework.transaction.annotation.TransactionAnnotationParser;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(AnnotationTransactionAttributeSource.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class AnnotationTransactionAttributeSourceTest extends AbstractTest {
	@Test
	public void test() {

		boolean publicMethodsOnly = false;
		Set<TransactionAnnotationParser> annotationParsers = null;
		TransactionAnnotationParser annotationParser = null;
		TransactionAnnotationParser annotationParser1 = null;
		TransactionAnnotationParser annotationParser2 = null;

		AnnotationTransactionAttributeSource s = new AnnotationTransactionAttributeSource();
		s = new AnnotationTransactionAttributeSource(publicMethodsOnly);
		s = new AnnotationTransactionAttributeSource(annotationParsers);
		s = new AnnotationTransactionAttributeSource(annotationParser);
		s = new AnnotationTransactionAttributeSource(annotationParser1, annotationParser2);

	}
}
