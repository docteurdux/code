package dux.org.springframework.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.junit.Test;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockFilterConfig;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.StandardServletEnvironment;
import org.springframework.web.filter.GenericFilterBean;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.security.web.authentication.logout.LogoutFilterTest;

@Topic(GenericFilterBean.class)
@Related({ LogoutFilterTest.class })
public class GenericFilterBeanTest extends AbstractTest {
	@Test
	public void test() throws ServletException {

		StandardServletEnvironment environment = new StandardServletEnvironment();
		MockServletContext servletContext = new MockServletContext();
		FilterConfig filterConfig = new MockFilterConfig();

		GenericFilterBean f = new GenericFilterBean() {
			@Override
			public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
					throws IOException, ServletException {
			}
		};

		f.setBeanName("beanName");
		f.setEnvironment(environment);
		f.setServletContext(servletContext);

		f.afterPropertiesSet();

		f.init(filterConfig);

		aeqr(filterConfig, f.getFilterConfig());
		aeq(environment, f.getEnvironment());

		f.destroy();
		/*-
		getEnvironment()
		getFilterConfig()
		init(FilterConfig)
		 */
	}
}
