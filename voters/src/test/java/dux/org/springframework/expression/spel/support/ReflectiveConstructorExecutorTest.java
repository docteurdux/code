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

	public static class B {
		public B(Object... objects) {

		}
	}

	public static class C {
		private C() {

		}
	}

	@Test
	public void test1() throws NoSuchMethodException, SecurityException, AccessException {
		Constructor<A> constructor = A.class.getConstructor();
		ReflectiveConstructorExecutor executor = new ReflectiveConstructorExecutor(constructor);
		Assert.assertEquals(constructor, executor.getConstructor());
		DummyEvaluationContext context = new DummyEvaluationContext();
		TypedValue o = executor.execute(context);
		A a = (A) o.getValue();
	}

	@Test
	public void test2() throws NoSuchMethodException, SecurityException, AccessException {
		Constructor<A> constructor = A.class.getConstructor();
		ReflectiveConstructorExecutor executor = new ReflectiveConstructorExecutor(constructor);
		Assert.assertEquals(constructor, executor.getConstructor());
		DummyEvaluationContext context = new DummyEvaluationContext();
		TypedValue o = executor.execute(context, (Object[]) null);
		A a = (A) o.getValue();
	}

	@Test
	public void test3() throws NoSuchMethodException, SecurityException, AccessException {
		Constructor<B> constructor = B.class.getConstructor(Object[].class);
		ReflectiveConstructorExecutor executor = new ReflectiveConstructorExecutor(constructor);
		Assert.assertEquals(constructor, executor.getConstructor());
		DummyEvaluationContext context = new DummyEvaluationContext();
		TypedValue o = executor.execute(context, new Object[] {});
		B a = (B) o.getValue();
	}

	@Test
	public void test4() throws NoSuchMethodException, SecurityException, AccessException {
		Constructor<C> constructor = C.class.getDeclaredConstructor();
		ReflectiveConstructorExecutor executor = new ReflectiveConstructorExecutor(constructor);
		Assert.assertEquals(constructor, executor.getConstructor());
		DummyEvaluationContext context = new DummyEvaluationContext();
		TypedValue o = executor.execute(context, new Object[] {});
		C a = (C) o.getValue();
	}
}
