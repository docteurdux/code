package dux.org.hibernate.hql.spi.id.global;

import org.hibernate.hql.spi.id.local.IdTableInfoImpl;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class IdTableInfoImplTest extends AbstractTest {
	@Test
	public void test() {

		String idTableName = "idTableName";
		String creationStatement = "creationStatement";
		String dropStatement = "dropStatement";

		IdTableInfoImpl info = new IdTableInfoImpl(idTableName, creationStatement, dropStatement);

		aeq(idTableName, info.getQualifiedIdTableName());
		aeq(creationStatement, info.getIdTableCreationStatement());
		aeq(dropStatement, info.getIdTableDropStatement());
	}
}
