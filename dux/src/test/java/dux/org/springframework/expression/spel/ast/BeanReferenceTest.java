package dux.org.springframework.expression.spel.ast;

import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.ExpressionState;
import org.springframework.expression.spel.ast.BeanReference;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Topic;

@Topic(BeanReference.class)
public class BeanReferenceTest extends AbstractTest {
	private String beanName;
	private Object bean;
	private BeanResolver beanResolver;
	private EvaluationContext evaluationContext;
	private ExpressionState expressionState;

	@Before
	public void before() {

		beanName = "bean";
		bean = new Object();

		beanResolver = Recorder.create("beanResolver", this, BeanResolver.class).v("resolve", bean).p();

		evaluationContext = Recorder.create("evaluationContext", this, EvaluationContext.class)
				.v("getBeanResolver", beanResolver).p();

		expressionState = new ExpressionState(evaluationContext);
	}

	@Test
	public void test() {

		BeanReference beanReference = new BeanReference(1, beanName);

		aeqr(bean, beanReference.getValueInternal(expressionState).getValue());

		aeq("@bean", beanReference.toStringAST());
	}
}
