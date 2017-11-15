package dum.org.hibernate.persister.spi;

import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.persister.spi.PersisterCreationContext;

public class DummyPersisterCreationContext implements PersisterCreationContext {

	private SessionFactoryImplementor sessionFactory;

	@Override
	public SessionFactoryImplementor getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactoryImplementor sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public MetadataImplementor getMetadata() {
		// TODO Auto-generated method stub
		return null;
	}

}
