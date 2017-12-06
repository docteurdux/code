package dux.org.springframework.expression.spel.ast;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.TypedValue;
import org.springframework.expression.spel.ExpressionState;
import org.springframework.expression.spel.ast.FloatLiteral;
import org.springframework.expression.spel.ast.IntLiteral;
import org.springframework.expression.spel.ast.Literal;
import org.springframework.expression.spel.ast.LongLiteral;
import org.springframework.expression.spel.ast.RealLiteral;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Recorder;

public class LiteralTest extends AbstractTest {
	@Test
	public void test() {

		Object value = new Object() {
			@Override
			public String toString() {
				return "toString";
			}
		};

		TypedValue typedValue = new TypedValue(value);

		Literal l = new Literal("value", 1) {
			@Override
			public TypedValue getLiteralValue() {
				return typedValue;
			}
		};

		aeq("value", l.getOriginalValue());
		EvaluationContext context = Recorder.create("evaluationContext", this, EvaluationContext.class).p();
		ExpressionState state = new ExpressionState(context);
		aeqr(typedValue, l.getValueInternal(state));
		aeq("toString", l.toString());
		aeq("toString", l.toStringAST());

		aeq(IntLiteral.class, Literal.getIntLiteral("1", 1, 10).getClass());
		aeq(LongLiteral.class, Literal.getLongLiteral("1", 1, 10).getClass());
		aeq(FloatLiteral.class, Literal.getRealLiteral("1", 1, true).getClass());
		aeq(RealLiteral.class, Literal.getRealLiteral("1", 1, false).getClass());

	}
}
