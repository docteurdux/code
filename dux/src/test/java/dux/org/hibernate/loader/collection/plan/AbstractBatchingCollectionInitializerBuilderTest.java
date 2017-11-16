package dux.org.hibernate.loader.collection.plan;

import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.spi.LoadQueryInfluencers;
import org.hibernate.loader.collection.CollectionInitializer;
import org.hibernate.loader.collection.plan.CollectionLoader;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.RunnableWithArgs;

import dum.org.hibernate.engine.jdbc.spi.DummyJdbcServices;
import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.loader.collection.plan.DummyAbstractBatchingCollectionInitializerBuilder;
import dum.org.hibernate.persister.collection.DummyCollectionPersister;
import dum.org.hibernate.persister.collection.DummyQueryableCollection;
import dum.org.hibernate.persister.walking.spi.DummyCollectionElementDefinition;
import dum.org.hibernate.service.spi.DummyServiceRegistryImplementor;
import dum.org.hibernate.type.DummyType;

@Done("requires a second pass to find whee the input can be found in the results")
public class AbstractBatchingCollectionInitializerBuilderTest extends AbstractTest {

	private DummyQueryableCollection queryableCollection;
	private DummySessionFactoryImplementor sessionFactoryImplementor;
	private LoadQueryInfluencers loadQueryInfluencers;

	public AbstractBatchingCollectionInitializerBuilderTest() {

		DummyType collectionElementDefinitionType = new DummyType();
		DummyType collectionPersisterElementType = new DummyType();

		Dialect dialect = new Dialect() {
		};

		RunnableWithArgs<String> filterFragmentRWA = new RunnableWithArgs<String>() {
			@Override
			public String run(Object... args) {
				return "filteredFragments";
			}
		};

		RunnableWithArgs<String> selectFragmentRWA = new RunnableWithArgs<String>() {
			@Override
			public String run(Object... args) {
				return "selectedFragment";
			}
		};

		DummyJdbcServices jdbcServices = new DummyJdbcServices();
		jdbcServices.setDialect(dialect);

		DummyServiceRegistryImplementor serviceRegistryImplementor = new DummyServiceRegistryImplementor();
		serviceRegistryImplementor.setService(JdbcServices.class, jdbcServices);

		sessionFactoryImplementor = new DummySessionFactoryImplementor();
		sessionFactoryImplementor.setServiceRegistry(serviceRegistryImplementor);

		DummyCollectionPersister collectionPersister = new DummyCollectionPersister();
		collectionPersister.setElementType(collectionPersisterElementType);
		collectionPersister.setTableName("tableName");
		collectionPersister.setRole("role");

		collectionPersister.setFilterFragmentRWA(filterFragmentRWA);

		collectionPersister.setSelectFragmentRWA(selectFragmentRWA);

		queryableCollection = new DummyQueryableCollection();
		queryableCollection.setFactory(sessionFactoryImplementor);

		DummyCollectionElementDefinition collectionElementDefinition = new DummyCollectionElementDefinition();
		collectionElementDefinition.setCollectionDefinition(queryableCollection);
		collectionElementDefinition.setType(collectionElementDefinitionType);
		queryableCollection.setElementDefinition(collectionElementDefinition);
		queryableCollection.setCollectionPersister(collectionPersister);

		loadQueryInfluencers = new LoadQueryInfluencers(sessionFactoryImplementor);
	}

	@Test
	public void test() {

		DummyAbstractBatchingCollectionInitializerBuilder abstractBatchingCollectionInitializerBuilder = null;
		abstractBatchingCollectionInitializerBuilder = new DummyAbstractBatchingCollectionInitializerBuilder();

		CollectionInitializer collectionInitializer = abstractBatchingCollectionInitializerBuilder
				.buildNonBatchingLoader(queryableCollection, sessionFactoryImplementor, loadQueryInfluencers);

		aeq(CollectionLoader.class, collectionInitializer.getClass());

	}
}
