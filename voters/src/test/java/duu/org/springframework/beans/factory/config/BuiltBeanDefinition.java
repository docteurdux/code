package duu.org.springframework.beans.factory.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;

public class BuiltBeanDefinition implements BeanDefinition {

	private String beanClassName;
	private boolean beanClassNameSet;
	private boolean singleton;
	private boolean singletonSet;
	private boolean prototype;
	private boolean prototypeSet;
	private boolean primary;
	private boolean primarySet;
	private boolean lazyInit;
	private boolean lazyInitSet;
	private boolean autowireCandidate;
	private boolean autowireCandidateSet;
	private boolean abstracT;
	private boolean abstractSet;
	private String scope;
	private boolean scopeSet;
	private int role;
	private boolean roleSet;
	private String description;
	private boolean descriptionSet;
	private String resourceDescription;
	private boolean resourceDescriptionSet;
	private String factoryBeanName;
	private boolean factoryBeanNameSet;
	private String factoryMethodName;
	private boolean factoryMethodNameSet;
	public String parentName;
	private boolean parentNameSet;
	private MutablePropertyValues propertyValues = new MutablePropertyValues();
	private String[] dependsOn;
	private boolean dependsOnSet;
	private BeanDefinition originatingBeanDefinition;
	private boolean originatingBeanDefinitionSet;
	private ConstructorArgumentValues constructorArgumentValues = new ConstructorArgumentValues();
	private boolean constructorArgumentValuesSet;
	private boolean attributesSet;
	private Map<String, Object> attributes = new HashMap<>();
	private Object source;
	private boolean sourceSet;
	private Map<Integer, Object> indexedArgumentValues = new HashMap<>();

	@Override
	public void setAttribute(String name, Object value) {
		attributesSet = true;
		attributes.put(name, value);
	}

	@Override
	public Object getAttribute(String name) {
		return attributes.get(name);
	}

	@Override
	public Object removeAttribute(String name) {
		return attributes.remove(name);
	}

	@Override
	public boolean hasAttribute(String name) {
		return attributes.containsKey(name);
	}

	@Override
	public String[] attributeNames() {
		return attributes.keySet().toArray(new String[] {});
	}

	@Override
	public Object getSource() {
		return source;
	}

	public void setSource(Object source) {
		this.sourceSet = true;
		this.source = source;
	}

	public boolean isSourceSet() {
		return sourceSet;
	}

	@Override
	public void setParentName(String parentName) {
		parentNameSet = true;
		this.parentName = parentName;

	}

	@Override
	public String getParentName() {
		return parentName;
	}

	public boolean isParentNameSet() {
		return parentNameSet;
	}

	@Override
	public void setBeanClassName(String beanClassName) {
		beanClassNameSet = true;
		this.beanClassName = beanClassName;
	}

	@Override
	public String getBeanClassName() {
		return beanClassName;
	}

	public boolean getBeanClassNameSet() {
		return beanClassNameSet;
	}

	@Override
	public void setScope(String scope) {
		scopeSet = true;
		this.scope = scope;

	}

	@Override
	public String getScope() {
		return scope;
	}

	public boolean isScopeSet() {
		return scopeSet;
	}

	@Override
	public void setLazyInit(boolean lazyInit) {
		lazyInitSet = true;
		this.lazyInit = lazyInit;

	}

	public boolean isLazyInitSet() {
		return lazyInitSet;
	}

	@Override
	public boolean isLazyInit() {
		return lazyInit;
	}

	@Override
	public void setDependsOn(String... dependsOn) {
		dependsOnSet = true;
		this.dependsOn = dependsOn;

	}

	@Override
	public String[] getDependsOn() {
		return dependsOn;
	}

	public boolean isDependsOnSet() {
		return dependsOnSet;
	}

	@Override
	public void setAutowireCandidate(boolean autowireCandidate) {
		autowireCandidateSet = true;
		this.autowireCandidate = autowireCandidate;

	}

	@Override
	public boolean isAutowireCandidate() {
		return autowireCandidate;
	}

	public boolean isAutowireCandidateSet() {
		return autowireCandidateSet;
	}

	@Override
	public void setPrimary(boolean primary) {
		primarySet = true;
		this.primary = primary;

	}

	public boolean isPrimarySet() {
		return primarySet;
	}

	@Override
	public boolean isPrimary() {
		return primary;
	}

	@Override
	public void setFactoryBeanName(String factoryBeanName) {
		factoryBeanNameSet = true;
		this.factoryBeanName = factoryBeanName;
	}

	@Override
	public String getFactoryBeanName() {
		return factoryBeanName;
	}

	public boolean isFactoryBeanNameSet() {
		return factoryBeanNameSet;
	}

	@Override
	public void setFactoryMethodName(String factoryMethodName) {
		factoryMethodNameSet = true;
		this.factoryMethodName = factoryMethodName;

	}

	@Override
	public String getFactoryMethodName() {
		return factoryMethodName;
	}

	public boolean isFactoryMethodNameSet() {
		return factoryMethodNameSet;
	}

	@Override
	public ConstructorArgumentValues getConstructorArgumentValues() {
		return constructorArgumentValues;
	}

	public void constructorArgumentValues() {
		constructorArgumentValuesSet = true;
	}

	public boolean isConstructorArgumentValuesSet() {
		return constructorArgumentValuesSet;
	}

	@Override
	public MutablePropertyValues getPropertyValues() {
		return propertyValues;
	}

	@Override
	public boolean isSingleton() {
		return singleton;
	}

	public void setSingleton(boolean singleton) {
		singletonSet = true;
		this.singleton = singleton;
	}

	public boolean isSingletonSet() {
		return singletonSet;
	}

	@Override
	public boolean isPrototype() {
		return prototype;
	}

	public void setPrototype(boolean prototype) {
		prototypeSet = true;
		this.prototype = prototype;
	}

	public boolean isPrototypeSet() {
		return prototypeSet;
	}

	@Override
	public boolean isAbstract() {
		return abstracT;
	}

	public void setAbstract(boolean abstracT) {
		abstractSet = true;
		this.abstracT = abstracT;
	}

	public boolean isAbstractSet() {
		return abstractSet;
	}

	@Override
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		roleSet = true;
		this.role = role;
	}

	public boolean isRoleSet() {
		return roleSet;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		descriptionSet = true;
		this.description = description;
	}

	public boolean isDescriptionSet() {
		return descriptionSet;
	}

	@Override
	public String getResourceDescription() {
		return resourceDescription;
	}

	public void setResourceDescription(String resourceDescription) {
		resourceDescriptionSet = true;
		this.resourceDescription = resourceDescription;
	}

	public boolean isResourceDescriptionSet() {
		return resourceDescriptionSet;
	}

	@Override
	public BeanDefinition getOriginatingBeanDefinition() {
		return originatingBeanDefinition;
	}

	public void setOriginatingBeanDefinition(BeanDefinition originatingBeanDefinition) {
		originatingBeanDefinitionSet = true;
		this.originatingBeanDefinition = originatingBeanDefinition;
	}

	public boolean isOriginatingBeanDefinitionSet() {
		return originatingBeanDefinitionSet;
	}

	public void attributes() {
		attributesSet = true;
	}

	public boolean isAttributesSet() {
		return attributesSet;
	}

	public void setIndexedArgumentValues(int i, Class<?> clazz) {
		constructorArgumentValuesSet = true;
		indexedArgumentValues.put(i, clazz);
	}

	public Map<Integer, Object> getIndexedArgumentValues() {
		return indexedArgumentValues;
	}

}
