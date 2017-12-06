package dux.org.springframework.beans.factory.config;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.beans.factory.ListableBeanFactoryTest;

@Topic(ConfigurableListableBeanFactory.class)
@Prerequisites({ ListableBeanFactoryTest.class, AutowireCapableBeanFactoryTest.class,
		ConfigurableBeanFactoryTest.class })
public class ConfigurableListableBeanFactoryTest {

}
