package dux.org.hibernate.boot.model.relational;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.relational.QualifiedTableName;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class QualifiedTableNameTest extends AbstractTest {
	private Identifier catalogName;
	private Identifier schemaName;
	private Identifier tableName;

	@Before
	public void before() {
		catalogName = new Identifier("catalogName", false);
		schemaName = new Identifier("schemaName", false);
		tableName = new Identifier("tableName", false);
	}

	@Test
	public void test() {

		QualifiedTableName qtn = new QualifiedTableName(catalogName, schemaName, tableName);

		aeqr(catalogName, qtn.getCatalogName());
		aeqr(schemaName, qtn.getSchemaName());
		aeqr(tableName, qtn.getTableName());
	}
}
