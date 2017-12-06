package dux.org.springframework.expression.spel.ast;

import org.junit.Test;
import org.springframework.asm.ClassWriter;
import org.springframework.asm.MethodVisitor;
import org.springframework.asm.Opcodes;
import org.springframework.expression.TypedValue;
import org.springframework.expression.spel.CodeFlow;
import org.springframework.expression.spel.ast.NullLiteral;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(NullLiteral.class)
public class NullLiteralTest extends AbstractTest {
	@Test
	public void test() {
		NullLiteral nl = new NullLiteral(1);
		aeqr(TypedValue.NULL, nl.getLiteralValue());
		aeq("null", nl.toString());
		aeq(true, nl.isCompilable());
		MethodVisitor mv = new MethodVisitor(Opcodes.ASM6) {
		};
		ClassWriter classWriter = new ClassWriter(0);
		CodeFlow cf = new CodeFlow("className", classWriter);
		nl.generateCode(mv, cf);
	}
}
