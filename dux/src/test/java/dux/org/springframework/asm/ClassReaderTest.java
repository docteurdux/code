package dux.org.springframework.asm;

import org.junit.Test;
import org.springframework.asm.ClassReader;
import org.springframework.expression.spel.ast.BooleanLiteral;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.expression.spel.standard.SpelCompilerTest;

@Topic(ClassReader.class)
public class ClassReaderTest extends AbstractTest {

	static final byte UTF8 = 1;

	@Test
	public void test() {

		byte[] bytes = SpelCompilerTest.generateExpressionClassBytes(new BooleanLiteral("true", 1, true));

		ClassReader r = new ClassReader(bytes);

		aeq(22, r.getItemCount());
		int strOffset = r.getItem(0) + 10;
		aeq(UTF8, bytes[strOffset]);
		int length = (bytes[strOffset + 1] << 8) + bytes[strOffset + 2];
		int startOffset = strOffset + 3;
		aeq("spel/Ex1", new String(bytes, startOffset, length));

	}
}
