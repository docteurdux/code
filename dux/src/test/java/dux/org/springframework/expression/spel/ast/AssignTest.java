package dux.org.springframework.expression.spel.ast;

import org.junit.Test;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.expression.spel.ast.BooleanLiteral;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(Assign.class)
public class AssignTest extends AbstractTest {
	@Test
	public void test() {
		BooleanLiteral T = new BooleanLiteral("foo", 1, true);
		BooleanLiteral F = new BooleanLiteral("bar", 1, false);
		Assign a = new Assign(1, T, F);
		aeq("true=false", a.toStringAST());
	}
}
