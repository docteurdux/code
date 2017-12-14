package dux.org.springframework.beans.factory;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(ObjectFactory.class)
public class ObjectFactoryTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * org.springframework.beans.factory.ObjectFactory defines the sole method
		 * getObject()
		 */

		/*
		 * All classes which implement this interface are private. An example is
		 * org.springframework.web.context.support.WebApplicationContextUtils.
		 * RequestObjectFactory
		 */

		ConfigurableListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		WebApplicationContextUtils.registerWebApplicationScopes(beanFactory);

	}
}
