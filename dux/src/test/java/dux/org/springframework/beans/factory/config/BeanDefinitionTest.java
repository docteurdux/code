package dux.org.springframework.beans.factory.config;

import org.springframework.beans.factory.config.BeanDefinition;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.beans.BeanMetadataElementTest;
import dux.org.springframework.core.AttributeAccessorTest;

@Topic(BeanDefinition.class)
@Prerequisites({ AttributeAccessorTest.class, BeanMetadataElementTest.class })
public class BeanDefinitionTest {

}
