package dux.org.springframework.web.context;

import javax.servlet.ServletContext;

import org.junit.Test;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.StaticWebApplicationContext;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.context.ApplicationContextTest;

@Topic(WebApplicationContext.class)
@Prerequisites(ApplicationContextTest.class)
public class WebApplicationContextTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * The org.springframework.web.context.WebApplicationContext only define the
		 * getServletContext() method which returns instances of
		 * javax.servlet.ServletContext
		 */

		/*
		 * As an example,
		 * org.springframework.web.context.support.StaticWebApplicationContext
		 * implements WebApplicationContext
		 */

		StaticWebApplicationContext c = new StaticWebApplicationContext();

		/* Initially, the servlet context is null */
		aeq(null, c.getServletContext());

		/* But for StaticWebApplicationContext, it can be set */
		ServletContext servletContext = new MockServletContext();
		c.setServletContext(servletContext);

		/* Things are as expected */
		aeqr(servletContext, c.getServletContext());

		/* The interface also defines the following constants */

		aeq("org.springframework.web.context.WebApplicationContext.ROOT",
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);

		aeq("contextAttributes", WebApplicationContext.CONTEXT_ATTRIBUTES_BEAN_NAME);
		aeq("contextParameters", WebApplicationContext.CONTEXT_PARAMETERS_BEAN_NAME);

		aeq("servletContext", WebApplicationContext.SERVLET_CONTEXT_BEAN_NAME);

		aeq("application", WebApplicationContext.SCOPE_APPLICATION);
		aeq("globalSession", WebApplicationContext.SCOPE_GLOBAL_SESSION);
		aeq("request", WebApplicationContext.SCOPE_REQUEST);
		aeq("session", WebApplicationContext.SCOPE_SESSION);

	}
}
