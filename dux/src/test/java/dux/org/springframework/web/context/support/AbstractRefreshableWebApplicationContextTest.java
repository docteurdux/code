package dux.org.springframework.web.context.support;

import org.springframework.web.context.support.AbstractRefreshableWebApplicationContext;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.context.support.AbstractRefreshableConfigApplicationContextTest;
import dux.org.springframework.ui.context.ThemeSourceTest;

@Topic(AbstractRefreshableWebApplicationContext.class)
@Prerequisites({ AbstractRefreshableConfigApplicationContextTest.class, ConfigurableWebApplicationContextTest.class,
		ThemeSourceTest.class })
public class AbstractRefreshableWebApplicationContextTest {

}
