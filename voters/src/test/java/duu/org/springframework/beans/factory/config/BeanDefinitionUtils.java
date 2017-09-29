package duu.org.springframework.beans.factory.config;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.ManagedList;

public class BeanDefinitionUtils {

	public static void match(BuiltBeanDefinition expected, BeanDefinition actual) {

		if (expected == null) {
			System.out.println(generateTest(actual));
			return;
		}

		if (expected.getBeanClassNameSet()) {
			Assert.assertEquals(expected.getBeanClassName(), actual.getBeanClassName());
		}

		if (expected.isSingletonSet()) {
			Assert.assertEquals(expected.isSingleton(), actual.isSingleton());
		}

		if (expected.isPrototypeSet()) {
			Assert.assertEquals(expected.isPrototype(), actual.isPrototype());
		}
		if (expected.isPrimarySet()) {
			Assert.assertEquals(expected.isPrimary(), actual.isPrimary());
		}
		if (expected.isLazyInitSet()) {
			Assert.assertEquals(expected.isLazyInit(), actual.isLazyInit());
		}

		if (expected.isAutowireCandidateSet()) {
			Assert.assertEquals(expected.isAutowireCandidate(), actual.isAutowireCandidate());
		}

		if (expected.isAbstractSet()) {
			Assert.assertEquals(expected.isAbstract(), actual.isAbstract());
		}

		if (expected.isScopeSet()) {
			Assert.assertEquals(expected.getScope(), actual.getScope());
		}

		if (expected.isRoleSet()) {
			Assert.assertEquals(expected.getRole(), actual.getRole());
		}

		if (expected.isDescriptionSet()) {
			Assert.assertEquals(expected.getDescription(), actual.getDescription());
		}

		if (expected.isResourceDescriptionSet()) {
			Assert.assertEquals(expected.getResourceDescription(), actual.getResourceDescription());
		}

		if (expected.isFactoryBeanNameSet()) {
			Assert.assertEquals(expected.getFactoryBeanName(), actual.getFactoryBeanName());
		}
		if (expected.isFactoryMethodNameSet()) {
			Assert.assertEquals(expected.getFactoryMethodName(), actual.getFactoryMethodName());
		}
		if (expected.isParentNameSet()) {
			Assert.assertEquals(expected.getParentName(), actual.getParentName());
		}

		MutablePropertyValues propertyValues = actual.getPropertyValues();
		List<PropertyValue> expectedProperties = expected.getPropertyValues().getPropertyValueList();

		if (expectedProperties.size() > 0) {
			Assert.assertNotNull(propertyValues);
			Assert.assertEquals(expectedProperties.size(), propertyValues.size());
		}

		for (PropertyValue pv : expectedProperties) {
			String name = pv.getName();
			Object expectedValue = pv.getValue();
			Assert.assertTrue(propertyValues.contains(name));
			Object actualValue = propertyValues.get(name);
			if (expectedValue instanceof Class) {
				Class<?> expectedClass = (Class<?>) expectedValue;
				Assert.assertNotNull(actualValue);
				Assert.assertTrue(actualValue.getClass().isAssignableFrom(expectedClass));
			}
		}

		if (expected.isDependsOnSet()) {
			if (expected.getDependsOn() == null) {
				Assert.assertNull(actual.getDependsOn());
			}
		}

		if (expected.isOriginatingBeanDefinitionSet()) {
			if (expected.getOriginatingBeanDefinition() == null) {
				Assert.assertNull(actual.getOriginatingBeanDefinition());
			}
		}

		if (expected.isConstructorArgumentValuesSet()) {
			Assert.assertEquals(expected.getConstructorArgumentValues().getArgumentCount(),
					actual.getConstructorArgumentValues().getArgumentCount());
		}

		if (expected.isAttributesSet()) {
			Assert.assertEquals(expected.attributeNames().length, actual.attributeNames().length);
		}

		if (expected.isSourceSet()) {
			if (expected.getSource() == null) {
				Assert.assertNull(actual.getSource());
			}
		}
	}

	public static String generateTest(BeanDefinition definition) {

		StringBuffer buffer = new StringBuffer();

		buffer.append("new DummyBeanDefinitionBuilder()");

		if (definition.isSingleton()) {
			buffer.append(".singleton()");
		} else {
			buffer.append(".notSingleton()");
		}
		if (definition.isPrototype()) {
			buffer.append(".prototype()");
		} else {
			buffer.append(".notPrototype()");
		}
		if (definition.isPrimary()) {
			buffer.append(".primary()");
		} else {
			buffer.append(".notPrimary()");
		}
		if (definition.isLazyInit()) {
			buffer.append(".lazyInit()");
		} else {
			buffer.append(".notLazyInit()");
		}
		if (definition.isAutowireCandidate()) {
			buffer.append(".autowireCandidate()");
		} else {
			buffer.append(".notAutowireCandidate()");
		}
		if (definition.isAbstract()) {
			buffer.append(".abstracT()");
		} else {
			buffer.append(".notAbstract()");
		}

		buffer.append(".role(" + definition.getRole() + ")");
		buffer.append(".scope(" + escape(definition.getScope(), true) + ")");
		buffer.append(".beanClassName(" + escape(definition.getBeanClassName(), true) + ")");
		buffer.append(".description(" + escape(definition.getDescription(), true) + ")");
		buffer.append(".resourceDescription(" + escape(definition.getResourceDescription(), true) + ")");
		buffer.append(".factoryBeanName(" + escape(definition.getFactoryBeanName(), true) + ")");
		buffer.append(".factoryMethodName(" + escape(definition.getFactoryMethodName(), true) + ")");
		buffer.append(".parentName(" + escape(definition.getParentName(), true) + ")");

		if (definition.getSource() == null) {
			buffer.append(".source(null)");
		} else {
			System.out.println("Source not null");
		}

		for (PropertyValue pv : definition.getPropertyValues().getPropertyValueList()) {
			String name = escape(pv.getName());
			Object value = pv.getValue();
			if (value == null) {
				buffer.append(".property(\"" + name + "\",(Object)null)");
			} else if (value instanceof String) {
				buffer.append(".property(\"" + name + "\"," + escape((String) value) + ")");
			} else if (value.getClass().isPrimitive()) {
				buffer.append(".property(\"" + name + "\"," + value.toString() + ")");
			} else if (value.getClass().isArray()) {
				System.out.println("Property " + name + " is of type " + value.getClass().getSimpleName());
			} else {
				String className = value.getClass().getName() + ".class";
				buffer.append(".property(\"" + name + "\"," + className + ")");
			}
		}

		if (definition.getConstructorArgumentValues().getArgumentCount() == 0) {
			buffer.append(".constructorArgumentValues()");
		} else {
			System.out.println("There are some constructor argument values");
		}

		if (definition.attributeNames().length == 0) {
			buffer.append(".attributes()");
		} else {
			System.out.println("There are some attributes");
		}

		if (definition.getDependsOn() == null) {
			buffer.append(".dependsOn(null)");
		} else {
			System.out.println("dependsOn is not null");
		}

		if (definition.getOriginatingBeanDefinition() == null) {
			buffer.append(".originatingBeanDefinition(null)");
		} else {
			System.out.println("originatingBeanDefinition is not null");
		}

		buffer.append(".build();");

		return buffer.toString();
	}

	private static String escape(String str) {
		return escape(str, false);
	}

	private static String escape(String str, boolean addQuotes) {
		if (str == null) {
			return "null";
		}
		if (addQuotes) {
			return "\"" + str.replaceAll("\"", "\\\\\"") + "\"";
		} else {
			return str.replaceAll("\"", "\\\\\"");
		}
	}

}
