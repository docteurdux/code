package dux.org.springframework.web.servlet.i18n;

import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import org.junit.Test;
import org.springframework.context.i18n.TimeZoneAwareLocaleContext;
import org.springframework.web.servlet.i18n.AbstractLocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.RunnableWhichThrow;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.web.servlet.LocaleResolverTest;

@Topic(FixedLocaleResolver.class)
@Related({ LocaleResolverTest.class, AbstractLocaleResolver.class, AbstractLocaleContextResolverTest.class })
public class FixedLocaleResolverTest extends AbstractTest {
	@Test
	public void test() {

		Locale locale = Locale.GERMAN;
		TimeZone timeZone = new SimpleTimeZone(0, "EST");
		FixedLocaleResolver resolver = new FixedLocaleResolver(locale, timeZone);

		aeqr(locale, resolver.resolveLocale(null));

		TimeZoneAwareLocaleContext localeContext = (TimeZoneAwareLocaleContext) resolver.resolveLocaleContext(null);
		aeqr(locale, localeContext.getLocale());
		aeqr(timeZone, localeContext.getTimeZone());

		expect(UnsupportedOperationException.class, new RunnableWhichThrow() {
			@Override
			public void run() throws Throwable {
				resolver.setLocaleContext(null, null, null);
			}

			@Override
			public void inspect(Throwable e) {
				e.getMessage().startsWith("Cannot change fixed locale");
			}
		});
	}
}
