package dux.org.springframework.web.servlet.mvc.method.annotation;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.security.Principal;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jetty.server.PushBuilder;
import org.junit.Test;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.DispatcherServletWebRequest;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletRequestMethodArgumentResolver;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(ServletRequestMethodArgumentResolver.class)
public class ServletRequestMethodArgumentResolverTest extends AbstractTest {

	private static class C {
		@SuppressWarnings("unused")
		public void m1(WebRequest p) {

		}

		@SuppressWarnings("unused")
		public void m2(ServletRequest p) {

		}

		@SuppressWarnings("unused")
		public void m3(MultipartRequest p) {

		}

		@SuppressWarnings("unused")
		public void m4(HttpSession p) {

		}

		@SuppressWarnings("unused")
		public void m5(PushBuilder p) {

		}

		@SuppressWarnings("unused")
		public void m6(Principal p) {

		}

		@SuppressWarnings("unused")
		public void m7(InputStream p) {

		}

		@SuppressWarnings("unused")
		public void m8(Reader p) {

		}

		@SuppressWarnings("unused")
		public void m9(HttpMethod p) {

		}

		@SuppressWarnings("unused")
		public void m10(Locale p) {

		}

		@SuppressWarnings("unused")
		public void m11(TimeZone p) {

		}

		@SuppressWarnings("unused")
		public void m12(ZoneId p) {

		}
	}

	@Test
	public void test() throws Exception {

		ServletRequestMethodArgumentResolver resolver = new ServletRequestMethodArgumentResolver();

		Principal principal = new TestingAuthenticationToken(new Object(), new Object());

		Locale locale = Locale.GERMAN;
		TimeZone timeZone = new SimpleTimeZone(0, "EST");
		LocaleResolver localeResolver = new CookieLocaleResolver();

		MockMultipartHttpServletRequest httpServletRequest = new MockMultipartHttpServletRequest();
		HttpSession httpSession = httpServletRequest.getSession();
		httpServletRequest.setUserPrincipal(principal);
		httpServletRequest.setMethod("GET");
		httpServletRequest.setAttribute(DispatcherServlet.LOCALE_RESOLVER_ATTRIBUTE, localeResolver);
		httpServletRequest.setAttribute(CookieLocaleResolver.LOCALE_REQUEST_ATTRIBUTE_NAME, locale);
		httpServletRequest.setAttribute(CookieLocaleResolver.TIME_ZONE_REQUEST_ATTRIBUTE_NAME, timeZone);

		HttpServletResponse httpServletResponse = new MockHttpServletResponse();

		NativeWebRequest nativeWebRequest = new DispatcherServletWebRequest(httpServletRequest, httpServletResponse);

		MethodParameter webRequestParameter = getMethodParameter(WebRequest.class);
		aeq(true, resolver.supportsParameter(webRequestParameter));
		aeqr(nativeWebRequest, resolver.resolveArgument(webRequestParameter, null, nativeWebRequest, null));

		MethodParameter servletRequestParameter = getMethodParameter(ServletRequest.class);
		aeq(true, resolver.supportsParameter(servletRequestParameter));
		aeqr(httpServletRequest, resolver.resolveArgument(servletRequestParameter, null, nativeWebRequest, null));

		MethodParameter multipartRequestParameter = getMethodParameter(MultipartRequest.class);
		aeq(true, resolver.supportsParameter(multipartRequestParameter));
		aeq(httpServletRequest, resolver.resolveArgument(multipartRequestParameter, null, nativeWebRequest, null));

		MethodParameter httpSessionParameter = getMethodParameter(HttpSession.class);
		aeq(true, resolver.supportsParameter(httpSessionParameter));
		aeqr(httpSession, resolver.resolveArgument(httpSessionParameter, null, nativeWebRequest, null));

		MethodParameter pushBuilderParameter = getMethodParameter(PushBuilder.class);
		aeq(false, resolver.supportsParameter(pushBuilderParameter));

		MethodParameter principalParameter = getMethodParameter(Principal.class);
		aeq(true, resolver.supportsParameter(principalParameter));
		aeq(principal, resolver.resolveArgument(principalParameter, null, nativeWebRequest, null));

		MethodParameter inputStreamParameter = getMethodParameter(InputStream.class);
		aeq(true, resolver.supportsParameter(inputStreamParameter));
		aeq(httpServletRequest.getInputStream(),
				resolver.resolveArgument(inputStreamParameter, null, nativeWebRequest, null));

		MethodParameter readerParameter = getMethodParameter(Reader.class);
		aeq(true, resolver.supportsParameter(readerParameter));
		aeq(httpServletRequest.getReader(), resolver.resolveArgument(readerParameter, null, nativeWebRequest, null));

		MethodParameter httpMethodParameter = getMethodParameter(HttpMethod.class);
		aeq(true, resolver.supportsParameter(httpMethodParameter));
		aeq(HttpMethod.GET, resolver.resolveArgument(httpMethodParameter, null, nativeWebRequest, null));

		MethodParameter localeParameter = getMethodParameter(Locale.class);
		aeq(true, resolver.supportsParameter(localeParameter));
		aeq(locale, resolver.resolveArgument(localeParameter, null, nativeWebRequest, null));

		MethodParameter timeZoneParameter = getMethodParameter(TimeZone.class);
		aeq(true, resolver.supportsParameter(timeZoneParameter));
		aeqr(timeZone, resolver.resolveArgument(timeZoneParameter, null, nativeWebRequest, null));

		MethodParameter zoneIdParameter = getMethodParameter(ZoneId.class);
		aeq(true, resolver.supportsParameter(zoneIdParameter));
		aeq(-18000, ((ZoneOffset) (resolver.resolveArgument(zoneIdParameter, null, nativeWebRequest, null)))
				.getTotalSeconds());

	}

	private MethodParameter getMethodParameter(Class<?> clazz) {
		for (Method method : C.class.getMethods()) {
			boolean classOk = method.getDeclaringClass().equals(C.class);
			boolean parameterCountOk = method.getParameterCount() == 1;
			boolean parameterClassOk = method.getParameterTypes()[0].equals(clazz);
			if (classOk && parameterCountOk && parameterClassOk) {
				return MethodParameter.forExecutable(method, 0);
			}
		}
		return null;
	}
}
