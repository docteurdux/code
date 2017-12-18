package dux.org.springframework.web.servlet.i18n;

import java.time.ZoneId;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.context.i18n.SimpleTimeZoneAwareLocaleContext;
import org.springframework.context.i18n.TimeZoneAwareLocaleContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.i18n.AbstractLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.web.servlet.LocaleResolverTest;

@Topic(SessionLocaleResolver.class)
@Related({ LocaleResolverTest.class, AbstractLocaleResolver.class, AbstractLocaleContextResolverTest.class })
public class SessionLocaleResolverTest extends AbstractTest {
	@Test
	public void test() {

		aeq("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE",
				SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);

		aeq("org.springframework.web.servlet.i18n.SessionLocaleResolver.TIME_ZONE",
				SessionLocaleResolver.TIME_ZONE_SESSION_ATTRIBUTE_NAME);

		SessionLocaleResolver r = new SessionLocaleResolver();

		Locale locale = Locale.GERMAN;
		TimeZone timeZone = new SimpleTimeZone(0, "EST");

		HttpServletRequest request = new MockHttpServletRequest();
		request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
		request.getSession().setAttribute(SessionLocaleResolver.TIME_ZONE_SESSION_ATTRIBUTE_NAME, timeZone);

		HttpServletResponse response = new MockHttpServletResponse();

		aeqr(locale, r.resolveLocale(request));

		TimeZoneAwareLocaleContext localeContext = (TimeZoneAwareLocaleContext) r.resolveLocaleContext(request);
		aeqr(locale, localeContext.getLocale());
		aeqr(timeZone, localeContext.getTimeZone());

		Locale locale2 = Locale.CANADA;
		TimeZone timeZone2 = new SimpleTimeZone(0, "ECT");
		SimpleTimeZoneAwareLocaleContext localContext2 = new SimpleTimeZoneAwareLocaleContext(locale2, timeZone2);
		r.setLocaleContext(request, response, localContext2);
		aeqr(locale2, request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME));
		aeqr(timeZone2, request.getSession().getAttribute(SessionLocaleResolver.TIME_ZONE_SESSION_ATTRIBUTE_NAME));

		// r.setLocaleAttributeName(localeAttributeName);
		// r.setTimeZoneAttributeName(timeZoneAttributeName);

	}
}
