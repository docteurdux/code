package dux.org.springframework.web.context.support;

import org.springframework.web.context.ConfigurableWebApplicationContext;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.context.ConfigurableApplicationContextTest;
import dux.org.springframework.web.context.WebApplicationContextTest;

@Topic(ConfigurableWebApplicationContext.class)
@Prerequisites({ WebApplicationContextTest.class, ConfigurableApplicationContextTest.class })
public class ConfigurableWebApplicationContextTest {

}
