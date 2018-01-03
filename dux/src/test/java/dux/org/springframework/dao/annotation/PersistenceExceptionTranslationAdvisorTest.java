package dux.org.springframework.dao.annotation;

import java.lang.annotation.Annotation;

import org.aopalliance.aop.Advice;
import org.junit.Test;
import org.springframework.aop.Pointcut;
import org.springframework.dao.annotation.PersistenceExceptionTranslationAdvisor;
import org.springframework.dao.support.PersistenceExceptionTranslator;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.dao.support.PersistenceExceptionTranslatorTest;

@Topic(PersistenceExceptionTranslationAdvisor.class)
@Extends({})
@ExtendedBy({})
@Related({PersistenceExceptionTranslatorTest.class})
public class PersistenceExceptionTranslationAdvisorTest extends AbstractTest {
	@Test
	public void test() {

		PersistenceExceptionTranslator persistenceExceptionTranslator = null;
		Class<? extends Annotation> repositoryAnnotationType = null;

		PersistenceExceptionTranslationAdvisor a = new PersistenceExceptionTranslationAdvisor(
				persistenceExceptionTranslator, repositoryAnnotationType);

		Advice ad = a.getAdvice();

		Pointcut p = a.getPointcut();

		/*-
		 * PersistenceExceptionTranslationAdvisor(PersistenceExceptionTranslator, Class<? extends Annotation>)
		getAdvice()
		getPointcut()
		 */
	}
}
