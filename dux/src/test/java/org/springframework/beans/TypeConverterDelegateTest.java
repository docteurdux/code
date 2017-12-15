package org.springframework.beans;

import java.lang.reflect.Field;

import org.junit.Test;
import org.springframework.core.MethodParameter;
import org.springframework.core.convert.TypeDescriptor;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(TypeConverterDelegate.class)
public class TypeConverterDelegateTest extends AbstractTest {
	@Test
	public void test() {
		PropertyEditorRegistrySupport propertyEditorRegistry = new PropertyEditorRegistrySupport();
		C targetObject = new C();
		TypeConverterDelegate t = new TypeConverterDelegate(propertyEditorRegistry, targetObject);

		TypeConverterDelegate t2 = new TypeConverterDelegate(propertyEditorRegistry);

		Object newValue = null;
		Class requiredType = null;
		Field field = null;
		MethodParameter methodParam = null;
		String propertyName = null;
		Object oldValue = null;
		TypeDescriptor typeDescriptor = null;
		t.convertIfNecessary(newValue, requiredType, field);
		t.convertIfNecessary(newValue, requiredType, methodParam);
		t.convertIfNecessary(propertyName, oldValue, newValue, requiredType);
		t.convertIfNecessary(propertyName, oldValue, newValue, requiredType, typeDescriptor);

		/*-
		TypeConverterDelegate(PropertyEditorRegistrySupport)
		TypeConverterDelegate(PropertyEditorRegistrySupport, Object)
		convertIfNecessary(Object, Class<T>, Field)
		convertIfNecessary(Object, Class<T>, MethodParameter)
		convertIfNecessary(String, Object, Object, Class<T>)
		convertIfNecessary(String, Object, Object, Class<T>, TypeDescriptor) 
		 */
	}

	private static class C {

	}
}
