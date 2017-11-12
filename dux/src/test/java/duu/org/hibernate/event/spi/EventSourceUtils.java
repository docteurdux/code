package duu.org.hibernate.event.spi;

import org.hibernate.secure.spi.JaccService;

import com.github.docteurdux.test.Instances;

import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.event.spi.DummyEventSource;
import dum.org.hibernate.secure.spi.DummyJaccService;
import dum.org.hibernate.service.spi.DummyServiceRegistryImplementor;

public class EventSourceUtils {

	public static DummyEventSource getAnInstance(Instances instances) {

		DummyJaccService jaccService = new DummyJaccService();

		DummyServiceRegistryImplementor serviceRegistryImplementor = new DummyServiceRegistryImplementor();
		serviceRegistryImplementor.setService(JaccService.class, jaccService);

		DummySessionFactoryImplementor sessionFactoryImplementor = new DummySessionFactoryImplementor();
		sessionFactoryImplementor.setServiceRegistry(serviceRegistryImplementor);

		DummyEventSource eventSource = new DummyEventSource();
		eventSource.setFactory(sessionFactoryImplementor);

		instances.set(jaccService);

		return eventSource;
	}

}
