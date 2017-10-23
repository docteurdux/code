package dux.org.springframework.core.annotation;

import org.junit.Test;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

public class AnnotationAwareOrderComparatorTest {
	@Test
	public void test() {
		AnnotationAwareOrderComparator.sort(new Object[] {});
	}
}
