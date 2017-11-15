package dux.org.hibernate.loader.custom;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.loader.custom.DummyNonScalarReturn;

@Done
public class NonScalarReturnTest extends AbstractTest {

	@Test
	public void test1() {
		String alias = "alias";
		LockMode lockMode = LockMode.OPTIMISTIC;
		DummyNonScalarReturn nsr = new DummyNonScalarReturn(alias, lockMode);
		aeq(alias, nsr.getAlias());
		aeq(lockMode, nsr.getLockMode());

	}

	@Test(expected = HibernateException.class)
	public void test2() {
		new DummyNonScalarReturn(null, LockMode.OPTIMISTIC);
	}
}
