package dux.org.springframework.context;

import org.springframework.context.ConfigurableApplicationContext;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.java.io.CloseableTest;
import dux.org.springframework.core.env.ConfigurableEnvironmentTest;

@Topic(ConfigurableApplicationContext.class)
@Prerequisites({ ApplicationContextTest.class, LifecycleTest.class, CloseableTest.class,
		ConfigurableEnvironmentTest.class })
public class ConfigurableApplicationContextTest {

}
