package dux.org.hibernate.loader.plan.exec.internal;

import org.hibernate.loader.plan.exec.internal.EntityReferenceAliasesImpl;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.loader.DummyEntityAliases;

@Done
public class EntityReferenceAliasesImplTest extends AbstractTest {

	@Test
	public void test() {

		String tableAlias = "tableAlias";
		DummyEntityAliases columnAliases = new DummyEntityAliases();

		EntityReferenceAliasesImpl erai = new EntityReferenceAliasesImpl(tableAlias, columnAliases);

		aeq(tableAlias, erai.getTableAlias());
		aeqr(columnAliases, erai.getColumnAliases());
	}
}
