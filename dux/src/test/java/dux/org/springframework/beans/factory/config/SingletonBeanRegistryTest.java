package dux.org.springframework.beans.factory.config;

import org.junit.Test;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(SingletonBeanRegistry.class)
public class SingletonBeanRegistryTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * org.springframework.beans.factory.config.SingletonBeanRegistry allows the
		 * definition of singleton beans
		 */

		/*
		 * registerSingleton(String, Object) register the provided object with the
		 * provided name
		 */

		/*
		 * containsSingleton(String) tells whether a singleton bean with that name
		 * exists
		 */

		/*
		 * getSingletonCount() returns the number of singleton beans
		 */

		/*
		 * and getSingletonNames() return their names
		 */

		/*
		 * getSingletonMutex() is used for synchronization and concurrency safety
		 * (guess)
		 */

		DefaultSingletonBeanRegistry bf = new DefaultSingletonBeanRegistry();

		String beanName = "bean";
		Object singletonObject = new Object();

		bf.registerSingleton(beanName, singletonObject);

		aeqr(singletonObject, bf.getSingleton(beanName));

		aeq(true, bf.containsSingleton(beanName));

		aeq(1, bf.getSingletonNames().length);
		aeq("bean", bf.getSingletonNames()[0]);

		aeq(1, bf.getSingletonCount());

		ann(bf.getSingletonMutex());

	}
}
