package dux.org.springframework.expression.spel.ast;

import org.junit.Test;
import org.springframework.asm.MethodVisitor;
import org.springframework.expression.spel.ast.Assign;

import com.github.docteurdux.test.AbstractTest;

public class AssignTest extends AbstractTest {
	@Test
	public void test() {
		Assign a = new Assign(1);
		
	}
}
