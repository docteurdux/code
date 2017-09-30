package duu.org.springframework.beans.factory.config;

import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.ManagedList;

public class DummyBeanDefinitionBuilder {

	private BuiltBeanDefinition definition;

	public DummyBeanDefinitionBuilder() {
		definition = new BuiltBeanDefinition();
	}

	public DummyBeanDefinitionBuilder beanClassName(String beanClassName) {
		definition.setBeanClassName(beanClassName);
		return this;
	}

	public BuiltBeanDefinition build() {
		return definition;
	}

	public DummyBeanDefinitionBuilder singleton() {
		definition.setSingleton(true);
		return this;
	}

	public DummyBeanDefinitionBuilder notPrototype() {
		definition.setPrototype(false);
		return this;
	}

	public DummyBeanDefinitionBuilder notPrimary() {
		definition.setPrimary(false);
		return this;
	}

	public DummyBeanDefinitionBuilder notLazyInit() {
		definition.setLazyInit(false);
		return this;
	}

	public DummyBeanDefinitionBuilder autowireCandidate() {
		definition.setAutowireCandidate(true);
		return this;
	}

	public DummyBeanDefinitionBuilder notAbstract() {
		definition.isAbstract();
		return this;
	}

	public DummyBeanDefinitionBuilder scope(String string) {
		definition.setScope(string);
		return this;
	}

	public DummyBeanDefinitionBuilder role(int role) {
		definition.getRole();
		return this;
	}

	public DummyBeanDefinitionBuilder description(String description) {
		definition.getDescription();
		return this;
	}

	public DummyBeanDefinitionBuilder resourceDescription(String resourceDescription) {
		definition.getResourceDescription();
		return this;
	}

	public DummyBeanDefinitionBuilder factoryBeanName(String factoryBeanName) {
		definition.setFactoryBeanName(factoryBeanName);
		return this;
	}

	public DummyBeanDefinitionBuilder factoryMethodName(String factoryMethodName) {
		definition.setFactoryMethodName(factoryMethodName);
		return this;
	}

	public DummyBeanDefinitionBuilder parentName(String parentName) {
		definition.setParentName(parentName);
		return this;
	}

	public DummyBeanDefinitionBuilder property(String name, Class<?> clazz) {
		definition.getPropertyValues().add(name, clazz);
		return this;
	}

	public DummyBeanDefinitionBuilder dependsOn(String[] dependsOn) {
		definition.setDependsOn(dependsOn);
		return this;
	}

	public DummyBeanDefinitionBuilder originatingBeanDefinition(Object object) {
		definition.getOriginatingBeanDefinition();
		return this;
	}

	public DummyBeanDefinitionBuilder constructorArgumentValues() {
		definition.constructorArgumentValues();
		return this;
	}

	public DummyBeanDefinitionBuilder attributes() {
		definition.attributes();
		return this;
	}

	public DummyBeanDefinitionBuilder attribute(String name, Object value) {
		definition.setAttribute(name, value);
		return this;
	}

	public DummyBeanDefinitionBuilder source(Object source) {
		definition.setSource(source);
		return this;
	}

	public DummyBeanDefinitionBuilder indexedArgumentValues(int i, Class<?> clazz) {
		definition.setIndexedArgumentValues(i, clazz);
		return this;
	}
}
