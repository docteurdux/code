package dux.org.springframework.beans.factory.config;

import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import com.github.docteurdux.test.Prerequisites;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.beans.factory.HierarchicalBeanFactoryTest;

@Topic(ConfigurableBeanFactory.class)
@Prerequisites({ HierarchicalBeanFactoryTest.class, SingletonBeanRegistryTest.class })
public class ConfigurableBeanFactoryTest {

	@Test
	public void test() {

		Object bean = new Object();

		DefaultListableBeanFactory f = new DefaultListableBeanFactory();
		f.registerSingleton("bean", bean);

		/*-
		addBeanPostProcessor(BeanPostProcessor)
		addEmbeddedValueResolver(StringValueResolver)
		addPropertyEditorRegistrar(PropertyEditorRegistrar)
		copyConfigurationFrom(ConfigurableBeanFactory)
		copyRegisteredEditorsTo(PropertyEditorRegistry)
		destroyBean(String, Object)
		destroyScopedBean(String)
		destroySingletons()
		getAccessControlContext()
		getBeanClassLoader()
		getBeanExpressionResolver()
		getBeanPostProcessorCount()
		getConversionService()
		getDependenciesForBean(String)
		getDependentBeans(String)
		getMergedBeanDefinition(String)
		getRegisteredScope(String)
		getRegisteredScopeNames()
		getTempClassLoader()
		getTypeConverter()
		hasEmbeddedValueResolver()
		isCacheBeanMetadata()
		isCurrentlyInCreation(String)
		isFactoryBean(String)
		registerAlias(String, String)
		registerCustomEditor(Class<?>, Class<? extends PropertyEditor>)
		registerDependentBean(String, String)
		registerScope(String, Scope)
		resolveAliases(StringValueResolver)
		resolveEmbeddedValue(String)
		setBeanClassLoader(ClassLoader)
		setBeanExpressionResolver(BeanExpressionResolver)
		setCacheBeanMetadata(boolean)
		setConversionService(ConversionService)
		setCurrentlyInCreation(String, boolean)
		setParentBeanFactory(BeanFactory)
		setTempClassLoader(ClassLoader)
		setTypeConverter(TypeConverter)
		 */
	}
}
