package dux.org.springframework.web.servlet;

import org.junit.Test;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AbstractLocaleContextResolver;
import org.springframework.web.servlet.i18n.AbstractLocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.web.servlet.i18n.FixedLocaleResolverTest;
import dux.org.springframework.web.servlet.i18n.SessionLocaleResolverTest;

@Topic(LocaleResolver.class)
@Related({ AbstractLocaleResolver.class, AbstractLocaleContextResolver.class, FixedLocaleResolverTest.class,
		SessionLocaleResolverTest.class, AcceptHeaderLocaleResolver.class, CookieLocaleResolver.class })
public class LocaleResolverTest extends AbstractTest {
	@Test
	public void test() {

	}
}
