package dux.org.hibernate.loader.custom;

import org.hibernate.LockMode;
import org.hibernate.loader.custom.CollectionFetchReturn;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.loader.DummyEntityAliases;
import dum.org.hibernate.loader.custom.DummyNonScalarReturn;

@Done
public class CollectionFetchReturnTest extends AbstractTest {

	private DummyNonScalarReturn nsr;
	private DummyCollectionAliases collectionAliases;
	private DummyEntityAliases elementEntityAliases;

	@Before
	public void before() {
		nsr = new DummyNonScalarReturn("nsrAlias", LockMode.NONE);
		collectionAliases = new DummyCollectionAliases();
		elementEntityAliases = new DummyEntityAliases();
	}

	@Test
	public void test() {

		CollectionFetchReturn collectionFetchReturn = new CollectionFetchReturn("cfrAlias", nsr, "ownerProperty",
				collectionAliases, elementEntityAliases, LockMode.OPTIMISTIC);

		aeqr(collectionAliases, collectionFetchReturn.getCollectionAliases());
		aeqr(elementEntityAliases, collectionFetchReturn.getElementEntityAliases());
	}
}
