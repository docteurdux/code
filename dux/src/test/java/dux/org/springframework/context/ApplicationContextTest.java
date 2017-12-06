package dux.org.springframework.context;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.beans.factory.HierarchicalBeanFactoryTest;
import dux.org.springframework.beans.factory.ListableBeanFactoryTest;
import dux.org.springframework.core.env.EnvironmentCapableTest;

@Topic(ApplicationContext.class)
@Prerequisites({ EnvironmentCapableTest.class, ListableBeanFactoryTest.class, HierarchicalBeanFactoryTest.class,
		MessageSourceTest.class, ApplicationEventPublisherTest.class, ResourcePatternResolver.class })
public class ApplicationContextTest {

	@Test
	public void test() {

		/*
		 * One of Spring's core very important interface is
		 * org.springframework.context.ApplicationContext. It is also quite complex for
		 * at least two reasons.
		 * 
		 * First, the interface extends a quite deep interface hierarchy, which includes
		 * the notions such as environments, bean factories, message sources, event
		 * publishers and resource pattern resolvers.
		 * 
		 * Second, actual implementation of this interface are quite numerous and relies
		 * on other interfaces themselves.
		 * 
		 * 
		 */

	}
}
