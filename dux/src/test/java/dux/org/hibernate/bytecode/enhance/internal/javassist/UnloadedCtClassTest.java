package dux.org.hibernate.bytecode.enhance.internal.javassist;

import java.lang.annotation.Annotation;

import org.hibernate.bytecode.enhance.internal.javassist.UnloadedCtClass;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class UnloadedCtClassTest extends AbstractTest {

	private DummyCtClass ctClass;

	@Before
	public void before() {
		ctClass = new DummyCtClass("name");
	}

	@Test
	public void test() {

		UnloadedCtClass ucc = new UnloadedCtClass(ctClass);
		af(ucc.hasAnnotation(Annotation.class));
		aeq("name", ucc.getName());

	}
}
