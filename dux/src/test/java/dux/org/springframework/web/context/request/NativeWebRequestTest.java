package dux.org.springframework.web.context.request;

import org.junit.Test;
import org.springframework.web.context.request.NativeWebRequest;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.web.context.request.async.AsyncWebRequestTest;

@Topic(NativeWebRequest.class)
@Related({ WebRequestTest.class, FacesWebRequestTest.class, ServletWebRequestTest.class, AsyncWebRequestTest.class })
public class NativeWebRequestTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		getNativeRequest()
		getNativeRequest(Class<T>)
		getNativeResponse()
		getNativeResponse(Class<T>)
		 */
	}
}
