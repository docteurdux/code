package dux.org.hibernate.tool.schema.extract.internal;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.tool.schema.extract.internal.PrimaryKeyInformationImpl;
import org.hibernate.tool.schema.extract.spi.ColumnInformation;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.java.lang.Iterable.DummyIterable;

@Done
public class PrimaryKeyInformationImplTest extends AbstractTest {

	private Identifier identifier;
	private Iterable<ColumnInformation> columnInformationIterable;

	@Before
	public void before() {
		identifier = new Identifier("identifier", false);
		columnInformationIterable = new DummyIterable<ColumnInformation>();
	}

	@Test
	public void test() {
		PrimaryKeyInformationImpl primaryKeyInformationImpl = new PrimaryKeyInformationImpl(identifier,
				columnInformationIterable);
		aeqr(identifier, primaryKeyInformationImpl.getPrimaryKeyIdentifier());
		aeqr(columnInformationIterable, primaryKeyInformationImpl.getColumns());
	}
}
