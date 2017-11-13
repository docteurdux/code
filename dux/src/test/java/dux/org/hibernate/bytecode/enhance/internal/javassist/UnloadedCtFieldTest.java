package dux.org.hibernate.bytecode.enhance.internal.javassist;

import java.io.DataInputStream;
import java.io.InputStream;
import java.lang.annotation.Annotation;

import org.hibernate.bytecode.enhance.internal.javassist.UnloadedCtField;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import javassist.CtClass;
import javassist.CtField;
import javassist.bytecode.ClassFile;

@Done
public class UnloadedCtFieldTest extends AbstractTest {

	private CtField ctField;
	private Class<Annotation> annotationType;

	@Before
	public void before() throws Exception {

		String path = this.getClass().getName().replaceAll("\\.", "/") + ".class";
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(path);
		ClassFile classFile = new ClassFile(new DataInputStream(is));
		CtClass type = new CtClass(Object.class.getName()) {
			@Override
			public ClassFile getClassFile2() {
				return classFile;
			}
		};
		ctField = new CtField(type, "name", type);
		annotationType = Annotation.class;
	}

	@Test
	public void test() {
		UnloadedCtField unloadedCtField = new UnloadedCtField(ctField);
		af(unloadedCtField.hasAnnotation(annotationType));
	}
}
