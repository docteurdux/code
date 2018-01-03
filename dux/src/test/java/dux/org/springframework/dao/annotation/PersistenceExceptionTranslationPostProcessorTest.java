package dux.org.springframework.dao.annotation;

import java.lang.annotation.Annotation;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(PersistenceExceptionTranslationPostProcessor.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class PersistenceExceptionTranslationPostProcessorTest extends AbstractTest {
	@Test
	public void test() {

		BeanFactory beanFactory = null;
		Class<? extends Annotation> repositoryAnnotationType = null;

		PersistenceExceptionTranslationPostProcessor p = new PersistenceExceptionTranslationPostProcessor();
		p.setBeanFactory(beanFactory);
		p.setRepositoryAnnotationType(repositoryAnnotationType);

		/*-
		PersistenceExceptionTranslationPostProcessor()
		setBeanFactory(BeanFactory)
		setRepositoryAnnotationType(Class<? extends Annotation>)
		 */
	}
}