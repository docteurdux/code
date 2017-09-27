package dux.org.springframework.web.context;

import org.junit.Test;
import org.springframework.web.context.ContextLoaderListener;

import dux.javax.servlet.DummyServletContext;

public class ContextLoaderListenerTest {
	@Test
	public void test() {
		ContextLoaderListener listener = new ContextLoaderListener();
		DummyServletContext servletContext = new DummyServletContext();
		servletContext.setInitParameter("contextConfigLocation", "spring-security.xml");
		listener.initWebApplicationContext(servletContext);
	}
}
