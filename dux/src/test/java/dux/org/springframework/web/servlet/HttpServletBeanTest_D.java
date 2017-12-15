package dux.org.springframework.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.junit.Test;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.StandardServletEnvironment;
import org.springframework.web.servlet.HttpServletBean;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.beans.BeanWrapperImplTest;

@Done
@Topic(HttpServletBean.class)
@Related({ BeanWrapperImplTest.class })
public class HttpServletBeanTest_D extends AbstractTest {
	@Test
	public void test() throws ServletException {

		/*
		 * org.springframework.web.servlet.HttpServletBean provides the basis for
		 * configuring servlet using bean services
		 */

		B b = new B();

		/*
		 * Here, we create a new servlet bean which has the "foo" required property, as
		 * specified in the constructor of B, and we initialize the servlet with that
		 * config
		 */
		ServletContext context = new MockServletContext();
		MockServletConfig config = new MockServletConfig(context, "servletName");
		config.addInitParameter("foo", "value");
		b.init(config);

		/*
		 * A lot of things can happen here. In particular, the String "value" was
		 * automatically converted using Foo(String) constructor. A lot of conversion
		 * mechanisms are possible.
		 */

		aeq("value", b.getFoo().getValue());

		/*
		 * The default environment is an instance of
		 * org.springframework.web.context.support.StandardServletEnvironment
		 */
		aeq(StandardServletEnvironment.class, b.getEnvironment().getClass());

		/* A custom environment can be specified */
		StandardServletEnvironment environment = new StandardServletEnvironment();
		b.setEnvironment(environment);
		aeqr(environment, b.getEnvironment());

		/* And the servlet name is derived from the servlet config */
		aeq("servletName", b.getServletName());
	}

	private class B extends HttpServletBean {

		private static final long serialVersionUID = 1L;

		private Foo foo;

		public B() {
			addRequiredProperty("foo");
		}

		@SuppressWarnings("unused")
		public void setFoo(Foo foo) {
			this.foo = foo;
		}

		public Foo getFoo() {
			return foo;
		}

	}

	private static class Foo {

		private String value;

		public Foo(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

	}
}
