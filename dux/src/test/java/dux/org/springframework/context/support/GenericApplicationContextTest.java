package dux.org.springframework.context.support;

import org.springframework.context.support.GenericApplicationContext;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.beans.factory.support.BeanDefinitionRegistryTest;

@Topic(GenericApplicationContext.class)
@Prerequisites({ AbstractApplicationContextTest.class, BeanDefinitionRegistryTest.class })
public class GenericApplicationContextTest {

}
