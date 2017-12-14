package dux.org.hibernate.proxy.map;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.proxy.map.DummyMapLazyInitializer;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.RunnableWhichThrow;
import com.github.docteurdux.test.RunnableWithArgs;

import dum.org.hibernate.engine.spi.DummyPersistenceContext;
import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.engine.spi.DummySharedSessionContractImplementor;
import dum.org.hibernate.metamodel.spi.DummyMetamodelImplementor;
import dum.org.hibernate.persister.entity.DummyEntityPersister;

@Done
public class MapLazyInitializerTest extends AbstractTest {

	private String entityName;
	private Serializable id;

	@SuppressWarnings("rawtypes")
	private Map resultOfImmediateLoad;

	private DummyEntityPersister entityPersister;
	private DummyMetamodelImplementor metamodelImplementor;
	private DummySessionFactoryImplementor sessionFactoryImplementor;
	private DummyPersistenceContext persistenceContext;
	private DummySharedSessionContractImplementor sharedSessionContractImplementor;
	private RunnableWithArgs<Object> immediateLoadRWA;

	@Before
	public void before() {

		entityName = "entityName";

		id = new Serializable() {
			private static final long serialVersionUID = 1L;
		};

		resultOfImmediateLoad = new HashMap<>();

		entityPersister = new DummyEntityPersister();
		metamodelImplementor = new DummyMetamodelImplementor();
		metamodelImplementor.entityPersisters().put(entityName, entityPersister);
		sessionFactoryImplementor = new DummySessionFactoryImplementor();
		sessionFactoryImplementor.setMetamodel(metamodelImplementor);
		persistenceContext = new DummyPersistenceContext();

		immediateLoadRWA = new RunnableWithArgs<Object>() {
			@Override
			public Object run(Object... args) {
				return resultOfImmediateLoad;
			}
		};

		sharedSessionContractImplementor = new DummySharedSessionContractImplementor();
		sharedSessionContractImplementor.setFactory(sessionFactoryImplementor);
		sharedSessionContractImplementor.setPersistenceContext(persistenceContext);
		sharedSessionContractImplementor.setOpen(true);
		sharedSessionContractImplementor.setConnected(true);
		sharedSessionContractImplementor.setImmediateLoadRWA(immediateLoadRWA);
	}

	@Test
	public void test() {

		DummyMapLazyInitializer mapLazyInitializer = new DummyMapLazyInitializer(entityName, id,
				sharedSessionContractImplementor);

		aeqr(resultOfImmediateLoad, mapLazyInitializer.getMap());

		expect(UnsupportedOperationException.class, new RunnableWhichThrow() {
			@Override
			public void run() throws Exception {
				mapLazyInitializer.getPersistentClass();

			}

			@Override
			public void inspect(Throwable e) {
				aeq("dynamic-map entity representation", e.getMessage());
			}
		});
	}
}
