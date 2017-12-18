package dux.org.springframework.validation;

import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(BeanPropertyBindingResult.class)
public class BeanPropertyBindingResultTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		BeanPropertyBindingResult(Object, String)
		BeanPropertyBindingResult(Object, String, boolean, int)
		getPropertyAccessor()
		getTarget()
		 */
	}
}
