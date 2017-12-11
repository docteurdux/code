package dux.org.springframework.beans.factory.config;

import java.util.Set;

import org.junit.Test;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.beans.factory.BeanFactoryTest;

@Topic(AutowireCapableBeanFactory.class)
@Prerequisites(BeanFactoryTest.class)
public class AutowireCapableBeanFactoryTest extends AbstractTest {
	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		/*-
		applyBeanPostProcessorsAfterInitialization(Object, String)
		applyBeanPostProcessorsBeforeInitialization(Object, String)
		applyBeanPropertyValues(Object, String)
		autowire(Class<?>, int, boolean)
		autowireBean(Object)
		autowireBeanProperties(Object, int, boolean)
		configureBean(Object, String)
		createBean(Class<?>, int, boolean)
		createBean(Class<T>)
		destroyBean(Object)
		initializeBean(Object, String)
		resolveDependency(DependencyDescriptor, String)
		resolveDependency(DependencyDescriptor, String, Set<String>, TypeConverter)
		resolveNamedBean(Class<T>)
		 */

		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		Object existingBean = null;
		String beanName = null;
		dlbf.applyBeanPostProcessorsBeforeInitialization(existingBean, beanName);
		dlbf.applyBeanPostProcessorsAfterInitialization(existingBean, beanName);
		dlbf.applyBeanPropertyValues(existingBean, beanName);
		Class<?> beanClass = null;
		int autowireMode = 0;
		boolean dependencyCheck = false;
		dlbf.autowire(beanClass, autowireMode, dependencyCheck);
		dlbf.autowireBean(existingBean);
		dlbf.autowireBeanProperties(existingBean, autowireMode, dependencyCheck);
		dlbf.configureBean(existingBean, beanName);
		dlbf.createBean(beanClass, autowireMode, dependencyCheck);
		dlbf.createBean(beanClass);
		dlbf.destroyBean(existingBean);
		dlbf.initializeBean(existingBean, beanName);
		String requestingBeanName = null;
		DependencyDescriptor descriptor = null;
		dlbf.resolveDependency(descriptor, requestingBeanName);
		Set<String> autowiredBeanNames = null;
		TypeConverter typeConverter = null;
		dlbf.resolveDependency(descriptor, requestingBeanName, autowiredBeanNames, typeConverter);
		Class requiredType = null;
		dlbf.resolveNamedBean(requiredType);
	}
}
