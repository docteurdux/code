package dux.org.springframework.context.support;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.beans.factory.DisposableBeanTest;
import dux.org.springframework.core.io.DefaultResourceLoaderTest;

@Topic(AbstractApplicationContext.class)
@Prerequisites({ DefaultResourceLoaderTest.class, ConfigurableApplicationContext.class, DisposableBeanTest.class })
public class AbstractApplicationContextTest {

}
