package dux.org.springframework.web.context.request;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(ServletRequestAttributes.class)
@Related({ AbstractRequestAttributesTest.class, ServletWebRequestTest.class })
public class ServletRequestAttributesTest extends AbstractTest {
	@Test
	public void test() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		ServletRequestAttributes a = new ServletRequestAttributes(request, response);

		aeqr(request, a.getRequest());
		aeqr(response, a.getResponse());

		aeq(true, request.getSession(false) == null);
		aeq("1", a.getSessionId());
		aeq(false, request.getSession(false) == null);

		if (t()) {
			return;
		}

		String name = null;
		int scope = 0;
		Runnable callback = null;
		String key = null;
		Object value = null;
		a.getAttribute(name, scope);
		a.getAttributeNames(scope);
		a.getSessionMutex();
		a.registerDestructionCallback(name, callback, scope);
		a.removeAttribute(name, scope);
		a.resolveReference(key);
		a.setAttribute(name, value, scope);
		a.toString();

		/*-
		ServletRequestAttributes(HttpServletRequest)
		ServletRequestAttributes(HttpServletRequest, HttpServletResponse)
		getAttribute(String, int)
		getAttributeNames(int)
		getRequest()
		getResponse()
		getSessionId()
		getSessionMutex()
		registerDestructionCallback(String, Runnable, int)
		removeAttribute(String, int)
		resolveReference(String)
		setAttribute(String, Object, int)
		toString() 
		 */
	}
}
