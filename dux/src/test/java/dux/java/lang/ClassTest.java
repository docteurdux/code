package dux.java.lang;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.web.servlet.View;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.RunnableWhichThrow;
import com.github.docteurdux.test.Topic;

@Topic(Class.class)
public class ClassTest extends AbstractTest {

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	public @interface A1 {

	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	public @interface A2 {

	}

	public static interface EmptyInterface {
	}

	@A1
	public static class CwA1 {
	}

	@A1
	public static class CwA1wAeA1 {
	}

	@A1
	public static interface I {
	}

	public static interface JeI extends I {

	}

	public static interface K {

	}

	public static interface L extends K {

	}

	public static class C {

	}

	public static class CiI implements I {

		private String fieldC1 = "fieldc1";
		public String fieldC2 = "fieldc2";

		private void c() {

		}

	}

	public static class DeC extends CiI {

	}

	public static class Bouip extends DeC implements L {

	}

	public static enum E {
		V
	}

	public static class Z {

	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	public @interface RAC {
		RA[] value() default {};
	}

	@Repeatable(RAC.class)
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	public @interface RA {
		String value();
	}

	@RA("ra1")
	@RA("ra2")
	public static class CwRA {

	}

	@SuppressWarnings("unused")
	private CiI foo(Class<? extends CiI> clazz) throws InstantiationException, IllegalAccessException {
		return clazz.newInstance();
	}

	private CiI bar(CiI c) {
		return c;
	}

	@Test
	public void test() throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException {

		/* # getInterface() */

		/* getInterfaces() returns the interfaces of the class. */
		aeq(1, CiI.class.getInterfaces().length);
		aeq(I.class, CiI.class.getInterfaces()[0]);

		/* It does not return interfaces implemented by super classes. */
		aeq(0, DeC.class.getInterfaces().length);

		/* For interfaces, it returns the super interface. */
		aeq(1, JeI.class.getInterfaces().length);
		aeq(I.class, JeI.class.getInterfaces()[0]);

		/* Annotations implement com.sun.tools.classfile.Annotation */
		aeq(1, A1.class.getInterfaces().length);
		aeq(Annotation.class, A1.class.getInterfaces()[0]);

		/* Enumerations do not implement any interfaces */
		aeq(0, E.class.getInterfaces().length);

		/* # isInterface() */

		/* Interfaces and annotations are interfaces */

		aeq(true, I.class.isInterface());
		aeq(true, A1.class.isInterface());
		aeq(false, C.class.isInterface());

		/* # isPrimitive() */

		/* Only truly primitive types are primitive */

		aeq(true, int.class.isPrimitive());
		aeq(false, Integer.class.isPrimitive());
		aeq(false, int[].class.isPrimitive());
		aeq(false, E.class.isPrimitive());
		aeq(false, String.class.isPrimitive());

		/* # isAnonymousClass() is true for class that have no names */

		/* This class has a name */
		aeq(false, EmptyInterface.class.isAnonymousClass());

		/* Anonymous implementations do not have a name */
		aeq(true, new EmptyInterface() {
		}.getClass().isAnonymousClass());

		/* We can also do this kind of things */
		aeq(true, new Object() {
		}.getClass().isAnonymousClass());

		/*
		 * By the way, only classes may be local, local enums, interfaces and
		 * annotations are not possible
		 */

		/* isArray() and getComponentType() */

		/* This is not an array */
		aeq(false, int.class.isArray());
		aeq(null, int.class.getComponentType());

		/* This is an array of integers */
		aeq(true, int[].class.isArray());
		aeq(int.class, int[].class.getComponentType());

		/* This is an array of arrays of integers */
		aeq(true, int[][].class.isArray());
		aeq(int[].class, int[][].class.getComponentType());

		/* Classes have usually all the same class loader */
		aeqr(this.getClass().getClassLoader(), C.class.getClassLoader());

		/* TODO : point to an illustration of the use of different class loaders */

		/*
		 * # isAnnotation(), isAnnotationPresent(), getAnnotations(), getAnnotation(),
		 * getAnnotationsByType()
		 */

		/* Only annotations are annotations */
		aeq(true, A1.class.isAnnotation());
		aeq(false, C.class.isAnnotation());
		aeq(false, I.class.isAnnotation());

		/* Annotations presence */
		aeq(false, C.class.isAnnotationPresent(A1.class));
		aeq(true, CwA1.class.isAnnotationPresent(A1.class));

		/*
		 * getAnnotations() return proxies, so things are not as obvious as they could
		 * be
		 */
		aeq(1, CwA1.class.getAnnotations().length);
		aeq(true, Proxy.isProxyClass(CwA1.class.getAnnotations()[0].getClass()));
		aeq(true, A1.class.isAssignableFrom(CwA1.class.getAnnotations()[0].getClass()));

		/* getAnnotation() returns the annotation of the requested type if any */
		aeq(true, Proxy.isProxyClass(CwA1.class.getAnnotation(A1.class).getClass()));
		aeq(true, A1.class.isAssignableFrom(CwA1.class.getAnnotation(A1.class).getClass()));
		aeq(null, CwA1.class.getAnnotation(A2.class));

		/*
		 * getAnnotationsByType() is useful for working with repeatable annotations, and
		 * is equivalent to getAnnotation() for standard annotations
		 */

		aeq(1, CwA1.class.getAnnotationsByType(A1.class).length);
		aeq(2, CwRA.class.getAnnotationsByType(RA.class).length);

		/* let's collection all the RA values on CwRA */
		Set<String> raValues = new HashSet<>();
		for (RA ra : CwRA.class.getAnnotationsByType(RA.class)) {
			raValues.add(ra.value());
		}
		aeq(true, raValues.contains("ra1"));
		aeq(true, raValues.contains("ra2"));

		/* # isAssignableFrom() */

		/* isAssignableFrom() returns whether the argument is a subclass */
		aeq(true, I.class.isAssignableFrom(CiI.class));

		/* # isEnum() */

		/* isEnum() returns whether the type is an enum */

		aeq(true, E.class.isEnum());

		/* # isLocalClass() */

		class LocalClass {
		}

		/* isLocalClass() returns true for local classes */

		aeq(true, LocalClass.class.isLocalClass());

		/* anonymous classes are not local */

		aeq(false, new I() {
		}.getClass().isLocalClass());

		/* and local classes are not anonymous */

		aeq(false, LocalClass.class.isAnonymousClass());

		/*
		 * # isMemberClass() returns whether a class is defined within another class,
		 * next to other class members
		 */

		aeq(true, C.class.isMemberClass());
		aeq(false, this.getClass().isMemberClass());
		aeq(false, LocalClass.class.isMemberClass());
		
		if (t()) {
			return;
		}


		aeq("dux.java.lang.ClassTest$C", CiI.class.getTypeName());
		aeq("dux.java.lang.ClassTest$1Y", LocalClass.class.getTypeName());
		aeq("dux.java.lang.ClassTest$3", new I() {

		}.getClass().getTypeName());

		aeq(true, I.class.desiredAssertionStatus());

		aeq("dux.java.lang", I.class.getPackage().getName());

		Class<?> clazz = DeC.class;

		// invalid :
		// aeq(D.class, foo(clazz)).getClass());

		// valid :
		aeq(DeC.class, foo(clazz.asSubclass(CiI.class)).getClass());

		Object o = new DeC();
		aeqr(o, bar(CiI.class.cast(o)));

		aeq("dux.java.lang.ClassTest$C", CiI.class.getName());

		aeq(true, CiI.class.getProtectionDomain() != null);

		aeq(null, CiI.class.getSigners());

		aeq(true, DeC.class.isInstance(o));

		aeq(DeC.class, DeC.class.newInstance().getClass());

		aeq(CiI.class, DeC.class.getSuperclass());
		aeq(null, JeI.class.getSuperclass());
		aeq(null, Object.class.getSuperclass());
		aeq(Enum.class, E.class.getSuperclass());

		// See test about Modifier.class
		aeq(false, CiI.class.getModifiers() == 0);

		aeq(10, CiI.class.getMethods().length);
		aeq(true, CiI.class.getMethod("i") != null);
		aeq(true, CiI.class.getMethod("toString") != null);
		expect(NoSuchMethodException.class, new RunnableWhichThrow() {
			@Override
			public void run() throws Exception {
				CiI.class.getMethod("c");
			}
		});
		for (Method m : CiI.class.getMethods()) {
			System.out.println(m.getName());
		}
		aeq(2, CiI.class.getDeclaredMethods().length);
		for (Method m : CiI.class.getDeclaredMethods()) {
			System.out.println(m.getName());
		}
		aeq(true, CiI.class.getDeclaredMethod("i") != null);
		aeq(true, CiI.class.getDeclaredMethod("c") != null);
		expect(NoSuchMethodException.class, new RunnableWhichThrow() {
			@Override
			public void run() throws Exception {
				CiI.class.getDeclaredMethod("toString");
			}
		});

		/*-
		forName(String)
		forName(String, boolean, ClassLoader)
		getAnnotatedInterfaces()
		getAnnotatedSuperclass()
		getCanonicalName()
		getClasses()
		getConstructor(Class<?>...)
		getConstructors()
		getDeclaredAnnotation(Class<A>)
		getDeclaredAnnotations()
		getDeclaredAnnotationsByType(Class<A>)
		getDeclaredClasses()
		getDeclaredConstructor(Class<?>...)
		getDeclaredConstructors()
		getDeclaredField(String)
		getDeclaredFields()
		getDeclaringClass()
		getEnclosingClass()
		getEnclosingConstructor()
		getEnclosingMethod()
		getEnumConstants()
		getField(String)
		getFields()
		getGenericInterfaces()
		getGenericSuperclass()
		getResource(String)
		getResourceAsStream(String)
		getSimpleName()
		getTypeParameters()
		isSynthetic()
		toGenericString()
		toString()
		 */
		
		aeq(false, Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class<?>[] { View.class },
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						return null;
					}
				}).getClass().isSynthetic());
	}
}
