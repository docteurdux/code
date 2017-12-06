package dux.org.springframework.beans.factory.support;

import org.springframework.beans.factory.support.AbstractBeanFactory;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.beans.factory.config.ConfigurableBeanFactoryTest;

@Topic(AbstractBeanFactory.class)
@Prerequisites({ FactoryBeanRegistrySupportTest.class, ConfigurableBeanFactoryTest.class })
public class AbstractBeanFactoryTest {

}
