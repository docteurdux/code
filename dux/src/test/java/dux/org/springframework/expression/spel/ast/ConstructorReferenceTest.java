package dux.org.springframework.expression.spel.ast;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.ExpressionState;
import org.springframework.expression.spel.ast.BooleanLiteral;
import org.springframework.expression.spel.ast.ConstructorReference;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Topic;

@Topic(ConstructorReference.class)
public class ConstructorReferenceTest extends AbstractTest {
	@Test
	public void test() {
		ConstructorReference r = new ConstructorReference(1, new BooleanLiteral("foo", 1, true));
		aeq("new true()", r.toStringAST());
		
		EvaluationContext context = Recorder.create(EvaluationContext.class).p();
		ExpressionState state = new ExpressionState(context);
		r.getValueInternal(state);
	}
}
