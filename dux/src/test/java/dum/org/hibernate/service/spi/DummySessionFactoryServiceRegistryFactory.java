package dum.org.hibernate.service.spi;

import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;
import org.hibernate.service.spi.SessionFactoryServiceRegistryFactory;

public class DummySessionFactoryServiceRegistryFactory implements SessionFactoryServiceRegistryFactory {

	private static final long serialVersionUID = 1L;
	private SessionFactoryServiceRegistry serviceRegistry;

	@Override
	public SessionFactoryServiceRegistry buildServiceRegistry(SessionFactoryImplementor sessionFactory,
			SessionFactoryOptions sessionFactoryOptions) {
		return serviceRegistry;
	}

	public void setServiceRegistry(SessionFactoryServiceRegistry serviceRegistry) {
		this.serviceRegistry = serviceRegistry;
	}

}
