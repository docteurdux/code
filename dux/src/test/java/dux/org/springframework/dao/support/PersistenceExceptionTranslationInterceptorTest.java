package dux.org.springframework.dao.support;

import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.dao.support.PersistenceExceptionTranslationInterceptor;
import org.springframework.dao.support.PersistenceExceptionTranslator;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(PersistenceExceptionTranslationInterceptor.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class PersistenceExceptionTranslationInterceptorTest extends AbstractTest {
	@Test
	public void test() throws Throwable {

		ListableBeanFactory beanFactory = null;
		PersistenceExceptionTranslator pet = null;

		PersistenceExceptionTranslationInterceptor p = new PersistenceExceptionTranslationInterceptor();
		p = new PersistenceExceptionTranslationInterceptor(beanFactory);
		p = new PersistenceExceptionTranslationInterceptor(pet);

		MethodInvocation mi = null;
		boolean alwaysTranslate = false;

		p.afterPropertiesSet();
		p.invoke(mi);
		p.setAlwaysTranslate(alwaysTranslate);
		p.setBeanFactory(beanFactory);
		p.setPersistenceExceptionTranslator(pet);

		
	}
}
