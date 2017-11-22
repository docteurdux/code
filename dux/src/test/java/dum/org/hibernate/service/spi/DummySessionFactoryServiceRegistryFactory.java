package dum.org.hibernate.service.spi;

import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;
import org.hibernate.service.spi.SessionFactoryServiceRegistryFactory;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummySessionFactoryServiceRegistryFactory implements SessionFactoryServiceRegistryFactory {

	private static final long serialVersionUID = 1L;
	private SessionFactoryServiceRegistry serviceRegistry;
	private RunnableWithArgs<SessionFactoryServiceRegistry> buildServiceRegistryRWA;

	@Override
	public SessionFactoryServiceRegistry buildServiceRegistry(SessionFactoryImplementor sessionFactory,
			SessionFactoryOptions sessionFactoryOptions) {
		if (buildServiceRegistryRWA != null) {
			return buildServiceRegistryRWA.run(sessionFactory, sessionFactoryOptions);
		}
		return serviceRegistry;
	}

	public void setBuildServiceRegistryRWA(RunnableWithArgs<SessionFactoryServiceRegistry> buildServiceRegistryRWA) {
		this.buildServiceRegistryRWA = buildServiceRegistryRWA;
	}

	@Deprecated
	public void setServiceRegistry(SessionFactoryServiceRegistry serviceRegistry) {
		this.serviceRegistry = serviceRegistry;
	}

}
