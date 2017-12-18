package dux.org.springframework.web.servlet.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.web.HttpRequestHandlerTest;
import dux.org.springframework.web.servlet.HandlerAdapterTest;

@Topic(HttpRequestHandlerAdapter.class)
@Related({ HandlerAdapterTest.class, HttpRequestHandlerTest.class })
public class HttpRequestHandlerAdapterTest extends AbstractTest {

	boolean requestHandled = false;

	@Test
	public void test() throws Exception {

		ModelAndView mav = new ModelAndView();

		HttpRequestHandlerAdapter a = new HttpRequestHandlerAdapter();
		HttpRequestHandler handler = Recorder.create(HttpRequestHandler.class)
				.r("handle", new RunnableWithArgs<ModelAndView>() {
					@Override
					public ModelAndView run(Object... args) {
						requestHandled = true;
						return mav;
					}
				}).p();

		aeq(true, a.supports(handler));

		HttpServletRequest request = new MockHttpServletRequest();
		HttpServletResponse response = new MockHttpServletResponse();

		aeq(false, requestHandled);
		aeq(null, a.handle(request, response, handler));
		aeq(true, requestHandled);

	}
}
