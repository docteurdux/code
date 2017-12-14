package dux.org.springframework.web.context.request;

import org.junit.Test;
import org.springframework.web.context.request.ServletWebRequest;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ServletWebRequest.class)
@Related({ ServletRequestAttributesTest.class, NativeWebRequestTest.class })
public class ServletWebRequestTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		ServletWebRequest(HttpServletRequest)
		ServletWebRequest(HttpServletRequest, HttpServletResponse)
		checkNotModified(String)
		checkNotModified(String, long)
		checkNotModified(long)
		getContextPath()
		getDescription(boolean)
		getHeader(String)
		getHeaderNames()
		getHeaderValues(String)
		getHttpMethod()
		getLocale()
		getNativeRequest()
		getNativeRequest(Class<T>)
		getNativeResponse()
		getNativeResponse(Class<T>)
		getParameter(String)
		getParameterMap()
		getParameterNames()
		getParameterValues(String)
		getRemoteUser()
		getUserPrincipal()
		isNotModified()
		isSecure()
		isUserInRole(String)
		toString()
		 */
	}
}
