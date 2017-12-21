package dux.org.springframework.web.servlet;

import org.junit.Test;
import org.springframework.context.ApplicationContextAwareTest;
import org.springframework.web.servlet.FrameworkServlet;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(FrameworkServlet.class)
@Related(DispatcherServletTest.class)
@Extends({HttpServletBeanTest_D.class, ApplicationContextAwareTest.class})
@ExtendedBy(DispatcherServletTest.class)
public class FrameworkServletTest extends AbstractTest {
	@Test
	public void test() {

	}
}
