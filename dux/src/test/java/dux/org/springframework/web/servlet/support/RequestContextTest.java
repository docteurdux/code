package dux.org.springframework.web.servlet.support;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.context.MessageSource;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.springframework.ui.context.Theme;
import org.springframework.ui.context.support.SimpleTheme;
import org.springframework.web.servlet.support.RequestContext;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.ui.context.ThemeTest;

@Topic(RequestContext.class)
@Related(ThemeTest.class)
public class RequestContextTest extends AbstractTest {
	@Test
	public void test() {

		HttpServletRequest request = new MockHttpServletRequest();
		HttpServletResponse response = new MockHttpServletResponse();
		ServletContext servletContext = new MockServletContext();
		Map<String, Object> model = new HashMap<String, Object>();
		RequestContext c = new RequestContext(request, response, servletContext, model);
		
		MessageSource messageSource = new StaticMessageSource();
		Theme theme = new SimpleTheme("name", messageSource );
		c.changeTheme(theme );
		

		/*-
		RequestContext(HttpServletRequest)
		RequestContext(HttpServletRequest, Map<String, Object>)
		RequestContext(HttpServletRequest, HttpServletResponse)
		RequestContext(HttpServletRequest, HttpServletResponse, ServletContext, Map<String, Object>)
		RequestContext(HttpServletRequest, ServletContext)
		changeLocale(Locale)
		changeLocale(Locale, TimeZone)
		changeTheme(String)
		changeTheme(Theme)
		getBindStatus(String)
		getBindStatus(String, boolean)
		getContextPath()
		getContextUrl(String)
		getContextUrl(String, Map<String, ?>)
		getDefaultHtmlEscape()
		getErrors(String)
		getErrors(String, boolean)
		getLocale()
		getMessage(String)
		getMessage(String, Object[])
		getMessage(String, Object[], boolean)
		getMessage(String, Object[], String)
		getMessage(String, Object[], String, boolean)
		getMessage(String, String)
		getMessage(String, List<?>)
		getMessage(String, List<?>, String)
		getMessage(MessageSourceResolvable)
		getMessage(MessageSourceResolvable, boolean)
		getMessageSource()
		getModel()
		getPathToServlet()
		getQueryString()
		getRequestDataValueProcessor()
		getRequestUri()
		getResponseEncodedHtmlEscape()
		getTheme()
		getThemeMessage(String)
		getThemeMessage(String, Object[])
		getThemeMessage(String, Object[], String)
		getThemeMessage(String, String)
		getThemeMessage(String, List<?>)
		getThemeMessage(String, List<?>, String)
		getThemeMessage(MessageSourceResolvable)
		getTimeZone()
		getUrlPathHelper()
		getWebApplicationContext()
		isDefaultHtmlEscape()
		isResponseEncodedHtmlEscape()
		setDefaultHtmlEscape(boolean)
		setUrlPathHelper(UrlPathHelper)
		 */

	}
}
