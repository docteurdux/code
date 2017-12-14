package dux.org.springframework.web.context.request;

import org.junit.Test;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(RequestContextHolder.class)
public class RequestContextHolderTest extends AbstractTest {
	@Test
	public void test() {

		RequestAttributes attributes = null;
		boolean inheritable = false;

		RequestContextHolder.currentRequestAttributes();
		RequestContextHolder.getRequestAttributes();
		RequestContextHolder.resetRequestAttributes();
		RequestContextHolder.setRequestAttributes(attributes);
		RequestContextHolder.setRequestAttributes(attributes, inheritable);

	}
}
