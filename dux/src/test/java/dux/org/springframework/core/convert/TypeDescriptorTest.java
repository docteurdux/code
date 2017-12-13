package dux.org.springframework.core.convert;

import org.junit.Test;
import org.springframework.core.convert.TypeDescriptor;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.core.ResolvableTypeTest;

@Topic(TypeDescriptor.class)
@Related({ ResolvableTypeTest.class })
public class TypeDescriptorTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		array(TypeDescriptor)
		collection(Class<?>, TypeDescriptor)
		forObject(Object)
		map(Class<?>, TypeDescriptor, TypeDescriptor)
		nested(Field, int)
		nested(Property, int)
		nested(MethodParameter, int)
		valueOf(Class<?>)
		TypeDescriptor(Field)
		TypeDescriptor(Property)
		TypeDescriptor(MethodParameter)
		elementTypeDescriptor(Object)
		equals(Object)
		getAnnotation(Class<T>)
		getAnnotations()
		getElementTypeDescriptor()
		getMapKeyTypeDescriptor()
		getMapKeyTypeDescriptor(Object)
		getMapValueTypeDescriptor()
		getMapValueTypeDescriptor(Object)
		getName()
		getObjectType()
		getResolvableType()
		getSource()
		getType()
		hasAnnotation(Class<? extends Annotation>)
		hashCode()
		isArray()
		isAssignableTo(TypeDescriptor)
		isCollection()
		isMap()
		isPrimitive()
		narrow(Object)
		toString()
		upcast(Class<?>)
		 */
	}
}
