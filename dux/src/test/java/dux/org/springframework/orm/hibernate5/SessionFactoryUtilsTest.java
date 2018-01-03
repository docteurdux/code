package dux.org.springframework.orm.hibernate5;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.JDBCConnectionException;
import org.junit.Test;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate5.SessionFactoryUtils;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(SessionFactoryUtils.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class SessionFactoryUtilsTest extends AbstractTest {
	@Test
	public void test() {

		if (t()) {
			return;
		}

		Session session = null;
		SessionFactory sessionFactory = null;
		HibernateException ex = null;

		SessionFactoryUtils.closeSession(session);
		SessionFactoryUtils.getDataSource(sessionFactory);
		SessionFactoryUtils.convertHibernateAccessException(ex);

	}
}