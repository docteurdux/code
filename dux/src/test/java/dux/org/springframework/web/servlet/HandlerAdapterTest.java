package dux.org.springframework.web.servlet;

import org.junit.Test;
import org.springframework.web.servlet.HandlerAdapter;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.web.servlet.handler.SimpleServletHandlerAdapterTest;
import dux.org.springframework.web.servlet.mvc.HttpRequestHandlerAdapterTest;
import dux.org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapterTest;

@Topic(HandlerAdapter.class)
@Related({ HttpRequestHandlerAdapterTest.class, SimpleControllerHandlerAdapterTest.class,
		SimpleServletHandlerAdapterTest.class })
public class HandlerAdapterTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		getLastModified(HttpServletRequest, Object)
		handle(HttpServletRequest, HttpServletResponse, Object)
		supports(Object)
		 */
	}

}
