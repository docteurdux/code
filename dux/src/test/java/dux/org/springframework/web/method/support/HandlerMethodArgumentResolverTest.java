package dux.org.springframework.web.method.support;

import org.junit.Test;
import org.springframework.security.web.method.annotation.CsrfTokenArgumentResolverTest;
import org.springframework.web.method.annotation.AbstractNamedValueMethodArgumentResolver;
import org.springframework.web.method.annotation.AbstractWebArgumentResolverAdapter;
import org.springframework.web.method.annotation.ErrorsMethodArgumentResolver;
import org.springframework.web.method.annotation.MapMethodProcessor;
import org.springframework.web.method.annotation.ModelAttributeMethodProcessor;
import org.springframework.web.method.annotation.ModelMethodProcessor;
import org.springframework.web.method.annotation.RequestHeaderMapMethodArgumentResolver;
import org.springframework.web.method.annotation.RequestParamMapMethodArgumentResolver;
import org.springframework.web.method.annotation.SessionStatusMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.MatrixVariableMapMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.PathVariableMapMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.RedirectAttributesMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletRequestMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletResponseMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.UriComponentsBuilderMethodArgumentResolver;

import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(HandlerMethodArgumentResolver.class)
@Related({})
@Extends({})
@ExtendedBy({ AbstractMessageConverterMethodArgumentResolver.class, AbstractNamedValueMethodArgumentResolver.class,
		AbstractWebArgumentResolverAdapter.class, CsrfTokenArgumentResolverTest.class, ErrorsMethodArgumentResolver.class,
		HandlerMethodArgumentResolverComposite.class, MapMethodProcessor.class,
		MatrixVariableMapMethodArgumentResolver.class, ModelAttributeMethodProcessor.class, ModelMethodProcessor.class,
		PathVariableMapMethodArgumentResolver.class, RedirectAttributesMethodArgumentResolver.class,
		RequestHeaderMapMethodArgumentResolver.class, RequestParamMapMethodArgumentResolver.class,
		ServletRequestMethodArgumentResolver.class, ServletResponseMethodArgumentResolver.class,
		SessionStatusMethodArgumentResolver.class, UriComponentsBuilderMethodArgumentResolver.class })
public class HandlerMethodArgumentResolverTest {
	@Test
	public void test() {

	}
}
