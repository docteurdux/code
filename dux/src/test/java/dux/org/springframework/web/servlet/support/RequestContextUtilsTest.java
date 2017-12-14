package dux.org.springframework.web.servlet.support;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(RequestContextUtils.class)
public class RequestContextUtilsTest extends AbstractTest {
	@Test
	public void test() {

		HttpServletRequest request = new MockHttpServletRequest();
		ServletContext servletContext = new MockServletContext();
		String location = "location";
		HttpServletResponse response = new MockHttpServletResponse();

		RequestContextUtils.findWebApplicationContext(request);
		RequestContextUtils.findWebApplicationContext(request, servletContext);
		RequestContextUtils.getFlashMapManager(request);
		RequestContextUtils.getInputFlashMap(request);
		RequestContextUtils.getLocale(request);
		RequestContextUtils.getLocaleResolver(request);
		RequestContextUtils.getOutputFlashMap(request);
		RequestContextUtils.getTheme(request);
		RequestContextUtils.getThemeResolver(request);
		RequestContextUtils.getThemeSource(request);
		RequestContextUtils.getTimeZone(request);
		RequestContextUtils.saveOutputFlashMap(location, request, response);

		/*-
		findWebApplicationContext(HttpServletRequest)
		findWebApplicationContext(HttpServletRequest, ServletContext)
		getFlashMapManager(HttpServletRequest)
		getInputFlashMap(HttpServletRequest)
		getLocale(HttpServletRequest)
		getLocaleResolver(HttpServletRequest)
		getOutputFlashMap(HttpServletRequest)
		getTheme(HttpServletRequest)
		getThemeResolver(HttpServletRequest)
		getThemeSource(HttpServletRequest)
		getTimeZone(HttpServletRequest)
		saveOutputFlashMap(String, HttpServletRequest, HttpServletResponse)
		 */
	}
}
