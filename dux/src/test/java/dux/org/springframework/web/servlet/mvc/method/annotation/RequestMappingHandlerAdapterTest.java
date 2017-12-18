package dux.org.springframework.web.servlet.mvc.method.annotation;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapterTest;

@Topic(RequestMappingHandlerAdapter.class)
@Related({ AbstractHandlerMethodAdapterTest.class })
public class RequestMappingHandlerAdapterTest extends AbstractTest {
	@Test
	public void test() throws Exception {
		RequestMappingHandlerAdapter a = new RequestMappingHandlerAdapter();
		Bean bean = new Bean();
		Method method = Bean.class.getMethod("method");
		HandlerMethod handler = new HandlerMethod(bean, method);
		aeq(true, a.supports(handler));
		HttpServletRequest request = new MockHttpServletRequest();
		HttpServletResponse response = new MockHttpServletResponse();
		a.handle(request, response, handler);
	}

	private static class Bean {
		@SuppressWarnings("unused")
		public void method() {

		}
	}
}
