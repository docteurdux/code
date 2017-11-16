package dux.org.hibernate.hql.spi.id;

import org.hibernate.hql.spi.id.IdTableSupportStandardImpl;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class IdTableSupportStandardImplTest extends AbstractTest {

	@Test
	public void test() {

		IdTableSupportStandardImpl instance = IdTableSupportStandardImpl.INSTANCE;

		aeq("HT_baseName", instance.generateIdTableName("baseName"));
		aeq("create table", instance.getCreateIdTableCommand());
		aeq(null, instance.getCreateIdTableStatementOptions());
		aeq("drop table", instance.getDropIdTableCommand());
	}
}
