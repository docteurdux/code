package dux.org.hibernate.boot.model.relational;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.relational.QualifiedNameImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class QualifiedNameImplTest extends AbstractTest {

	private Identifier catalogName;
	private Identifier schemaName;
	private Identifier objectName;

	@Before
	public void before() {
		catalogName = new Identifier("catalogName", false);
		schemaName = new Identifier("schemaName", false);
		objectName = new Identifier("objectName", false);
	}

	@Test
	public void test() {
		QualifiedNameImpl qni = new QualifiedNameImpl(catalogName, schemaName, objectName);
		aeqr(catalogName, qni.getCatalogName());
		aeqr(schemaName, qni.getSchemaName());
		aeqr(objectName, qni.getObjectName());
	}
}
