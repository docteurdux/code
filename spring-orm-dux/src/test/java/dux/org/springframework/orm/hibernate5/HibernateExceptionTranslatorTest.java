package dux.org.springframework.orm.hibernate5;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

/**
 * Hibernate Exception translation is delegated to SessionFactoryUtils
 * Persistence Exception tranlsation is delegated to EntityManagerFactoryUtils
 */
@Done
public class HibernateExceptionTranslatorTest extends AbstractTest {

	private HibernateExceptionTranslator translator;

	@Before
	public void before() {
		translator = new HibernateExceptionTranslator();
	}

	@Test
	public void test1() {
		RuntimeException ex = new RuntimeException();
		DataAccessException tex = translator.translateExceptionIfPossible(ex);
		an(tex);
	}

	@Test
	public void test2() {
		HibernateException ex = new HibernateException("");
		DataAccessException tex = translator.translateExceptionIfPossible(ex);
		ann(tex);
	}

	@Test
	public void test3() {
		PersistenceException ex = new PersistenceException(new HibernateException(""));
		DataAccessException tex = translator.translateExceptionIfPossible(ex);
		ann(tex);
	}

	@Test
	public void test4() {
		PersistenceException ex = new PersistenceException("");
		DataAccessException tex = translator.translateExceptionIfPossible(ex);
		ann(tex);
	}
}
