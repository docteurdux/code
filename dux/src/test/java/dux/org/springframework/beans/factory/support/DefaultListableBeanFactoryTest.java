package dux.org.springframework.beans.factory.support;

import java.util.Comparator;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.AutowireCandidateResolver;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.ResolvableType;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.java.io.SerializableTest;
import dux.org.springframework.beans.factory.config.ConfigurableListableBeanFactoryTest;

@Topic(DefaultListableBeanFactory.class)
@Prerequisites({ AbstractAutowireCapableBeanFactoryTest.class, ConfigurableListableBeanFactoryTest.class,
		BeanDefinitionRegistryTest.class, SerializableTest.class })
public class DefaultListableBeanFactoryTest extends AbstractTest {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void test() {

		DefaultListableBeanFactory d = new DefaultListableBeanFactory();

		DependencyDescriptor descriptor = null;
		String beanName = null;
		Set<String> autowiredBeanNames = null;
		TypeConverter typeConverter = null;
		d.doResolveDependency(descriptor, beanName, autowiredBeanNames, typeConverter);

		if (t()) {
			return;
		}

		ConfigurableBeanFactory otherFactory = null;
		Class annotationType = null;
		String requiredType = null;
		Object args = null;
		ResolvableType type = null;
		Class type1 = null;
		BeanDefinition beanDefinition = null;
		Class<?> dependencyType = null;
		Object autowiredValue = null;
		Object singletonObject = null;
		String requestingBeanName = null;
		boolean allowEagerClassLoading = false;
		AutowireCandidateResolver autowireCandidateResolver = null;
		Comparator<Object> dependencyComparator = null;
		String serializationId = null;
		boolean allowBeanDefinitionOverriding = false;
		Class<?> type7 = null;
		boolean includeNonSingletons7 = false;
		boolean allowEagerInit7 = false;
		Class type8 = null;
		boolean includeNonSingletons8 = false;
		boolean allowEagerInit8 = false;
		Class requiredTyp1e = null;

		d.clearMetadataCache();
		d.containsBeanDefinition(beanName);
		d.copyConfigurationFrom(otherFactory);
		d.destroySingleton(beanName);
		d.destroySingletons();
		d.findAnnotationOnBean(beanName, annotationType);
		d.freezeConfiguration();
		d.getAutowireCandidateResolver();
		d.getBean(requiredType);
		d.getBean(requiredType, args);
		d.getBeanDefinition(beanName);
		d.getBeanNamesForAnnotation(annotationType);
		d.getBeanNamesForType(type);
		d.getBeanNamesForType(type7, includeNonSingletons7, allowEagerInit7);
		d.getBeanNamesForType(type);
		d.getBeanNamesIterator();
		d.getBeansOfType(type1);
		d.getBeansOfType(type8, includeNonSingletons8, allowEagerInit8);
		d.getBeansWithAnnotation(annotationType);
		d.getDependencyComparator();
		d.getSerializationId();
		d.isAllowBeanDefinitionOverriding();
		d.isAllowEagerClassLoading();
		d.isAutowireCandidate(beanName, descriptor);
		d.isConfigurationFrozen();
		d.preInstantiateSingletons();
		d.registerBeanDefinition(beanName, beanDefinition);
		d.registerResolvableDependency(dependencyType, autowiredValue);
		d.registerSingleton(beanName, singletonObject);
		d.removeBeanDefinition(beanName);
		d.resolveDependency(descriptor, requestingBeanName, autowiredBeanNames, typeConverter);
		d.resolveNamedBean(requiredTyp1e);
		d.setAllowBeanDefinitionOverriding(allowBeanDefinitionOverriding);
		d.setAllowEagerClassLoading(allowEagerClassLoading);
		d.setAutowireCandidateResolver(autowireCandidateResolver);
		d.setDependencyComparator(dependencyComparator);
		d.setSerializationId(serializationId);
		d.toString();

	}
}
