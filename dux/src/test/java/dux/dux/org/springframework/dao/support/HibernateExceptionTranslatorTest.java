package dux.dux.org.springframework.dao.support;

import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(HibernateExceptionTranslator.class)
@Extends({})
@ExtendedBy({})
@Related({SessionFactoryUtils.class, EntityManagerFactoryUtils.class})
public class HibernateExceptionTranslatorTest extends AbstractTest {
	@Test
	public void test() {
		HibernateExceptionTranslator t = new HibernateExceptionTranslator();
		RuntimeException ex = null;
		DataAccessException r = t.translateExceptionIfPossible(ex);
	}
}