package dux.org.hibernate.hql.spi.id.persistent;

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

		IdTableInfoImpl iti = new IdTableInfoImpl(idTableName, creationStatement, dropStatement);

		aeq(idTableName, iti.getQualifiedIdTableName());
		aeq(creationStatement, iti.getIdTableCreationStatement());
		aeq(dropStatement, iti.getIdTableDropStatement());

	}
}
