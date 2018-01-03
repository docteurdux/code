package dux.org.springframework.dao.support;

import org.junit.Test;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaDialect;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(PersistenceExceptionTranslator.class)
@Extends({})
@ExtendedBy({ AbstractEntityManagerFactoryBean.class, ChainedPersistenceExceptionTranslatorTest.class,
		HibernateExceptionTranslator.class, JpaDialect.class })
@Related({})
public class PersistenceExceptionTranslatorTest extends AbstractTest {
	@Test
	public void test() {
		/*-
		 * translateExceptionIfPossible(RuntimeException)
		 */

	}
}