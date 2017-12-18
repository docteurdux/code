package dux.org.springframework.web.method.support;

import org.junit.Test;
import org.springframework.security.web.bind.support.AuthenticationPrincipalArgumentResolver;
import org.springframework.security.web.method.annotation.CsrfTokenArgumentResolver;
import org.springframework.web.method.annotation.AbstractCookieValueMethodArgumentResolver;
import org.springframework.web.method.annotation.AbstractNamedValueMethodArgumentResolver;
import org.springframework.web.method.annotation.AbstractWebArgumentResolverAdapter;
import org.springframework.web.method.annotation.ErrorsMethodArgumentResolver;
import org.springframework.web.method.annotation.ExpressionValueMethodArgumentResolver;
import org.springframework.web.method.annotation.MapMethodProcessor;
import org.springframework.web.method.annotation.ModelAttributeMethodProcessor;
import org.springframework.web.method.annotation.ModelMethodProcessor;
import org.springframework.web.method.annotation.RequestHeaderMethodArgumentResolver;
import org.springframework.web.method.annotation.RequestParamMapMethodArgumentResolver;
import org.springframework.web.method.annotation.RequestParamMethodArgumentResolver;
import org.springframework.web.method.annotation.SessionStatusMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.HttpEntityMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.MatrixVariableMapMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.MatrixVariableMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.PathVariableMapMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.PathVariableMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.RedirectAttributesMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestPartMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.ServletCookieValueMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.ServletRequestMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletResponseMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletWebArgumentResolverAdapter;
import org.springframework.web.servlet.mvc.method.annotation.SessionAttributeMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.UriComponentsBuilderMethodArgumentResolver;

import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(HandlerMethodArgumentResolver.class)
@Related({ AbstractMessageConverterMethodArgumentResolver.class, AbstractMessageConverterMethodProcessor.class,
		HttpEntityMethodProcessor.class, RequestResponseBodyMethodProcessor.class,
		RequestPartMethodArgumentResolver.class, AbstractNamedValueMethodArgumentResolver.class,
		AbstractCookieValueMethodArgumentResolver.class, ServletCookieValueMethodArgumentResolver.class,
		ExpressionValueMethodArgumentResolver.class, MatrixVariableMethodArgumentResolver.class,
		PathVariableMethodArgumentResolver.class, RedirectAttributesMethodArgumentResolver.class,
		RequestHeaderMethodArgumentResolver.class, RequestParamMethodArgumentResolver.class,
		SessionAttributeMethodArgumentResolver.class, AbstractWebArgumentResolverAdapter.class,
		ServletWebArgumentResolverAdapter.class, AuthenticationPrincipalArgumentResolver.class,
		org.springframework.security.web.method.annotation.AuthenticationPrincipalArgumentResolver.class,
		CsrfTokenArgumentResolver.class, ErrorsMethodArgumentResolver.class,
		HandlerMethodArgumentResolverComposite.class, MapMethodProcessor.class,
		MatrixVariableMapMethodArgumentResolver.class, ModelAttributeMethodProcessor.class,
		ServletModelAttributeMethodProcessor.class, ModelMethodProcessor.class,
		PathVariableMapMethodArgumentResolver.class, RedirectAttributesMethodArgumentResolver.class,
		RedirectAttributesMethodArgumentResolver.class, RequestParamMapMethodArgumentResolver.class,
		ServletRequestMethodArgumentResolver.class, ServletResponseMethodArgumentResolver.class,
		SessionStatusMethodArgumentResolver.class, UriComponentsBuilderMethodArgumentResolver.class })
public class HandlerMethodArgumentResolverTest {
	@Test
	public void test() {

	}
}
