package dux.org.hibernate.action.internal;

import java.io.Serializable;

import org.hibernate.action.internal.EntityDeleteAction;
import org.hibernate.action.internal.OrphanRemovalAction;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.engine.spi.DummyPersistenceContext;
import dum.org.hibernate.engine.spi.DummySessionImplementor;
import dum.org.hibernate.engine.spi.PersistenceContext.DummyNaturalIdHelper;
import dum.org.hibernate.persister.entity.DummyEntityPersister;

@Done
public class OrphanRemovalActionTest extends AbstractTest {

	private boolean isCascadeDeleteEnabled;

	private Object instance;
	private Object version;

	private Object[] states;

	private Serializable id;

	private DummyEntityPersister entityPersister;

	private DummyNaturalIdHelper naturalIdHelper;

	private DummyPersistenceContext persistenceContext;

	private DummySessionImplementor sessionImplementor;

	@Before
	public void before() {

		isCascadeDeleteEnabled = false;

		instance = new Object();
		version = new Object();

		states = new Object[] {};

		id = new Serializable() {
			private static final long serialVersionUID = 1L;
		};

		entityPersister = new DummyEntityPersister();

		naturalIdHelper = new DummyNaturalIdHelper();

		persistenceContext = new DummyPersistenceContext();
		persistenceContext.setNaturalIdHelper(naturalIdHelper);

		sessionImplementor = new DummySessionImplementor();
		sessionImplementor.setPersistenceContext(persistenceContext);
	}

	@Test
	public void test() {
		aeq(EntityDeleteAction.class, OrphanRemovalAction.class.getSuperclass());

		OrphanRemovalAction orphanRemovalAction = new OrphanRemovalAction(id, states, version, instance,
				entityPersister, isCascadeDeleteEnabled, sessionImplementor);

		aeqr(id, orphanRemovalAction.getId());
		aeqr(instance, orphanRemovalAction.getInstance());
		aeqr(entityPersister, orphanRemovalAction.getPersister());
		aeqr(sessionImplementor, orphanRemovalAction.getSession());

	}
}
