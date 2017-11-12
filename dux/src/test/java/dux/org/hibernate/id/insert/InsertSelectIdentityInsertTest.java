package dux.org.hibernate.id.insert;

import org.hibernate.dialect.Dialect;
import org.hibernate.id.insert.IdentifierGeneratingInsert;
import org.hibernate.id.insert.InsertSelectIdentityInsert;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class InsertSelectIdentityInsertTest extends AbstractTest {
	private Dialect dialect;

	@Before
	public void before() {
		dialect = new Dialect() {
		};
	}

	@Test
	public void test() {

		aeq(IdentifierGeneratingInsert.class, InsertSelectIdentityInsert.class.getSuperclass());

		InsertSelectIdentityInsert insertSelectIdentityInsert = new InsertSelectIdentityInsert(dialect);
		insertSelectIdentityInsert.setTableName("tableName");

		aeq("insert into tableName values ( )", insertSelectIdentityInsert.toStatementString());

	}
}
