package dux.org.springframework.beans.factory.support;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.java.io.SerializableTest;
import dux.org.springframework.beans.factory.config.ConfigurableListableBeanFactoryTest;

@Topic(DefaultListableBeanFactory.class)
@Prerequisites({ AbstractAutowireCapableBeanFactoryTest.class, ConfigurableListableBeanFactoryTest.class,
		BeanDefinitionRegistryTest.class, SerializableTest.class })
public class DefaultListableBeanFactoryTest {

}
