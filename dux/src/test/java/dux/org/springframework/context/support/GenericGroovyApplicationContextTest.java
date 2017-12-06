package dux.org.springframework.context.support;

import org.springframework.context.support.GenericGroovyApplicationContext;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.groovy.lang.GroovyObjectTest;

@Topic(GenericGroovyApplicationContext.class)
@Prerequisites({ GenericApplicationContextTest.class, GroovyObjectTest.class })
public class GenericGroovyApplicationContextTest {

}
