package dux.org.springframework.beans.factory;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.StaticListableBeanFactory;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

@Topic(HierarchicalBeanFactory.class)
@Prerequisites(BeanFactoryTest.class)
public class HierarchicalBeanFactoryTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * The org.springframework.beans.factory.HierarchicalBeanFactory interface
		 * extends org.springframework.beans.factory.BeanFactory with only two methods
		 */

		/* getParentBeanFactory() return the parent bean factory */

		/*
		 * containsLocalBean(String) says whether the provided bean name is contained at
		 * the top level of the hierarchy
		 */

		/*
		 * We illustrate these two methods with an instance of
		 * dux.org.springframework.beans.factory.HierarchicalBeanFactoryTest, which
		 * implements org.springframework.beans.factory.HierarchicalBeanFactory, and an
		 * instance of
		 * org.springframework.beans.factory.support.StaticListableBeanFactory as the
		 * parent bean factory
		 */

		/*
		 * We set up the StaticListableBeanFactory to contain "bean1" and the
		 * DefaultListableBeanFactory to contain "bean2"
		 */
		Object bean1 = new Object();
		Object bean2 = new Object();

		Map<String, Object> beans = new HashMap<>();
		beans.put("bean1", bean1);
		StaticListableBeanFactory parentBeanFactory = new StaticListableBeanFactory(beans);

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory(parentBeanFactory);
		beanFactory.registerSingleton("bean2", bean2);

		/* The parent bean factory is the instance of StaticListableBeanFactory */

		aeqr(parentBeanFactory, beanFactory.getParentBeanFactory());

		/*
		 * bean2 is defined in the instance of DefaultListableBeanFactory, but bean1 is
		 * not
		 */
		aeq(true, beanFactory.containsLocalBean("bean2"));
		aeq(false, beanFactory.containsLocalBean("bean1"));

	}
}
