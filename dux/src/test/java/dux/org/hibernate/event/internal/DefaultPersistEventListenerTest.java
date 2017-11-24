package dux.org.hibernate.event.internal;

import org.hibernate.engine.spi.EntityEntry;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.internal.DefaultPersistEventListener;
import org.hibernate.event.spi.PersistEvent;
import org.hibernate.metamodel.spi.MetamodelImplementor;
import org.hibernate.persister.entity.EntityPersister;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.RunnableWithArgs;

import dum.org.hibernate.engine.spi.DummyEntityEntry;
import dum.org.hibernate.engine.spi.DummyPersistenceContext;
import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.event.spi.DummyEventSource;
import dum.org.hibernate.metamodel.spi.DummyMetamodelImplementor;
import dum.org.hibernate.persister.entity.DummyEntityPersister;
import dus.hibernate.core.HibernateCoreSummaryTest;

public class DefaultPersistEventListenerTest extends AbstractTest {

	@Before
	public void before() {
		requireSources(HibernateCoreSummaryTest.MVNNAME, DefaultPersistEventListener.class);
	}

	@Test
	public void test() {
		DummyEntityEntry entityEntry = new DummyEntityEntry();
		Object object = new Object();
		DummyEventSource source = new DummyEventSource();
		DummySessionFactoryImplementor factory = new DummySessionFactoryImplementor();
		DummyMetamodelImplementor metamodel = new DummyMetamodelImplementor();
		DummyEntityPersister ep = new DummyEntityPersister();

		factory.setMetamodel(metamodel);
		metamodel.setEntityPersisterRWA(new RunnableWithArgs<EntityPersister>() {
			@Override
			public EntityPersister run(Object... args) {
				return ep;
			}
		});
		source.setFactory(factory);
		DummyPersistenceContext persistenceContext = new DummyPersistenceContext();
		persistenceContext.setGetEntryRWA(new RunnableWithArgs<EntityEntry>() {
			@Override
			public EntityEntry run(Object... args) {
				return entityEntry;
			}
		});
		source.setPersistenceContext(persistenceContext);
		PersistEvent event = new PersistEvent(object, source);
		event.setEntityName("entityName");
		DefaultPersistEventListener l = new DefaultPersistEventListener();
		l.onPersist(event);
	}
}
