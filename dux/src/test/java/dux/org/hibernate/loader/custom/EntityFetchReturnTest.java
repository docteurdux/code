package dux.org.hibernate.loader.custom;

import org.hibernate.LockMode;
import org.hibernate.loader.EntityAliases;
import org.hibernate.loader.custom.EntityFetchReturn;
import org.hibernate.loader.custom.FetchReturn;
import org.hibernate.loader.custom.NonScalarReturn;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.loader.DummyEntityAliases;

@Done
public class EntityFetchReturnTest extends AbstractTest {

	private String ownerAlias;
	private LockMode ownerLockMode;

	private String efrAlias;
	private LockMode efrLockMode;

	private String ownerProperty;
	private EntityAliases entityAliases;
	private NonScalarReturn ownerNsr;

	@Before
	public void before() {

		ownerAlias = "ownerAlias";
		ownerLockMode = LockMode.NONE;

		efrAlias = "efrAlias";
		efrLockMode = LockMode.OPTIMISTIC;

		ownerProperty = "ownerProperty";

		entityAliases = new DummyEntityAliases();

		ownerNsr = new NonScalarReturn(ownerAlias, ownerLockMode) {
		};

	}

	@Test
	public void test() {

		aeq(FetchReturn.class, EntityFetchReturn.class.getSuperclass());

		EntityFetchReturn entityFetchReturn = new EntityFetchReturn(efrAlias, entityAliases, ownerNsr, ownerProperty,
				efrLockMode);

		aeqr(entityAliases, entityFetchReturn.getEntityAliases());

		FetchReturn fetchReturn = entityFetchReturn;

		aeqr(ownerNsr, fetchReturn.getOwner());
		aeq(ownerProperty, fetchReturn.getOwnerProperty());

		NonScalarReturn nonScalarReturn = fetchReturn;

		aeq(efrAlias, nonScalarReturn.getAlias());
		aeq(efrLockMode, nonScalarReturn.getLockMode());

	}
}
