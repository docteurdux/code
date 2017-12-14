package dux.org.springframework.beans.factory.config;

import java.lang.reflect.Field;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.core.ParameterNameDiscoverer;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(DependencyDescriptor.class)
public class DependencyDescriptorTest extends AbstractTest {

	public static class A {
		public String field = "dleif";
	}

	@Test
	public void test() throws NoSuchFieldException, SecurityException {
		Field field = A.class.getField("field");
		boolean required = false;
		boolean eager = false;
		DependencyDescriptor dd = new DependencyDescriptor(field, required, eager);

		aeq(false, dd.isRequired());
		aeq(false, dd.isEager());

		ParameterNameDiscoverer parameterNameDiscoverer = null;
		String beanName = null;
		Class<?> requiredType = null;
		BeanFactory beanFactory = null;
		Map<String, Object> matchingBeans = null;
		Class<?> type = null;
		Class<?> containingClass = null;

		dd.fallbackMatchAllowed();
		dd.forFallbackMatch();
		dd.getDependencyName();
		dd.getDeclaredType();
		dd.getResolvableType();
		dd.increaseNestingLevel();
		dd.initParameterNameDiscovery(parameterNameDiscoverer);
		dd.resolveCandidate(beanName, requiredType, beanFactory);
		dd.resolveNotUnique(type, matchingBeans);
		dd.resolveShortcut(beanFactory);
		dd.setContainingClass(containingClass);

		/*-
		DependencyDescriptor(Field, boolean)
		DependencyDescriptor(Field, boolean, boolean)
		DependencyDescriptor(DependencyDescriptor)
		DependencyDescriptor(MethodParameter, boolean)
		DependencyDescriptor(MethodParameter, boolean, boolean)
		equals(Object)
		fallbackMatchAllowed()
		forFallbackMatch()
		getDependencyName()
		getDependencyType()
		getResolvableType()
		increaseNestingLevel()
		initParameterNameDiscovery(ParameterNameDiscoverer)
		resolveCandidate(String, Class<?>, BeanFactory)
		resolveNotUnique(Class<?>, Map<String, Object>)
		resolveShortcut(BeanFactory)
		setContainingClass(Class<?>)
		 */

	}
}
