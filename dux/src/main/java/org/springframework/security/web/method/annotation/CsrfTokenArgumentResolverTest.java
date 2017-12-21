package org.springframework.security.web.method.annotation;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.MethodParameter;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.handler.DispatcherServletWebRequest;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.web.method.support.HandlerMethodArgumentResolverTest;

@Topic(CsrfTokenArgumentResolver.class)
@Extends({ HandlerMethodArgumentResolverTest.class })
@ExtendedBy({})
@Related({})
public class CsrfTokenArgumentResolverTest extends AbstractTest {

	private MethodParameter methodParameter;
	private NativeWebRequest request;
	private String csrfTokenRequestAttributeName;
	private int csrfTokenRequestAttributeScope;

	private static class C {
		@SuppressWarnings("unused")
		public void method(CsrfToken token) {

		}
	}

	@Before
	public void before() throws NoSuchMethodException, SecurityException {

		methodParameter = MethodParameter.forExecutable(C.class.getMethod("method", CsrfToken.class), 0);
		request = new DispatcherServletWebRequest(new MockHttpServletRequest(), new MockHttpServletResponse());

		csrfTokenRequestAttributeName = CsrfToken.class.getName();
		csrfTokenRequestAttributeScope = NativeWebRequest.SCOPE_REQUEST;

	}

	@Test
	public void test() throws Exception {

		CsrfToken token = new DefaultCsrfToken("h", "p", "t");
		request.setAttribute(csrfTokenRequestAttributeName, token, csrfTokenRequestAttributeScope);

		CsrfTokenArgumentResolver r = new CsrfTokenArgumentResolver();
		aeq(true, r.supportsParameter(methodParameter));
		aeqr(token, r.resolveArgument(methodParameter, null, request, null));
	}
}