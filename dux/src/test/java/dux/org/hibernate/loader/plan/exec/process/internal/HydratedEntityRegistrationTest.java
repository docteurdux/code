package dux.org.hibernate.loader.plan.exec.process.internal;

import java.io.Serializable;

import org.hibernate.engine.spi.EntityKey;
import org.hibernate.loader.plan.exec.process.internal.DummyHydratedEntityRegistration;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.loader.plan.spi.DummyEntityReference;
import dum.org.hibernate.persister.entity.DummyEntityPersister;
import dum.org.hibernate.type.DummyType;

@Done
public class HydratedEntityRegistrationTest extends AbstractTest {

	private Object instance;
	private Serializable id;
	private DummyType type;

	private DummyEntityPersister entityPersister;

	private EntityKey entityKey;

	private DummyEntityReference entityReference;

	@Before
	public void before() {

		instance = new Object();
		id = new Serializable() {
			private static final long serialVersionUID = 1L;
		};
		type = new DummyType();

		entityPersister = new DummyEntityPersister();
		entityPersister.setIdentifierType(type);

		entityKey = new EntityKey(id, entityPersister);

		entityReference = new DummyEntityReference();

	}

	@Test
	public void test() {
		DummyHydratedEntityRegistration her = new DummyHydratedEntityRegistration(entityReference, entityKey, instance);
		aeqr(entityReference, her.getEntityReference());
		aeqr(entityKey, her.getKey());
		aeqr(instance, her.getInstance());
	}
}
