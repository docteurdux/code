package dux.org.springframework.core;

import java.lang.reflect.Executable;
import java.lang.reflect.Method;

import org.junit.Test;
import org.springframework.core.MethodParameter;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(MethodParameter.class)
public class MethodParameterTest extends AbstractTest {

	public static class C {
		public void foo(String p) {
		}
	}

	@Test
	public void test() throws NoSuchMethodException, SecurityException {

		Method method = C.class.getMethod("foo", String.class);
		MethodParameter mp = new MethodParameter(method, 0);

		Executable executable = null;
		int parameterIndex = 1;
		MethodParameter.forExecutable(executable, parameterIndex);

		/*-
		forExecutable(Executable, int)
		forMethodOrConstructor(Object, int)
		forParameter(Parameter)
		MethodParameter(Constructor<?>, int)
		MethodParameter(Constructor<?>, int, int)
		MethodParameter(Method, int)
		MethodParameter(Method, int, int)
		MethodParameter(MethodParameter)
		clone()
		decreaseNestingLevel()
		equals(Object)
		getAnnotatedElement()
		getConstructor()
		getContainingClass()
		getDeclaringClass()
		getExecutable()
		getGenericParameterType()
		getMember()
		getMethod()
		getMethodAnnotation(Class<A>)
		getMethodAnnotations()
		getNestedGenericParameterType()
		getNestedParameterType()
		getNestingLevel()
		getParameter()
		getParameterAnnotation(Class<A>)
		getParameterAnnotations()
		getParameterIndex()
		getParameterName()
		getParameterType()
		getTypeIndexForCurrentLevel()
		getTypeIndexForLevel(int)
		hashCode()
		hasMethodAnnotation(Class<A>)
		hasParameterAnnotation(Class<A>)
		hasParameterAnnotations()
		increaseNestingLevel()
		initParameterNameDiscovery(ParameterNameDiscoverer)
		isOptional()
		nested()
		nestedIfOptional()
		setTypeIndexForCurrentLevel(int)
		toString()
		 */

	}
}
