package dux.org.springframework.web.servlet.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.web.servlet.HandlerAdapterTest;

@Topic(SimpleControllerHandlerAdapter.class)
@Related({ HandlerAdapterTest.class, ControllerTest.class })
public class SimpleControllerHandlerAdapterTest extends AbstractTest {
	@Test
	public void test() throws Exception {

		SimpleControllerHandlerAdapter a = new SimpleControllerHandlerAdapter();

		ModelAndView mav = new ModelAndView();

		Controller handler = Recorder.create(Controller.class).r("handleRequest", new RunnableWithArgs<ModelAndView>() {
			@Override
			public ModelAndView run(Object... args) {
				return mav;
			}
		}).p();

		aeq(true, a.supports(handler));

		HttpServletRequest request = new MockHttpServletRequest();
		HttpServletResponse response = new MockHttpServletResponse();
		aeqr(mav, a.handle(request, response, handler));
	}
}
