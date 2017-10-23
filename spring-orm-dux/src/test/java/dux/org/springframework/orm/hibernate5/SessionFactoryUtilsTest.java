package dux.org.springframework.orm.hibernate5;

import org.hibernate.HibernateException;
import org.junit.Test;
import org.springframework.orm.hibernate5.SessionFactoryUtils;

import com.github.docteurdux.test.AbstractTest;

import dum.org.hibernate.DummySession;

public class SessionFactoryUtilsTest extends AbstractTest {
	@Test
	public void test() {

		aeq(900, SessionFactoryUtils.SESSION_SYNCHRONIZATION_ORDER);

		DummySession session = new DummySession();
		SessionFactoryUtils.closeSession(session);
		aeq(1, session.getEvents().size());
		aeq("close", session.getEvents().get(0).getName());

		SessionFactoryUtils.closeSession(null);

		
		session = new DummySession();
		session.setThrow("close", new HibernateException(""));
		SessionFactoryUtils.closeSession(session);
	}
}
