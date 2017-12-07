package dux.org.springframework.asm;

import org.junit.Test;
import org.springframework.asm.ClassWriter;
import org.springframework.asm.MethodVisitor;
import org.springframework.asm.Opcodes;

import com.github.docteurdux.test.AbstractTest;

public class MethodWriterTest extends AbstractTest {
	@Test
	public void test() {
		ClassWriter cw = new ClassWriter(0);
		MethodVisitor mw = cw.visitMethod(0, "n", "d", "s", new String[] {});
		mw.visitInsn(Opcodes.DUP);
		byte[] bytes = cw.toByteArray();
		dumpBytes(bytes);
		/*-
		visitAnnotation(String, boolean)
		visitAnnotationDefault()
		visitAttribute(Attribute)
		visitCode()
		visitEnd()
		visitFieldInsn(int, String, String, String)
		visitFrame(int, int, Object[], int, Object[])
		visitIincInsn(int, int)
		visitInsn(int)
		visitInsnAnnotation(int, TypePath, String, boolean)
		visitIntInsn(int, int)
		visitInvokeDynamicInsn(String, String, Handle, Object...)
		visitJumpInsn(int, Label)
		visitLabel(Label)
		visitLdcInsn(Object)
		visitLineNumber(int, Label)
		visitLocalVariable(String, String, String, Label, Label, int)
		visitLocalVariableAnnotation(int, TypePath, Label[], Label[], int[], String, boolean)
		visitLookupSwitchInsn(Label, int[], Label[])
		visitMaxs(int, int)
		visitMethodInsn(int, String, String, String, boolean)
		visitMultiANewArrayInsn(String, int)
		visitParameter(String, int)
		visitParameterAnnotation(int, String, boolean)
		visitTableSwitchInsn(int, int, Label, Label...)
		visitTryCatchAnnotation(int, TypePath, String, boolean)
		visitTryCatchBlock(Label, Label, Label, String)
		visitTypeAnnotation(int, TypePath, String, boolean)
		visitTypeInsn(int, String)
		visitVarInsn(int, int)
		 */
	}
}
