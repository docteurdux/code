package dux.org.springframework.orm.hibernate5;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.TransactionDefinition;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.TestEvents;

public class HibernateTransactionManagerTest extends AbstractTest {
	@Test
	public void test() {
		SessionFactory sessionFactory = Recorder.create("sessionFactory", this, SessionFactory.class).p();
		HibernateTransactionManager h = new HibernateTransactionManager(sessionFactory);
		h.afterPropertiesSet();
		TransactionDefinition definition = null;
		h.getTransaction(definition);
		dumpTestEvents(TestEvents.getTestEvents());
	}
}
