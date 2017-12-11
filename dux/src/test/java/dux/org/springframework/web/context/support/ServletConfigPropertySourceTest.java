package dux.org.springframework.web.context.support;

import javax.servlet.ServletConfig;

import org.junit.Test;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.web.context.support.ServletConfigPropertySource;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(ServletConfigPropertySource.class)
public class ServletConfigPropertySourceTest extends AbstractTest {
	@Test
	public void test() {

		ServletConfig servletConfig = new MockServletConfig();
		ServletConfigPropertySource s = new ServletConfigPropertySource("name", servletConfig);

	}
}
