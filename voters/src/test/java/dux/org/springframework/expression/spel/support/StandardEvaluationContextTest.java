package dux.org.springframework.expression.spel.support;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.ConstructorResolver;
import org.springframework.expression.MethodResolver;
import org.springframework.expression.TypedValue;
import org.springframework.expression.spel.support.ReflectiveConstructorResolver;
import org.springframework.expression.spel.support.ReflectiveMethodResolver;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class StandardEvaluationContextTest {

	@Test
	public void test() {
		StandardEvaluationContext context = new StandardEvaluationContext();

		Assert.assertEquals(TypedValue.NULL, context.getRootObject());

		Object o = new Object();
		context.setRootObject(o);

		ConstructorResolver resolver = null;
		context.addConstructorResolver(resolver);
		context.removeConstructorResolver(resolver);
		List<ConstructorResolver> resolvers = context.getConstructorResolvers();
		Assert.assertEquals(1, resolvers.size());
		Assert.assertTrue(resolvers.get(0) instanceof ReflectiveConstructorResolver);
		context.setConstructorResolvers(resolvers);

		MethodResolver methodResolver = null;
		context.addMethodResolver(methodResolver);
		context.removeMethodResolver(methodResolver);
		List<MethodResolver> mr = context.getMethodResolvers();
		Assert.assertEquals(1, mr.size());
		Assert.assertTrue(mr.get(0) instanceof ReflectiveMethodResolver);
		context.setMethodResolvers(mr);

	}
}
