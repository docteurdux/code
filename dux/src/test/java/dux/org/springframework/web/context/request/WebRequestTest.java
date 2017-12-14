package dux.org.springframework.web.context.request;

import org.junit.Test;
import org.springframework.web.context.request.WebRequest;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(WebRequest.class)
@Related({ RequestAttributesTest.class, NativeWebRequestTest.class })
public class WebRequestTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		checkNotModified(String)
		checkNotModified(String, long)
		checkNotModified(long)
		getContextPath()
		getDescription(boolean)
		getHeader(String)
		getHeaderNames()
		getHeaderValues(String)
		getLocale()
		getParameter(String)
		getParameterMap()
		getParameterNames()
		getParameterValues(String)
		getRemoteUser()
		getUserPrincipal()
		isSecure()
		isUserInRole(String)
		 */
	}
}
