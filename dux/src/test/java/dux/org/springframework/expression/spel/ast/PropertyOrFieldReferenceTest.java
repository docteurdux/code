package dux.org.springframework.expression.spel.ast;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.TypedValue;
import org.springframework.expression.spel.ExpressionState;
import org.springframework.expression.spel.ast.PropertyOrFieldReference;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(PropertyOrFieldReference.class)
public class PropertyOrFieldReferenceTest extends AbstractTest {

	public static class A {
		public String foo = "foo";
	}

	@Test
	public void test() {
		Object a = new A();
		PropertyOrFieldReference p = new PropertyOrFieldReference(true, "foo", 1);
		EvaluationContext context = new StandardEvaluationContext();
		TypedValue rootObject = new TypedValue(a);
		ExpressionState state = new ExpressionState(context, rootObject);

		aeq("foo", p.getValueInternal(state).getValue());
	}
}
