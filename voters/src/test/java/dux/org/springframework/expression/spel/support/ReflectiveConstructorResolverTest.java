package dux.org.springframework.expression.spel.support;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.expression.AccessException;
import org.springframework.expression.ConstructorExecutor;
import org.springframework.expression.spel.support.ReflectiveConstructorResolver;

import dum.org.springframework.expression.DummyEvaluationContext;
import dum.org.springframework.expression.DummyTypeLocator;

public class ReflectiveConstructorResolverTest {

	public static class A {
		
	}
	
	@Test
	public void test() throws AccessException {
		ReflectiveConstructorResolver resolver = new ReflectiveConstructorResolver();

		DummyEvaluationContext context = new DummyEvaluationContext();
		DummyTypeLocator typeLocator = new DummyTypeLocator();
		typeLocator.setType(A.class);
		context.setTypeLocator(typeLocator);
		String typeName = null;
		List<TypeDescriptor> argumentTypes = new ArrayList<>();
		ConstructorExecutor r = resolver.resolve(context, typeName, argumentTypes);
		Assert.assertNotNull(r);
	}

}
