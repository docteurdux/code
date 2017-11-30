package dux.org.junit.runner;

import java.io.Serializable;
import java.lang.annotation.Annotation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Description;

import com.github.docteurdux.test.AbstractTest;

public class DescriptionTest extends AbstractTest {

	public static class T {
		
	}
	
	private Class<?> clazz;
	private String name;
	private Annotation[] annotations;
	private Serializable uniqueId;
	private String className;

	@Before
	public void before() {

		requireSources("junit-4.12", Description.class);

		clazz = T.class;
		name = "name";
		annotations = new Annotation[] {};
		uniqueId = new Serializable() {
			private static final long serialVersionUID = 1L;
		};
		className = "className";
	}

	@Test
	public void test() {

//		Description.EMPTY.getClass();
//		Description.TEST_MECHANISM.getClass();

		Description.createSuiteDescription(clazz);
//		Description.createSuiteDescription(name, annotations);
//		Description.createSuiteDescription(name, uniqueId, annotations);
//
//		Description.createTestDescription(clazz, name);
//		Description.createTestDescription(clazz, name, annotations);
//		Description.createTestDescription(className, name, annotations);
//		Description.createTestDescription(className, className, uniqueId);
	}
}
