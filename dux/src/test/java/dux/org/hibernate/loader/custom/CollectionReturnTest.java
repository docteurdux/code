package dux.org.hibernate.loader.custom;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.LockMode;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.loader.DefaultEntityAliases;
import org.hibernate.loader.custom.CollectionReturn;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.engine.jdbc.spi.DummyJdbcServices;
import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.service.spi.DummyServiceRegistryImplementor;
import dux.org.hibernate.loader.DummyLoadable;

@Done
public class CollectionReturnTest extends AbstractTest {

	private String alias;
	private String ownerEntityName;
	private String ownerProperty;
	private String identifierPropertyName;
	private String suffix;

	private Map<String, String[]> userProvidedAliases;
	private String[] providedAliases;

	private Dialect dialect;

	private DummyCollectionAliases collectionAliases;
	private DummyLoadable loadable;
	private DummySessionFactoryImplementor sessionFactoryImplementor;
	private DummyServiceRegistryImplementor serviceRegistryImplementor;
	private DummyJdbcServices jdbcServices;
	private DefaultEntityAliases defaultEntityAliases;
	private LockMode lockMode;

	public CollectionReturnTest() {
		alias = "alias";
		ownerEntityName = "ownerEntityName";
		ownerProperty = "ownerProperty";
		identifierPropertyName = "identifierPropertyName";
		suffix = "suffix";

		lockMode = LockMode.NONE;

		providedAliases = new String[] {};

		userProvidedAliases = new HashMap<>();
		userProvidedAliases.put("identifierPropertyName", providedAliases);

		collectionAliases = new DummyCollectionAliases();

		dialect = new Dialect() {
		};

		jdbcServices = new DummyJdbcServices();
		jdbcServices.setDialect(dialect);

		serviceRegistryImplementor = new DummyServiceRegistryImplementor();
		serviceRegistryImplementor.setService(JdbcServices.class, jdbcServices);

		sessionFactoryImplementor = new DummySessionFactoryImplementor();
		sessionFactoryImplementor.setServiceRegistry(serviceRegistryImplementor);

		loadable = new DummyLoadable();
		loadable.setIdentifierPropertyName(identifierPropertyName);
		loadable.setFactory(sessionFactoryImplementor);

		defaultEntityAliases = new DefaultEntityAliases(userProvidedAliases, loadable, suffix);

	}

	@Test
	public void test() {

		CollectionReturn collectionReturn = new CollectionReturn(alias, ownerEntityName, ownerProperty,
				collectionAliases, defaultEntityAliases, lockMode);

		aeq(alias, collectionReturn.getAlias());
		aeq(ownerEntityName, collectionReturn.getOwnerEntityName());
		aeq(ownerProperty, collectionReturn.getOwnerProperty());
		aeqr(collectionAliases, collectionReturn.getCollectionAliases());
		aeq(lockMode, collectionReturn.getLockMode());

	}
}
