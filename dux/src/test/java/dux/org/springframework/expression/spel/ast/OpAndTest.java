package dux.org.springframework.expression.spel.ast;

import org.junit.Test;
import org.springframework.asm.ClassWriter;
import org.springframework.asm.MethodVisitor;
import org.springframework.expression.spel.CodeFlow;
import org.springframework.expression.spel.ast.BooleanLiteral;
import org.springframework.expression.spel.ast.OpAnd;

import com.github.docteurdux.test.AbstractTest;

public class OpAndTest extends AbstractTest {
	@Test
	public void test() {
		BooleanLiteral operand1 = new BooleanLiteral("", 1, true);
		BooleanLiteral operand2 = new BooleanLiteral("", 1, false);
		OpAnd o = new OpAnd(1, operand1, operand2);
		ClassWriter cw = new ClassWriter(0);
		MethodVisitor mv = cw.visitMethod(0, "name", "desc", "", new String[] {});
		CodeFlow cf = new CodeFlow("className", cw);
		o.generateCode(mv, cf);
		byte[] bytes = cw.toByteArray();
		dumpBytes(bytes);
	}
}
