package dux.org.springframework.web.context;

import org.junit.Test;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.ContextLoaderListener;

public class ContextLoaderListenerTest {
	@Test
	public void test() {
		ContextLoaderListener listener = new ContextLoaderListener();
		MockServletContext servletContext = new MockServletContext();
		servletContext.setInitParameter("contextConfigLocation", "spring-security.xml");
		listener.initWebApplicationContext(servletContext);
	}
}
