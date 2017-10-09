package dux.org.springframework.expression.spel.support;

import java.lang.reflect.Constructor;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.AccessException;
import org.springframework.expression.TypedValue;
import org.springframework.expression.spel.support.ReflectiveConstructorExecutor;

import dum.org.springframework.expression.DummyEvaluationContext;

public class ReflectiveConstructorExecutorTest {

	public static class A {

	}

	@Test
	public void test() throws NoSuchMethodException, SecurityException, AccessException {
		Constructor<A> constructor = A.class.getConstructor();
		ReflectiveConstructorExecutor executor = new ReflectiveConstructorExecutor(constructor);
		Assert.assertEquals(constructor, executor.getConstructor());
		DummyEvaluationContext context = new DummyEvaluationContext();
		TypedValue o = executor.execute(context );
	}
}
