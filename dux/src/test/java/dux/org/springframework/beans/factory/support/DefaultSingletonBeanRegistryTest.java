package dux.org.springframework.beans.factory.support;

import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.beans.factory.config.SingletonBeanRegistryTest;
import dux.org.springframework.core.SimpleAliasRegistryTest;

@Topic(DefaultSingletonBeanRegistry.class)
@Prerequisites({ SimpleAliasRegistryTest.class, SingletonBeanRegistryTest.class })
public class DefaultSingletonBeanRegistryTest {

}
