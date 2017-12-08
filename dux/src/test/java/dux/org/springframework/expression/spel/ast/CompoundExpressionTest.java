package dux.org.springframework.expression.spel.ast;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.ExpressionState;
import org.springframework.expression.spel.ast.BooleanLiteral;
import org.springframework.expression.spel.ast.CompoundExpression;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Topic;

@Topic(CompoundExpression.class)
public class CompoundExpressionTest extends AbstractTest {
	@Test
	public void test() {

		CompoundExpression e = new CompoundExpression(1, new BooleanLiteral("foo", 1, true),
				new BooleanLiteral("bar", 1, false), new BooleanLiteral("baz", 1, true));

		aeq("true.false.true", e.toStringAST());
		aeq(true, e.isCompilable());

		EvaluationContext context = Recorder.create("evaluationContext", this, EvaluationContext.class).p();
		ExpressionState state = new ExpressionState(context);

	}
}
