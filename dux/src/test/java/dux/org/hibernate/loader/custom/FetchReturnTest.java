package dux.org.hibernate.loader.custom;

import org.hibernate.LockMode;
import org.hibernate.loader.custom.FetchReturn;
import org.hibernate.loader.custom.NonScalarReturn;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class FetchReturnTest extends AbstractTest {

	private String nsrAlias;
	private LockMode nsrLockMode;

	private NonScalarReturn nonScalarReturn;

	private String ownerProperty;
	private String frAlias;
	private LockMode frLockMode;

	@Before
	public void before() {

		nsrAlias = "nsrAlias";
		nsrLockMode = LockMode.NONE;

		nonScalarReturn = new NonScalarReturn(nsrAlias, nsrLockMode) {
		};

		ownerProperty = "ownerProperty";
		frAlias = "frAlias";
		frLockMode = LockMode.OPTIMISTIC;
	}

	@Test
	public void test() {

		aeq(NonScalarReturn.class, FetchReturn.class.getSuperclass());

		FetchReturn fr = new FetchReturn(nonScalarReturn, ownerProperty, frAlias, frLockMode) {
		};

		aeqr(nonScalarReturn, fr.getOwner());
		aeq(ownerProperty, fr.getOwnerProperty());

		aeq(frAlias, fr.getAlias());
		aeq(frLockMode, fr.getLockMode());

	}
}
