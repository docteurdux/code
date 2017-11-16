package dux.org.hibernate.bytecode.enhance.internal.bytebuddy;

import java.lang.annotation.Annotation;

import org.hibernate.bytecode.enhance.internal.bytebuddy.DummyUnloadedFieldDescription;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.net.bytebuddy.description.annotation.DummyAnnotationList;
import dum.net.bytebuddy.description.field.DummyFieldDescription;

@Done
public class UnloadedFieldDescriptionTest extends AbstractTest {
	
	private DummyAnnotationList annotationList;
	private DummyFieldDescription fieldDescription;

	@Before
	public void before() {
		annotationList = new DummyAnnotationList();
		annotationList.setAnnotationPresent(Annotation.class, true);
		fieldDescription = new DummyFieldDescription();
		fieldDescription.setAnnotationList(annotationList);
	}

	@Test
	public void test() {
		DummyUnloadedFieldDescription unloadedFieldDescription = new DummyUnloadedFieldDescription(fieldDescription);
		at(unloadedFieldDescription.hasAnnotation(Annotation.class));

	}
}
