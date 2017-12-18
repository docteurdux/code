package dux.org.springframework.web.servlet.mvc.method.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.core.MethodParameter;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.bind.support.DefaultDataBinderFactory;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.handler.DispatcherServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ServletRequestMethodArgumentResolver;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(ServletRequestMethodArgumentResolver.class)
public class ServletRequestMethodArgumentResolverTest extends AbstractTest {
	@Test
	public void test() throws Exception {
		ServletRequestMethodArgumentResolver r = new ServletRequestMethodArgumentResolver();
		MethodParameter parameter = null;
		ModelAndViewContainer mavContainer = new ModelAndViewContainer();
		HttpServletRequest request = new MockHttpServletRequest();
		HttpServletResponse response = new MockHttpServletResponse();
		NativeWebRequest webRequest = new DispatcherServletWebRequest(request, response);
		WebBindingInitializer initializer = new ConfigurableWebBindingInitializer();
		WebDataBinderFactory binderFactory = new DefaultDataBinderFactory(initializer);
		r.supportsParameter(parameter);
		r.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
	}
}
