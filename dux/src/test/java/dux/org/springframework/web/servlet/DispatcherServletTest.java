package dux.org.springframework.web.servlet;

import org.junit.Test;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Topic;

@Topic(DispatcherServlet.class)
@Extends(FrameworkServletTest.class)
public class DispatcherServletTest extends AbstractTest {
	@Test
	public void test() {
		WebApplicationContext webApplicationContext= null;
		DispatcherServlet s = new DispatcherServlet(webApplicationContext);
	}
}
