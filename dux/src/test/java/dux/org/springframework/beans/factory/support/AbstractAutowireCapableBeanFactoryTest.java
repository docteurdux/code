package dux.org.springframework.beans.factory.support;

import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.beans.factory.config.AutowireCapableBeanFactoryTest;

@Topic(AbstractAutowireCapableBeanFactory.class)
@Prerequisites({ AbstractBeanFactoryTest.class, AutowireCapableBeanFactoryTest.class })
public class AbstractAutowireCapableBeanFactoryTest {

}
