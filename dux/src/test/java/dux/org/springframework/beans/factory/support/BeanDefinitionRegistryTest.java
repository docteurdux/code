package dux.org.springframework.beans.factory.support;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.beans.factory.config.BeanDefinitionTest;
import dux.org.springframework.core.AliasRegistryTest;

@Topic(BeanDefinitionRegistry.class)
@Prerequisites({ AliasRegistryTest.class, BeanDefinitionTest.class })
public class BeanDefinitionRegistryTest {

}
