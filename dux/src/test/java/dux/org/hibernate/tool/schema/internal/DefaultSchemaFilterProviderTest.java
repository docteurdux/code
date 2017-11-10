package dux.org.hibernate.tool.schema.internal;

import org.hibernate.tool.schema.internal.DefaultSchemaFilter;
import org.hibernate.tool.schema.internal.DefaultSchemaFilterProvider;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class DefaultSchemaFilterProviderTest extends AbstractTest {

	private DefaultSchemaFilter defaultSchemaFilter = DefaultSchemaFilter.INSTANCE;;

	@Test
	public void test() {

		DefaultSchemaFilterProvider dsfp = new DefaultSchemaFilterProvider();

		aeqr(defaultSchemaFilter, dsfp.getCreateFilter());
		aeqr(defaultSchemaFilter, dsfp.getDropFilter());
		aeqr(defaultSchemaFilter, dsfp.getMigrateFilter());
		aeqr(defaultSchemaFilter, dsfp.getValidateFilter());

	}
}
