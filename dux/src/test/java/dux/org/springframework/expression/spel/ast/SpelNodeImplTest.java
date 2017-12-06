package dux.org.springframework.expression.spel.ast;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.EvaluationException;
import org.springframework.expression.TypedValue;
import org.springframework.expression.spel.ExpressionState;
import org.springframework.expression.spel.ast.SpelNodeImpl;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Topic;

@Topic(SpelNodeImpl.class)
public class SpelNodeImplTest extends AbstractTest {
	@Test
	public void test() {

		Object value = new Object();
		TypedValue typedValue = new TypedValue(value);

		SpelNodeImpl i = new SpelNodeImpl(1) {

			@Override
			public String toStringAST() {
				return "toAST";
			}

			@Override
			public TypedValue getValueInternal(ExpressionState expressionState) throws EvaluationException {
				return typedValue;
			}

		};

		EvaluationContext context = Recorder.create("evaluationContext", this, EvaluationContext.class).p();
		ExpressionState es = new ExpressionState(context);
		aeqr(value, i.getValue(es));

		aeqr(typedValue, i.getTypedValue(es));

		aeq(false, i.isWritable(es));
		/*-
		i.setValue(expressionState, newValue);
		i.getChild(index);
		i.getChildCount();
		i.getObjectClass(obj);
		i.getStartPosition();
		*/
		
		i.getEndPosition();
		aeq(false,i.isCompilable());
		//i.generateCode(mv, cf);
		i.getExitDescriptor();
		
		
	}
}
