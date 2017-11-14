package dux.org.hibernate.bytecode.enhance.internal.javassist;

import java.util.HashSet;
import java.util.Set;

import javassist.CtClass;

public class DummyCtClass extends CtClass {

	Set<Class<?>> annotationsSet = new HashSet<>();

	protected DummyCtClass(String name) {
		super(name);
	}

}
