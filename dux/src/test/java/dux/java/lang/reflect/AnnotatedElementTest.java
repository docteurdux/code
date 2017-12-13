package dux.java.lang.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Consumer;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(AnnotatedElement.class)
@Related({GenericDeclarationTest.class})
public class AnnotatedElementTest extends AbstractTest {

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	public @interface A1 {

	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	public @interface A2 {

	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.METHOD)
	public @interface A3 {

	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.PARAMETER)
	public @interface A4 {

	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.CONSTRUCTOR)
	public @interface A5 {

	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE_PARAMETER)
	public @interface A6 {

	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE_USE)
	public @interface A7 {

	}

	@A1
	public static class C {

		@A2
		public String field;

		@A5
		public C() {

		}

		@A3
		public void method(@A4 String param) {

		}

		public <@A6 T> T methodp() {
			return null;
		}
	}

	@Test
	public void test() throws NoSuchFieldException, SecurityException, NoSuchMethodException {

		Class<C> clazz = C.class;
		Class<A1> annotationClass = A1.class;

		aeq(true, clazz instanceof AnnotatedElement);
		aeq(true, C.class.getAnnotation(annotationClass) != null);
		aeq(1, C.class.getAnnotations().length);
		aeq(1, C.class.getAnnotationsByType(A1.class).length);
		aeq(true, C.class.getDeclaredAnnotation(A1.class) != null);
		aeq(1, C.class.getDeclaredAnnotations().length);
		aeq(true, C.class.isAnnotationPresent(A1.class));

		Field field = C.class.getField("field");
		aeq(true, field instanceof AnnotatedElement);

		Method method = C.class.getMethod("method", String.class);
		aeq(true, method instanceof AnnotatedElement);

		aeq(true, method.getParameters()[0] instanceof AnnotatedElement);

		aeq(true, clazz.getPackage() instanceof AnnotatedElement);

		aeq(true, clazz.getConstructor() instanceof AnnotatedElement);

		new C().<@A7 Object>methodp();

		// https://dzone.com/articles/java-8-type-annotations

		Consumer<Object[]> a = Arrays::<@A7 Integer>sort;

		/*-
		getAnnotation(Class<T>)
		getAnnotations()
		getAnnotationsByType(Class<T>)
		getDeclaredAnnotation(Class<T>)
		getDeclaredAnnotations()
		getDeclaredAnnotationsByType(Class<T>)
		isAnnotationPresent(Class<? extends Annotation>)
		 */

	}

}
