package com.github.docteurdux.test;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class Instrumenter {

	private static ClassPool classPool = ClassPool.getDefault();

	public static void instrument(String className) {
		try {
			CtClass cc = classPool.get(className);
			if (cc.getSuperclass() != null) {
				String superClassName = cc.getSuperclass().getName();
				instrument(superClassName);

			}
			for (CtMethod m : cc.getMethods()) {
				CtClass declaringClass = m.getDeclaringClass();
				if (className.equals(declaringClass.getName())) {
					String n = m.getName();
					m.insertBefore("com.github.docteurdux.test.Instrumenter.hello(\"" + n + "\");");
				}
			}
			cc.toClass();
		} catch (Exception ex) {
			System.out.println("Failed to instrument " + className + " : " + ex.getClass().getSimpleName() + " : "
					+ ex.getMessage());

		}
	}

	public static void hello(String name) {
		System.out.println("Hello from " + name);
	}

}
