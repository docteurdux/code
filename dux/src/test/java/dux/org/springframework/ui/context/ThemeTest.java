package dux.org.springframework.ui.context;

import org.junit.Test;
import org.springframework.context.MessageSource;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.ui.context.Theme;
import org.springframework.ui.context.support.SimpleTheme;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.context.MessageSourceTest;
import dux.org.springframework.ui.context.support.SimpleThemeTest;

@Topic(Theme.class)
@Prerequisites(MessageSourceTest.class)
@Related(SimpleThemeTest.class)
public class ThemeTest extends AbstractTest {
	@Test
	public void test() {

		/* A org.springframework.ui.context.Theme has a name and a message source */

		/* org.springframework.ui.context.support.SimpleTheme implements Theme */

		MessageSource messageSource = new StaticMessageSource();
		SimpleTheme theme = new SimpleTheme("name", messageSource);

		aeq("name", theme.getName());
		aeqr(messageSource, theme.getMessageSource());

	}
}
