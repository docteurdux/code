package dux.org.springframework.context.i18n;

import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import org.junit.Test;
import org.springframework.context.i18n.SimpleTimeZoneAwareLocaleContext;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(SimpleTimeZoneAwareLocaleContext.class)
public class SimpleTimeZoneAwareLocaleContextTest extends AbstractTest {
	@Test
	public void test() {
		Locale locale = Locale.GERMAN;
		TimeZone timeZone = new SimpleTimeZone(0, "EST");
		SimpleTimeZoneAwareLocaleContext c = new SimpleTimeZoneAwareLocaleContext(locale, timeZone);
		aeqr(locale, c.getLocale());
		aeqr(timeZone, c.getTimeZone());
	}
}
