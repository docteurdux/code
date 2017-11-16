package org.hibernate.bytecode.enhance.internal.bytebuddy;

import java.lang.annotation.Annotation;

import net.bytebuddy.description.field.FieldDescription;

public class DummyUnloadedFieldDescription {

	private UnloadedFieldDescription instance;

	public DummyUnloadedFieldDescription(FieldDescription fieldDescription) {
		instance = new UnloadedFieldDescription(fieldDescription);
	}

	public boolean hasAnnotation(Class<? extends Annotation> annotationType) {
		return instance.hasAnnotation(annotationType);
	}

}
