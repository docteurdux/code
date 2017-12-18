package dux.org.springframework.web.servlet.mvc.method;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.web.method.HandlerMethodTest;
import dux.org.springframework.web.servlet.HandlerAdapterTest;

@Topic(AbstractHandlerMethodAdapter.class)
@Related({HandlerAdapterTest.class, HandlerMethodTest.class})
public class AbstractHandlerMethodAdapterTest extends AbstractTest {

	private static ModelAndView mav = new ModelAndView();

	@Test
	public void test() throws Exception {

		A a = new A();
		Bean bean = new Bean();
		Method method = Bean.class.getMethod("method");
		HandlerMethod handler = new HandlerMethod(bean, method);
		aeq(true, a.supports(handler));

		HttpServletRequest request = new MockHttpServletRequest();
		HttpServletResponse response = new MockHttpServletResponse();
		aeq(mav, a.handle(request, response, handler));

	}

	private static class Bean {
		@SuppressWarnings("unused")
		public void method() {

		}
	}

	private static class A extends AbstractHandlerMethodAdapter {

		@Override
		protected boolean supportsInternal(HandlerMethod handlerMethod) {
			return true;
		}

		@Override
		protected ModelAndView handleInternal(HttpServletRequest request, HttpServletResponse response,
				HandlerMethod handlerMethod) throws Exception {
			return mav;
		}

		@Override
		protected long getLastModifiedInternal(HttpServletRequest request, HandlerMethod handlerMethod) {
			return 0;
		}

	}
}
