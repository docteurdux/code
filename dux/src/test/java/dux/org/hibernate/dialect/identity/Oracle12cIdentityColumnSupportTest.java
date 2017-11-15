package dux.org.hibernate.dialect.identity;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.GetGeneratedKeysDelegate;
import org.hibernate.dialect.identity.Oracle12cGetGeneratedKeysDelegate;
import org.hibernate.dialect.identity.Oracle12cIdentityColumnSupport;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.id.DummyPostInsertIdentityPersister;

@Done
public class Oracle12cIdentityColumnSupportTest extends AbstractTest {

	private int ignoredType;

	private Dialect dialect;
	private DummyPostInsertIdentityPersister postInsertIdentityPersister;

	@Before
	public void before() {
		ignoredType = 0;

		dialect = new Dialect() {
		};
		postInsertIdentityPersister = new DummyPostInsertIdentityPersister();
		postInsertIdentityPersister.setRootTableKeyColumnNames(new String[] {});
	}

	@Test
	public void test() {

		Oracle12cIdentityColumnSupport oracle12cIdentityColumnSupport = new Oracle12cIdentityColumnSupport();

		at(oracle12cIdentityColumnSupport.supportsIdentityColumns());
		at(oracle12cIdentityColumnSupport.supportsInsertSelectIdentity());
		aeq("generated as identity", oracle12cIdentityColumnSupport.getIdentityColumnString(ignoredType));

		GetGeneratedKeysDelegate getGeneratedKeysDelegate = oracle12cIdentityColumnSupport
				.buildGetGeneratedKeysDelegate(postInsertIdentityPersister, dialect);
		aeq(Oracle12cGetGeneratedKeysDelegate.class, getGeneratedKeysDelegate.getClass());

	}
}
