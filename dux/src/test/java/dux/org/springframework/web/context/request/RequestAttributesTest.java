package dux.org.springframework.web.context.request;

import org.junit.Test;
import org.springframework.web.context.request.RequestAttributes;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(RequestAttributes.class)
@Related({ AbstractRequestAttributesTest.class, FacesRequestAttributesTest.class, WebRequestTest.class })
public class RequestAttributesTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		getAttribute(String, int)
		getAttributeNames(int)
		getSessionId()
		getSessionMutex()
		registerDestructionCallback(String, Runnable, int)
		removeAttribute(String, int)
		resolveReference(String)
		setAttribute(String, Object, int)
		 */
	}
}
