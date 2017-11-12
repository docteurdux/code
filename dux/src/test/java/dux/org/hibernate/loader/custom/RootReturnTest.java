package dux.org.hibernate.loader.custom;

import org.hibernate.LockMode;
import org.hibernate.loader.custom.NonScalarReturn;
import org.hibernate.loader.custom.RootReturn;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.loader.DummyEntityAliases;

@Done
public class RootReturnTest extends AbstractTest {

	private String alias;
	private String entityName;
	private DummyEntityAliases entityAliases;
	private LockMode lockMode;

	@Before
	public void before() {
		alias = "alias";
		entityName = "entityName";
		entityAliases = new DummyEntityAliases();
		lockMode = LockMode.NONE;
	}

	@Test
	public void test() {

		aeq(NonScalarReturn.class, RootReturn.class.getSuperclass());

		RootReturn rr = new RootReturn(alias, entityName, entityAliases, lockMode);

		aeq(alias, rr.getAlias());
		aeq(entityName, rr.getEntityName());
		aeqr(entityAliases, rr.getEntityAliases());
		aeq(lockMode, rr.getLockMode());

	}
}
