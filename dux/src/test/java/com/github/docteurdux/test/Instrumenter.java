package com.github.docteurdux.test;

import java.lang.reflect.Modifier;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class Instrumenter {

	private static ClassPool classPool = ClassPool.getDefault();

	public static Class instrument(String className) {
		try {
			CtClass cc = classPool.get(className);
			if (cc.getSuperclass() != null) {
				String superClassName = cc.getSuperclass().getName();
				instrument(superClassName);

			}
			for (CtMethod m : cc.getMethods()) {
				if (Modifier.isStatic(m.getModifiers())) {
					continue;
				}
				CtClass declaringClass = m.getDeclaringClass();
				if (className.equals(declaringClass.getName())) {
					String n = m.getName();
					m.insertBefore("com.github.docteurdux.test.Instrumenter.hello(this,\"" + n + "\", $args);");
				}
			}
			return cc.toClass();
		} catch (Exception ex) {
			System.out.println("Failed to instrument " + className + " : " + ex.getClass().getSimpleName() + " : "
					+ ex.getMessage());

		}
		return null;
	}

	public static void hello(Object o, String name, Object[] args) {
		TestEvents.record(o, name, args);
	}

}
