package dux.org.springframework.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;

import org.junit.Test;
import org.springframework.core.MethodParameter;
import org.springframework.core.ResolvableType;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.core.convert.TypeDescriptorTest;

@Topic(ResolvableType.class)
@Related({ TypeDescriptorTest.class })
public class ResolvableTypeTest extends AbstractTest {

	public static class A {
		public String foo = "oof";
	}
	
	

	@Test
	public void test() throws NoSuchFieldException, SecurityException {

		A a = new A();
		
		ResolvableType classRT = ResolvableType.forClass(A.class);
		aeqr(ResolvableType.NONE, classRT.getComponentType());
		aeq(0, classRT.getGenerics().length);
		aeq(0, classRT.getInterfaces().length);
		aeq(A.class, classRT.getRawClass());
		aeq(A.class, classRT.getSource());
		aeq(true, ResolvableType.forClass(Object.class).isAssignableFrom(classRT.getSuperType()));
		aeq(A.class, classRT.getType());
		aeq(false, classRT.hasGenerics());
		aeq(false, classRT.hasUnresolvableGenerics());
		aeq(false, classRT.isArray());
		aeq(true, classRT.isAssignableFrom(A.class));
		aeq(true, classRT.isAssignableFrom(classRT));
		classRT.isInstance(a);
		aeq(A.class, classRT.resolve());
		aeq(A.class, classRT.resolve(Object.class));
		aeq(0, classRT.resolveGenerics().length);
		aeq(0, classRT.resolveGenerics(Object.class).length);

		Field field = A.class.getField("foo");
		ResolvableType fieldRT = ResolvableType.forField(field);
		aeqr(ResolvableType.NONE, fieldRT.getComponentType());
		aeq(0, fieldRT.getGenerics().length);
		aeq(3, fieldRT.getInterfaces().length);
		aeq(String.class, fieldRT.getRawClass());
		aeqr(field, fieldRT.getSource());
		aeq(true, ResolvableType.forClass(Object.class).isAssignableFrom(fieldRT.getSuperType()));
		aeq(String.class, fieldRT.getType());
		aeq(false, fieldRT.hasGenerics());
		aeq(false, fieldRT.hasUnresolvableGenerics());
		aeq(false, fieldRT.isArray());
		aeq(true, fieldRT.isAssignableFrom(String.class));
		aeq(true, fieldRT.isAssignableFrom(fieldRT));
		fieldRT.isInstance(a);
		aeq(String.class, fieldRT.resolve());
		aeq(String.class, fieldRT.resolve(Object.class));
		aeq(0, fieldRT.resolveGenerics().length);
		aeq(0, fieldRT.resolveGenerics(Object.class).length);

		ResolvableType instanceRT = ResolvableType.forInstance(a);
		aeqr(ResolvableType.NONE, instanceRT.getComponentType());
		aeq(0, instanceRT.getGenerics().length);
		aeq(0, instanceRT.getInterfaces().length);
		aeq(A.class, instanceRT.getRawClass());
		aeq(A.class, instanceRT.getSource());
		aeq(true, ResolvableType.forClass(Object.class).isAssignableFrom(instanceRT.getSuperType()));
		aeq(A.class, instanceRT.getType());
		aeq(false, instanceRT.hasGenerics());
		aeq(false, instanceRT.hasUnresolvableGenerics());
		aeq(false, instanceRT.isArray());
		aeq(true, instanceRT.isAssignableFrom(A.class));
		aeq(true, instanceRT.isAssignableFrom(instanceRT));
		instanceRT.isInstance(a);
		aeq(A.class, instanceRT.resolve());
		aeq(A.class, instanceRT.resolve(Object.class));
		aeq(0, instanceRT.resolveGenerics().length);
		aeq(0, instanceRT.resolveGenerics(Object.class).length);
		
		ResolvableType rawClassRT = ResolvableType.forRawClass(A.class);
		aeqr(ResolvableType.NONE, rawClassRT.getComponentType());
		aeq(0, rawClassRT.getGenerics().length);
		aeq(0, rawClassRT.getInterfaces().length);
		aeq(A.class, rawClassRT.getRawClass());
		aeq(A.class, rawClassRT.getSource());
		aeq(true, ResolvableType.forClass(Object.class).isAssignableFrom(rawClassRT.getSuperType()));
		aeq(A.class, rawClassRT.getType());
		aeq(false, rawClassRT.hasGenerics());
		aeq(false, rawClassRT.hasUnresolvableGenerics());
		aeq(false, rawClassRT.isArray());
		aeq(true, rawClassRT.isAssignableFrom(A.class));
		aeq(true, rawClassRT.isAssignableFrom(rawClassRT));
		rawClassRT.isInstance(a);
		aeq(A.class, rawClassRT.resolve());
		aeq(A.class, rawClassRT.resolve(Object.class));
		aeq(0, rawClassRT.resolveGenerics().length);
		aeq(0, rawClassRT.resolveGenerics(Object.class).length);
		
		if (t()) {
			return;
		}

		Class<?> type = null;
		classRT.as(type);
		classRT.asCollection();
		classRT.asMap();
		Class<?> other = null;
		classRT.equals(other);
		classRT.getComponentType();
		classRT.getGeneric(0, 1, 2);
		classRT.getGenerics();
		classRT.getInterfaces();
		int nestingLevel = 0;
		classRT.getNested(nestingLevel);
		Map<Integer, Integer> typeIndexesPerLevel = null;
		classRT.getNested(nestingLevel, typeIndexesPerLevel);
		classRT.getRawClass();
		classRT.getSource();
		classRT.getSuperType();
		classRT.getType();
		classRT.hasGenerics();
		classRT.hashCode();
		classRT.hasUnresolvableGenerics();
		classRT.isArray();
		classRT.isAssignableFrom(other);
		classRT.isAssignableFrom(other);
		Object obj = null;
		classRT.isInstance(obj);
		classRT.resolve();
		Class<?> fallback = null;
		classRT.resolve(fallback);
		classRT.resolveGeneric(1, 2, 3);
		classRT.resolveGenerics();
		classRT.resolveGenerics(fallback);
		classRT.toString();

		
		
		/*-
		as(Class<?>)
		asCollection()
		asMap()
		equals(Object)
		getComponentType()
		getGeneric(int...)
		getGenerics()
		getInterfaces()
		getNested(int)
		getNested(int, Map<Integer, Integer>)
		getRawClass()
		getSource()
		getSuperType()
		getType()
		hasGenerics()
		hashCode()
		hasUnresolvableGenerics()
		isArray()
		isAssignableFrom(Class<?>)
		isAssignableFrom(ResolvableType)
		isInstance(Object)
		resolve()
		resolve(Class<?>)
		resolveGeneric(int...)
		resolveGenerics()
		resolveGenerics(Class<?>)
		toString()
		 */

		ResolvableType componentType = null;
		ResolvableType.forArrayComponent(componentType);
		Class<?> clazz = null;
		Class<?> baseType = null;
		Class<?> implementationClass = null;
		ResolvableType.forClass(baseType, implementationClass);
		Class<?> generics1 = null;
		Class<?> generics2 = null;
		ResolvableType.forClassWithGenerics(clazz, generics1, generics2);
		ResolvableType generics = null;
		ResolvableType.forClassWithGenerics(clazz, generics);
		Constructor<?> constructor = null;
		int parameterIndex = 0;
		ResolvableType.forConstructorParameter(constructor, parameterIndex);
		ResolvableType.forConstructorParameter(constructor, parameterIndex, implementationClass);
		ResolvableType.forField(field, nestingLevel);
		Field field1 = null;
		int nestingLevel1 = 0;
		Class<?> implementationClass1 = null;
		ResolvableType.forField(field1, nestingLevel1, implementationClass1);
		ResolvableType.forField(field, implementationClass);
		ResolvableType implementationType = null;
		ResolvableType.forField(field, implementationType);
		Object instance = null;
		Method method = null;
		ResolvableType.forMethodParameter(method, parameterIndex);
		ResolvableType.forMethodParameter(method, parameterIndex, implementationClass);
		MethodParameter methodParameter = null;
		ResolvableType.forMethodParameter(methodParameter);
		Type targetType = null;
		ResolvableType.forMethodParameter(methodParameter, targetType);
		ResolvableType.forMethodParameter(methodParameter, implementationType);
		
		ResolvableType.forType(type);
		ResolvableType owner = null;
		ResolvableType.forType(type, owner);
		ResolvableType.clearCache();

	}
}
