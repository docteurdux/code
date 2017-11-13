package dux.org.hibernate.hql.spi.id.local;

import org.hibernate.hql.spi.id.local.IdTableInfoImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class IdTableInfoImplTest extends AbstractTest {
	private String idTableName;
	private String creationStatement;
	private String dropStatement;

	@Before
	public void before() {
		idTableName = "idTableName";
		creationStatement = "creationStatement";
		dropStatement = "dropStatement";
	}

	@Test
	public void test() {

		IdTableInfoImpl itii = new IdTableInfoImpl(idTableName, creationStatement, dropStatement);

		aeq(idTableName, itii.getQualifiedIdTableName());
		aeq(creationStatement, itii.getIdTableCreationStatement());
		aeq(dropStatement, itii.getIdTableDropStatement());
	}
}
