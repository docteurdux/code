package dux.org.springframework.web.context.support;

import javax.servlet.ServletConfig;

import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource.StubPropertySource;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.ServletConfigPropertySource;
import org.springframework.web.context.support.ServletContextPropertySource;
import org.springframework.web.context.support.StandardServletEnvironment;
import org.springframework.web.context.support.StaticWebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.RunnableWhichThrow;
import com.github.docteurdux.test.Topic;

@Topic(WebApplicationContextUtils.class)
public class WebApplicationContextUtilsTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * org.springframework.web.context.support.WebApplicationContextUtils contains
		 * utilities to
		 */

		/*-
		- retrieve application context from servlet context
		- something 1
		- something 2
		 */

		/* Let's create a mock servlet context */
		MockServletContext servletContext = new MockServletContext();

		/*
		 * The web application context is expected to be found on a predefined servlet
		 * context attribute
		 */
		String name = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
		aeq("org.springframework.web.context.WebApplicationContext.ROOT", name);

		/*
		 * The most genereal method allows getting the web application context from any
		 * attribute. We'll use the default name here.
		 */

		/* If the attribute is null, the returned value is null */
		aeq(null, WebApplicationContextUtils.getWebApplicationContext(servletContext, name));

		/*
		 * Spring also handle cases where the attribute actually contains errors and
		 * exceptions, which are rethrown and possibly modified
		 */

		/* Instances of java.lang.RuntimeException are rethrown */
		RuntimeException runtimeException = new RuntimeException();
		servletContext.setAttribute(name, runtimeException);
		expect(new RunnableWhichThrow() {
			@Override
			public void run() throws Exception {
				WebApplicationContextUtils.getWebApplicationContext(servletContext, name);
			}

			@Override
			public void inspect(Throwable e) {
				aeqr(runtimeException, e);
			}
		});

		/* Instances of java.lang.Error are rethrown */
		Error error = new Error();
		servletContext.setAttribute(name, error);
		expect(new RunnableWhichThrow() {
			@Override
			public void run() throws Exception {
				WebApplicationContextUtils.getWebApplicationContext(servletContext, name);
			}

			@Override
			public void inspect(Throwable e) {
				aeqr(error, e);
			}
		});

		/* Other exceptions are encapsulated in a java.lang.IllegalStateException */
		Exception exception = new Exception();
		servletContext.setAttribute(name, exception);
		expect(new RunnableWhichThrow() {
			@Override
			public void run() throws Exception {
				WebApplicationContextUtils.getWebApplicationContext(servletContext, name);
			}

			@Override
			public void inspect(Throwable e) {
				aeqr(exception, ((IllegalStateException) e).getCause());
			}
		});

		/* Objects of unexpected types trigger a java.lang.IllegalStateException */
		servletContext.setAttribute(name, new Object());
		expect(new RunnableWhichThrow() {
			@Override
			public void run() throws Exception {
				WebApplicationContextUtils.getWebApplicationContext(servletContext, name);
			}

			@Override
			public void inspect(Throwable e) {
				aeq(true, ((IllegalStateException) e).getMessage()
						.startsWith("Context attribute is not of type WebApplicationContext: "));
			}
		});

		/* When the type is correct, things are as expected */
		WebApplicationContext applicationContext = new StaticWebApplicationContext();
		servletContext.setAttribute(name, applicationContext);
		aeqr(applicationContext, WebApplicationContextUtils.getWebApplicationContext(servletContext, name));

		/* If the attribute name is not specified, it uses the default attribute */
		aeqr(applicationContext, WebApplicationContextUtils.getWebApplicationContext(servletContext));

		/*
		 * findWebApplicationContext() scan all attributes for an instance of
		 * org.springframework.web.context.WebApplicationContext
		 */
		servletContext.setAttribute(name, null);
		servletContext.setAttribute("other1", applicationContext);
		aeqr(applicationContext, WebApplicationContextUtils.findWebApplicationContext(servletContext));

		/*
		 * If more than one attribute match, an java.lang.IllegalStateException is
		 * thrown
		 */
		servletContext.setAttribute("other2", applicationContext);
		expect(IllegalStateException.class, new RunnableWhichThrow() {
			@Override
			public void run() throws Throwable {
				WebApplicationContextUtils.findWebApplicationContext(servletContext);
			}

			@Override
			public void inspect(Throwable e) {
				aeq(true, e.getMessage().startsWith("No unique WebApplicationContext found:"));
			}
		});

		/*
		 * But if the attribute with the default name matches, other attributes are not
		 * checked
		 */
		servletContext.setAttribute(name, applicationContext);
		aeqr(applicationContext, WebApplicationContextUtils.findWebApplicationContext(servletContext));

		/*
		 * getRequiredWebApplicationContext returns the applicationContext under the
		 * default name
		 */
		servletContext.setAttribute(name, applicationContext);
		aeqr(applicationContext, WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext));

		/* And throws if it is not found, without checking other attributes */
		servletContext.setAttribute(name, null);
		expect(IllegalStateException.class, new RunnableWhichThrow() {
			@Override
			public void run() throws Throwable {
				WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
			}

			@Override
			public void inspect(Throwable e) {
				aeq(true, e.getMessage().startsWith("No WebApplicationContext found"));
			}
		});

		/*
		 * Now we switch our attention to initServletPropertySources(), which handles
		 * the initialization of the property sources associated with
		 * "servletContextInitParams" and "servletConfigInitParams"
		 */

		aeq("servletContextInitParams", StandardServletEnvironment.SERVLET_CONTEXT_PROPERTY_SOURCE_NAME);
		aeq("servletConfigInitParams", StandardServletEnvironment.SERVLET_CONFIG_PROPERTY_SOURCE_NAME);
		String sContextPSN = "servletContextInitParams";
		String sConfigPSN = "servletConfigInitParams";

		/*
		 * First, if no property sources are registered under those names,
		 * initServletPropertySources() does nothing
		 */
		MutablePropertySources propertySources = new MutablePropertySources();
		ServletConfig servletConfig = new MockServletConfig();
		WebApplicationContextUtils.initServletPropertySources(propertySources, servletContext, servletConfig);
		aeq(0, propertySources.size());

		/*
		 * If the propertySources contains stubs under those names, they are replaced
		 * with real ones
		 */
		StubPropertySource ssContextPS = new StubPropertySource(sContextPSN);
		StubPropertySource ssConfigPS = new StubPropertySource(sConfigPSN);
		propertySources.addLast(ssContextPS);
		propertySources.addLast(ssConfigPS);

		ServletContextPropertySource sContextPS = (ServletContextPropertySource) propertySources.get(sContextPSN);
		ServletConfigPropertySource sConfigPS = (ServletConfigPropertySource) propertySources.get(sConfigPSN);

		/*
		 * If the propertySources already registered are not stubs, they are left
		 * untouched
		 */

		WebApplicationContextUtils.initServletPropertySources(propertySources, servletContext, servletConfig);

		aeqr(sContextPS, propertySources.get(sContextPSN));
		aeqr(sConfigPS, propertySources.get(sConfigPSN));

		/*
		 * Stubs are not replaced when the servlet context or the servlet config is null
		 */

		propertySources.replace(sContextPSN, ssContextPS);
		propertySources.replace(sConfigPSN, ssConfigPS);

		WebApplicationContextUtils.initServletPropertySources(propertySources, null, null);

		aeqr(ssContextPS, propertySources.get(sContextPSN));
		aeqr(ssConfigPS, propertySources.get(sConfigPSN));

		/*
		 * The treatment of the servlet context and the servlet config are independent,
		 * and the other initServletPropertySources() variant just set the servlet
		 * config to null
		 */

		WebApplicationContextUtils.initServletPropertySources(propertySources, servletContext);
		aeq(ServletContextPropertySource.class, propertySources.get(sContextPSN).getClass());
		aeqr(ssConfigPS, propertySources.get(sConfigPSN));

		if (t()) {
			return;
		}

		WebApplicationContext.SERVLET_CONTEXT_BEAN_NAME.length();
		ConfigurableWebApplicationContext.SERVLET_CONFIG_BEAN_NAME.length();
		WebApplicationContext.CONTEXT_PARAMETERS_BEAN_NAME.length();
		WebApplicationContext.CONTEXT_ATTRIBUTES_BEAN_NAME.length();
		
		WebApplicationContext.SCOPE_REQUEST.length();
		WebApplicationContext.SCOPE_SESSION.length();
		WebApplicationContext.SCOPE_GLOBAL_SESSION.length();
		WebApplicationContext.SCOPE_APPLICATION.length();
		
		ConfigurableListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		WebApplicationContextUtils.registerEnvironmentBeans(beanFactory, servletContext);
		WebApplicationContextUtils.registerEnvironmentBeans(beanFactory, servletContext, servletConfig);
		WebApplicationContextUtils.registerWebApplicationScopes(beanFactory);
		WebApplicationContextUtils.registerWebApplicationScopes(beanFactory, servletContext);

		/*-
		findWebApplicationContext(ServletContext)
		getRequiredWebApplicationContext(ServletContext)
		getWebApplicationContext(ServletContext)
		getWebApplicationContext(ServletContext, String)
		initServletPropertySources(MutablePropertySources, ServletContext)
		initServletPropertySources(MutablePropertySources, ServletContext, ServletConfig)
		registerEnvironmentBeans(ConfigurableListableBeanFactory, ServletContext)
		registerEnvironmentBeans(ConfigurableListableBeanFactory, ServletContext, ServletConfig)
		registerWebApplicationScopes(ConfigurableListableBeanFactory)
		registerWebApplicationScopes(ConfigurableListableBeanFactory, ServletContext)
		 */
	}
}
