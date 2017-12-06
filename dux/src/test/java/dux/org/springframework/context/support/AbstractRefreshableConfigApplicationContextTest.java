package dux.org.springframework.context.support;

import org.springframework.context.support.AbstractRefreshableConfigApplicationContext;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.beans.factory.BeanNameAwareTest;
import dux.org.springframework.beans.factory.InitializingBeanTest;

@Topic(AbstractRefreshableConfigApplicationContext.class)
@Prerequisites({ AbstractRefreshableApplicationContextTest.class, BeanNameAwareTest.class, InitializingBeanTest.class })
public class AbstractRefreshableConfigApplicationContextTest {

}
