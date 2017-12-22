package dux.org.springframework.web.servlet.mvc.method.annotation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.RequestPartMethodArgumentResolver;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.web.method.support.HandlerMethodArgumentResolverTest;

@Topic(AbstractMessageConverterMethodArgumentResolver.class)
@Extends({ HandlerMethodArgumentResolverTest.class })
@ExtendedBy({ AbstractMessageConverterMethodProcessor.class, RequestPartMethodArgumentResolver.class })
@Related({HttpMessageConverter.class})
public class AbstractMessageConverterMethodArgumentResolverTest extends AbstractTest {
	@Test
	public void test() {
		List<HttpMessageConverter<?>> converters = new ArrayList<>();
		List<Object> requestResponseBodyAdvice = new ArrayList<>();
		AbstractMessageConverterMethodArgumentResolver r = new A(converters, requestResponseBodyAdvice);
	}

	private static class A extends AbstractMessageConverterMethodArgumentResolver {

		public A(List<HttpMessageConverter<?>> converters, List<Object> requestResponseBodyAdvice) {
			super(converters, requestResponseBodyAdvice);
			// TODO Auto-generated constructor stub
		}

		@Override
		public boolean supportsParameter(MethodParameter parameter) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
				NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}

	}
}