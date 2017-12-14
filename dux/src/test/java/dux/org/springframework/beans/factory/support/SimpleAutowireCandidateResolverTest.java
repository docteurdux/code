package dux.org.springframework.beans.factory.support;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.support.SimpleAutowireCandidateResolver;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(SimpleAutowireCandidateResolver.class)
public class SimpleAutowireCandidateResolverTest extends AbstractTest {

	private class A {
		public String field = "dleif";
	}

	@Test
	public void test() throws NoSuchFieldException, SecurityException {
		SimpleAutowireCandidateResolver r = new SimpleAutowireCandidateResolver();
		String beanName = "beanName";
		BeanDefinition beanDefinition = new RootBeanDefinition();
		BeanDefinitionHolder bdHolder = new BeanDefinitionHolder(beanDefinition, beanName);
		DependencyDescriptor descriptor = new DependencyDescriptor(A.class.getField("field"), false, false);

		r.isAutowireCandidate(bdHolder, descriptor);
		r.isRequired(descriptor);
		r.getSuggestedValue(descriptor);
		r.getLazyResolutionProxyIfNecessary(descriptor, beanName);
	}
}
