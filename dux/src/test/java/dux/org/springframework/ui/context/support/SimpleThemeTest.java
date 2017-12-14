package dux.org.springframework.ui.context.support;

import org.junit.Test;
import org.springframework.context.MessageSource;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.ui.context.support.SimpleTheme;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.ui.context.ThemeTest;

@Topic(SimpleTheme.class)
@Related(ThemeTest.class)
public class SimpleThemeTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * org.springframework.ui.context.support.SimpleTheme is the most simple
		 * implementation of org.springframework.ui.context.Theme possible
		 */

		/* Spring does not define any other implementation of the Theme interface */

		MessageSource messageSource = new StaticMessageSource();
		SimpleTheme theme = new SimpleTheme("name", messageSource);

		aeq("name", theme.getName());
		aeqr(messageSource, theme.getMessageSource());
	}
}
