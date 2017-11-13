package dux.org.hibernate.boot.model.relational;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.relational.QualifiedSequenceName;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class QualifiedSequenceNameTest extends AbstractTest {

	private Identifier catalogName;
	private Identifier schemaName;
	private Identifier sequenceName;

	@Before
	public void before() {
		catalogName = new Identifier("catalogName", false);
		schemaName = new Identifier("schemaName", false);
		sequenceName = new Identifier("sequenceName", false);
	}

	@Test
	public void test() {
		QualifiedSequenceName qsn = new QualifiedSequenceName(catalogName, schemaName, sequenceName);

		aeqr(catalogName, qsn.getCatalogName());
		aeqr(schemaName, qsn.getSchemaName());
		aeqr(sequenceName, qsn.getSequenceName());
	}
}
