package dux.org.springframework.expression.spel.support;

import java.lang.reflect.Method;

import org.junit.Test;
import org.springframework.expression.spel.support.ReflectionHelper;

import dum.org.springframework.expression.DummyTypeConverter;

public class ReflectionHelperTest {

	public static class A {
		public void foo() {
		}
	}

	@Test
	public void test1() throws NoSuchMethodException, SecurityException {
		DummyTypeConverter converter = new DummyTypeConverter();
		Object[] arguments = new Object[] {};
//		Method method = A.class.getMethod("foo");
		ReflectionHelper.convertAllArguments(converter, arguments, null);
	}
	@Test
	public void test() throws NoSuchMethodException, SecurityException {
		DummyTypeConverter converter = new DummyTypeConverter();
		Object[] arguments = new Object[] {};
		Method method = A.class.getMethod("foo");
		ReflectionHelper.convertAllArguments(converter, arguments, method);
//		List<TypeDescriptor> paramTypes = null;
//		List<TypeDescriptor> argTypes = null;
//		ReflectionHelper.getTypeDifferenceWeight(paramTypes, argTypes);
//		Object args = null;
//		Class<?>[] requiredParameterTypes = null;
//		ReflectionHelper.setupArgumentsForVarargsInvocation(requiredParameterTypes, args);
	}
}
