package dux.org.hibernate.secure.internal;

import org.hibernate.event.spi.PreLoadEvent;
import org.hibernate.secure.internal.JaccPreLoadEventListener;
import org.hibernate.secure.spi.JaccService;
import org.hibernate.secure.spi.PermissibleAction;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.event.spi.DummyEventSource;
import dum.org.hibernate.secure.spi.DummyJaccService;
import dum.org.hibernate.service.spi.DummyServiceRegistryImplementor;

@Done
public class JaccPreLoadEventListenerTest extends AbstractTest {

	private DummyJaccService jaccService;
	private DummyServiceRegistryImplementor serviceRegistryImplementor;
	private DummySessionFactoryImplementor sessionFactoryImplementor;
	private DummyEventSource eventSource;
	private PreLoadEvent preLoadEvent;

	@Before
	public void before() {

		jaccService = new DummyJaccService();

		serviceRegistryImplementor = new DummyServiceRegistryImplementor();
		serviceRegistryImplementor.setService(JaccService.class, jaccService);

		sessionFactoryImplementor = new DummySessionFactoryImplementor();
		sessionFactoryImplementor.setServiceRegistry(serviceRegistryImplementor);

		eventSource = new DummyEventSource();
		eventSource.setFactory(sessionFactoryImplementor);

		preLoadEvent = new PreLoadEvent(eventSource);
	}

	@Test
	public void test() {

		JaccPreLoadEventListener jaccPreLoadEventListener = new JaccPreLoadEventListener();

		jaccPreLoadEventListener.onPreLoad(preLoadEvent);

		aeq(preLoadEvent, testEvent(jaccService, 0, "entityInformation"));
		aeq(PermissibleAction.READ, testEvent(jaccService, 0, "action"));
	}
}
