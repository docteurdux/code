package dux.org.springframework.web.servlet.handler;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.handler.SimpleServletHandlerAdapter;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.Topic;

import dux.javax.servlet.ServletTest;
import dux.org.springframework.web.servlet.HandlerAdapterTest;

@Topic(SimpleServletHandlerAdapter.class)
@Related({ HandlerAdapterTest.class, ServletTest.class })
public class SimpleServletHandlerAdapterTest extends AbstractTest {

	private boolean requestHandled;

	@Test
	public void test() throws Exception {
		SimpleServletHandlerAdapter a = new SimpleServletHandlerAdapter();

		Servlet handler = Recorder.create(Servlet.class).r("service", new RunnableWithArgs<Void>() {
			@Override
			public Void run(Object... args) {
				requestHandled = true;
				return null;
			}
		}).p();

		a.supports(handler);

		HttpServletRequest request = new MockHttpServletRequest();
		HttpServletResponse response = new MockHttpServletResponse();

		aeq(false, requestHandled);
		aeq(null, a.handle(request, response, handler));
		aeq(true, requestHandled);
	}
}
