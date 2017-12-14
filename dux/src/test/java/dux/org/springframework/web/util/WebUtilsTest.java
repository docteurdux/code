package dux.org.springframework.web.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.ServletResponse;
import javax.servlet.ServletResponseWrapper;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.http.HttpRequest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.util.WebUtils;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.RunnableWhichThrow;
import com.github.docteurdux.test.Topic;

@Topic(WebUtils.class)
public class WebUtilsTest extends AbstractTest {
	@Test
	@SuppressWarnings({ "deprecation" })
	public void test() throws FileNotFoundException {

		HttpSession session = new MockHttpSession();

		/* # getSessionMutex() */

		/*
		 * getSessionMutex() looks for the "org.springframework.web.util.WebUtils.MUTEX"
		 * session attribute
		 */

		String mutexSessionAttributeName = WebUtils.SESSION_MUTEX_ATTRIBUTE;
		aeq("org.springframework.web.util.WebUtils.MUTEX", mutexSessionAttributeName);

		/* If the attribute is not defined, the session itself acts as mutex */
		aeqr(session, WebUtils.getSessionMutex(session));

		/* Otherwise, the actual mutex is returned */
		Object sessionMutex = new Object();
		session.setAttribute(mutexSessionAttributeName, sessionMutex);
		aeqr(sessionMutex, WebUtils.getSessionMutex(session));

		/*
		 * # exposeErrorRequestAttributes() follows the Servlet 2.3 specification and
		 * clearErrorRequestAttributes() clears the corresponding attributes
		 */

		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setRequestURI("requestURI");
		Throwable exception = new Exception("exceptionMessage");
		String servletName = "servletName";

		/* The error attributes */
		aeq("javax.servlet.error.status_code", WebUtils.ERROR_STATUS_CODE_ATTRIBUTE);
		aeq("javax.servlet.error.exception_type", WebUtils.ERROR_EXCEPTION_TYPE_ATTRIBUTE);
		aeq("javax.servlet.error.message", WebUtils.ERROR_MESSAGE_ATTRIBUTE);
		aeq("javax.servlet.error.exception", WebUtils.ERROR_EXCEPTION_ATTRIBUTE);
		aeq("javax.servlet.error.request_uri", WebUtils.ERROR_REQUEST_URI_ATTRIBUTE);
		aeq("javax.servlet.error.servlet_name", WebUtils.ERROR_SERVLET_NAME_ATTRIBUTE);

		/* Setting them */
		WebUtils.exposeErrorRequestAttributes(request, exception, servletName);
		aeq(200, request.getAttribute("javax.servlet.error.status_code"));
		aeq(Exception.class, request.getAttribute("javax.servlet.error.exception_type"));
		aeq("exceptionMessage", request.getAttribute("javax.servlet.error.message"));
		aeqr(exception, request.getAttribute("javax.servlet.error.exception"));
		aeq("requestURI", request.getAttribute("javax.servlet.error.request_uri"));
		aeq("servletName", request.getAttribute("javax.servlet.error.servlet_name"));

		/* Clearing them */
		WebUtils.clearErrorRequestAttributes(request);
		aeq(null, request.getAttribute("javax.servlet.error.status_code"));
		aeq(null, request.getAttribute("javax.servlet.error.exception_type"));
		aeq(null, request.getAttribute("javax.servlet.error.message"));
		aeqr(null, request.getAttribute("javax.servlet.error.exception"));
		aeq(null, request.getAttribute("javax.servlet.error.request_uri"));
		aeq(null, request.getAttribute("javax.servlet.error.servlet_name"));

		/* Error attributes are set only if not already defined */
		request.setAttribute("javax.servlet.error.status_code", "a");
		request.setAttribute("javax.servlet.error.exception_type", "b");
		request.setAttribute("javax.servlet.error.message", "c");
		request.setAttribute("javax.servlet.error.exception", "d");
		request.setAttribute("javax.servlet.error.request_uri", "e");
		request.setAttribute("javax.servlet.error.servlet_name", "f");

		WebUtils.exposeErrorRequestAttributes(request, exception, servletName);

		aeq("a", request.getAttribute("javax.servlet.error.status_code"));
		aeq("b", request.getAttribute("javax.servlet.error.exception_type"));
		aeq("c", request.getAttribute("javax.servlet.error.message"));
		aeq("d", request.getAttribute("javax.servlet.error.exception"));
		aeq("e", request.getAttribute("javax.servlet.error.request_uri"));
		aeq("f", request.getAttribute("javax.servlet.error.servlet_name"));

		WebUtils.clearErrorRequestAttributes(request);

		/* # getDefaultHtmlEscape() */

		/*
		 * getDefaultHtmlEscape() returns the "defaultHtmlEscape" servlet init parameter
		 */

		aeq("defaultHtmlEscape", WebUtils.HTML_ESCAPE_CONTEXT_PARAM);

		MockServletContext servletContext = new MockServletContext();

		/* null when not defined */
		aeq(null, WebUtils.getDefaultHtmlEscape(servletContext));

		/* value of the parameter when defined */
		servletContext.setInitParameter("defaultHtmlEscape", "true");
		aeq(true, WebUtils.getDefaultHtmlEscape(servletContext));

		/* # getNativeRequest() and getNativeResponse() */

		/*
		 * Basically, these methods allow to walk down request wrappers to get to the
		 * underlying "native" request of the requested type
		 */

		/* Unspecified type yields null */
		MockHttpServletResponse response = new MockHttpServletResponse();
		aeq(null, WebUtils.getNativeRequest(request, null));
		aeq(null, WebUtils.getNativeResponse(response, null));

		/* Let's create two levels of wrapping */
		ServletRequestWrapper requestWrapper1 = new ServletRequestWrapper(request);
		ServletResponseWrapper responseWrapper1 = new ServletResponseWrapper(response);

		ServletRequestWrapper requestWrapper2 = new ServletRequestWrapper(requestWrapper1);
		ServletResponseWrapper responseWrapper2 = new ServletResponseWrapper(responseWrapper1);

		/* We can get the top wrapper if we ask for wrapper types */
		aeqr(requestWrapper2, WebUtils.getNativeRequest(requestWrapper2, ServletRequestWrapper.class));
		aeqr(responseWrapper2, WebUtils.getNativeResponse(responseWrapper2, ServletResponseWrapper.class));

		/* And the underlying request if we ask for its type */
		aeqr(request, WebUtils.getNativeRequest(requestWrapper2, MockHttpServletRequest.class));
		aeqr(response, WebUtils.getNativeResponse(responseWrapper2, MockHttpServletResponse.class));

		/*
		 * Because ServletRequestWrapper implements ServletRequest, this type always
		 * yields the wrapper, which means knowing the expected type is mandatory to get
		 * the underlying native request
		 */
		aeqr(requestWrapper2, WebUtils.getNativeRequest(requestWrapper2, ServletRequest.class));
		aeqr(responseWrapper2, WebUtils.getNativeResponse(responseWrapper2, ServletResponse.class));

		/*
		 * But since most request types implements HttpServletRequest, this type is
		 * usually good enough
		 */
		aeqr(request, WebUtils.getNativeRequest(requestWrapper2, HttpServletRequest.class));
		aeqr(response, WebUtils.getNativeResponse(responseWrapper2, HttpServletResponse.class));

		/* # getCookie() */

		/*
		 * Retrieves the cookie of the given name, which is surprisingly inconvenient to
		 * do manually
		 */

		Cookie cookie = new Cookie("cookieName", "cookieValue");
		request.setCookies(cookie);
		aeqr(cookie, WebUtils.getCookie(request, "cookieName"));

		/* # getSessionAttribute() */

		/*
		 * Returns the attribute on the session, and do not create a session if no
		 * session exists
		 */

		String attributeName = "attributeName";
		String attributeValue = "attributeValue";

		aeq(null, WebUtils.getSessionAttribute(request, attributeName));
		aeq(null, request.getSession(false));
		request.getSession().setAttribute(attributeName, attributeValue);
		aeq(attributeValue, WebUtils.getSessionAttribute(request, attributeName));
		request.setSession(null);

		/* # setSessionAttribute */

		/*
		 * If the value is not null, and no session exists, create a session and set the
		 * attribute
		 */
		aeq(null, request.getSession(false));
		WebUtils.setSessionAttribute(request, attributeName, attributeValue);
		aeq(attributeValue, request.getSession(false).getAttribute(attributeName));

		/*
		 * If the value is null, and a session exists, remove the attribute
		 */
		WebUtils.setSessionAttribute(request, attributeName, null);
		aeq(null, request.getSession(false).getAttribute(attributeName));

		/* But if the value is null and no session exists, do not create one */
		request.setSession(null);
		aeq(null, request.getSession(false));
		WebUtils.setSessionAttribute(request, attributeName, null);
		aeq(null, request.getSession(false));

		/* # getRequiredSessionAttribute() */

		/* Throws an exception the session is null or the session attribute is null */

		expect(IllegalStateException.class, new RunnableWhichThrow() {
			@Override
			public void run() throws Throwable {
				WebUtils.getRequiredSessionAttribute(request, attributeName);
			}

			@Override
			public void inspect(Throwable e) {
				aeq(true, e.getMessage().startsWith("No session attribute"));
			}
		});

		/* # getResponseEncodedHtmlEscape() */

		/* Just another boolean init servlet context parameter */

		aeq("responseEncodedHtmlEscape", WebUtils.RESPONSE_ENCODED_HTML_ESCAPE_CONTEXT_PARAM);

		aeq(null, WebUtils.getResponseEncodedHtmlEscape(null));
		aeq(null, WebUtils.getResponseEncodedHtmlEscape(servletContext));
		servletContext.setInitParameter("responseEncodedHtmlEscape", "true");
		aeq(true, WebUtils.getResponseEncodedHtmlEscape(servletContext));

		/* # hasSubmitParameter() */

		/*
		 * Returns true if request parameter is there, possibly suffixed with ".x" and
		 * ".y"
		 */

		aeq(false, WebUtils.hasSubmitParameter(request, "parameterName"));

		/* plain */
		request.setParameter("parameterName", "value");
		aeq(true, WebUtils.hasSubmitParameter(request, "parameterName"));
		request.removeParameter("parameterName");

		/* x suffix */
		request.setParameter("parameterName.x", "value");
		aeq(true, WebUtils.hasSubmitParameter(request, "parameterName"));
		request.removeParameter("parameterName.x");

		/* y suffix */
		request.setParameter("parameterName.y", "value");
		aeq(true, WebUtils.hasSubmitParameter(request, "parameterName"));
		request.removeParameter("parameterName.y");

		/* # getSessionId() */

		/* Returns the request session id or null */

		aeq(null, request.getSession(false));
		aeq(null, WebUtils.getSessionId(request));

		request.getSession();
		aeq("4", WebUtils.getSessionId(request));

		/* # getTempDir() */

		/* The servlet context attribute for temporary directories */

		aeq("javax.servlet.context.tempdir", WebUtils.TEMP_DIR_CONTEXT_ATTRIBUTE);

		File tempDirFile = new File("tempDir");
		servletContext.setAttribute("javax.servlet.context.tempdir", tempDirFile);
		aeq(tempDirFile, WebUtils.getTempDir(servletContext));

		/* # isIncludeRequest() */

		/* Included request are stored under this attribute */

		aeq("javax.servlet.include.request_uri", WebUtils.INCLUDE_REQUEST_URI_ATTRIBUTE);
		aeq(false, WebUtils.isIncludeRequest(request));
		request.setAttribute("javax.servlet.include.request_uri", new Object());
		aeq(true, WebUtils.isIncludeRequest(request));

		if (t()) {
			return;
		}

		Map<String, ?> attributes = null;
		String urlPath = null;
		Map<String, ?> parameters = null;
		String name = null;
		Class<?> clazz = null;
		String prefix = null;
		String path = null;
		String paramPrefix = null;
		int currentPage = 0;
		Collection<String> allowedOrigins = null;
		String matrixVariables = null;
		HttpRequest request1 = null;

		WebUtils.findParameterValue(parameters, name);
		WebUtils.findParameterValue(request, name);
		WebUtils.getParametersStartingWith(request, prefix);
		
		WebUtils.getRealPath(servletContext, path);

		WebUtils.isSameOrigin(request1);
		WebUtils.isValidOrigin(request1, allowedOrigins);
		
		WebUtils.parseMatrixVariables(matrixVariables);
		
		WebUtils.removeWebAppRootSystemProperty(servletContext);
		WebUtils.setWebAppRootSystemProperty(servletContext);
		
		WebUtils.exposeRequestAttributes(request, attributes);
		WebUtils.extractFilenameFromUrlPath(urlPath);
		WebUtils.extractFullFilenameFromUrlPath(urlPath);
		WebUtils.getOrCreateSessionAttribute(session, name, clazz);
		WebUtils.getTargetPage(request, paramPrefix, currentPage);
		WebUtils.isDefaultHtmlEscape(servletContext);

		/*-
		exposeRequestAttributes(ServletRequest, Map<String, ?>)
		extractFilenameFromUrlPath(String)
		extractFullFilenameFromUrlPath(String)
		findParameterValue(Map<String, ?>, String)
		findParameterValue(ServletRequest, String)
		getOrCreateSessionAttribute(HttpSession, String, Class<?>)
		getParametersStartingWith(ServletRequest, String)
		getRealPath(ServletContext, String)
		getTargetPage(ServletRequest, String, int)
		isDefaultHtmlEscape(ServletContext)
		isSameOrigin(HttpRequest)
		isValidOrigin(HttpRequest, Collection<String>)
		parseMatrixVariables(String)
		removeWebAppRootSystemProperty(ServletContext)
		setWebAppRootSystemProperty(ServletContext)
		 */

	}
}
