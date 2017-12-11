package dux.org.springframework.beans.factory;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

import org.junit.Test;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.core.MethodParameter;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(InjectionPoint.class)
public class InjectionPointTest extends AbstractTest {

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	public static @interface A1 {

	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	public static @interface A2 {

	}

	@A1
	public static class C {
		@A2
		private String foo = "foo";
	}

	@Test
	public void test() throws NoSuchFieldException, SecurityException {

		Field field = C.class.getDeclaredField("foo");

		InjectionPoint p = new InjectionPoint(field);

		aeqr(field, p.getField());
		aeqr(field, p.getAnnotatedElement());
		aeq(true, p.getAnnotation(A2.class) != null);
		aeq(1, p.getAnnotations().length);
		aeq(String.class, p.getDeclaredType());
		aeqr(field, p.getMember());
		aeq(null, p.getMethodParameter());
		
		MethodParameter parameter = null;
		p = new InjectionPoint(parameter );

		if (t()) {
			return;
		}

		p.getAnnotatedElement();
		p.getAnnotation(Annotation.class);
		p.getAnnotations();
		p.getDeclaredType();
		p.getMember();
		p.getMethodParameter();

		/*-
		equals(Object)
		getAnnotatedElement()
		getAnnotation(Class<A>)
		getAnnotations()
		getDeclaredType()
		getField()
		getMember()
		getMethodParameter()
		hashCode()
		toString()
		 */

	}
}
