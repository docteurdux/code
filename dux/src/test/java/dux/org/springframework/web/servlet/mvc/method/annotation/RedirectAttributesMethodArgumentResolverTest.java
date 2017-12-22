package dux.org.springframework.web.servlet.mvc.method.annotation;

import org.junit.Test;
import org.springframework.core.MethodParameter;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.bind.support.DefaultDataBinderFactory;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.handler.DispatcherServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.RedirectAttributesMethodArgumentResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.web.method.support.HandlerMethodArgumentResolverTest;

@Topic(RedirectAttributesMethodArgumentResolver.class)
@Extends({ HandlerMethodArgumentResolverTest.class })
@ExtendedBy({})
@Related({})
public class RedirectAttributesMethodArgumentResolverTest extends AbstractTest {

	private static class C {
		public void method(RedirectAttributes attributes) {

		}
	}

	@Test
	public void test() throws Exception {
		RedirectAttributesMethodArgumentResolver r = new RedirectAttributesMethodArgumentResolver();
		MethodParameter parameter = MethodParameter.forExecutable(C.class.getMethod("method", RedirectAttributes.class),
				0);
		r.supportsParameter(parameter);
		ModelAndViewContainer mavContainer = new ModelAndViewContainer();
		mavContainer.setRedirectModelScenario(true);
		NativeWebRequest webRequest = new DispatcherServletWebRequest(new MockHttpServletRequest(),
				new MockHttpServletResponse());
		WebDataBinderFactory binderFactory = new DefaultDataBinderFactory(new ConfigurableWebBindingInitializer());
		r.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
		mavContainer.getModel().containsKey("hello");
	}
}
