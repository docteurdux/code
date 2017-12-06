package dux.org.springframework.context;

import org.springframework.context.ConfigurableApplicationContext;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.java.io.CloseableTest;

@Topic(ConfigurableApplicationContext.class)
@Prerequisites({ ApplicationContextTest.class, LifecycleTest.class, CloseableTest.class })
public class ConfigurableApplicationContextTest {

}
