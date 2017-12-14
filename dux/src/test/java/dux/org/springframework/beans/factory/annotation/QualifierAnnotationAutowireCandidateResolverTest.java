package dux.org.springframework.beans.factory.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.core.MethodParameter;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.beans.factory.support.GenericTypeAwareAutowireCandidateResolverTest;

@Topic(QualifierAnnotationAutowireCandidateResolver.class)
@Related({ GenericTypeAwareAutowireCandidateResolverTest.class })
public class QualifierAnnotationAutowireCandidateResolverTest extends AbstractTest {

	private class C {

		@Value("field")
		private String field;

		@Value("barp")
		public void method(@Value("foop") String foop, String barp) {

		}

	}

	@Test
	public void test() throws NoSuchFieldException, SecurityException, NoSuchMethodException {

		QualifierAnnotationAutowireCandidateResolver q = new QualifierAnnotationAutowireCandidateResolver();

		Field field = C.class.getDeclaredField("field");
		DependencyDescriptor fieldDescriptor = new DependencyDescriptor(field, false, false);
		aeq("field", q.getSuggestedValue(fieldDescriptor));

		Method method = C.class.getMethod("method", String.class, String.class);
		MethodParameter methodParameter0 = new MethodParameter(method, 0);
		DependencyDescriptor methodDescriptor0 = new DependencyDescriptor(methodParameter0, false, false);
		aeq("foop", q.getSuggestedValue(methodDescriptor0));

		MethodParameter methodParameter1 = new MethodParameter(method, 1);
		DependencyDescriptor methodDescriptor1 = new DependencyDescriptor(methodParameter1, false, false);
		aeq("barp", q.getSuggestedValue(methodDescriptor1));

		if (t()) {
			return;
		}

		Class<? extends Annotation> qualifierType = null;
		q.addQualifierType(qualifierType);

		/*-
		addQualifierType(Class<? extends Annotation>)
		getSuggestedValue(DependencyDescriptor)
		isAutowireCandidate(BeanDefinitionHolder, DependencyDescriptor)
		isRequired(DependencyDescriptor)
		setValueAnnotationType(Class<? extends Annotation>)
		 */
	}
}
